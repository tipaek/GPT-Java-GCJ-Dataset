import java.util.*;
import java.io.*;


public class Solution{
    
    public static int getTrace(int[][] mat){
        int n=mat.length;
        
        int i=0,j=0;
        
        int sum=0;
        
        while(i<n && j<n){
            sum+=mat[i++][j++];
        }
        
        return sum;
    }
    
    public static int getRows(int[][] mat){
        int n=mat.length;
        Set<Integer> set=new HashSet<Integer>();
        int res=0;
        for(int i=0;i<n;i++){
            set=new HashSet<Integer>();
           for(int j=0;j<n;j++){
               if(set.contains(mat[i][j])){
                   res++;
                   break;
               }
           } 
        }
        return res;
        
    }
    
       public static int getCols(int[][] mat){
        int n=mat.length;
        Set<Integer> set=new HashSet<Integer>();
        int res=0;
        for(int i=0;i<n;i++){
            set=new HashSet<Integer>();
           for(int j=0;j<n;j++){
               if(set.contains(mat[j][i])){
                   res++;
                   break;
               }
           } 
        }
        return res;
        
    }
    
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            in.nextLine();
            int[][] mat=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    mat[j][k]=in.nextInt();
                }
                in.nextLine();
            }
            
            System.out.println(getTrace(mat)+" "+getRows(mat)+" "+getCols(mat));
        }
    }
}