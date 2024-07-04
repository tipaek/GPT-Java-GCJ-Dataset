import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            boolean isEnd = false;
            if (b == Math.pow(10, 9) - 5) {
                for (int i = 0; i <= 10; i++) {
                    if (!isEnd) {
                        for (int j = 0; j <= 10; j++) {
                            System.out.println((-5 + i) + " " + (-5 + j));
                            String str = in.next();
                            if (str.equals("CENTER")) {
                                isEnd = true;
                                break;
                            }
                        }
                    }
                }
            }

        }
    }
}