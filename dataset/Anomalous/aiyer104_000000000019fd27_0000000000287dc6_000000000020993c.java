import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfRows = scanner.nextInt();
            System.out.println(numberOfRows);
        }

        scanner.close();
    }
}