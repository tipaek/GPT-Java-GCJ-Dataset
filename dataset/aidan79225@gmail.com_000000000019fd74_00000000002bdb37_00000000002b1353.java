import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: ";
    private static String output2 = "%d %d";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getAnswer(int caseNum, Scanner scanner) {
        int sum = scanner.nextInt();
        int t = 1;
        boolean isStart = false;
        int step = 1;
        List<Pair> ans = new ArrayList<>();
        while (sum >= t) {
            sum -= t;
            if (isStart) {
                for (int i = 1; i <= step; ++i) {
                    ans.add(new Pair(step, i));
                }
            } else {
                for (int i = step; i > 0; --i) {
                    ans.add(new Pair(step, i));
                }
            }
            isStart = !isStart;
            t = (t<<1);
            ++step;
        }

        while (sum > 0) {
            --sum;
            if (isStart) {
                ans.add(new Pair(step, 1));
            } else {
                ans.add(new Pair(step, step));
            }
            ++step;
        }



        System.out.println(String.format(output1, caseNum));
        for (Pair p : ans) {
            System.out.println(String.format(output2, p.x, p.y));
        }
    }

    class Pair {
        public int x;
        public int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
