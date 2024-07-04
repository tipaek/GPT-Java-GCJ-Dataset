
import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if ((k==n+1) || (k==n*n-1)){
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
            } else {
                System.out.println(String.format(PATTEN, p, "POSSIBLE"));
            }
        }
    }
}