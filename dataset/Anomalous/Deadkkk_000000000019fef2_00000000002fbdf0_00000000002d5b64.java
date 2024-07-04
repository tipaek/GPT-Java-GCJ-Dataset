import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int[] r = new int[t];
        int[] s = new int[t];
        
        for (int i = 0; i < t; i++) {
            r[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + i + ": ");
            process(r[i], s[i]);
        }
    }

    private static void process(int r, int s) {
        int k = (r * s) - r;
        System.out.println((r - 1) * (s - 1));
        
        for (int i = r - 1; i > 0; i--) {
            for (int j = s - 1; j > 0; j--) {
                System.out.println(k + " " + i);
                k--;
            }
        }
    }
}