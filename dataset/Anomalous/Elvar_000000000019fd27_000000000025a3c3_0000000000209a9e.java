import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int x = 0; x < T; x++) {
            int[] A = new int[B];
            initializeArray(A);

            readFirstHalf(sc, A);
            readSecondHalf(sc, A);

            int stadureins = -1;
            int stadurolikur = -1;

            for (int r = 0; r < B / 8 + 5; r += 4) {
                findStadureinsAndStadurolikur(A, B, r);

                if (stadureins == -1) {
                    handleStadureinsNegativeOne(sc, A);
                } else if (stadurolikur == -1) {
                    handleStadurolikurNegativeOne(sc, A);
                } else {
                    handleGeneralCase(sc, A, stadureins, stadurolikur);
                }

                readNextEightBits(sc, A, r, B);
            }

            printArray(A);
        }
    }

    private static void initializeArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = -1;
        }
    }

    private static void readFirstHalf(Scanner sc, int[] A) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            A[i - 1] = sc.nextInt();
        }
    }

    private static void readSecondHalf(Scanner sc, int[] A) {
        for (int i = 0; i <= 4; i++) {
            System.out.println(A.length - i);
            A[A.length - i - 1] = sc.nextInt();
        }
    }

    private static void findStadureinsAndStadurolikur(int[] A, int B, int r) {
        int stadureins = -1;
        int stadurolikur = -1;

        for (int i = 0; i < 5; i++) {
            if (A[r + i] == A[B - i - 1 - r] && A[r + i] != -1) {
                stadureins = r + i;
            } else if (A[r + i] != -1) {
                stadurolikur = r + i;
            }
        }
    }

    private static void handleStadureinsNegativeOne(Scanner sc, int[] A) {
        System.out.println(1);
        int a = sc.nextInt();
        System.out.println(1);
        a = sc.nextInt();
        if (A[0] != a) {
            reverseArray(A);
        }
    }

    private static void handleStadurolikurNegativeOne(Scanner sc, int[] A) {
        System.out.println(1);
        int a = sc.nextInt();
        System.out.println(1);
        a = sc.nextInt();
        if (A[0] != a) {
            complementArray(A);
        }
    }

    private static void handleGeneralCase(Scanner sc, int[] A, int stadureins, int stadurolikur) {
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

    private static void readNextEightBits(Scanner sc, int[] A, int r, int B) {
        for (int i = r + 4 + 1; i < r + 8 + 1; i++) {
            System.out.println(i + 1);
            A[i] = sc.nextInt();
        }
        for (int i = B - r - 4 - 2; i > B - r - 8 - 2; i--) {
            System.out.println(i + 1);
            A[i] = sc.nextInt();
        }
    }

    private static void printArray(int[] A) {
        StringBuilder sb = new StringBuilder();
        for (int i : A) {
            sb.append(i);
        }
        System.out.println(sb.toString());
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