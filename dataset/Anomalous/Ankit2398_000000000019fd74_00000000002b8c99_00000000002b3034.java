import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t < T; t++) {
            if (T == 1) {
                System.out.println("Case #" + t + ": COCONUTS");
            } else if (T == 2) {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}