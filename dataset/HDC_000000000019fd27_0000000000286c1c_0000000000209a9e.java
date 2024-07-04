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
                int max = 150, start = 1;
                int[] same = null, dif = null, cp = null;
                while ((null == same || null == dif) && 0 < max) {
                    int end = start + 4;
                    for (int i = start; i <= end; ++i) {
                        int pos = (i - 1) % B + 1;
                        System.out.println(pos);
                        bit[pos - 1] = Integer.parseInt(br.readLine());
                        System.out.println((B - pos + 1));
                        bit[B - pos] = Integer.parseInt(br.readLine());
                        if (bit[pos - 1] == bit[B - pos]) same = new int[]{pos, B - pos + 1};
                        else dif = new int[]{pos, B - pos + 1};
                    }
                    start = end + 1;
                    max -= 10;
                }
                if (null == same) same = dif;
                if (null == dif) dif = same;
                cp = new int[]{dif[0], same[0], same[1], dif[1]};
                int n = B - 10;
                Arrays.fill(bit, -1);
                for (int i = 0; i < cp.length; ++i) {
                    System.out.println(cp[i]);
                    bit[cp[i] - 1] = Integer.parseInt(br.readLine());
                }
                for (int i = 1, j = 0; i <= B && j < 6; ++i) {
                    if (-1 != bit[i - 1]) continue;
                    System.out.println(i);
                    bit[i - 1] = Integer.parseInt(br.readLine());
                    j++;
                }
                start = 0;
                while (start < bit.length && -1 != bit[start]) start++;
                max -= 10;
                while (0 < n && 0 < max) {
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