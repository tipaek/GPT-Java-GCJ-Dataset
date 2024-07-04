import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T;
		
		do
		{
			T=sc.nextInt();
		} while(T<1 || T>100);
		
		String[] result=new String[T];
		try
		{
			for(int i=0;i<T;i++)
			{
				result[i]="Case #"+(i+1)+": "+doCalculation(sc);
			}
			
			for(int i=0;i<T;i++)
			{
				System.out.println(result[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		sc.close();
	}
	
	private static String doCalculation(Scanner sc) throws Exception
	{
		int X,Y;
		String M,result="";
		
		do
		{
			X=sc.nextInt();
		} while(X<1 || X>1000);
		
		do
		{
			Y=sc.nextInt();
		} while(Y<1 || Y>1000);
		
		boolean validString;
		
		sc.nextLine();
		do
		{
			validString=true;
			M=sc.nextLine();
			
			for(int i=0;i<M.length();i++)
			{
				if(M.charAt(i)!='N' && M.charAt(i)!='S' && M.charAt(i)!='E' && M.charAt(i)!='W')
				{
					validString=false;
				}
			}
		} while(M.length()>1000 || validString==false);
		
		int curX=X,curY=Y,ind=0;
		double[] distances=new double[M.length()+1];
		
		distances[0]=distance(X,Y);
		ind++;
		
		for(int j=0;j<M.length();j++)
		{
			char a=M.charAt(j);
			
			if(a=='N')
			{
				curY=curY+1;
			}
			else if(a=='S')
			{
				curY=curY-1;
			}
			else if(a=='E')
			{
				curX=curX+1;
			}
			else if(a=='W')
			{
				curX=curX-1;
			}
			
			distances[ind++]=distance(curX,curY);
		}
		
		double least=distances[0];
		
		for(int j=1;j<distances.length;j++)
		{
			if(least>distances[j])
			{
				least=distances[j];
			}
		}
		
		for(int j=0;j<distances.length;j++)
		{
			if(least==distances[j])
			{
				int XCo=calculateXCo(M,j,X), YCo=calculateYCo(M,j,Y);
				
				int pepTime=Math.abs(XCo-X)+Math.abs(YCo-Y);
				
				int time=Math.abs(XCo)+Math.abs(YCo);
				
				if(time>pepTime)
				{
					result="IMPOSSIBLE";
				}
				else
				{
					result=Integer.toString(pepTime);
				}
				
				break;
			}
		}
		
		return result;		
	}
	
	private static int calculateXCo(String M, int index, int X) throws Exception
	{
	
		int XC=X;
		
		for(int i=0;i<index;i++)
		{
			char a=M.charAt(i);
			
			if(a=='E')
			{
				XC+=1;
			}
			else if(a=='W')
			{
				XC-=1;
			}
		}
		return XC;
	}
	
	private static int calculateYCo(String M, int index, int Y) throws Exception
	{
	
		int YC=Y;
		
		for(int i=0;i<index;i++)
		{
			char a=M.charAt(i);
			
			if(a=='N')
			{
				YC+=1;
			}
			else if(a=='S')
			{
				YC-=1;
			}
		}
		return YC;
	}
	
	private static double distance(int posX,int posY) throws Exception
	{
		double sum=posX*posX+posY*posY;
		return Math.sqrt(sum);
	}
}
