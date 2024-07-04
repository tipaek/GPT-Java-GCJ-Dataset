import java.io.*;
import java.util.Arrays;

public class Solution {

    private static final boolean FROM_FILE = false;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static String line;
    private static int[] bits;

    private static int readBit(int pos) throws IOException {
        bw.write(pos + "\n");
        bw.flush();
        line = br.readLine();
        return Integer.parseInt(line);
    }

    private static void reverseStoredData(int b) {
        for (int j = 0, temp; j < b / 2; j++) {
            temp = bits[j];
            bits[j] = bits[b - j - 1];
            bits[b - j - 1] = temp;
        }
    }

    private static void flipStoredData(int b) {
        for (int j = 0; j < b; j++) {
            if (bits[j] >= 0) {
                bits[j] = 1 - bits[j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("QR20204.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if (FROM_FILE) {
                File file = new File("QR20204.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            line = br.readLine();
            String[] p = line.split("\\s+");
            int tests = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);

            for (int i = 0; i < tests; i++) {
                StringBuilder s = new StringBuilder(b);

                if (b == 10) {
                    for (int j = 0; j < 10; j++) {
                        s.append(readBit(j + 1));
                    }
                } else {
                    bits = new int[b];
                    Arrays.fill(bits, -1);
                    int j, bit, bit2;

                    for (j = 1; j <= 5; bits[j - 1] = readBit(j), j++);
                    for (j = b; j > b - 5; bits[j - 1] = readBit(j), j--);

                    int detectFlip = -1;
                    int detectReverse = -1;

                    for (j = 0; j < 5; j++) {
                        if (bits[j] != bits[b - j - 1]) {
                            if (detectReverse < 0) {
                                detectReverse = j;
                            }
                        } else {
                            if (detectFlip < 0) {
                                detectFlip = j;
                            }
                        }
                    }

                    boolean haveBothDetectors;
                    int bitsSoFar = 10;
                    int nextBitToRead = 5;
                    int queriesSoFar = 10;

                    while (bitsSoFar < b && queriesSoFar <= 140) {
                        haveBothDetectors = detectFlip >= 0 && detectReverse >= 0;

                        if (haveBothDetectors) {
                            bit = readBit(detectFlip + 1);
                            bit2 = readBit(detectReverse + 1);

                            if (bit != bits[detectFlip]) {
                                if (bit2 != bits[detectReverse]) {
                                    flipStoredData(b);
                                } else {
                                    flipStoredData(b);
                                    reverseStoredData(b);
                                }
                            } else {
                                if (bit2 != bits[detectReverse]) {
                                    reverseStoredData(b);
                                }
                            }
                        } else if (detectFlip >= 0) {
                            bit = readBit(detectFlip + 1);
                            if (bit != bits[detectFlip]) {
                                flipStoredData(b);
                            }
                            readBit(b - detectFlip);
                        } else {
                            bit = readBit(detectReverse + 1);
                            if (bit != bits[detectReverse]) {
                                reverseStoredData(b);
                            }
                            readBit(b - detectReverse);
                        }

                        for (j = nextBitToRead; j < nextBitToRead + 4; bits[j] = readBit(j + 1), j++);
                        for (j = b - nextBitToRead; j > b - nextBitToRead - 4; bits[j - 1] = readBit(j), j--);

                        if (detectReverse < 0) {
                            for (j = nextBitToRead; j < nextBitToRead + 4; j++) {
                                if (bits[j] != bits[b - j - 1]) {
                                    detectReverse = j;
                                }
                            }
                        }

                        if (detectFlip < 0) {
                            for (j = nextBitToRead; j < nextBitToRead + 4; j++) {
                                if (bits[j] == bits[b - j - 1]) {
                                    detectFlip = j;
                                }
                            }
                        }

                        nextBitToRead += 4;
                        bitsSoFar += 8;
                        queriesSoFar += 10;
                    }

                    for (j = 0; j < b; j++) {
                        s.append(bits[j]);
                    }
                }

                bw.write(s.toString() + "\n");
                bw.flush();

                line = br.readLine();
                if (line.startsWith("N")) {
                    throw new RuntimeException();
                }
            }

            if (FROM_FILE) {
                bw.close();
            }
        } finally {
            if (FROM_FILE) {
                br.close();
            }
        }
    }
}