import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            StringBuilder answerBuilder = new StringBuilder();
            
            for (int number = 1; number <= 10; number++) {
                System.out.println(number);
                String response = scanner.nextLine();
                answerBuilder.append(response);
                System.out.flush();
            }
            
            System.out.println(answerBuilder.toString());
            System.out.flush();
        }
    }
}