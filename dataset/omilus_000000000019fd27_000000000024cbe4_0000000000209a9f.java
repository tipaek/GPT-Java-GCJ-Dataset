import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    //0((2)1), (((3))1(2)), ((((4))))
    public static void solve(String s) {

        

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.valueOf(s.charAt(i) - '0');

            if (num > open) {
                int k = num - open;
                for (int j = 0; j < k; j++) {
                    sb.append("(");
                    open++;
                }
                sb.append(num);
            } else if (num == open) {
                sb.append(num);
            } else {
                int k = open - num;
                for (int j = 0; j < k; j++) {
                    sb.append(")");
                    open--;
                }
                sb.append(num);
            }
        }

        for (int i = 0; i < open; i++) {
            sb.append(")");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int cs = 1; cs <=cases; cs++) {
            String line = in.next();
            System.out.print("Case #" + cs + ": ");
            solve(line);
        }
    }
}
