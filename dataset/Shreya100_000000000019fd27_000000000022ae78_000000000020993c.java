import java.util.*;
 public class Solution{
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         for(int l =1;l<=t;l++)
         {
             int n = sc.nextInt();
             int a[][] = new int[n][n];
             int i, j;
             HashSet<Integer> h = new HashSet<Integer>();
             int row=0;
             int column =0;
             int diagonal =0;
             for(i=0;i<n;i++)
             {
                 for(j=0;j<n;j++)
                 {
                     a[i][j] = sc.nextInt();
                 }
             }
             
             for(i=0;i<n;i++)
             {
                 for(j=0;j<n;j++)
                 {
                     if(h.contains(a[i][j]))
                     {
                         row++;
                         break;
                     }
                     else
                     h.add(a[i][j]);
                 }
                 h.clear();
             }
             h.clear();
             for(i=0;i<n;i++)
             {
                 for(j=0;j<n;j++)
                 {
                     if(h.contains(a[j][i]))
                     {
                         column++;
                         break;
                     }
                     else
                     h.add(a[j][i]);
                 }
                 h.clear();
             }
             i=0;j=0;
             while(i<n && j<n)
             {
                 diagonal+=a[i][j];
                 i++;
                 j++;
             }
             
             System.out.println("Case #"+l+": "+diagonal+" "
             +row+" "+column);
         }
     }
 }