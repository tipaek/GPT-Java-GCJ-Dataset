
import java.util.*;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int i=1; i<=t; i++)
		{
			int n=in.nextInt();
			String[] str=new String[n];
			String longest_word="";
			int len=0;
			for(int j=0; j<n; j++)
			{
				str[j]=in.next();
				str[j]=charRemoveAt(str[j], 0);
				if(len<str[j].length())
				{
//					System.out.println("prev: "+longest_word);
					longest_word=str[j];
					len=str[j].length();
//					System.out.println("new: "+longest_word);
				}
					
			}
//			
			for(int j=0; j<n; j++)
			{
				if(match(longest_word,str[j])==-1)
				{
					longest_word="*";
					break;
				}
			}
//			for(String s:str)
//				System.out.println(s);
			System.out.println("Case #" + i + ": "+longest_word);
		}
	}
	
	public static int match(String longest_word, String string)
	{
		// TODO Auto-generated method stub
		int len1=longest_word.length();
		int len2=string.length();
		while(len2>0)
		{
			if(longest_word.charAt(len1-1)!=string.charAt(len2-1))
				return -1;
			else
			{
				len2--;
				len1--;
			}
		}
		return 1;
	}

	public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
     }

}
