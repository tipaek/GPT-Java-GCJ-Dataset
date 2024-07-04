import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] conditions = scanner.nextLine().split(" ");
        int numOfCases = Integer.parseInt(conditions[0]);
        int A = Integer.parseInt(conditions[1]);
        int B = Integer.parseInt(conditions[2]);

        for (int i = 0; i < numOfCases; i++) {
            solve(scanner, A, B);
        }
    }

    private static void solve(Scanner scanner, int A, int B) {
        for (int i=-5; i<=5; i++) {
            for (int j=-5; j<=5; j++) {
                System.out.println(i + " " + j);
                System.out.flush();

                String result = scanner.next();
                if (result.equals("CENTER")) {
                    return;
                }
            }
        }
    }
}
