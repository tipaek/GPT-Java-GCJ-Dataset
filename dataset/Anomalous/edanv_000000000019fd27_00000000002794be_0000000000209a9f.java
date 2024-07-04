import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        int caseNumber = 1;

        while (numberOfCases > 0) {
            String inputString = scanner.next();
            String modifiedString = inputString.replace("1", "(1)").replace(")(", "");
            System.out.println("Case #" + caseNumber + ": " + modifiedString);
            caseNumber++;
            numberOfCases--;
        }
    }
}