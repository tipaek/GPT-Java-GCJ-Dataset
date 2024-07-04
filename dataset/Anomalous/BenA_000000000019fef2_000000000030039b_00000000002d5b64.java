import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String[] input = scanner.nextLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            System.out.print("Case #" + caseIndex + ": ");
            calculateDecks(r, s);
        }
    }

    public static void calculateDecks(int r, int s) {
        System.out.println((r - 1) * (s - 1));
        int sortIndex = 1;
        int decrement = r - 1;

        while (decrement > 0) {
            for (int i = 1; i < s; i++) {
                System.out.println((r * s - decrement - sortIndex) + " " + decrement);
                sortIndex++;
            }
            decrement--;
            sortIndex++;
        }
    }
}