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
        byte[] bArray = new byte[b];
        
        for (int z = 1; z <= t; z++) {
            int q = 1;
            pw.println(1);
            pw.flush();
            q++;
            bArray[0] = readByte();
            
            pw.println(b);
            pw.flush();
            q++;
            bArray[b - 1] = readByte();
            
            int i = 1;
            int reverse = 0, compliment = 0, both = 0, nothing = 0, same = 0, diff = 0;
            int front = 0, back = 0;
            
            while (i <= b / 2) {
                if (q % 10 == 1) {
                    reverse = compliment = both = nothing = same = diff = 0;
                    
                    for (int j = 0; j < i; j++) {
                        if (bArray[j] == bArray[b - j - 1]) {
                            if (same == 0) {
                                same = 1;
                                pw.println(j + 1);
                                pw.flush();
                                q++;
                                front = readByte();
                                
                                if (front == bArray[j]) {
                                    reverse++;
                                    nothing++;
                                } else {
                                    bArray[j] = (byte) front;
                                    bArray[b - j - 1] = (byte) front;
                                    compliment++;
                                    both++;
                                }
                            } else {
                                if (reverse != 0 && nothing != 0) {
                                    // Do nothing
                                } else if (compliment != 0 && both != 0) {
                                    bArray[j] = (byte) (bArray[j] == 0 ? 1 : 0);
                                    bArray[b - j - 1] = (byte) (bArray[b - j - 1] == 0 ? 1 : 0);
                                }
                            }
                        } else {
                            if (diff == 0) {
                                diff = 1;
                                pw.println(j + 1);
                                pw.flush();
                                q++;
                                front = readByte();
                                
                                if (front == bArray[j]) {
                                    both++;
                                    nothing++;
                                } else {
                                    bArray[b - j - 1] = bArray[j];
                                    bArray[j] = (byte) front;
                                    compliment++;
                                    reverse++;
                                }
                            } else {
                                if (both != 0 && nothing != 0) {
                                    // Do nothing
                                } else if (compliment != 0 && reverse != 0) {
                                    bArray[j] = (byte) (bArray[j] == 0 ? 1 : 0);
                                    bArray[b - j - 1] = (byte) (bArray[b - j - 1] == 0 ? 1 : 0);
                                }
                            }
                        }
                    }
                } else {
                    pw.println(i + 1);
                    pw.flush();
                    bArray[i] = readByte();
                    
                    pw.println(b - i);
                    pw.flush();
                    bArray[b - i - 1] = readByte();
                    
                    i++;
                    q += 2;
                }
            }
            
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < b; j++) {
                output.append(bArray[j]);
            }
            pw.println(output);
            pw.flush();
            
            if (nextLine().equalsIgnoreCase("Y")) {
                // System.out.println("Y");
            } else {
                // System.out.println("N");
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