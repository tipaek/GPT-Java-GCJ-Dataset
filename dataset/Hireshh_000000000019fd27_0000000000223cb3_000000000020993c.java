
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int i=1;i<=t;i++){
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            int trace = 0;
            int rr=0;int rc=0;
            for(int r=0;r<n;r++){
                HashSet<Integer> rset = new HashSet<>();
                boolean detected = false;
                for(int c=0;c<n;c++){
                    mat[r][c]=in.nextInt();
                    if(!detected&&!rset.add(mat[r][c])){
                        rr+=1;
                        detected=true;
                    }
                    if(r==c){
                        trace+=mat[r][c];
                    }
                }
            }
            outer:for(int r=0;r<n;r++){
                HashSet<Integer> cset = new HashSet<>();

                for(int c=0;c<n;c++){
                    if(!cset.add(mat[c][r])){
                        rc+=1;
                        continue outer;
                    }
                }
            }
            System.out.println("Case #"+i+": "+trace+" "+rr+" "+rc);
        }
    }
}
