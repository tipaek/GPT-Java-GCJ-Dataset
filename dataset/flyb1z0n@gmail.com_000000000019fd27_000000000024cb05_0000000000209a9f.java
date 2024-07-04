
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();
        String line = sc.nextLine();
        for (int t = 1; t <= testCaseCount; t++) {
            line = sc.nextLine();
            String result = solve(line);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    public static String solve(String line) {
        int cop = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            int dig = Integer.parseInt(String.valueOf(line.charAt(i)));
            if (cop == dig) {
                sb.append(dig);
                continue;
            }
            while (cop > dig)
            {
                sb.append(")");
                cop--;
            }
            while (cop < dig)
            {
                sb.append("(");
                cop++;
            }
            sb.append(dig);
        }
        while (cop > 0)
        {
            sb.append(")");
            cop--;
        }
        return sb.toString();
    }
}