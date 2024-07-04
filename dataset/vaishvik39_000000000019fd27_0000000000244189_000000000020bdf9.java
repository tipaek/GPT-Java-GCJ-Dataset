import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int i,j,k,l,m,n,f=0,g=0,g1=0;
     int t = sc.nextInt();
     int c[] = new int[1441];
     int j1[] = new int[1441];
     for(i=0;i<t;i++)
     {
         System.out.print("Case"+" "+"#"+(i+1)+":"+" ");
        
         for(j=0;j<1441;j++)
         {
             c[j]=0;
             j1[j]=0;
         }
         f=0;
         g=0;
         g1=0;
         n=sc.nextInt();
         int s[] = new int[n];
         int e[] = new int[n];
         char a[] = new char[n];
         for(j=0;j<n;j++)
         {
             s[j] = sc.nextInt();
             e[j] = sc.nextInt();
         }
         for(k=0;k<n;k++)
         {
             f=0;
             g=0;
             for(l=(s[k]+1);l<e[k];l++)
             {
                 if(c[l]==0)
                 {
                     f++;
                 }
                 else
                 {
                     
                     g=1;
                     break;
                 }
             }
             
             if(g!=1)
             {
                 for(l=s[k];l<=e[k];l++)
                 {
                     c[l]=1;
                 }
                 a[k]='C';
             }
             else
             {
                 f=0;
                for(l=(s[k]+1);l<e[k];l++)
             {
                 if(j1[l]==0)
                 {
                     f++;
                 }
                 else
                 {
                     System.out.println("IMPOSSIBLE");
                     g1=1;
                     break;
                 }
             }
             if(g1!=1)
             {
                 for(l=s[k];l<=e[k];l++)
                 {
                     j1[l]=1;
                 }
                 a[k]='J';
             }
             else
             {
                 break;
             }
             }
         }
         if(g1!=1)
         {
             for(k=0;k<n;k++)
             {
                 System.out.print(a[k]);
             }
             System.out.println(" ");
         }
     }
    }
}