import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        String S = scan.next();
        int currentDepth = 0;
        StringBuilder Sprime = new StringBuilder();
        for (char c : S.toCharArray()) {
            int i = c - '0';
            while (i > currentDepth) {
                Sprime.append("(");
                currentDepth++;
            }
            while (i < currentDepth) {
                Sprime.append(")");
                currentDepth--;
            }
            Sprime.append(i);
        }
        while (currentDepth > 0) {
            Sprime.append(")");
            currentDepth--;
        }


        System.out.println(Sprime.toString());
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }

}