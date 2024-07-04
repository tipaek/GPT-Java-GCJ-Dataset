import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String[] inputs = inputLine.split(" ");
        int numberOfTests = Integer.parseInt(inputs[0]);
        int base = Integer.parseInt(inputs[1]);

        if (base == 10) {
            for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
                StringBuilder resultBuilder = new StringBuilder();

                for (int i = 0; i < base; i++) {
                    System.out.println(i);
                    resultBuilder.append(scanner.nextLine());
                }

                System.out.print(resultBuilder.toString());
                String serverResponse = scanner.nextLine();
                
                if (serverResponse.equals("N")) {
                    return;
                }
            }
        }
    }
}