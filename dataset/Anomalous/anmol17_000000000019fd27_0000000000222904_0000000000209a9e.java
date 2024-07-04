import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution solution = new Solution();
            int testCases = scanner.nextInt();
            int arraySize = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                if (!solution.processCase(arraySize, scanner)) {
                    return;
                }
            }
        }
    }

    private boolean processCase(int size, Scanner scanner) {
        char[] array = new char[size];
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1);
            array[i] = (char) (scanner.nextInt() + '0');
        }

        System.out.println(new String(array));
        String result = scanner.next();
        return !result.equals("N");
    }
}