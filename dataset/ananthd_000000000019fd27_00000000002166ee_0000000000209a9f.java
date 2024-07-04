import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int currentParens = 0;
            StringBuilder builder = new StringBuilder();
            String stringToParse = in.next();
            for (int j = 0; j< stringToParse.length(); j++){
                int value = Integer.parseInt(stringToParse.substring(j,j+1));
                if (currentParens == value) {
                    builder.append(value);
                }
                else if (currentParens < value){
                    int addedNum = value - currentParens;
                    builder.append(Solution.parenBuilder(true, addedNum));
                    builder.append(value);
                    currentParens = value;
                }
                else{
                    int subNum = currentParens - value;
                    builder.append(Solution.parenBuilder(false, subNum));
                    builder.append(value);
                    currentParens = value;
                }
            }
            builder.append(Solution.parenBuilder(false, currentParens));
            System.out.println("Case #" + i +": "+builder.toString());
        }
    }
    private static String parenBuilder(boolean left, int num){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (left) {
                builder.append("(");
            }
            else{
                builder.append(")");
            }
        }
        return builder.toString();
    }
}
