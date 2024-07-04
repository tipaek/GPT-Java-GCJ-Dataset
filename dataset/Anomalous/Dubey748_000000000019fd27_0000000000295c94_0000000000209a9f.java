import java.util.Scanner;

public class Code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            
            System.out.print("Case #" + caseNumber + ": ");
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                
                if (currentChar == '1') {
                    System.out.print("(" + currentChar + ")");
                } else if (currentChar == '0') {
                    System.out.print(currentChar);
                }
            }
            System.out.println(); // To ensure each case is printed on a new line
        }
        
        scanner.close();
    }
}