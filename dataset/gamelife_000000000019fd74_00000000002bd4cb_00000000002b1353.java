
import java.util.*;

public class Solution {
    private static String output1 = "Case #%d: %s";
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
        int n = scanner.nextInt();
        String result = "";
        if (n <= 500) {
            for (int i = 1 ; i <= n ; i++) {
                result += String.format(("\n%d 1"),i);
            }
        }
        if (n == 501) {
            result += "\n1 1";
            result += "\n2 1";
            result += "\n3 2";
            result += "\n3 1";
            for (int i = 4 ; i <= n ; i++) {
                result += String.format(("\n%d 1"),i);
            }
        }

        System.out.println(String.format(output1, caseNum, result));
    }

}
