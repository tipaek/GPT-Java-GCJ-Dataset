import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        int T=SC.nextInt(),N;
        int[][] M;
        boolean B;
        String S;
        ArrayList<ArrayList<Integer>> AL = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            S="C";
            B=true;
            N=SC.nextInt();
            M=new int[N][2];
            AL=new ArrayList<>();
            AL.add(new ArrayList<>());
            AL.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                M[j][0]=SC.nextInt();
                M[j][1]=SC.nextInt();
            }
            for (int j = 1; j < N; j++) {
                if (M[j][1]<=M[0][0] || M[j][0]>=M[0][1]) {
                    S+="C";
                }
                else{
                    S+="J";
                    AL.get(0).add(M[j][0]);
                    AL.get(1).add(M[j][1]);    
                }
            }
            System.out.print("Case #"+ (i+1)+": ");
            for (int j = 0; j < AL.get(0).size(); j++) {
                for (int k = j+1; k < AL.get(0).size(); k++) {
                    if (!(AL.get(1).get(k)<=AL.get(0).get(j) || AL.get(0).get(k)>=AL.get(1).get(j))) {
                        System.out.println("IMPOSIBLE");
                        B=false;
                    }
                }
            }
            if (B==true) {
                System.out.println(S);
            }
            
        }
    } 
}