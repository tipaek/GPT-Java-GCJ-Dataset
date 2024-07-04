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
            System.out.println(1);
            System.out.flush();
            q++;
            barray[0] = readByte();
            System.out.println(b);
            System.out.flush();
            q++;
            barray[b - 1] = readByte();
            
            int i = 1;
            int reverse = 0, compliment = 0, both = 0, nothing = 0, same = 0, diff = 0;
            
            while (true) {
                if (q % 10 == 1) {
                    reverse = 0;
                    compliment = 0;
                    both = 0;
                    nothing = 0;
                    same = 0;
                    diff = 0;
                    
                    for (int j = 0; j < i; j++) {
                        if (barray[j] == barray[b - j - 1]) {
                            if (same == 0) {
                                same = 1;
                                System.out.println(j + 1);
                                System.out.flush();
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
                                if (reverse != 0 && nothing != 0) {
                                    // Do nothing
                                } else if (compliment != 0 && both != 0) {
                                    barray[j] = (byte) (barray[j] == 0 ? 1 : 0);
                                    barray[b - j - 1] = (byte) (barray[b - j - 1] == 0 ? 1 : 0);
                                }
                            }
                        } else {
                            if (diff == 0) {
                                diff = 1;
                                System.out.println(j + 1);
                                System.out.flush();
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
                                if (both != 0 && nothing != 0) {
                                    // Do nothing
                                } else if (compliment != 0 && reverse != 0) {
                                    barray[j] = (byte) (barray[j] == 0 ? 1 : 0);
                                    barray[b - j - 1] = (byte) (barray[b - j - 1] == 0 ? 1 : 0);
                                }
                            }
                        }
                    }
                } else {
                    System.out.println(i + 1);
                    System.out.flush();
                    barray[i] = readByte();

                    System.out.println(b - i);
                    System.out.flush();
                    barray[b - i - 1] = readByte();

                    i++;
                    q += 2;
                }
                if (i > b / 2) {
                    break;
                }
            }
            
            StringBuilder output = new StringBuilder();
            for (byte value : barray) {
                output.append(value);
            }
            System.out.println(output.toString());
            
            if (nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
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