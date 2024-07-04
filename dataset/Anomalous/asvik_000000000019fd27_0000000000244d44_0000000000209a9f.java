import java.util.Scanner;

public class Solution {

    public static void nestingDepth(int caseNumber, String sequence) {
        StringBuilder result = new StringBuilder();
        int length = sequence.length();
        
        for (int i = 0; i < length - 1; i++) {
            char current = sequence.charAt(i);
            char next = sequence.charAt(i + 1);
            
            if (current == '0' && next == '0') {
                result.append("0");
            } else if (current == '0' && next == '1') {
                result.append("0(");
            } else if (current == '1' && next == '0') {
                if (i == 0) {
                    result.append("(1)");
                } else {
                    result.append("1)");
                }
            } else if (i > 0 && sequence.charAt(i - 1) == '1' && current == '1' && next == '1') {
                result.append("1");
            } else if (current == '1' && next == '1') {
                result.append("(1");
            }
        }
        
        if (sequence.charAt(length - 1) == '0') {
            result.append("0");
        } else {
            if (length == 1) {
                result.append("(1)");
            } else {
                result.append("1)");
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            String sequence = scanner.nextLine();
            nestingDepth(i + 1, sequence);
        }

        scanner.close();
    }
}