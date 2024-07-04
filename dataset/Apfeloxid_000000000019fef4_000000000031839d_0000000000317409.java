import java.util.Scanner;

public class SolutionA {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();

            String solution = "";

            for (int i = 0; i < M.length(); i++) {
                switch (M.charAt(i)) {
                    case 'N': Y++; break;
                    case 'S': Y--; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                }

                if (Math.abs(X) + Math.abs(Y) <= i + 1 && solution.isEmpty()) {
                    solution = i + 1 + "";
                }
            }
            
            if (solution.isEmpty()) {
                solution = "IMPOSSIBLE";
            }

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}
