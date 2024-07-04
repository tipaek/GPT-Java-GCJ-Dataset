import java.util.*;

public class Solution {
    Scanner scanner = new Scanner(System.in);

    private void exe() {
        int test = scanner.nextInt();
        for (int z = 0; z < test; z++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int t = z + 1;
            System.out.print("Case #" + t + ": ");
            if (r == 1 || s == 1) {
                System.out.print(0);
            } else {
                int a = (r - 1) * s - 1;
                if (s == 2) {
                    a = Math.min(a, (s - 1) * r - 1);
                }
                System.out.println(a);
                if (s == 2) {
                    for (int i = 0; i < r - 1; i++) {
                        int c = r - i;
                        int d = c - 1;
                        System.out.println(c + " " + d);
                    }
                } else {
                    for (int i = 0; i < r - 1; i++) {
                        for (int j = 0; j < s; j++) {
                            if (j < s - 1) {
                                int c = s * (j + 1);
                                System.out.println(c + " " + 1);
                            } else if (i < r - 2) {
                                int d = (r - 1) * s;
                                System.out.println(s + " " + d);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution prob = new Solution();
        prob.exe();
    }
}