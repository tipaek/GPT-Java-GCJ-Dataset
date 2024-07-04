import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    final String FILENAME = this.getClass().getSimpleName();
    final String IN = FILENAME + ".in";
//    Scanner in = new Scanner(Vestigium.class.getResourceAsStream(IN));

    PrintStream out = System.out;
    Scanner     in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private void solve(int testcase) {
        int[] inputTest = convertToInt(in.nextLine());

        int size = inputTest.length;
        int i = 0;
        StringBuffer strStart = new StringBuffer();
        StringBuffer strEnd = new StringBuffer();
        int indexStart = 0;
        int indexEnd = 0;
        for (i = 0; i < size; ++i) {
            indexStart = i;;
            indexEnd = size - 1 - i;
            if(indexStart == indexEnd) {
                if(indexStart == 0) {
                    appendParentheses(true, strStart, inputTest[indexStart], inputTest[indexStart]);
                    appendParentheses(false, strEnd, inputTest[indexStart], -1);
                } else {
                    int numParenthesesLeft = inputTest[indexStart] - inputTest[indexStart - 1];
                    int numParenthesesRight = inputTest[indexEnd] - inputTest[indexEnd + 1];
                    appendParentheses(numParenthesesLeft > 0, strStart, numParenthesesLeft, inputTest[indexStart]);
                    appendParentheses(numParenthesesRight < 0, strEnd, numParenthesesRight, -1, true);
                }
            } else if(indexStart < indexEnd) {
                if(indexStart == 0) {
                    appendParentheses(true, strStart, inputTest[indexStart], inputTest[indexStart]);
                } else {
                    int numParentheses = inputTest[indexStart] - inputTest[indexStart - 1];
                    appendParentheses(numParentheses > 0, strStart, numParentheses, inputTest[indexStart]);
                }
                if(indexEnd == size - 1) {
                    appendParentheses(false, strEnd, inputTest[indexEnd], inputTest[indexEnd], true);
                } else {
                    int numParentheses = inputTest[indexEnd] - inputTest[indexEnd + 1];
                    appendParentheses(numParentheses < 0, strEnd, numParentheses, inputTest[indexEnd], true);
                }
            } else {
                if(indexStart == indexEnd + 1) {
                    int numParentheses = inputTest[indexStart] - inputTest[indexStart - 1];
                    appendParentheses(numParentheses > 0, strStart, numParentheses, -1);
                }
                break;
            }
        }

        out.println("Case #" + testcase + ": " + strStart.append(strEnd).toString());
    }

    void appendParentheses(boolean open, StringBuffer stringBuffer, int num, int numberAppend) {
        appendParentheses(open, stringBuffer, num, numberAppend, false);
    }
    void appendParentheses(boolean open, StringBuffer stringBuffer, int num, int numberAppend, boolean numFirst) {
        int total = Math.abs(num);
        for(int i = 0; i < total; ++i) {
            if(open) {
                if(numFirst) {
                    stringBuffer.insert(0, "(");
                } else {
                    stringBuffer.append("(");
                }
            } else {
                if(numFirst) {
                    stringBuffer.insert(0,")");
                } else {
                    stringBuffer.append(")");
                }
            }
        }
        if(numberAppend > -1) {
            if(numFirst) {
                stringBuffer.insert(0, numberAppend);
            } else {
                stringBuffer.append(numberAppend);
            }
        }
    }

    int[] convertToInt(String strTestCase) {
        int length = strTestCase.length();
        int[] res = new int[length];
        int i = 0;
        for(i = 0; i < length; ++i) {
            res[i] = Character.getNumericValue(strTestCase.charAt(i));
        }
        return res;
    }

    void run() {
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
