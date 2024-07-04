import java.util.*;
public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;++i){
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            for(int j=0;j<n;++j){
                for(int k=0;k<n;++k)mat[j][k]=sc.nextInt();
            }
            System.out.print("Case #"+i+": ");
        int tr=0,rc=0,cc=0;
        for(int j=0;j<n;++j){
            tr+=mat[j][j];
            HashSet<Integer> hs=new HashSet<>();
            for(int k=0;k<n;++k){
                if(hs.contains(mat[j][k])){
                    ++rc;break;
                }
                hs.add(mat[j][k]);
            }
        }
        for(int j=0;j<n;++j){
            HashSet<Integer> hs=new HashSet<>();
            for(int k=0;k<n;++k){
                if(hs.contains(mat[k][j])){
                    ++cc;break;
                }
                hs.add(mat[k][j]);
            }
        }
        System.out.println(tr+" "+rc+" "+cc);
        }
        sc.close();
    }
}