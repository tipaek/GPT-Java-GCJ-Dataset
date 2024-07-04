import java.util.*;
import java.io.*;
public class Solution{
    
   static boolean checkRow(int[][] mat, int index){
        TreeSet<Integer> st=new TreeSet();
        for(int i=0;i<mat.length;i++){
            if(st.contains(mat[index][i])){
                return false;
            }
            st.add(mat[index][i]);
        }
        return true;
    }
    static boolean checkColumn(int[][] mat,int index){
        TreeSet<Integer> set=new TreeSet();
        for(int i=0;i<mat.length;i++){
            if(set.contains(mat[i][index])){
                return false;
            }
            set.add(mat[i][index]);
        }
        return true;
    }
    public static void main(String[] args){
          Scanner in=new Scanner(System.in);
          int t=in.nextInt();
          for(int test=1;test<=t;test++){
              int n=in.nextInt();
              int mat[][]=new int[n][n];
              for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                      mat[i][j]=in.nextInt();
                  }
              }
              
              int x = 0;
              int r = 0;
              int c = 0;
              for(int i=0;i<n;i++){
                  if(!checkRow(mat,i)){
                      r++;
                  }
                  if(!checkColumn(mat,i)){
                      c++;
                  }
                  
                  x = x + mat[i][i];
              }
              
              System.out.println("Case #"+test+": "+x+" "+r+" "+c);
          }
    }
}