import java.io.*;
import java.util.*;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int T = in.nextInt();
        int B = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int[] bits = new int[B];
            bits[0] = ask(0);
            int left = 1;
            int right = B-1;
            for (int j = 2; j <= 150 && left <= right; j++) {
                if (j % 10 == 1) {
                    int updated = ask(0);
                    boolean flipped = bits[0] != updated;
                    int l = Math.min(left, B-right-1);
                    int nextAsk = -1;
                    for (int k = 0; k < l; k++) {
                        if ((bits[0] == bits[B-1]) == (bits[k] == bits[B-k-1])) {
                            if (flipped) {
                                bits[k] = 1 - bits[k];
                                bits[B-k-1] = 1 - bits[B-k-1];
                            } else {
                                // nothing to do
                            }
                        } else {
                            nextAsk = k;
                        }
                    }
                    if (nextAsk > -1) {
                        j++;
                        updated = ask(nextAsk);
                        flipped = bits[nextAsk] != updated;
                        for (int k = 0; k < l; k++) {
                            if ((bits[nextAsk] == bits[B-nextAsk-1]) == (bits[k] == bits[B-k-1])) {
                                if (flipped) {
                                    bits[k] = 1 - bits[k];
                                    bits[B-k-1] = 1 - bits[B-k-1];
                                } else {
                                    // nothing to do
                                }
                            }
                        }
                    }
                } else {
                    if (B-right-1 < left) {
                        bits[right] = ask(right);
                        right--;
                    } else {
                        bits[left] = ask(left);
                        left++;
                    }
                }
            }
            if (!guess(bits)) {
                break;
            }
        }
    }

    public static int ask(int p) {
        System.out.println(p+1);
        return in.nextInt();
    }

    public static boolean guess(int[] bits) {
        for (int b: bits) {
            System.out.print(b);
        }
        System.out.println();
        return in.next().equals("Y");
    }


}
