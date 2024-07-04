import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int size = scanner.nextInt();

        String[] array = new String[size];
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int additionalSteps = (int) Math.ceil((double) size / 10) + size % 10;

            for (int p = 0, index = 0; p < size + additionalSteps; p++) {
                System.out.println(index + 1);

                String bit = scanner.next();
                if ((index + 1) % 10 == 0) {
                    array[index] = bit;
                    index++;
                }
            }

            String output = String.join("", array);
            System.out.println(output);

            String result = scanner.next();
            if ("N".equals(result)) {
                System.exit(0);
            }
        }
    }
}