import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previousNum = 0;
            
            for (char character : inputLine.toCharArray()) {
                int currentNum = Character.getNumericValue(character);

                if (currentNum > previousNum) {
                    for (int j = 0; j < currentNum - previousNum; j++) {
                        output.append("(");
                    }
                } else if (currentNum < previousNum) {
                    for (int j = 0; j < previousNum - currentNum; j++) {
                        output.append(")");
                    }
                }
                
                output.append(currentNum);
                previousNum = currentNum;
            }
            
            for (int j = 0; j < previousNum; j++) {
                output.append(")");
            }
            
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
        
        scanner.close();
    }
}