import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int size = scanner.nextInt();

        String[] array = new String[size];

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int additionalSteps = (int) Math.ceil(size / 10.0) + size % 10;

            for (int p = 1, i = 1; p <= size + additionalSteps; p++) {
                System.out.println(i);

                String bit = scanner.next();
                if (p % 10 != 1) {
                    array[i - 1] = bit;
                    i++;
                }
            }

            String output = String.join("", array);
            System.out.println(output);

            String result = scanner.next();
            if (result.equals("N")) {
                System.exit(0);
            }
        }
    }
}