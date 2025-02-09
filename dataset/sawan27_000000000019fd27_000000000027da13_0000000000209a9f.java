import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1 ; i <= T ; i++) {
            String s = sc.next();
            StringBuilder stringWithParenthesis = new StringBuilder();
            for (int j = 0 ; j < s.length() ; j++) {
                if (s.length() == 1 && s.charAt(0) == '1')
                    stringWithParenthesis.append("(1)");
                else if (s.charAt(j) == '1' && j == 0)
                    stringWithParenthesis.append("(1");
                else if (s.charAt(j) == '0') {
                    if(s.length() > 1 && (j - 1 >= 0) && s.charAt(j - 1) == '1')
                        stringWithParenthesis.append(")0");
                    else
                        stringWithParenthesis.append("0");
                }
                else {
                    if(s.length() > 1 && (j - 1 >= 0) && s.charAt(j) == '1' && j == s.length() -1 && s.charAt(j -1) == '0')
                        stringWithParenthesis.append("(");
                    if(s.charAt(j) == '1' && j == s.length() -1)
                        stringWithParenthesis.append("1)");
                    else if(s.length() > 1 && (j - 1 >= 0) && s.charAt(j) == '1' && s.charAt(j - 1) == '0')
                        stringWithParenthesis.append("(1");
                    else if(s.length() > 1 && (j - 1 >= 0) && s.charAt(j) == '1' && s.charAt(j - 1) == '1')
                        stringWithParenthesis.append("1");
                }
            }
            System.out.println("Case #"+i+": "+ stringWithParenthesis);
        }
    }
}
