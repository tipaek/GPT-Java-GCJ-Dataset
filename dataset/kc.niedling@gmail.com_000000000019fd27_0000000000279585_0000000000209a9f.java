import java.util.Scanner;

//Google CodeJam Nesting Depth
public class Solution {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int c = 1; c <= tc; c++) {
            String s = in.next();
            String result = solve(s);
            System.out.println("Case #" + c + ": " + result);
        }
    }

    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int numOpenBrackets = 0;
        char prevValue = '\u0000'; //null char
        int intPrevValue = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int intVal = ch - '0';  //gives the int value
            //case 1: first value in string
            if (i == 0) {
                if (prevValue == '\u0000' && ch == '0') {
                    sb.append(ch);
                    prevValue = ch;
                    intPrevValue = 0;
                } else {
                    for (int j = 0; j < intVal; j++) {
                        sb.append('(');
                        numOpenBrackets++;
                    }
                    sb.append(ch);
                }
            } else {
                //case 2: intVal < intPrevValue
                //  (((3))1(2))
                //  3 open brackets
                if (intVal < intPrevValue) {
                    int difference = intPrevValue - intVal;
                    for (int k = 0; k < difference; k++) {
                        sb.append(')');
                    }
                    sb.append(ch);
                    numOpenBrackets -= difference;
                }
                //case 3: intVal > intPrevVal
                //  (((3))1(2))
                //  1 open bracket, intVal 2, intPrevValue is 1
                else if (intVal > intPrevValue) {
                    int difference = intVal - intPrevValue;
                    for (int k = 0; k < difference; k++) {
                        sb.append('(');
                    }
                    sb.append(ch);
                    numOpenBrackets += difference;
                }
                //case 4: same value
                else if (intVal == intPrevValue && intPrevValue != -1) {
                    sb.append(ch);
                }
            }
            prevValue = ch;
            intPrevValue = intVal;
        }
        for(int k = 0; k < numOpenBrackets; k++) {
            sb.append(')');
        }
        return sb.toString();
    }
}
