import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNumber = 1;
        int n = sc.nextInt();
        int trace = sc.nextInt();
        boolean isPossible = false;

        for (int i = 1; i <= n; i++) {
            int sum = i * n;
            if (sum == trace) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                isPossible = true;
                int start = (i == 1) ? n + 1 : i + 1;
                System.out.println();
                generateLatinSquare(n, start);
                break;
            }
        }
        
        if (!isPossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    public static void generateLatinSquare(int n, int start) {
        for (int i = 1; i <= n; i++) {
            int temp = start;
            while (temp <= n) {
                System.out.print(temp + " ");
                temp++;
            }
            for (int j = 1; j < start; j++) {
                System.out.print(j + " ");
            }
            start--;
            if (start == 0) {
                start = n;
            }
            System.out.println();
        }
    }
}