import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringBuilder stringBuffer = new StringBuilder();
        int i = nextInt();
        int s = 0;
        for (int j = 0; j < i; j++) {
            stringBuffer.delete(0, stringBuffer.length());
            String k = nextToken();
            int[] starts = new int[k.length()];
            int[] ends = new int[k.length()];
            starts[0] = (k.charAt(0) - '0');
            s = starts[0];
            for (int l = 1; l < k.length(); l++) {
                if (k.charAt(l) < k.charAt(l - 1)) {
                    ends[l] = (k.charAt(l - 1) - '0') - (k.charAt(l) - '0');
                    s -= ends[l];
                    continue;
                }
                if (k.charAt(l) > k.charAt(l - 1)) {
                    starts[l] = (k.charAt(l) - '0') - s;
                    s += starts[l];
                    continue;
                }
            }
            int toWriteAfter = s;

            for (int h = 0; h < k.length(); h++) {
                if (starts[h] != 0 && ends[h] == 0) {
                    for (int c = 0; c < starts[h]; c++) {
                        stringBuffer.append('(');
                    }
                    stringBuffer.append(k.charAt(h));
                } else if (ends[h] != 0 && starts[h] == 0) {
                    for (int c = 0; c < ends[h]; c++) {
                        stringBuffer.append(')');
                    }
                    stringBuffer.append(k.charAt(h));
                } else {
                    stringBuffer.append(k.charAt(h));
                }
            }
            for (int c = 0; c < toWriteAfter; c++) {
                stringBuffer.append(')');
            }

            System.out.println("\n" + "Case #" + (j + 1) + ":" + ' ' + stringBuffer.toString());
        }
        pw.close();
    }
}
