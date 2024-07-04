import java.util.Scanner;

public class Solution {
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

    public static String output = "Case #%d: %s";
    public static String output1 = "Case #%d: IMPOSSIBLE";
    public void getAnswer(int caseNum, Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();


        if (dfs(x, y)) {
            System.out.println(String.format(output, caseNum, sb.toString()));
        } else {
            System.out.println(String.format(output1, caseNum));
        }

    }

    StringBuilder sb = new StringBuilder();
    public boolean dfs(int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        }
        int rx = Math.abs(x % 2);
        int ry = Math.abs(y % 2);
        if (rx == ry) {
            return false;
        }

        if (rx == 1) {
            int direction = x > 0 ? -1: 1;
            if (dfs((x+direction)/2, y/2)) {
                if (direction > 0) {
                    sb.append('W');
                } else  {
                    sb.append('E');
                }
                return true;
            } else if (dfs((x-direction)/2, y/2)) {
                if (direction > 0) {
                    sb.append('E');
                } else  {
                    sb.append('W');
                }
                return true;
            }

        } else {
            int direction = y > 0 ? -1: 1;
            if (dfs(x/2, (y+direction)/2)) {
                if (direction > 0) {
                    sb.append('N');
                } else  {
                    sb.append('S');
                }
                return true;
            } else if (dfs(x/2, (y-direction)/2)) {
                if (direction > 0) {
                    sb.append('S');
                } else  {
                    sb.append('N');
                }
                return true;
            }
        }


        return false;
    }


}
