import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        ArrayList<String[]> pairs = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        for(int t = 1; t <= numCases; t++) {
            int U = scanner.nextInt();
            scanner.nextLine();
            for(int i = 0; i < 10 * 10 * 10 * 10; i++) {
                String input = scanner.nextLine();
                String[] inputArray = input.split(" ");
                pairs.add(inputArray);
            }
            System.out.printf("Case #%s: %s%n", t, calculateSecret(pairs));
        }

    }

    public static String calculateSecret(ArrayList<String[]> pairs) {
        Random random = new Random();
        char[] D = new char[10];
        for(String[] s : pairs) {
            int sDigit = Integer.parseInt(s[0]);
            if(numDigits(sDigit) == 1 && sDigit != -1) {
                int r = random.nextInt(sDigit) + 1;
                D[r] = s[1].charAt(0);
            }
        }
        return String.valueOf(D);
    }

    public static int numDigits(int number) {
        int count = 0;
        while(number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
