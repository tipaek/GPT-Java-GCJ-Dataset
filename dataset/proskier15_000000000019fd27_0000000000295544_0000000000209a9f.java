import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String str = scanner.nextLine();

            int[] arr = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                arr[j] = str.charAt(j) - 48;
            }

            process(arr, str.length(), i + 1);
        }
    }

    private static void process(int[] arr, int length, int testCaseNum) {
        StringBuilder output = new StringBuilder();

        int currentCount = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == currentCount) {
                output.append(currentCount);
            } else {
                boolean greater = arr[i] > currentCount;
                int difference = Math.abs(arr[i] - currentCount);

                char ch = greater ? '(' : ')';
                output.append(String.valueOf(ch).repeat(difference));

                if (greater) {
                    currentCount += difference;
                } else {
                    currentCount -= difference;
                }

                output.append(currentCount);
            }
        }

        output.append(")".repeat(currentCount));

        System.out.println("Case #: " + testCaseNum + ": " + output.toString());
    }

}
