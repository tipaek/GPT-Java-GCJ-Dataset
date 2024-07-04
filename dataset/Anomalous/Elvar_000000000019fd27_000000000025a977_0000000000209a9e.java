import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int x = 0; x < T; x++) {
            int[] A = new int[B];
            for (int i = 0; i < B; i++) A[i] = -1;

            // Initial reads
            readInitialBits(sc, A, B);

            // Process and adjust bits
            processBits(sc, A, B);

            // Output the result
            StringBuilder s = new StringBuilder();
            for (int i : A) s.append(i);
            System.out.println(s);
            sc.next(); // Read the response
        }
    }

    private static void readInitialBits(Scanner sc, int[] A, int B) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            A[i - 1] = sc.nextInt();
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println(B - i);
            A[B - i - 1] = sc.nextInt();
        }
    }

    private static void processBits(Scanner sc, int[] A, int B) {
        int stadureins = -1;
        int stadurolikur = -1;

        for (int r = 0; r < B / 8 + 3; r += 4) {
            stadureins = -1;
            stadurolikur = -1;

            for (int i = 0; i < 5; i++) {
                if (A[r + i] == A[B - i - 1 - r] && A[r + i] != -1) {
                    stadureins = r + i;
                } else if (A[r + i] != -1) {
                    stadurolikur = r + i;
                }
            }

            adjustArray(sc, A, stadureins, stadurolikur);

            // Read next bits
            for (int i = r + 5; i < r + 9; i++) {
                System.out.println(i + 1);
                A[i] = sc.nextInt();
            }
            for (int i = B - r - 6; i > B - r - 10; i--) {
                System.out.println(i + 1);
                A[i] = sc.nextInt();
            }
        }
    }

    private static void adjustArray(Scanner sc, int[] A, int stadureins, int stadurolikur) {
        if (stadureins == -1) {
            handleUniformArray(sc, A, 1);
        } else if (stadurolikur == -1) {
            handleUniformArray(sc, A, 1);
        } else {
            handleMixedArray(sc, A, stadureins, stadurolikur);
        }
    }

    private static void handleUniformArray(Scanner sc, int[] A, int index) {
        System.out.println(index);
        int a = sc.nextInt();
        System.out.println(index);
        a = sc.nextInt();
        if (A[0] != a) {
            reverseArray(A);
        }
    }

    private static void handleMixedArray(Scanner sc, int[] A, int stadureins, int stadurolikur) {
        System.out.println(stadureins + 1);
        int a = sc.nextInt();
        System.out.println(stadurolikur + 1);
        int b = sc.nextInt();

        if (a != A[stadureins] && b != A[stadurolikur]) {
            complementArray(A);
        } else if (a == A[stadureins] && b != A[stadurolikur]) {
            reverseArray(A);
        } else if (a != A[stadureins] && b == A[stadurolikur]) {
            complementArray(A);
            reverseArray(A);
        }
    }

    private static void reverseArray(int[] A) {
        int n = A.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = A[i];
            A[i] = A[n - i - 1];
            A[n - i - 1] = temp;
        }
    }

    private static void complementArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != -1) {
                A[i] = 1 - A[i];
            }
        }
    }
}