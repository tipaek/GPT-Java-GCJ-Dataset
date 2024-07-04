import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            String nesting = "";
            nesting+=addParentheses(Character.getNumericValue(n.charAt(0)),'(');
                nesting+=n.charAt(0);

            for (int j = 1; j < n.length(); ++j) {
                if (Character.getNumericValue(n.charAt(j))>Character.getNumericValue(n.charAt(j-1))) {
                    nesting+= addParentheses(Character.getNumericValue(n.charAt(j))-Character.getNumericValue(n.charAt(j-1)),'(');
                }

                if (Character.getNumericValue(n.charAt(j))<Character.getNumericValue(n.charAt(j-1))) {
                    nesting+= addParentheses(Character.getNumericValue(n.charAt(j-1))-Character.getNumericValue(n.charAt(j)),')');

                }
                nesting += n.charAt(j);
            }
            nesting+=addParentheses(Character.getNumericValue(n.charAt(n.length()-1)),')');
            System.out.println("Case #" + i + ": " + nesting);
        }
    }
    public static String addParentheses(int n,char parenthese){
        String result="";
        for(int k=0;k<n;++k)
            result+=parenthese;
        return result;
    }
}
