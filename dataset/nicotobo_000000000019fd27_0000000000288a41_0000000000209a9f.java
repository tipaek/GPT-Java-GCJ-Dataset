import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution 
{
	public static void main(String[] args) throws IOException 
	{	
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String strnumCasos=bf.readLine();
		Integer numCasos=Integer.parseInt(strnumCasos);
		Stack<String>stk=new Stack<String>();
		for (int i = 0; i < numCasos; i++) 
		{
			String strCaso=bf.readLine();	   
			String rta="";
			for (int j = 0; j < strCaso.length(); j++) 
			{
				int xNum=Integer.parseInt(strCaso.charAt(j)+"");
				int xNumAnterior=0;
				if(j-1>=0)
				{
					xNumAnterior=Integer.parseInt(strCaso.charAt(j-1)+"");
				}
				for (int k = 0; k < xNum-xNumAnterior; k++) 
				{
					rta+="(";	
				}
				for (int k = 0; k < xNumAnterior-xNum; k++) 
				{
				   rta+=")";	
				}
				rta+=xNum;
				if(j==strCaso.length()-1) 
				{
					for (int k = 0; k < xNum; k++) 
					{
						rta+=")";	
					}
				}


			}

			System.out.println("Case #"+(i+1)+": "+rta);
		}
	}
}