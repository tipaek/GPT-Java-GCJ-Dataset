
import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int b) {
        int[] sol = new int[10];
        for(int i=1;i<=b;i++){
            System.out.println(i);
            sol[i]=input.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(sol[i]);
        }
        System.out.println(sb.toString());

        String judge = input.next();
        if(judge.equals("N")) System.exit();
        
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {

            solve(input, B);
        }
    }
}