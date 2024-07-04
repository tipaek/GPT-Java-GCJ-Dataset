import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  int t,cno=1;
	  t=sc.nextInt();
	  for(int k=0;k<t;k++)
	  {
	      int n;
	      n=sc.nextInt();
	      int[][] ar=new int[n][2];
	      for(int i=0;i<n;i++)
	      {
	          for(int j=0;j<2;j++)
	          {
	              ar[i][j]=sc.nextInt();
	              //ar[i][j]=ar[i][j]/60;
	          }
	      }
	      int[] C=new int[2];
	      String s1="";
	      int max=1,min=0,jmax=0,jmin=0;
	      C[max]=ar[0][1];
	      C[min]=ar[0][0];
	      s1=s1+"C";
	      boolean ha=false;
	      for(int i=1;i<n;i++)
	      {
	          for(int j=0;j<2;j++)
	          {
	              int result=0;
	              if(ar[i][j]<C[max])
	              {
	                  result=result+C[min]-ar[i][j];
	                  if(result<0&&jmin==0&&jmax==0)
	                  {
	                      if(j==0)
	                      {jmin=ar[i][j];
	                      jmax=ar[i][j+1];
	                      }
	                      else
	                      {
	                          jmin=ar[i][j-1];
	                          jmax=ar[i][j];
	                      }
	                      if(jmin!=0||jmax!=0)
	                      {
	                          ha=true;
	                          j++;
	                      }
	                  }
	                  else if(result<0)
	                  {
	                      if(ar[i][j]<jmax)
	                      {
	                          result=0;
	                          result=jmin-ar[i][j];
	                          if(result<0)
	                          s1="Impossible";
	                          j++;
	                      }
	                      else
	                      {
	                          ha=true;
	                          j++;
	                      }
	                  }
	                  else
	                  ha=false;
	                  if(ha==true&&s1!="Impossible")
	                  s1=s1+"J";
	              }
	              else 
	              {ha=false;
	              j++;
	              }
	          }
	          if(ha==false&&s1!="Impossible")
	          {s1=s1+"C";
	          }
	          
	      }System.out.println("Case #"+cno+": "+s1);
	        cno++;
	  }
	}
}