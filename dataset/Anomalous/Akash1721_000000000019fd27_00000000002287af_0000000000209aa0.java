import java.util.Scanner;

class Solution {
    static int[] generateArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (i + 1) * n;
        }
        return array;
    }

    static boolean contains(int[] array, int key) {
        for (int value : array) {
            if (value == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] array = generateArray(n);
            
            boolean found = contains(array, k);
            if (found) {
                System.out.println("Case #" + t + ": POSSIBLE");
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}