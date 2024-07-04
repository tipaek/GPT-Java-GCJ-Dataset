import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int a=0; a<T; a++){
        int N = s.nextInt();
        int[][] M = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                M[i][j] = s.nextInt();
        }
        int t = 0;
        for(int i=0; i<N; i++)
          t = t+M[i][i];
        int l=0;
        for(int i=0; i<N; i++){
            Set<Integer> s1 = new HashSet<>();
            int y=0;
            for(int j=0; j<N; j++){
                if(s1.add(M[i][j]) == false){
                    y++;
                }
            }
            if(y != 0)
                l++;
        }
        int r=0;
        for(int i=0; i<N; i++){
            Set<Integer> s2 = new HashSet<>();
            int y=0;
            for(int j=0; j<N; j++){
                if(s2.add(M[j][i]) == false){
                    y++;
                }
            }
            if(y != 0)
                r++;
        }
        System.out.println("Case #"+T+": "+t+" "+l+" "+r);
            
        }
    }
    
}