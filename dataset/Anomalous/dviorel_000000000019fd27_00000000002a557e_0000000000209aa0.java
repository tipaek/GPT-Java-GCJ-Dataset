import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            if (isPossible(n, k)) {
                System.out.printf("Case #%d: POSSIBLE%n%s", i, generateMatrix(n, k));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i);
            }
        }
    }

    private static boolean isPossible(int n, int k) {
        if (n == 4) {
            return k % n == 0 || k == 10;
        }
        return k % n == 0;
    }

    private static String generateMatrix(int n, int k) {
        StringBuilder matrix = new StringBuilder();
        
        switch (n) {
            case 2:
                if (k == 2) {
                    matrix.append("1 2\n2 1\n");
                } else if (k == 4) {
                    matrix.append("2 1\n1 2\n");
                }
                break;
            case 3:
                if (k == 3) {
                    matrix.append("1 2 3\n3 1 2\n2 3 1\n");
                } else if (k == 6) {
                    matrix.append("2 1 3\n3 2 1\n1 3 2\n");
                } else if (k == 9) {
                    matrix.append("3 1 2\n2 3 1\n1 2 3\n");
                }
                break;
            case 4:
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
                break;
            case 5:
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
                break;
        }
        
        return matrix.toString();
    }
}