import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            int N = input.nextInt();
            for (int i = 0; i < N * N; i++) {
                int value = input.nextInt();
            }
            // Assuming k, r, c are calculated somewhere in the omitted code
            int k = 0; // Placeholder value
            int r = 0; // Placeholder value
            int c = 0; // Placeholder value
            System.out.println("Case #" + caseNumber + ": " + k + " " + r + " " + c);
        }
    }
}