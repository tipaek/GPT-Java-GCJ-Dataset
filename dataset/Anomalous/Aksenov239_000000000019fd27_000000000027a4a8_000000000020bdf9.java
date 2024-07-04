package java.io;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Reads text from a character-input stream, buffering characters so as to
 * provide for the efficient reading of characters, arrays, and lines.
 *
 * <p> The buffer size may be specified, or the default size may be used.  The
 * default is large enough for most purposes.
 *
 * <p> In general, each read request made of a Reader causes a corresponding
 * read request to be made of the underlying character or byte stream.  It is
 * therefore advisable to wrap a BufferedReader around any Reader whose read()
 * operations may be costly, such as FileReaders and InputStreamReaders.  For
 * example,
 *
 * <pre>
 * BufferedReader in = new BufferedReader(new FileReader("foo.in"));
 * </pre>
 *
 * will buffer the input from the specified file.  Without buffering, each
 * invocation of read() or readLine() could cause bytes to be read from the
 * file, converted into characters, and then returned, which can be very
 * inefficient.
 *
 * <p> Programs that use DataInputStreams for textual input can be localized by
 * replacing each DataInputStream with an appropriate BufferedReader.
 *
 * @see FileReader
 * @see InputStreamReader
 * @see java.nio.file.Files#newBufferedReader
 *
 * @since JDK1.1
 */
public class BufferedReader extends Reader {

    private Reader in;
    private char[] cb;
    private int nChars, nextChar;
    private static final int INVALIDATED = -2;
    private static final int UNMARKED = -1;
    private int markedChar = UNMARKED;
    private int readAheadLimit = 0;
    private boolean skipLF = false;
    private boolean markedSkipLF = false;
    private static final int DEFAULT_CHAR_BUFFER_SIZE = 8192;
    private static final int DEFAULT_EXPECTED_LINE_LENGTH = 80;

