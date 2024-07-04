import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            String input = sc.next();
            LinkedList<String> outputList = new LinkedList<>();

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                for (int i = 0; i < digit; i++) {
                    outputList.addLast("(");
                }
                outputList.addLast(String.valueOf(digit));
                for (int i = 0; i < digit; i++) {
                    outputList.addLast(")");
                }
            }

            for (int i = 1; i < outputList.size(); i++) {
                if (outputList.get(i).equals("(") && outputList.get(i - 1).equals(")")) {
                    outputList.remove(i);
                    outputList.remove(i - 1);
                    i -= 2;
                }
            }

            StringBuilder result = new StringBuilder();
            for (String s : outputList) {
                result.append(s);
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }
}