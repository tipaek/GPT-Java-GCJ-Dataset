import java.io.*;
import java.util.*;
import java.math.*;

public class A
{
	public static void main(String[] args) throws Exception
	{		
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=Integer.parseInt(in.nextLine());
		

		for (int i=1; i<=T; i++)
		{
      int N=Integer.parseInt(in.nextLine());
      int[][] a=new int[N][N];
      for (int k=0; k<N; k++)
      {  
        String s=in.nextLine();
        String[] temp=s.split(" ");
        for (int m=0; m<N; m++) a[k][m]=Integer.parseInt(temp[m]);
      }
      String ans=solve(a);
      System.out.println("Case #"+i+": "+ans);
    }

		in.close();
	}

  public static String solve(int[][] a)
  {
    int N=a.length;

    int trace=0;
    for (int i=0; i<N; i++) trace+=a[i][i];

    int badRows=0;
    for (int r=0; r<N; r++)
    {
      Set<Integer> seen=new HashSet<Integer>();
      for (int c=0; c<N; c++)
      {
        if (seen.contains(a[r][c]))
        {
          badRows++;
          break;
        }
        seen.add(a[r][c]);
      }
    }

    int badCols=0;
    for (int c=0; c<N; c++)
    {
      Set<Integer> seen=new HashSet<Integer>();
      for (int r=0; r<N; r++)
      {
        if (seen.contains(a[r][c]))
        {
          badCols++;
          break;
        }
        seen.add(a[r][c]);
      }
    }    

    return trace+" "+badRows+" "+badCols;
  }
}