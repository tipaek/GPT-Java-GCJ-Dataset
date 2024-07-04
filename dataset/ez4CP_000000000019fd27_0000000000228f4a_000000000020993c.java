import java.util.*;
import java.io.*;
import java.lang.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int x=1;       
        Set<Integer> set=new HashSet<Integer>();
        while(x<=test){
            int r=0,c=0,k=0;
            int n=sc.nextInt();
            int[][] matrix=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                    if(i==j){
                        k+=matrix[i][j];
                    }
                    set.add(matrix[i][j]);
                }
                if(set.size()!=n){
                    r++;
                }
                set.clear();
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    set.add(matrix[j][i]);
                }
                if(set.size()!=n){
                    c++;
                }
                set.clear();
            }
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
            x++;
        }
               
    }
}