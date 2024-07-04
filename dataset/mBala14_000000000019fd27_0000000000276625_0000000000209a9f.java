import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            String newS = "";
            int lastnum =-1;
            int openedParentheses = 0;
            for( int j = 0; j < s.length() ; j++){
                int cur = Character.getNumericValue(s.charAt(j));
                if (lastnum == -1 ){
                    char[] fillers = new char[cur];
                    Arrays.fill(fillers, '(');
                    newS += new String(fillers);
                    newS += cur;
                    lastnum = cur;
                    openedParentheses = cur;
                }
                else if ( lastnum != -1 && lastnum == cur ) {
                    newS += cur;
                }
                else if ( lastnum != -1 && lastnum > cur ) {
                    int removedParentheses = lastnum - cur;
                    char[] fillers = new char[removedParentheses];
                    Arrays.fill(fillers, ')');
                    newS += new String(fillers);
                    newS += cur;
                    lastnum = cur;
                    openedParentheses -= removedParentheses;
                }
                else if ( lastnum != -1 && lastnum < cur ){
                    char[] fillers = new char[cur - openedParentheses];
                    Arrays.fill(fillers, '(');
                    newS += new String(fillers);
                    newS += cur;
                    lastnum = cur;
                    openedParentheses = cur;
                }


            }
            char[] fillers = new char[openedParentheses];
            Arrays.fill(fillers, ')');
            newS += new String(fillers);
            System.out.println("Case #" + i + ": " + newS);
        }
    }
}