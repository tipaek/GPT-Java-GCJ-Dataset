import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        //BufferedReader bufferRead = new BufferedReader(new FileReader("A-small-practice.in"));
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new FileWriter("A-small-practice.out"));

        int caseCnt = Integer.parseInt(bufferRead.readLine());

        for(int l=0; l<caseCnt; l++) {
            String caseData = bufferRead.readLine();

            //out.println("Case #"+(l+1)+": "+checkChaos(N, L, source, target));\
            System.out.println("Case #"+(l+1)+": "+generateSquares(caseData));
        }

        //out.close();
        bufferRead.close();
    }

    private static String generateSquares(String digits) {
        final StringBuilder sb = new StringBuilder();

        char prevChar = '0';
        boolean isFirst = true;
        for (int i = 0; i < digits.length(); i++) {
            char currChar = digits.charAt(i);
            if (currChar == '0') {
                if (prevChar != currChar) {
                    sb.append(')');
                }
                sb.append(currChar);
                prevChar = currChar;
                continue;
            }
            if (currChar != prevChar) {
                if (!isFirst && prevChar != '0') {
                    sb.append(')');
                }
                sb.append('(');
            }
            sb.append(currChar);
            isFirst = false;
            prevChar = currChar;
        }
        if (!isFirst && prevChar != '0') {
            sb.append(')');
        }

        return sb.toString();
    }
}
