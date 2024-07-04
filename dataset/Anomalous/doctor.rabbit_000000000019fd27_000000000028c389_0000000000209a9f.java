import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = Integer.parseInt(in.nextLine());
        
        for (int c = 1; c <= numOfCases; c++) {
            String caseString = in.nextLine();
            int currentDepth = 0;
            List<Character> outputList = new ArrayList<>();

            for (char ch : caseString.toCharArray()) {
                if (ch == '0') {
                    while (currentDepth > 0) {
                        outputList.add(')');
                        currentDepth--;
                    }
                    outputList.add(ch);
                } else { // ch == '1'
                    while (currentDepth < 1) {
                        outputList.add('(');
                        currentDepth++;
                    }
                    outputList.add(ch);
                }
            }

            while (currentDepth > 0) {
                outputList.add(')');
                currentDepth--;
            }

            StringBuilder builder = new StringBuilder();
            for (char value : outputList) {
                builder.append(value);
            }

            System.out.println("Case #" + c + ": " + builder.toString());
        }
    }
}