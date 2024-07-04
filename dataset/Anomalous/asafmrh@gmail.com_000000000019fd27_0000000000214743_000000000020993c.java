import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = readMatrix(scanner, size);
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        return matrix;
    }
}