import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int cc = 1; cc <= t; ++cc) {
      int r = in.nextInt();
      int c = in.nextInt();
      int[][] floor = new int[r][c];
      emptySpotsInDirection = new int[4][r][c];
      for(int i=0;i<r;i++)
      {
    	  for(int j=0;j<c;j++)
    	  {
    		  floor[i][j] = in.nextInt();
    	  }
      }
      long totalInterest = 0;
      boolean changed = true;
      Set<intPair> checkthese = new HashSet<intPair>();
      for(int i=0;i<r;i++)
	  {
		  for(int j=0;j<c;j++)
		  {
			  checkthese.add(new intPair(i,j));
		  }
	  }
      while(changed==true)
      {
    	  changed=false;
    	  totalInterest += sumall(floor);
    	  Set<intPair> newCheckThese = new HashSet<>();
    	  Set<intPair> changedPos=  new HashSet<>();
    	  for(intPair ip : checkthese)
    	  {
    		  int i= ip.a;
    		  int j = ip.b;
    			  if((floor[i][j]!=0)&&(checkIfOut(i,j,floor)))
    			  {
    				  changed = true;
    				  newCheckThese.addAll(neighbors(i,j,floor));
    				  changedPos.add(ip);
    			  }
    		  
    	  }
    	  for(intPair ip : changedPos)
    	  {
    		  floor[ip.a][ip.b]=0;
    	  }
    	  checkthese = newCheckThese;
      }
      System.out.println("Case #" + cc + ": "+totalInterest);
    }
  }
  public static class intPair
  {
	  public int a;
	  public int b;
	  public intPair(int a,int b)
	  {
		  this.a = a;
		  this.b = b;
	  }
  }
  public static long sumall(int[][] floor)
  {
	  long sum =0;
	  for(int i=0;i<floor.length;i++)
	  {
		  for(int j=0;j<floor[0].length;j++)
		  {
			  sum+=floor[i][j];
		  }
	  }
	  return sum;
  }
  //how far to go in direction until hit active dancer
  //0 -x
  //1 +x
  //2 -y
  //3 +y
  public static int[][][] emptySpotsInDirection;
  public static boolean checkIfOut(int x, int y, int[][] floor)
  {
	  int sum =0;
	  int count=0;
	  for(int i=x-emptySpotsInDirection[0][x][y]-1;i>=0;i--)
	  {
		  if(floor[i][y]!=0)
		  {
			  sum+=floor[i][y];
			  count++;
			  emptySpotsInDirection[0][x][y] = x-i-1;
			  break;
		  }if(i==0)
		  {
			  emptySpotsInDirection[0][x][y] = x;
		  }
	  }
	  for(int i=x+1+emptySpotsInDirection[1][x][y];i<floor.length;i++)
	  {
		  if(floor[i][y]!=0)
		  {
			  sum+=floor[i][y];
			  count++;
			  emptySpotsInDirection[1][x][y] = i-x-1;
			  break;
		  }if(i==floor.length-1)
		  {
			  emptySpotsInDirection[1][x][y] = floor.length-x-1;
		  }
	  }
	  for(int j=y-1-emptySpotsInDirection[2][x][y];j>=0;j--)
	  {
		  if(floor[x][j]!=0)
		  {
			  sum+=floor[x][j];
			  count++;
			  emptySpotsInDirection[2][x][y] = y-j-1;
			  break;
		  }if(j==0)
		  {
			  emptySpotsInDirection[2][x][y] = y;
		  }
	  }
	  for(int j=y+1+emptySpotsInDirection[3][x][y];j<floor[0].length;j++)
	  {
		  if(floor[x][j]!=0)
		  {
			  sum+=floor[x][j];
			  count++;
			  emptySpotsInDirection[3][x][y] = j-y-1;
			  break;
		  }if(j==floor[0].length-1)
		  {
			  emptySpotsInDirection[3][x][y] = floor[0].length-y-1;
		  }
	  }
	  return(floor[x][y]*count < sum);
  }
public static Set<intPair> neighbors(int x, int y, int[][] floor)
{
	  Set<intPair> ret = new HashSet<>();
	  for(int i=x-emptySpotsInDirection[0][x][y]-1;i>=0;i--)
	  {
		  if(floor[i][y]!=0)
		  {
			  ret.add(new intPair(i,y));
			  emptySpotsInDirection[0][x][y] = x-i-1;
			  break;
		  }if(i==0)
		  {
			  emptySpotsInDirection[0][x][y] = x;
		  }
	  }
	  for(int i=x+1+emptySpotsInDirection[1][x][y];i<floor.length;i++)
	  {
		  if(floor[i][y]!=0)
		  {

			  ret.add(new intPair(i,y));
			  emptySpotsInDirection[1][x][y] = i-x-1;
			  break;
		  }if(i==floor.length-1)
		  {
			  emptySpotsInDirection[1][x][y] = floor.length-x-1;
		  }
	  }
	  for(int j=y-1-emptySpotsInDirection[2][x][y];j>=0;j--)
	  {
		  if(floor[x][j]!=0)
		  {

			  ret.add(new intPair(x,j));
			  emptySpotsInDirection[2][x][y] = y-j-1;
			  break;
		  }if(j==0)
		  {
			  emptySpotsInDirection[2][x][y] = y;
		  }
	  }
	  for(int j=y+1+emptySpotsInDirection[3][x][y];j<floor[0].length;j++)
	  {
		  if(floor[x][j]!=0)
		  {

			  ret.add(new intPair(x,j));
			  emptySpotsInDirection[3][x][y] = j-y-1;
			  break;
		  }if(j==floor[0].length-1)
		  {
			  emptySpotsInDirection[3][x][y] = floor[0].length-y-1;
		  }
	  }
	  return(ret);
}

}
