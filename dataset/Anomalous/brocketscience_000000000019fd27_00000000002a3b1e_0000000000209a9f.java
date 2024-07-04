import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new Solver().process(scanner, writer);
        writer.flush();
        writer.close();
    }
}

class Solver {
    public void process(Scanner scanner, PrintWriter writer) {
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            
            int openParens = 0;
            
            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                while (openParens < num) {
                    result.append('(');
                    openParens++;
                }
                
                while (openParens > num) {
                    result.append(')');
                    openParens--;
                }
                
                result.append(ch);
            }
            
            while (openParens > 0) {
                result.append(')');
                openParens--;
            }
            
            writer.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }
}