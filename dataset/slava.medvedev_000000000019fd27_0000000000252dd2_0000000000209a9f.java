import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ScanWrapper input = new ScanWrapper();
        int testsNum = input.nextInt();
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            int[] test = input.nextLine();
            StringBuilder sb = new StringBuilder();
            int depth = 0;
            for (int number : test) {
                if (number > depth) {
                    int diff = number - depth;
                    depth = number;
                    for (int i = 0; i < diff; i++)
                        sb.append("(");
                } else if (number < depth) {
                    int diff = depth - number;
                    depth = number;
                    for (int i = 0; i < diff; i++)
                        sb.append(")");
                }
                sb.append(number);
            }
            for (int i = 0; i < depth; i++)
                sb.append(")");
            System.out.println("Case #" + (testIndex + 1) + ": " + sb.toString());
        }

    }

    private static class ScanWrapper {

        private final Scanner scanner;

        ScanWrapper() {
            scanner = new Scanner(System.in);
        }

        int nextInt() {
            return Integer.parseInt(scanner.nextLine());
        }

        int[] nextLine() {
            String strings = scanner.nextLine();
            int i = 0;
            int[] result = new int[strings.length()];
            for (char c : strings.toCharArray()) {
                result[i++] = c - 48;
            }
            return result;
        }

    }

}
