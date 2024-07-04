import java.util.Scanner;

public class Solution {
	public static String solution(String str)
	{
		int temp1, temp2=0, len;
		String s = "";
		String sl;

		for(int j=0; j<str.length(); j++)
		{
			temp1 = Integer.parseInt(String.valueOf(str.charAt(j)));
			
			if(s.length() == 0)
			{
				for(int i=0; i<temp1; i++)
				{
					s = s+"(";
				}

				s = s+Integer.toString(temp1);

				for(int i=0; i<temp1; i++)
				{
					s = s+")";
				}
			}
			else if(temp1 == 0)
			{
				s= s+Integer.toString(temp1);
			}
			else 
			{
				if(temp1 < temp2) 
				{
					len = s.length();
					s = s.substring(0,len-temp1)+Integer.toString(temp1)+ s.substring(len-temp1,len);
				}
				else if(temp2 == temp1)
				{
					len = s.length();
					s = s.substring(0,len-temp1)+Integer.toString(temp1)+ s.substring(len-temp1,len);
				}
				else if(temp1 > temp2)
				{
					len = s.length();
					sl = "";

					for(int i=0; i<temp1-temp2; i++)
					{
						sl = sl+"(";
					}

					sl = sl+Integer.toString(temp1);

					for(int i=0; i<temp1-temp2; i++)
					{
						sl = sl+")";
					}
					
					s = s.substring(0,len-temp2)+sl+ s.substring(len-temp2,len);	
				}
			}
			temp2 = temp1;
			
		}
		return s;
	}
	
	public static void main(String[] args) {
		
		int totalTestCases;
		String Temp, out;
		Scanner sc = new Scanner(System.in);
		totalTestCases = sc.nextInt();

		for(int i=0; i<totalTestCases; i++)
		{
			Temp = sc.next();
			System.out.println("case #"+(i+1)+": "+solution(Temp));
		}

		sc.close();
	}
	
}