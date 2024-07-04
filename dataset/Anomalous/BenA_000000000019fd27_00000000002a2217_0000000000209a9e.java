import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String initialInput = scanner.nextLine();
        StringBuilder accumulatedInput = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            accumulatedInput.append(scanner.nextLine());
            System.out.flush();
        }

        System.out.println(accumulatedInput.toString());
        System.out.flush();
        
        String finalInput = scanner.nextLine();
        System.out.println(finalInput);
    }
}