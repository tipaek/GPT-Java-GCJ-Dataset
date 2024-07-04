import java.util.Scanner;

public class Solution {

    public static String solve(Scanner input, int B) {
        int[] bits = new int[B + 1];
        int left = B / 2;
        int right = left + 1;
        int move = 1;
        while (true) {
            while ((move < 10 || move % 10 != 1) && left > 0) {
                System.out.println(left);
                bits[left] = input.nextInt();
                left--;
                move++;

                System.out.println(right);
                bits[right] = input.nextInt();
                right++;
                move++;
            }

            if (move % 10 == 1 && left > 0) {
                // detect complemented
                int flag = 0;
                for (int i = 1; i + left <= B / 2; i++) {
                    if (bits[left + i] == bits[right - i]) {
                        move++;

                        System.out.println(left + i);
                        int newVal = input.nextInt();
                        flag = 1;
                        if (bits[left + i] != newVal) {
                            for (int j = left + 1; j < right; j++) {
                                bits[j] ^= 1;
                            }
                        }
                        break;
                    }
                }

                if (flag == 0) {
                    System.out.println(1);
                    input.nextInt();
                    move++;
                }

                flag = 0;

                // detect reverse
                for (int i = 1; i + left <= B / 2; i++) {
                    if (bits[left + i] != bits[right - i]) {
                        move++;
                        System.out.println(left + i);
                        int newVal = input.nextInt();
                        flag = 1;
                        if (bits[left + i] != newVal) {
                            int n = B/2;
                            for (int j = 1; j <= n; j++) {
                                int t = bits[B - j + 1];
                                bits[B - j + 1] = bits[j];
                                bits[j] = t;
                            }
                        }
                    }
                }

                if (flag == 0) {
                    System.out.println(1);
                    input.nextInt();
                    move++;
                }
            } else {
                StringBuilder builder = new StringBuilder();

                for (int bit : bits) {
                    builder.append(bit);
                }
                System.out.println(builder.toString());
                String res = input.next();
                return res;
            }
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            String res = solve(input, B);

            if ("N".equals(res)) {
                break;
            }
        }
    }
}