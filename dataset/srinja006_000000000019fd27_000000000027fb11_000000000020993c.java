import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    int t1=1;
    while(t1<=t)
    {
      int n=sc.nextInt();
      int i,j,k,l;
      int a[][]=new int[n][n];
      for(i=0;i<n;i++)
      {
        for(j=0;j<n;j++)
        a[i][j]=sc.nextInt();
      }
      int c=0,cn=0,trace=0,rows=0,cols=0;
      for(i=0;i<n;i++)
      {
        for(j=0;j<n;j++)
        {
          if(i==j){
          trace+=a[i][j];
          break;
          }
        }
        for(k=0;k<n;k++)
        {
          c=0;cn=0;
          for(l=k+1;l<n;l++)
          {
            if(a[i][k]==a[i][l] && c==0)
            {
              rows++;
              c++;
            }
            if(a[k][i]==a[l][k] && cn==0)
            {
              cols++;
              cn++;
            }
          }
        }
      }
      System.out.println("Case #"+t1+": "+trace+" "+rows+" "+cols);
      t1++;
    }
   }
 }