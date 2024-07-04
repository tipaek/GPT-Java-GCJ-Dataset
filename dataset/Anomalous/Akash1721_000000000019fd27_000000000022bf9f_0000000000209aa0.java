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
        int count = 0;
        int b = value / size;
        while (count != size) {
            for (int i = b - 1; i < size; i++) {
                System.out.print(naturalArray[i] + " ");
            }
            for (int i = 0; i < b - 1; i++) {
                System.out.print(naturalArray[i] + " ");
            }
            count++;
            b--;
            if (b == 0) {
                b = size;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }
}