import java.io.*;
import java.util.*;

public class Answer {
    public static void main(String[] args) throws Exception {
        String[] leftBrackets = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
        String[] rightBrackets = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};
        
        Scanner scanner = initializeScanner();
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            int previous = 0;
            StringBuilder output = new StringBuilder();
            
            for (int j = 0; j < line.length(); j++) {
                int currentDigit = Character.getNumericValue(line.charAt(j));
                if (currentDigit > previous) {
                    output.append(leftBrackets[currentDigit - previous]);
                } else if (currentDigit < previous) {
                    output.append(rightBrackets[previous - currentDigit]);
                }
                output.append(currentDigit);
                if (j == line.length() - 1) {
                    output.append(rightBrackets[currentDigit]);
                }
                previous = currentDigit;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
    
    static Scanner initializeScanner() throws Exception {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // return new Scanner(new File("input.txt"));
    }
}