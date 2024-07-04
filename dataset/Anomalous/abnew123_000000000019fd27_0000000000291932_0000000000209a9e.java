import java.util.Scanner;

public class Solution {

    public static void solve(Scanner input, int b) {
        boolean[] data = new boolean[b];
        
        if (b == 10) {
            for (int i = 0; i < b; i++) {
                System.out.println(i);
                String s = input.next();
                data[i] = Integer.parseInt(s) == 1;
            }
            
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < b; i++) {
                answer.append(data[i] ? 1 : 0);
            }
            
            System.out.println(answer.toString());
            
            if (input.next().equals("Y")) {
                return;
            }
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