import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int b = sc.nextInt();
		if(b == 10)
		{
			for(int z = 0 ;z < t ; z++ )
			{
			
				String s = "";
				String [] all =new String[15];
				for(int i = 0 ; i< 150; i++ )
				{
					
					if(i % b == 0 && i/b !=0)
					{
						all[(i/10)-1] = s;
						s= "";
					}
					System.out.println(((i%10) +1));
			
					s+= sc.next().charAt(0);
					if(i == 149)
					{
						
						all[14] = s; 
					}
				}
				System.out.println(all[14]);
				char res = sc.next().charAt(0);
				if(res == 'Y')
					continue;
				else
					break;
			}
		}
		else
		{
			for(int z = 0 ;z < t ; z++ )
			{
			
				String s = "";
				String [] all =new String[15];
				for(int i = 0 ; i< 150; i++ )
				{
					
					if(i % 10 == 0 && i/10 !=0)
					{
						for(int j = 0 ; j < 10 ; j++ )
							s+='#';
						int index = (i/10)-1;
						all[index] = s;
						s= "";
					}
					System.out.println(((i%10) +1));
			
					s+= sc.next().charAt(0);
					if(i == 149)
					{
						
						all[14] = s; 
						for(int j = 0 ; j < 10 ; j++ )
							s+='#';
					}
				}
				for(int i = 0 ; i < 10 ; i++ )
					System.out.print(all[14].charAt(i));
				String n = reverseOf(all[13]);
				for(int i = 10 ; i < 20 ; i++ )
					System.out.print(n.charAt(i));
				System.out.println();
				char res = sc.next().charAt(0);
				if(res == 'Y')
					continue;
				else
					break;
					
			}
			
		}
		sc.close();
	}

	private static String complementOf(String s)
	{
		String temp = "";
		for(int i = 0 ; i < s.length() ; i++  )
		{
			if(s.charAt(i) == '0' )
				temp += 1;
			else if(s.charAt(i) == '1' )
				temp += 0 ;
			else if(s.charAt(i) == '#' )
				temp += '#';
		}
		return temp;
	}
	private static String reverseOf(String s)
	{
		String temp = "";
		for(int i = s.length()-1 ;i >= 0 ;i--  )
		{
			temp += s.charAt(i);
		}
		return temp;
	}
	
	private static String rev_compOf(String s)
	{
		s = reverseOf(s);
		s = complementOf(s);
		return s;
	}
	

}
