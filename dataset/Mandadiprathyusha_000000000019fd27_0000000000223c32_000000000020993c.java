import java.lang.*;
import java.util.*;
class Vestigium
{
 public static void main(String args[])
 {
  Scanner sc= new Scanner(System.in);
  
  System.out.print("enter the number of testcases: ");
  int T=sc.nextInt();
  int trace[]=new int[T];
  int rc[]=new int[T];
  int cc[]=new int[T];
  for(int k=0;k<T;k++)
  {
  System.out.print("enter the size of the array: ");
  int N=sc.nextInt();
  System.out.print("enter the elements: ");
  int mat[][] = new int[N][N];
  for(int i=0;i<N;i++)
  {
   for(int j=0;j<N;j++)
   {
    mat[i][j]=sc.nextInt();
   }
  }
  for(int i=0;i<N;i++)
  {
   for(int j=0;j<N;j++)
   {
    if(i==j)
    {
     trace[k]=trace[k]+mat[i][j];
    }
   }
  }
  int rcount=0,q=0;
  for(int i=0;i<N;i++)
  {
   for(int j=0;j<N-1;j++)
   {
    if(mat[i][j]==mat[i][j+1])
    {
     q=1;
    }
   }
    if(q==1){
    rcount = rcount+1;
    rc[k]=rcount;
    }
   }
  
  int ccount=0,w=0;
  for(int j=0;j<N;j++)
  {
   for(int i=0;i<N-1;i++)
   {
    if(mat[i][j]==mat[i+1][j])
    {
     w=1;
    }
   }
    if(w==1)
    {
    ccount = ccount+1;
    cc[k]=ccount;
    }
  }
  }
  for(int k=0;k<T;k++)
  {
   System.out.println("case #"+k+": "+trace[k]+" " +rc[k]+" " +cc[k]);
  }
 }
}
