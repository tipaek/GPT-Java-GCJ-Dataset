import java.util.Scanner;

public class SolutionA {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String movements = scanner.next();

            String result = "IMPOSSIBLE";

            for (int i = 0; i < movements.length(); i++) {
                char move = movements.charAt(i);
                switch (move) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    result = String.valueOf(i + 1);
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}