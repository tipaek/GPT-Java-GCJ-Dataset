import java.util.*;
  import java.io.*;
class Solution 
{
	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
		String s[]=new String[t];
		s[0]=in.nextLine();
		for(int i=0;i<t;i++)
			s[i]=in.nextLine();
		int count=0;
           for(int i=0;i<t;i++)
		{
          int flag=0;
           if(s[i].contains("1"))
			{
			   count=0;
			   System.out.println();
			   for(int j=0;j<s[i].length();j++)
				{
				   if(s[i].charAt(j)=='0')
                      System.out.print(s[i].charAt(j));
				   else
					{
					   count++;
                   if ( count==1 && s[i].charAt(j)=='1') 
                       System.out.print("(");
				   else if(s[i].charAt(j)=='1' && s[i].charAt(j-1)=='0')
                        System.out.print("(");
					  
						else
							flag=1;
                       System.out.print(s[i].charAt(j));
					   if((j+1)!=s[i].length() && s[i].charAt(j+1)=='0'  || j==s[i].length()-1 )
						   System.out.print(")");
					} 
				}
                      
			
			}
			else
              System.out.print(s[i]);
		
	}
}
}
