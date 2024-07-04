
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            Character[][] responses = new Character[15][b];

            int version = 0;

            readVersion(scanner, 0, 9, version, responses);
            System.out.println(print(responses[version]));

            String verdict = scanner.next();
            if ("Y".equals(verdict)) {
//                break;
            } else if ("N".equals(verdict)) {
                return;
            }
        }
    }

    private static void readVersion(Scanner scanner, int start, int end, int version, Character[][] responses) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + 1);
            responses[version][i] = scanner.next().charAt(0);
        }
    }

    private static String print(Character[] array) {
        StringBuilder result = new StringBuilder();
        for (Character character : array) {
            result.append(character);
        }
        return result.toString();
    }
}
