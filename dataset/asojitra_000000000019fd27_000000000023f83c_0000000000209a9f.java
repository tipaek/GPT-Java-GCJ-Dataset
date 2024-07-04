import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        for(int testcase = 0; testcase < testcases; testcase++) {
            String input = scan.next();
            System.out.println("Case #"+(testcase+1) +" "+buildNestingDepthString(input));
        }
        scan.close();
    }


    //122
    //0000
    //101
    //111000
    //1
    //221
    public static String buildNestingDepthString(String input) {
        int length = input.length();
        int previous = 0;
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < length; index++) {
            char c = input.charAt(index);
            int val = Character.getNumericValue(c);
            if(val > previous) addOpenParenthesis(sb, val - previous);
            else if(val < previous) addClosingParenthesis(sb, previous - val);
            sb.append(val);
            previous = val;
        }
        addClosingParenthesis(sb, previous);
        return sb.toString();
    }

    public static void addOpenParenthesis(StringBuilder sb, int times) {
        int index = 0;
        while(index < times) {
            sb.append("(");
            index++;
        }
    }

    public static void addClosingParenthesis(StringBuilder sb, int times) {
        int index = 0;
        while(index < times) {
            sb.append(")");
            index++;
        }
    }
}