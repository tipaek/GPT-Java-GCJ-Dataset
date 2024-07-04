import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #"+t+": ");
            solve(sc);
        }
    }

    private static void solve(Scanner sc){
        int N = sc.nextInt();
        int[][] M = new int[N][N];
        int tr = 0;
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                M[r][c]=sc.nextInt();
                if(r==c){
                    tr += M[r][c];
                }
            }
        }
        int rans=0;
        int cans=0;

        for(int r=0;r<N;r++){
            Set<Integer> st = new HashSet<>();
            boolean isDouble = false;
            for(int i=0;i<N;i++) {
                if(st.contains(M[r][i])){
                    isDouble = true;
                    break;
                }
                st.add(M[r][i]);
            }
            if(isDouble)
                rans++;
        }
        for(int c=0;c<N;c++){
            Set<Integer> st = new HashSet<>();
            boolean isDouble = false;
            for(int i=0;i<N;i++) {
                if(st.contains(M[i][c])){
                    isDouble = true;
                    break;
                }
                st.add(M[i][c]);
            }
            if(isDouble)
                cans++;
        }

        System.out.println(tr + " " + rans + " " + cans);
    }

}
