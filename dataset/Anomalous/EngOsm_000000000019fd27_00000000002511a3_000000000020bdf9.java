import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int i = 0; i < T; i++) {
            char pos = 'P';
            int N = input.nextInt();
            int AC = 1441, BC = 0, AJ = 1441, BJ = 0;
            char[] MT = new char[N];
            
            for (int j = 0; j < N; j++) {
                int A = input.nextInt();
                int B = input.nextInt();
                
                if (BC <= A || B <= AC) {
                    MT[j] = 'C';
                    AC = Math.min(AC, A);
                    BC = Math.max(BC, B);
                } else if (BJ <= A || B <= AJ) {
                    MT[j] = 'J';
                    AJ = Math.min(AJ, A);
                    BJ = Math.max(BJ, B);
                } else {
                    pos = 'I';
                    break;
                }
            }
            
            System.out.print("Case #" + (i + 1) + ": ");
            if (pos == 'I') {
                System.out.println("Impossible");
            } else {
                for (int j = 0; j < N; j++) {
                    System.out.print(MT[j]);
                }
                System.out.println();
            }
        }
        
        input.close();
    }
}