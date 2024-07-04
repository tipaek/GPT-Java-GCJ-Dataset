import java.lang.*;
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int t=0;t<test;t++){
            int n=sc.nextInt();
            int[][] mat =new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=sc.nextInt();
                    if(i==j){
                        trace+=mat[i][j];
                    }
                }
            }
            int r_count=0;
            int c_count=0;
            for(int i=0;i<n;i++){
                HashSet<Integer> rset=new HashSet<>();
                HashSet<Integer> cset=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(rset.contains(mat[i][j])){
                        r_count++;
                        break;
                    }
                    else{
                        rset.add(mat[i][j]);
                    }
                }
                for(int j=0;j<n;j++){
                    if(cset.contains(mat[j][i])){
                        c_count++;
                        break;
                    }
                    else{
                        cset.add(mat[j][i]);
                    }
                }
                
            }
            System.out.print("Case #");
            System.out.print(t);
            System.out.print(": ");
            System.out.print(r_count);
            System.out.print(" ");
            System.out.print(c_count);
            System.out.println();
        }
    }
}