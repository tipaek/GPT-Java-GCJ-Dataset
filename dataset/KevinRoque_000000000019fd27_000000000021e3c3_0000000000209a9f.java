import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        int T=SC.nextInt(),L,N = 0,N1 = 0,A;
        SC.nextLine();
        char[] S;
        StringBuilder SB;
        for (int i = 0; i < T; i++) {
            S=SC.nextLine().toCharArray();
            L=S.length;
            A=0;
            SB=new StringBuilder();
            for (int j = 0; j < L; j++) {
                N=Integer.parseInt(String.valueOf(S[j]));
                N1=A-N;
                if (N1<0) {
                    for (int k = 0; k < Math.abs(N1); k++) {
                        SB.append('(');
                    }
                }
                else if(N1>0){
                    for (int k = 0; k < N1; k++) {
                        SB.append(')');
                    }
                }
                A=N;
                SB.append(N);
            }
            for (int j = 0; j < N; j++) {
                SB.append(')');
            }
            System.out.println("Case #"+ (i+1) + ": "+ SB.toString());
        }    
    } 
}