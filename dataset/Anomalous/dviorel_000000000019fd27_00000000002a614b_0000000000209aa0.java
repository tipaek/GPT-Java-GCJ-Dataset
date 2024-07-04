import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int q = 1; q <= t; q++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (isPossible(n, k)) {
                System.out.printf("Case #%d: POSSIBLE%n%s", q, getMatrix(n, k));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", q);
            }
        }
    }

    static boolean isPossible(int n, int k) {
        if (n == 2) {
            return k == 2 || k == 4;
        } else if (n == 3) {
            return k == 3 || k == 6 || k == 9;
        } else if (n == 4) {
            return k == 4 || k == 8 || k == 12 || k == 16 || k == 10;
        } else if (n == 5) {
            return k == 5 || k == 10 || k == 15 || k == 20 || k == 25;
        }
        return false;
    }

    static String getMatrix(int n, int k) {
        StringBuilder matrix = new StringBuilder();
        if (n == 2) {
            if (k == 2) {
                matrix.append("1 2\n2 1\n");
            } else if (k == 4) {
                matrix.append("2 1\n1 2\n");
            }
        } else if (n == 3) {
            if (k == 3) {
                matrix.append("1 2 3\n3 1 2\n2 3 1\n");
            } else if (k == 6) {
                matrix.append("2 3 1\n1 2 3\n3 1 2\n");
            } else if (k == 9) {
                matrix.append("3 1 2\n2 3 1\n1 2 3\n");
            }
        } else if (n == 4) {
            if (k == 4) {
                matrix.append("1 2 3 4\n3 1 4 2\n2 4 1 3\n4 3 2 1\n");
            } else if (k == 8) {
                matrix.append("2 1 3 4\n3 2 4 1\n1 4 2 3\n4 3 1 2\n");
            } else if (k == 10) {
                matrix.append("1 4 2 3\n3 2 4 1\n4 1 3 2\n2 1 3 4\n");
            } else if (k == 12) {
                matrix.append("3 1 2 4\n2 3 4 1\n1 4 3 2\n4 2 1 3\n");
            } else if (k == 16) {
                matrix.append("4 1 2 3\n2 4 3 1\n1 3 4 2\n3 2 1 4\n");
            }
        } else if (n == 5) {
            if (k == 5) {
                matrix.append("1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n");
            } else if (k == 10) {
                matrix.append("2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n");
            } else if (k == 15) {
                matrix.append("3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n");
            } else if (k == 20) {
                matrix.append("4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n");
            } else if (k == 25) {
                matrix.append("5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n");
            }
        }
        return matrix.toString();
    }
}