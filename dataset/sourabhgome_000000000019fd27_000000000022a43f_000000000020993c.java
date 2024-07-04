import java.util.*;
class Q1
{
 public static void main(String gg[])
 {
  int testCases;
  Scanner sc=new Scanner(System.in);
  testCases=sc.nextInt();
  int t=0;
  while(t<testCases)
  {
   
   int n;
   n=sc.nextInt();
   int i=0,j=0,k=0;
   int arr[][]=new int[n][n];
   int rows[]=new int[n];
   int cols[]=new int[n];
   int rowc=0;
   int colc=0;
   int trace=0;

   for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
    {
     arr[i][j]=sc.nextInt();
     if(i==j) trace+=arr[i][j];
    }
   }
//   System.out.println(trace);

   //for rows
   for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
    {
     for(k=j+1;k<n;k++)
     {
      if(arr[i][j]==arr[i][k])
      {
       rows[i]=1;
//       System.out.println(cols[j]+" "+cols[k]);
      }
      //System.out.println(i+" "+j+" "+k);
     }
    }
   }
   
   //for cols
   for(i=0;i<n;i++)
   {
    for(j=0;j<n;j++)
    {
     for(k=j+1;k<n;k++)
     {
      if(arr[j][i]==arr[k][i])
      {
       cols[i]=1;
//       System.out.println(i+":"+j+" "+rows[j]+" "+rows[k]);
      }
     }
    }
   }
   
   for(i=0;i<n;i++)
   {
    if(rows[i]==1) rowc++;
    if(cols[i]==1) colc++;
   }
   System.out.println("Case #"+(t+1)+": "+trace+" "+rowc+" "+colc);   
   t++;
  }
 }
}