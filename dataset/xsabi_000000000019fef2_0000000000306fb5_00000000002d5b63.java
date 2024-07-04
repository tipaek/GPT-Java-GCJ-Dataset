import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int A = in.nextInt();
        int B = Integer.parseInt(in.nextLine());
        int x, y;
        int H = 1000000000;
        String answer;
        for (int t = 1; t <= T; t++) {
            int turn = 0;
            y = H;
            x = 0;
            answer = "MISS";
            while (answer.equals("MISS")) {
                System.out.println(x + " " + y);
                answer = in.nextLine();
                y--;
            }
            y -= H;
            x = -5;
            answer = "MISS";
            while (!answer.equals("CENTER")) {
                System.out.println(x + " " + y);
                answer = in.nextLine();
                if (answer.equals("WRONG")) {
                    answer = "CENTER";
                }                  
                x++;
            }
        }
    }
}