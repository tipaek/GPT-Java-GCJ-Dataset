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
            q++;
            barray[0] = readByte();
            pw.println(b);
            pw.flush();
            q++;
            barray[b - 1] = readByte();

            int i = 1;
            while (i <= b / 2) {
                if (q % 10 == 1) {
                    int reverse = 0, compliment = 0, both = 0, nothing = 0;
                    boolean same = false, diff = false;

                    for (int j = 0; j < i; j++) {
                        if (barray[j] == barray[b - j - 1]) {
                            if (!same) {
                                same = true;
                                pw.println(j + 1);
                                pw.flush();
                                q++;
                                int front = readByte();
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
                                if (reverse == 0 && nothing == 0 && compliment != 0 && both != 0) {
                                    barray[j] = (byte) (barray[j] == 0 ? 1 : 0);
                                    barray[b - j - 1] = (byte) (barray[b - j - 1] == 0 ? 1 : 0);
                                }
                            }
                        } else {
                            if (!diff) {
                                diff = true;
                                pw.println(j + 1);
                                pw.flush();
                                q++;
                                int front = readByte();
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
                                if (both == 0 && nothing == 0 && compliment != 0 && reverse != 0) {
                                    barray[j] = (byte) (barray[j] == 0 ? 1 : 0);
                                    barray[b - j - 1] = (byte) (barray[b - j - 1] == 0 ? 1 : 0);
                                }
                            }
                        }
                    }
                } else {
                    pw.println(i + 1);
                    pw.flush();
                    barray[i] = readByte();
                    pw.println(b - i);
                    pw.flush();
                    barray[b - i - 1] = readByte();
                    i++;
                    q += 2;
                }
            }

            StringBuilder output = new StringBuilder();
            for (byte value : barray) {
                output.append(value);
            }
            pw.println(output);
            pw.flush();

            if (!nextLine().equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        }

        pw.close();
        br.close();
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }

    private static byte readByte() throws IOException {
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
}