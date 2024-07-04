import java.util.*;
class Code1{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k=1;k<=t;k++)
		{
			String s=sc.next();
			
			
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='1')
				{
				   	System.out.print("("+s.charAt(i)+")");
				}

			
			else
				if(s.charAt(i)=='0')
				{
				  System.out.print(s.charAt(i));
				}
			}	
			
		}
	}
}