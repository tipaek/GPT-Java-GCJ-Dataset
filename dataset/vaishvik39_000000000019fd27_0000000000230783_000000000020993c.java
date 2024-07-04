import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int i,j,k,l,m,n,r=0,c=0,f=0;
     int sum = 0;
     int t = sc.nextInt();
     for(i=0;i<t;i++)
     {
         n=sc.nextInt();
         sum=0;
         r=0;
         c=0;
         f=0;
         int a[][] = new int[n][n];
         for(j=0;j<n;j++)
         {
           for(k=0;k<n;k++)
           {
             a[j][k] = sc.nextInt();  
           }
         }
         for(j=0,k=0;j<n;j++,k++)
         {
             sum = sum + a[j][k];
         }
         for(k=0;k<n;k++)
         {
             for(j=0;j<n-1;j++)
             {
                 for(l=j+1;l<n;l++)
                 {
                     if(a[j][k]==a[l][k])
                     {
                         r++;
                         f=1;
                         break;
                     }
                 }
                 if(f==1)
                 {
                     break;
                 }
             }
            
         }
         f=0;
         for(j=0;j<n;j++)
         {
             for(k=0;k<n-1;k++)
             {
                 for(l=k+1;l<n;l++)
                 {
                     if(a[j][k]==a[j][l])
                     {
                         c++;
                         f=1;
                         break;
                     }
                 }
                 if(f==1)
                 {
                     break;
                 }
                 
             }
            
         }
         System.out.println("Case"+" "+"#"+(i+1)+":"+" "+sum+" "+c+" "+r);
         
         
     }
    }
}