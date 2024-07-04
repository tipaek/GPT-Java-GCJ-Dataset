import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 0; i < cases; i++) {
            String vals = scanner.nextLine();
            solveCase(i, vals);
        }
    }

    public static void solveCase(int caseNum, String problem) {
        System.out.print("Case #" + (caseNum + 1) + ": ");
        StringBuilder solution = new StringBuilder("");

        int offset = 0;
        for(int i = 0; i < problem.length(); i++, offset++) {
            int currVal = problem.charAt(i)-48;
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < currVal; j++) {
                temp.insert(0, "(");
                temp.append(")");
            }
            temp.insert(temp.length() / 2, currVal);
            solution.append(temp);

            int val;
            while((val = solution.indexOf(")(")) != -1) {
                solution.delete(val, val + 2);
            }
        }

        System.out.println(solution);
    }
}