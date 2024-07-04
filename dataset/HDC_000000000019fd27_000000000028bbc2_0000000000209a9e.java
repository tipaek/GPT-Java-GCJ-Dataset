import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("\\s+");
        int nt = Integer.parseInt(data[0]), B = Integer.parseInt(data[1]);
        for (int t = 1; t <= nt; ++t) {
            // flip, reverse, flip+reverse, nothing
            int[] bit = new int[B];
            if (10 == B) {
                for (int i = 1; i <= B; ++i) {
                    System.out.println(i);
                    bit[i - 1] = Integer.parseInt(br.readLine());
                }
            } else {
                int[] same = null, dif = null, cp = null;
                Arrays.fill(bit, -1);
                for (int i = 1; i <= 5; ++i) {
                    System.out.println(i);
                    bit[i - 1] = Integer.parseInt(br.readLine());
                    System.out.println((B - i + 1));
                    bit[B - i] = Integer.parseInt(br.readLine());
                    if (bit[i - 1] == bit[B - i]) same = new int[]{i, B - i + 1};
                    else dif = new int[]{i, B - i + 1};
                }
                int n = B - 10, max = 140, start = 6;
                while (0 < n && 0 < max) {
                    if (null == same) {
                        int[] rp = new int[2];
                        for (int i = 0; i < dif.length; ++i) {
                            System.out.println(dif[i]);
                            rp[i] = Integer.parseInt(br.readLine());
                        }
                        if (bit[dif[0] - 1] == rp[0] && bit[dif[1] - 1] == rp[1]) {
                            // flip + reverse or nothing
                        } else {
                            flip(bit);
                        }
                        for (int i = start; i <= start + 3 && 0 < n; ++i) {
                            System.out.println(i);
                            bit[i - 1] = Integer.parseInt(br.readLine());
                            System.out.println((B - i + 1));
                            bit[B - i] = Integer.parseInt(br.readLine());
                            if (bit[i - 1] == bit[B - i]) same = new int[]{i, B - i + 1};
                            else dif = new int[]{i, B - i + 1};
                            n -= 2;
                            max -= 2;
                        }
                        start += 4;
                    } else if (null == dif) {
                        int[] rp = new int[2];
                        for (int i = 0; i < 2; ++i) {
                            System.out.println(same[i]);
                            rp[i] = Integer.parseInt(br.readLine());
                        }
                        if (bit[same[0] - 1] == rp[0] && bit[same[1] - 1] == rp[1]) {
                            // reverse or nothing
                        } else {
                            flip(bit);
                        }
                        for (int i = start; i <= start + 3 && 0 < n; ++i) {
                            System.out.println(i);
                            bit[i - 1] = Integer.parseInt(br.readLine());
                            System.out.println((B - i + 1));
                            bit[B - i] = Integer.parseInt(br.readLine());
                            if (bit[i - 1] == bit[B - i]) same = new int[]{i, B - i + 1};
                            else dif = new int[]{i, B - i + 1};
                            n -= 2;
                            max -= 2;
                        }
                        start += 4;
                    } else {
                        if (null == cp) cp = new int[]{dif[0], same[0], same[1], dif[1]};
                        int[] rp = new int[4];
                        for (int i = 0; i < cp.length; ++i) {
                            if (2 == i) continue;
                            System.out.println(cp[i]);
                            rp[i] = Integer.parseInt(br.readLine());
                        }
                        if (bit[cp[0] - 1] == rp[0] && bit[cp[1] - 1] == rp[1] && bit[cp[3] - 1] == rp[3]) {}
                        else if ((bit[cp[0] - 1] ^ 1) == rp[0] && (bit[cp[2] - 1] ^ 1) == rp[1] && (bit[cp[3] - 1] ^ 1) == rp[3]) {
                            // flip
                            flip(bit);
                        } else if ((bit[cp[3] - 1] ^ 1) == rp[0] && (bit[cp[2] - 1] ^ 1) == rp[1] && (bit[cp[0] - 1] ^ 1) == rp[3]) {
                            // flip + reverse
                            reverse(bit);
                            flip(bit);
                        } else if (bit[cp[3] - 1] == rp[0] && bit[cp[2] - 1] == rp[1] && bit[cp[0] - 1] == rp[3]) {
                            // reverse
                            reverse(bit);
                        }
                        for (int i = 0; i < 7 && 0 < n; start = (start + 1) % B) {
                            if (-1 != bit[start]) continue;
                            System.out.println((start + 1));
                            bit[start] = Integer.parseInt(br.readLine());
                            i++;
                            n--;
                            max--;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i : bit) sb.append(i);
            System.out.println(sb.toString());
            if ("N".equals(br.readLine())) break;
        }
        br.close();
    }
    private static void flip(int[] num) {
        for (int i = 0; i < num.length; ++i) {
            if (-1 == num[i]) continue;
            num[i] ^= 1;
        }
    }
    private static void reverse(int[] num) {
        int i = 0, j = num.length - 1;
        while (i < j) {
            if (num[i] != num[j]) {
                num[i] ^= num[j];
                num[j] ^= num[i];
                num[i] ^= num[j];
            }
            i++;
            j--;
        }
    }
}