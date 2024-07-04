import java.util.*;
public class Test
{ public static void main(String[] args)
{
  Scanner sc=new Scanner(System.in);
  int t=sc.nextInt();
  int S[][]=new int[t][4];
  for(int i=1;i<=t;i++)
  {
    int count=0;
    int trace=0;
    int n=sc.nextInt();
   // System.out.println(i);
    // System.out.println(n);
    
    int M[][]=new int[n][n];
    
    for(int j=0;j<n;j++)
    for(int k=0;k<n;k++)
    M[j][k]=sc.nextInt();
    
    for(int j=0;j<n;j++)
    trace=trace+M[j][j];
    
    S[i-1][0]=i;
    S[i-1][1]=trace;
    
    for(int x=0;x<n;x++)
    {
        count=0;
        for(int y=0;y<n-1;y++)
      { int t1=M[y][x];
        for(int z=y+1;z<n;z++)
        if(M[z][x]==t1)
        {
          count++;
          
         // break;
        }
      }
      if(count>0)
      S[i-1][2]=S[i-1][2]+1;
    }
    for(int x=0;x<n;x++)
    {
        count=0;
        for(int y=0;y<n-1;y++)
      { int t2=M[x][y];
        for(int z=y+1;z<n;z++)
        if(M[x][z]==t2)
        {
          count++;
          //break;
        }
      }
      if(count>0)
      S[i-1][3]=S[i-1][3]+1;
    }
    // System.out.println("Case #"+i+": "+S[i-1][1]+" "+S[i-1][2]+" "+S[i-1][3]);
  }
  for(int i=1;i<=t;i++)
  System.out.println("Case #"+i+": "+S[i-1][1]+" "+S[i-1][3]+" "+S[i-1][2]);
}
}