import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < t; i++) {
            String s = scan.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + solve(s));
        }
    }
    
    public static String solve(String s) {
        String ret = "";
        int depth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int val = Integer.valueOf(s.charAt(i) + "");
            if (depth < val) {
                while (depth != val) {
                    ret += "(";
                    depth++;
                }
            }
            else if (depth > val) {
                while (depth != val) {
                    ret += ")";
                    depth--;
                }
            }
            if (depth == val) ret += (val + "");
        }
        while (depth != 0) {
            ret += ")";
            depth--;
        }
        return ret;
    }
}