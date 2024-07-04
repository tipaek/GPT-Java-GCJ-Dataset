import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.io.Writer;
import java.util.Optional;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakeChoppers {
        long[] a;

        private ArrayList<LongPt> zip() {
            int curStreak = 0;

            ArrayList<LongPt> res = new ArrayList<>();

            for (int i = 1; i <= a.length; i++) {
                if (i < a.length && a[i] == a[i - 1]) {
                    curStreak++;
                } else {
                    res.add(new LongPt(curStreak, a[i - 1]));
                    curStreak = 1;
                }
            }
            return res;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            int n = in.readInt();
            int d = in.readInt();
            a = in.readLongArray(n);

            MergeSort.sort(a);

            // count; value
            ArrayList<LongPt> zip = zip();

            LongPt maxFreq = zip.stream().max(LongPt::compareTo).get();


            boolean hasDouble = false;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == 2L * a[i]) {
                        hasDouble = true;
                    }
                }
            }

            if (d == 2) {
                if (maxFreq.x >= 2) {
                    out.println("Case #" + testNumber + ": " + 0);
                } else {
                    out.println("Case #" + testNumber + ": " + 1);
                }
                return;
            } else if (d == 3) {
                if (maxFreq.x >= 3) {
                    out.println("Case #" + testNumber + ": " + 0);
                } else if (maxFreq.x >= 2) {

                    boolean hasBigger = false;
                    for (int i = 0; i < zip.size() - 1; i++) {
                        if (zip.get(i).x >= 2) {
                            hasBigger = true;
                            break;
                        }
                    }

                    if (hasBigger) {
                        out.println("Case #" + testNumber + ": " + 1);
                        return;
                    } else {
//                    out.println("Case #" + testNumber + ": " + 1);
                    }
                }

                {
                    if (hasDouble) {
                        out.println("Case #" + testNumber + ": " + 1);
                    } else {
                        out.println("Case #" + testNumber + ": " + 2);
                    }

                }
            }

//        out.println("Case #" + testNumber + ": ");
        }

    }

    static class MergeSort {
        public static void sort(long[] array, int left, int right, Comparator<Long> cmp) {
            if (right <= left) return;
            int mid = (left + right) / 2;
            sort(array, left, mid, cmp);
            sort(array, mid + 1, right, cmp);
            merge(array, left, mid, right, cmp);
        }

        public static void sort(long[] array) {
            sort(array, 0, array.length - 1, null);
        }

        private static void merge(long[] array, int left, int mid, int right, Comparator<Long> cmp) {
            // calculating lengths
            int lengthLeft = mid - left + 1;
            int lengthRight = right - mid;

            // creating temporary subarrays
            long[] leftArray = new long[lengthLeft];
            long[] rightArray = new long[lengthRight];

            // copying our sorted subarrays into temporaries
            for (int i = 0; i < lengthLeft; i++)
                leftArray[i] = array[left + i];
            for (int i = 0; i < lengthRight; i++)
                rightArray[i] = array[mid + i + 1];

            // iterators containing current index of temp subarrays
            int leftIndex = 0;
            int rightIndex = 0;

            // copying from leftArray and rightArray back into array
            for (int i = left; i < right + 1; i++) {
                // if there are still uncopied elements in R and L, copy minimum of the two
                if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                    boolean isLess = true;
                    if (cmp != null) {
                        isLess = cmp.compare(leftArray[leftIndex], rightArray[rightIndex]) <= 0;
                    } else {
                        isLess = leftArray[leftIndex] <= rightArray[rightIndex];
                    }
                    if (isLess) {
                        array[i] = leftArray[leftIndex];
                        leftIndex++;
                    } else {
                        array[i] = rightArray[rightIndex];
                        rightIndex++;
                    }
                }
                // if all the elements have been copied from rightArray, copy the rest of leftArray
                else if (leftIndex < lengthLeft) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                // if all the elements have been copied from leftArray, copy the rest of rightArray
                else if (rightIndex < lengthRight) {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public long[] readLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = readLong();
            }
            return array;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static interface IPt<A, B> {
    }

    static class LongPt implements Comparable<LongPt>, IPt<Long, Long> {
        public final long x;
        public final long y;

        public LongPt(long k, long v) {
            x = k;
            y = v;
        }

        public LongPt(LongPt entry) {
            this(entry.x, entry.y);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LongPt)) {
                return false;
            } else {
                return x == ((LongPt) o).x && y == ((LongPt) o).y;
            }
        }

        public int hashCode() {
            int result = Long.hashCode(x);

            final int h = Long.hashCode(y);
            result = 37 * result + h ^ (h >>> 16);

            return result;
        }

        public String toString() {
            return "[" + x + ", " + y + "]";
        }

        public int compareTo(LongPt o) {
            if (x == o.x) {
                return Long.compare(y, o.y);
            }
            return Long.compare(x, o.x);
        }

    }
}

