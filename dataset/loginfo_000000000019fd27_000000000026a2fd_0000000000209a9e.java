import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            boolean[] bits = new boolean[B];

            for (int t = 1; t <= T; t++) {
                for (int i = 1; i <= 10; i++) {
                    bw.write(i);
                    bw.flush();
                    bits[i - 1] = br.readLine().equals("1");
                }

                StringBuilder answer = new StringBuilder();
                for (boolean bit : bits) {
                    answer.append(booleanToChar(bit));
                }

                bw.write(answer.toString());
                bw.flush();

                if (!br.readLine().equals("Y")) {
                    return;
                }
            }

        }
    }

    private static char booleanToChar(boolean b) {
        return b ? '1' : '0';
    }

    private static void complement(boolean[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = !bits[i];
        }
    }

    private static void reverse(boolean[] bits) {
        int halfLength = bits.length / 2;
        for (int i = 0; i < halfLength; i++) {
            boolean temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }

    private static void completmentAndReverse(boolean[] bits) {
        complement(bits);
        reverse(bits);
    }
}