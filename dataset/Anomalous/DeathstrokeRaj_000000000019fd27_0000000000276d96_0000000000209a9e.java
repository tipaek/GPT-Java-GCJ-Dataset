import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = readInt();
        int b = readInt();
        byte[] barray = new byte[b];

        for (int z = 1; z <= t; z++) {
            int q = 1;
            pw.println(1);
            pw.flush();
            barray[0] = readByte();
            q++;

            pw.println(b);
            pw.flush();
            barray[b - 1] = readByte();
            q++;

            int i = 1;
            int reverse = 0, compliment = 0, both = 0, nothing = 0, same = 0, diff = 0;

            while (i <= b / 2) {
                if (q % 10 == 1) {
                    resetFlags();

                    for (int j = 0; j < i; j++) {
                        if (barray[j] == barray[b - j - 1]) {
                            processSame(j);
                        } else {
                            processDifferent(j);
                        }
                    }
                } else {
                    barray[i] = queryAndRead(i + 1);
                    barray[b - i - 1] = queryAndRead(b - i);
                    i++;
                    q += 2;
                }
            }

            printOutput(barray, b);
            if (!"Y".equalsIgnoreCase(nextLine())) {
                System.exit(0);
            }
        }

        pw.close();
        br.close();
    }

    private static void resetFlags() {
        reverse = compliment = both = nothing = same = diff = 0;
    }

    private static void processSame(int j) throws IOException {
        if (same == 0) {
            same = 1;
            int front = queryAndRead(j + 1);
            if (front == barray[j]) {
                reverse++;
                nothing++;
            } else {
                barray[j] = (byte) front;
                barray[b - j - 1] = (byte) front;
                compliment++;
                both++;
            }
        } else {
            adjustArrayForSame(j);
        }
    }

    private static void adjustArrayForSame(int j) {
        if (reverse == 0 && nothing == 0) {
            barray[j] = (byte) (barray[j] == 0 ? 1 : 0);
            barray[b - j - 1] = (byte) (barray[b - j - 1] == 0 ? 1 : 0);
        }
    }

    private static void processDifferent(int j) throws IOException {
        if (diff == 0) {
            diff = 1;
            int front = queryAndRead(j + 1);
            if (front == barray[j]) {
                both++;
                nothing++;
            } else {
                barray[b - j - 1] = barray[j];
                barray[j] = (byte) front;
                compliment++;
                reverse++;
            }
        } else {
            adjustArrayForDifferent(j);
        }
    }

    private static void adjustArrayForDifferent(int j) {
        if (both == 0 && nothing == 0) {
            barray[j] = (byte) (barray[j] == 0 ? 1 : 0);
            barray[b - j - 1] = (byte) (barray[b - j - 1] == 0 ? 1 : 0);
        }
    }

    private static byte queryAndRead(int index) throws IOException {
        pw.println(index);
        pw.flush();
        return readByte();
    }

    private static void printOutput(byte[] barray, int b) {
        StringBuilder output = new StringBuilder();
        for (int j = 0; j < b; j++) {
            output.append(barray[j]);
        }
        pw.println(output);
        pw.flush();
    }

    private static Byte readByte() throws IOException {
        return Byte.parseByte(nextToken());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException {
        String s = br.readLine();
        if (s == null) {
            exitImmediately();
        }
        st = null;
        return s;
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
        }
        return st.nextToken();
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }
}