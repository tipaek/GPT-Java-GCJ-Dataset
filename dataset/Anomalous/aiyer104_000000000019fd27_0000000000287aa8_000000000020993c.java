import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int i = 1; i <= numberOfCases; i++) {
            int numberOfRows = scanner.nextInt();
            System.out.println(numberOfRows);
        }
        
        scanner.close();
    }
}