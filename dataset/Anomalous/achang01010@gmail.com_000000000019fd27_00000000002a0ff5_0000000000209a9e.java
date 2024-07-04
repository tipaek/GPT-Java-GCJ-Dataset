import java.util.Scanner;

public class Solution {
    public static void solve(Scanner sc, int bits) {
        int[] memory = new int[bits];
        System.out.println(0);
        memory[0] = sc.nextInt();
        System.out.println(memory[0]);
        System.out.println("0000000000");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int c = 1; c <= T; c++) {
            solve(sc, sc.nextInt());
        }
        sc.close();
    }
}