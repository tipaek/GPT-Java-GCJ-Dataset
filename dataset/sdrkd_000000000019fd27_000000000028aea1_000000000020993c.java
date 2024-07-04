import java.util.*;
class Vestigium
{static int test=1;
  private static Scanner sc;
    public static void main(String args[])throws Exception
{int t,n;
sc=new Scanner(System.in);
    t=sc.nextInt();
    while(t-->0)
    {
      find();
    }
  } 
  public static void find()
{int i,j,trace=0,n;

n=sc.nextInt();
  int m[][]=new int[n][n];
  for(i=0;i<n;i++)
  {
    for(j=0;j<n;j++)
    {
      m[i][j]=sc.nextInt();
      if(i==j)
        trace+=m[i][j];

    }
  }
  System.out.println("Case #"+(test++)+": "+trace+" "+noRow(m)+" "+noCol(m));
    
} 
public static int noRow(int m[][])
{int row=0;
for(int i=0;i<m.length;i++)
{
  ArrayList<Integer> l=new ArrayList<Integer>();
  for(int j=0;j<m.length;j++)
  {
      if(l.contains(m[i][j]))
        {row++;
      break;}
      l.add(m[i][j]);
  }
}
return row;
}
public static int noCol(int m[][])
{int col=0;
for(int i=0;i<m.length;i++)
{
  ArrayList<Integer> l=new ArrayList<Integer>();
  for(int j=0;j<m.length;j++)
  {
      if(l.contains(m[j][i]))
        {col++;
      break;}
      l.add(m[j][i]);
  }
}
return col;
  
}
}