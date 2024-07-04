import java.util.Scanner;

public class SolutionB {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            findCenter();
        }
    }

    private static void findCenter() {
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int minX = -5, maxX = 5;
        int minY = -5, maxY = 5;

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                System.out.println(x + " " + y);
                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
}