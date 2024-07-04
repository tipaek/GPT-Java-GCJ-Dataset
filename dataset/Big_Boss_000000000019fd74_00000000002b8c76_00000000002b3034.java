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
				if(longest_word.indexOf(str[j])==-1)
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
	
	public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
     }
	
	public static int isSubstring(String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        } 
      
        return -1; 
    }

}
