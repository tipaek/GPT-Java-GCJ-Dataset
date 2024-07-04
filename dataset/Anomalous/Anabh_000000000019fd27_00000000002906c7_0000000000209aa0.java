import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean possible = isPossible(n, k);
            System.out.println("case #" + i + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
        }
    }

    private static boolean isPossible(int n, int k) {
        switch (n) {
            case 2:
                return k == 2 || k == 4;
            case 3:
                return k == 6;
            case 4:
                return k == 8 || k == 12;
            case 5:
                return k == 15;
            default:
                return false;
        }
    }
}