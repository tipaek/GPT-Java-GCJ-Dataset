import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] ar = new String[n];
            int[] len = new int[n];
            int min = Integer.MAX_VALUE;
            int max = 0;
            int pos = 0;
            int pos1 = 0;
            int f = 0;
            boolean flag = false;

            for (int j = 0; j < n; j++) {
                ar[j] = br.readLine();
                len[j] = ar[j].length();
                char d = ar[j].charAt(0);

                if (len[j] < min) {
                    min = len[j];
                    pos = j;
                }

                if (len[j] > max) {
                    max = len[j];
                    pos1 = j;
                }

                if (d == '*') {
                    f++;
                }
            }

            if (f == n) {
                String mat = ar[pos];
                char g = mat.charAt(min - 1);

                for (int k = 1; k < max; k++) {
                    for (int j = 0; j < n; j++) {
                        String h = ar[j];
                        int l = h.length();

                        if (l > k) {
                            if ((h.charAt(l - k) != g) && (h.charAt(l - k) != '*')) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        break;
                    }
                }

                if (!flag) {
                    System.out.println("Case #" + i + ": " + ar[pos1].substring(1));
                }
            }
        }
    }
}