import java.util.*;

class Solution 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int x = 1;
		while(x<=t)
		{
			String s = sc.next();
			char ch[] = s.toCharArray();
			
			String new_str ="";
			
			boolean open = false;
			
			for(int i=0 ; i<ch.length ; i++)
			{
				if(ch[i] == '0')
				{
					if( open == false )
						new_str += "0";
					else
					{
						new_str += ")0";
						open = false;
					}
				}
				
				else if(ch[i] == '1')
				{
					if( open == true )
					{
						if( i== ch.length-1)
							new_str += "1)";
						
						else
							new_str += "1";	
					}
					else
					{
						if( i == ch.length-1 )
							new_str += "(1)";
						
						else
						{
							new_str += "(1";
							open = true;
						}
						
					}
				}
			
			}
			
			System.out.println("Case #"+x+": "+new_str);
			
			x++;
		}
	}

}
