import java.util.*;

class Solution {
    
    static int[] generateArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (i + 1) * n;
        }
        return array;
    }

    static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    static int[] generateNaturalArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    static void printLatinSquare(int n, int k) {
        int[] naturalArray = generateNaturalArray(n);
        int b = k / n;
        for (int c = 0; c < n; c++) {
            for (int i = b - 1; i < n; i++) {
                System.out.print(naturalArray[i] + " ");
            }
            for (int i = 0; i < b - 1; i++) {
                System.out.print(naturalArray[i] + " ");
            }
            System.out.println();
            b--;
            if (b == 0) {
                b = n;
            }
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