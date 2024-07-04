import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("data/input.txt"));

        int T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; ++t) {
            String result = solve(in.readLine());
            System.out.println("Case #" + (t + 1) + ": " + result);
        }

    }

    private static String solve(String sin) {
        StringBuilder sb = new StringBuilder();

        int lastNum = 0;
        int d = 0;
        for (int i = 0, n = sin.length(); i < n; ++i) {
            int currentNum = Integer.parseInt( sin.substring(i, i + 1));
            if (currentNum > lastNum) {
                int addLeft = currentNum - lastNum;
                add(sb, '(', addLeft);
                d = currentNum;
            } else if (currentNum < lastNum) {
                int addRight = lastNum - currentNum;
                add(sb, ')', addRight);
                d = currentNum;
            }

            sb.append(currentNum);
            lastNum = currentNum;
        }

        add(sb, ')', d);
        return  sb.toString();
    }


    private static void add(StringBuilder sb, char c, int num) {
        for (int i = 0; i < num; ++i) {
            sb.append(c);
        }
    }

    public static void main2(String[] args) {
        System.out.println(solve("0000"));
        System.out.println(solve("101"));
        System.out.println(solve("111000"));
        System.out.println(solve("1"));

        System.out.println(solve("021"));
        System.out.println(solve("312"));
        System.out.println(solve("4"));
        System.out.println(solve("221"));
    }



}
