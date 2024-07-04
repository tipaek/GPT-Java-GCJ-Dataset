import java.util.*;
 public class Solution 
 {
     public static void main(String args [])
     {
         Scanner in=new Scanner(System.in);
         int t=in.nextInt();
        //  int cc=0;
        for(int l=1;l<=t;l++) {
             int n=in.nextInt();
             int mat[][]=new int[n][n];
             int k=0,r=0,c=0;
             for(int i=0;i<n;i++)
             {
                 HashMap<Integer,Boolean>map=new HashMap<>();
                 for(int j=0;j<n;j++)
                 {
                     mat[i][j]=in.nextInt();
                     if(i==j)
                     k+=mat[i][j];
                     map.put(mat[i][j],true);
                 }
                 if(map.size()!=n)
                 r++;
             }
             for(int i=0;i<n;i++)
             {
                  HashMap<Integer,Boolean>map=new HashMap<>();
                 for(int j=0;j<n;j++)
                 {
                     map.put(mat[j][i],true);
                 }
                 if(map.size()!=n)
                 c++;
             }
             System.out.println("Case #"+l+": "+k+" "+r+" "+c);
         }
     }
 }