import java.io.*;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        int T = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);

        if (B == 10) {
            B10(T);
        } else if (B == 20) {
            B20(T);
        } else {
            B100(T);
        }
    }

    private static void B10(int T) throws IOException {
        for (int t = 1; t <= T; ++t) {
            char[] arr = new char[10];
            for (int b = 0; b < 10; ++b) {
                System.out.println(b + 1);
                int bit = Integer.parseInt(br.readLine());
                arr[b] = (char) ('0' + bit);
            }
            System.out.println(new String(arr));
            char c = br.readLine().charAt(0);
            if (c == 'N') {
                System.exit(0);
            }
        }
    }

    private static void B20(int T) throws IOException {
        // for (int t = 1; t <= T; ++t) {
        //     char[] arr = new char[10];
        //     for (int b = 0; b < 10; ++b) {
        //         System.out.println(b + 1);
        //         int bit = Integer.parseInt(br.readLine());
        //         arr[b] = '0' + bit;
        //     }
        //     System.out.println(new String(arr));
        // }
    }

    private static void B100(int T) throws IOException {
        // for (int t = 1; t <= T; ++t) {
        //     char[] arr = new char[10];
        //     for (int b = 0; b < 10; ++b) {
        //         System.out.println(b + 1);
        //         int bit = Integer.parseInt(br.readLine());
        //         arr[b] = '0' + bit;
        //     }
        //     System.out.println(new String(arr));
        // }
    }
}