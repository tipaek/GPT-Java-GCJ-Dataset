import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            String result = (N <= 5) ? handleSmallN(N, K) : handleLargeN(N, K);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String handleLargeN(int n, int k) {
        return "";
    }

    private static String handleSmallN(int n, int k) {
        switch (n) {
            case 2:
                return (k % 2 == 0) ? "POSSIBLE" : "IMPOSSIBLE";
            case 3:
                return (k % 3 == 0) ? "POSSIBLE" : "IMPOSSIBLE";
            case 4:
                return (k != 5 && k != 15) ? "POSSIBLE" : "IMPOSSIBLE";
            case 5:
                if ((k >= 6 && k <= 8) || (k >= 23 && k <= 24)) {
                    return "IMPOSSIBLE";
                } else {
                    return "POSSIBLE";
                }
            default:
                return "IMPOSSIBLE";
        }
    }
}