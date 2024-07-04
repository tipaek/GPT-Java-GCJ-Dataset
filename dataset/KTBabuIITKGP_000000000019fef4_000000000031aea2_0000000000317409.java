import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String S = sc.next().trim();
            int minutes = 0;
            if (Math.abs(X) + Math.abs(Y) <= minutes) {
                System.out.println("Case #" + t + ": " + minutes);
            }else {
                for (char c : S.toCharArray()) {
                    switch (c) {
                        case 'N':
                            Y++;
                            break;
                        case 'S':
                            Y--;
                            break;
                        case 'E':
                            X++;
                            break;
                        case 'W':
                            X--;
                            break;
                    }
                    minutes++;

                    if (Math.abs(X) + Math.abs(Y) <= minutes) {
                        System.out.println("Case #" + t + ": " + minutes);
                        break;
                    }
                }
                if (Math.abs(X) + Math.abs(Y) > minutes) {
                    System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                }
            }
        }
    }
}