    /**
     * Creates a buffering character-input stream that uses an input buffer of
     * the specified size.
     *
     * @param in A Reader
     * @param sz Input-buffer size
     * @exception IllegalArgumentException If {@code sz <= 0}
     */
    public BufferedReader(Reader in, int sz) {
        super(in);
        if (sz <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.in = in;
        cb = new char[sz];
        nextChar = nChars = 0;
    }

    /**
     * Creates a buffering character-input stream that uses a default-sized
     * input buffer.
     *
     * @param in A Reader
     */
    public BufferedReader(Reader in) {
        this(in, DEFAULT_CHAR_BUFFER_SIZE);
    }

    /** Checks to make sure that the stream has not been closed */
    private void ensureOpen() throws IOException {
        if (in == null) {
            throw new IOException("Stream closed");
        }
    }

    /** Fills the input buffer, taking the mark into account if it is valid. */
    private void fill() throws IOException {
        int dst;
        if (markedChar <= UNMARKED) {
            dst = 0;
        } else {
            int delta = nextChar - markedChar;
            if (delta >= readAheadLimit) {
                markedChar = INVALIDATED;
                readAheadLimit = 0;
                dst = 0;
            } else {
                if (readAheadLimit <= cb.length) {
                    System.arraycopy(cb, markedChar, cb, 0, delta);
                    markedChar = 0;
                    dst = delta;
                } else {
                    char[] ncb = new char[readAheadLimit];
                    System.arraycopy(cb, markedChar, ncb, 0, delta);
                    cb = ncb;
                    markedChar = 0;
                    dst = delta;
                }
                nextChar = nChars = delta;
            }
        }

        int n;
        do {
            n = in.read(cb, dst, cb.length - dst);
        } while (n == 0);
        if (n > 0) {
            nChars = dst + n;
            nextChar = dst;
        }
    }

    /**
     * Reads a single character.
     *
     * @return The character read, as an integer in the range 0 to 65535
     *         (<tt>0x00-0xffff</tt>), or -1 if the end of the stream has been reached
     * @exception IOException If an I/O error occurs
     */
    public int read() throws IOException {
        synchronized (lock) {
            ensureOpen();
            while (true) {
                if (nextChar >= nChars) {
                    fill();
                    if (nextChar >= nChars) {
                        return -1;
                    }
                }
                if (skipLF) {
                    skipLF = false;
                    if (cb[nextChar] == '\n') {
                        nextChar++;
                        continue;
                    }
                }
                return cb[nextChar++];
            }
        }
    }

    private int read1(char[] cbuf, int off, int len) throws IOException {
        if (nextChar >= nChars) {
            if (len >= cb.length && markedChar <= UNMARKED && !skipLF) {
                return in.read(cbuf, off, len);
            }
            fill();
        }
        if (nextChar >= nChars) {
            return -1;
        }
        if (skipLF) {
            skipLF = false;
            if (cb[nextChar] == '\n') {
                nextChar++;
                if (nextChar >= nChars) {
                    fill();
                }
                if (nextChar >= nChars) {
                    return -1;
                }
            }
        }
        int n = Math.min(len, nChars - nextChar);
        System.arraycopy(cb, nextChar, cbuf, off, n);
        nextChar += n;
        return n;
    }

    /**
     * Reads characters into a portion of an array.
     *
     * @param cbuf Destination buffer
     * @param off Offset at which to start storing characters
     * @param len Maximum number of characters to read
     * @return The number of characters read, or -1 if the end of the stream has been reached
     * @exception IOException If an I/O error occurs
     */
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            ensureOpen();
            if ((off < 0) || (off > cbuf.length) || (len < 0) || ((off + len) > cbuf.length) || ((off + len) < 0)) {
                throw new IndexOutOfBoundsException();
            } else if (len == 0) {
                return 0;
            }

            int n = read1(cbuf, off, len);
            if (n <= 0) {
                return n;
            }
            while ((n < len) && in.ready()) {
                int n1 = read1(cbuf, off + n, len - n);
                if (n1 <= 0) {
                    break;
                }
                n += n1;
            }
            return n;
        }
    }

    private String readLine(boolean ignoreLF) throws IOException {
        StringBuilder s = null;
        int startChar;

        synchronized (lock) {
            ensureOpen();
            boolean omitLF = ignoreLF || skipLF;

            while (true) {
                if (nextChar >= nChars) {
                    fill();
                }
                if (nextChar >= nChars) {
                    if (s != null && s.length() > 0) {
                        return s.toString();
                    } else {
                        return null;
                    }
                }
                boolean eol = false;
                char c = 0;
                int i;

                if (omitLF && (cb[nextChar] == '\n')) {
                    nextChar++;
                }
                skipLF = false;
                omitLF = false;

                for (i = nextChar; i < nChars; i++) {
                    c = cb[i];
                    if ((c == '\n') || (c == '\r')) {
                        eol = true;
                        break;
                    }
                }

                startChar = nextChar;
                nextChar = i;

                if (eol) {
                    String str;
                    if (s == null) {
                        str = new String(cb, startChar, i - startChar);
                    } else {
                        s.append(cb, startChar, i - startChar);
                        str = s.toString();
                    }
                    nextChar++;
                    if (c == '\r') {
                        skipLF = true;
                    }
                    return str;
                }

                if (s == null) {
                    s = new StringBuilder(DEFAULT_EXPECTED_LINE_LENGTH);
                }
                s.append(cb, startChar, i - startChar);
            }
        }
    }

    /**
     * Reads a line of text.
     *
     * @return A String containing the contents of the line, not including any line-termination characters,
     *         or null if the end of the stream has been reached
     * @exception IOException If an I/O error occurs
     */
    public String readLine() throws IOException {
        return readLine(false);
    }

    /**
     * Skips characters.
     *
     * @param n The number of characters to skip
     * @return The number of characters actually skipped
     * @exception IllegalArgumentException If <code>n</code> is negative.
     * @exception IOException If an I/O error occurs
     */
    public long skip(long n) throws IOException {
        if (n < 0L) {
            throw new IllegalArgumentException("skip value is negative");
        }
        synchronized (lock) {
            ensureOpen();
            long r = n;
            while (r > 0) {
                if (nextChar >= nChars) {
                    fill();
                }
                if (nextChar >= nChars) {
                    break;
                }
                if (skipLF) {
                    skipLF = false;
                    if (cb[nextChar] == '\n') {
                        nextChar++;
                    }
                }
                long d = nChars - nextChar;
                if (r <= d) {
                    nextChar += r;
                    r = 0;
                    break;
                } else {
                    r -= d;
                    nextChar = nChars;
                }
            }
            return n - r;
        }
    }

    /**
     * Tells whether this stream is ready to be read.
     *
     * @exception IOException If an I/O error occurs
     */
    public boolean ready() throws IOException {
        synchronized (lock) {
            ensureOpen();
            if (skipLF) {
                if (nextChar >= nChars && in.ready()) {
                    fill();
                }
                if (nextChar < nChars) {
                    if (cb[nextChar] == '\n') {
                        nextChar++;
                    }
                    skipLF = false;
                }
            }
            return (nextChar < nChars) || in.ready();
        }
    }

    /**
     * Tells whether this stream supports the mark() operation, which it does.
     */
    public boolean markSupported() {
        return true;
    }

    /**
     * Marks the present position in the stream.
     *
     * @param readAheadLimit Limit on the number of characters that may be read while still preserving the mark.
     * @exception IllegalArgumentException If {@code readAheadLimit < 0}
     * @exception IOException If an I/O error occurs
     */
    public void mark(int readAheadLimit) throws IOException {
        if (readAheadLimit < 0) {
            throw new IllegalArgumentException("Read-ahead limit < 0");
        }
        synchronized (lock) {
            ensureOpen();
            this.readAheadLimit = readAheadLimit;
            markedChar = nextChar;
            markedSkipLF = skipLF;
        }
    }

    /**
     * Resets the stream to the most recent mark.
     *
     * @exception IOException If the stream has never been marked, or if the mark has been invalidated
     */
    public void reset() throws IOException {
        synchronized (lock) {
            ensureOpen();
            if (markedChar < 0) {
                throw new IOException((markedChar == INVALIDATED) ? "Mark invalid" : "Stream not marked");
            }
            nextChar = markedChar;
            skipLF = markedSkipLF;
        }
    }

    /**
     * Closes the stream.
     *
     * @exception IOException If an I/O error occurs
     */
    public void close() throws IOException {
        synchronized (lock) {
            if (in == null) {
                return;
            }
            try {
                in.close();
            } finally {
                in = null;
                cb = null;
            }
        }
    }

    /**
     * Returns a {@code Stream}, the elements of which are lines read from this {@code BufferedReader}.
     *
     * @return a {@code Stream<String>} providing the lines of text described by this {@code BufferedReader}
     * @since 1.8
     */
    public Stream<String> lines() {
        Iterator<String> iter = new Iterator<String>() {
            String nextLine = null;

            @Override
            public boolean hasNext() {
                if (nextLine != null) {
                    return true;
                } else {
                    try {
                        nextLine = readLine();
                        return (nextLine != null);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
            }

            @Override
            public String next() {
                if (nextLine != null || hasNext()) {
                    String line = nextLine;
                    nextLine = null;
                    return line;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
}