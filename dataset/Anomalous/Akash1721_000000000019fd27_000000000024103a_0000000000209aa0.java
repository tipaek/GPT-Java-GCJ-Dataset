import java.util.Scanner;

class Solution {

    static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (i + 1) * size;
        }
        return array;
    }

    static boolean contains(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    static int[] generateNaturalArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    static void printLatinSquare(int size, int value) {
        int[] naturalArray = generateNaturalArray(size);
        int shift = value / size;
        for (int i = 0; i < size; i++) {
            for (int j = shift; j < size; j++) {
                System.out.print(naturalArray[j] + " ");
            }
            for (int j = 0; j < shift; j++) {
                System.out.print(naturalArray[j] + " ");
            }
            System.out.println();
            shift = (shift - 1 + size) % size;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int set = 1; set <= 2; set++) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int[] array = generateArray(n);
                if (contains(array, k)) {
                    System.out.println("Case #" + t + ": POSSIBLE");
                    printLatinSquare(n, k);
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }
        scanner.close();
    }
}