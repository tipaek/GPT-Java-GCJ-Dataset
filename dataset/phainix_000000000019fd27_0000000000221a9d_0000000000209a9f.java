import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        scan.nextLine();
        for(int i = 0; i < testCase; i++) {
            // System.out.println("Starting test case "+(i+1));
            String s = scan.nextLine();
            // System.out.println(s);

            String result = compute(s);

            System.out.printf("Case #%d: %s", i+1, result);
            System.out.println("");
        }
    }

    private static String compute(String s) {
        // System.out.println(s.length());
        String result = "";
        String open = "(";
        String close = ")";
        int open_count = 0;
        int length = s.length();

        for(int i = 0; i < length; i++) {
            int val = Integer.parseInt(String.valueOf(s.charAt(i)));
            int next_val = (i < s.length() - 1) ? Integer.parseInt(String.valueOf(s.charAt(i + 1))) : 0;
            int prev_val = (i > 0) ? Integer.parseInt(String.valueOf(s.charAt(i - 1))) : 0;
            // Evaluate opening bracket
            if(val > prev_val) {
                result += repeat(open, val - open_count);
                open_count += val - open_count;
            }

            // Append val
            result += String.valueOf(s.charAt(i));

            // Evaluate closing bracket
            if(val > next_val) {
                result += repeat(close, val - next_val);
                open_count -= val - next_val;
            }

            if(val < next_val) {
                // result += repeat(close, open_count);
                // open_count -= open_count;
            }
        }
        return result;
    }
    
    
    private static String repeat(String s, int num) {
        String str = "";
        for(int i = 0; i < num; i++) {
            str += s;
        }
        return str;
    }
    
}
