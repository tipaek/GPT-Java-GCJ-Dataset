import java.util.*;
class Solution {
    public static void main(String[] commands) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= T; t++) {
            String answer = "";
            for (int i = 0; i < B; i++) {
                System.out.println(i+1);
                String s = in.nextLine();
                answer += s;
            }
            System.out.println(answer);
            String result = in.nextLine();
        }
        System.exit(0);
    }
}