import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int b) {
        boolean[] data = new boolean[b];
        
        if (b == 10) {
            for (int i = 0; i < b; i++) {
                System.out.println(i);
                data[i] = input.nextInt() == 1;
            }
            
            StringBuilder answer = new StringBuilder();
            for (boolean bit : data) {
                answer.append(bit ? 1 : 0);
            }
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        
        for (int ks = 1; ks <= T; ks++) {
            solve(input, B);
        }
    }
}