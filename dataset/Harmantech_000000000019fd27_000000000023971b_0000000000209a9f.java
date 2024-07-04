import java.util.*;

public class Solution{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
			
		solve();
	}

	public static void solve()
	{
		int n = scan.nextInt();

		String rough = scan.nextLine();
		
		for(int i=0; i<n;i++)
		{
			String res = solveTest();
			System.out.println("Case #"+(i+1)+": "+res);
		}
		
	}
	
	public static String solveTest()
	{
		String S = scan.nextLine();
		int x =0;
		char[] MyArray = S.toCharArray();
	
		StringBuilder resultString = new StringBuilder();
		
		
		int num = 0;
		int NoOfBrackets = 0;
		
		int intial = Character.getNumericValue(MyArray[0]);
		
		num = intial;
		NoOfBrackets = intial;
		
		
		for(int i=0; i < intial ; i++)
		{
			resultString.append('(');
						
		}
		resultString.append(intial);
		
		for(int i =1 ; i < MyArray.length;i++)
		{
			int d = Character.getNumericValue(MyArray[i]);
			
			if(d==num)
			{
				resultString.append(d);
			}
			else if (d> num)
			{
				int diff = d- num;
				for(int j=0; j< diff ; j++)
				{
					resultString.append('(');
				
					NoOfBrackets++;
				}
				resultString.append(d);
			}
			else
			{
				int diff = num -d ;
				for(int j=0; j< diff ; j++)
				{
					resultString.append(')');
				
					NoOfBrackets--;
				}
				
				resultString.append(d);
				
			}
			
			num = Character.getNumericValue(MyArray[i]);
		}
		
		while( NoOfBrackets-- > 0)
		{
			resultString.append(')');
		}
		return resultString.toString();
		
	}



}
