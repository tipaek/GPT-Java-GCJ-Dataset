import java.util.*;


import java.io.*;


public class Solution {
	
	static int dig[];
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


	
	public static void main(String[] args) {
		

		int t = in.nextInt();
		
		int count=1;
		String ns="";
		
		while(count <=t)
		{
			String input="";
			input = readInput();
			
			//System.out.println(input.length());
			
			 dig = new int[input.length()];
			
			for(int i=input.length()-1;i>=0;i--){
				dig[i] =  Character.getNumericValue(input.charAt(i));
				
			}
			int digit=0;
			int prev=0;
			int prevIndex =0;
			
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			
			for(int i=dig.length-1;i>=0;i--)
			{
				digit = dig[i];
				if (i==(dig.length-1)) {
					ns = bracketString(digit, "f")+digit+bracketString(digit, "b");
				}
				
				else if (digit==0) {
					ns = 0+ns;
				}
				else {
					if (prev==0) {
						ns = bracketString(digit, "f")+digit+bracketString(digit, "b")+ns;
					}
					
					else if (digit>prev) {
						//System.out.println("Entered");
						String s1 = ns.substring(0,prevIndex);
						//System.out.println(s1);
						String s2 = bracketString(digit-s1.length(), "f");
						//System.out.println(s2);
						ns = s1+s2+digit+bracketString(digit-s1.length(), "b")+ns.substring(prevIndex);
					}
					
					else if (digit<prev) {
						
						String s1 = ns.substring(0,prevIndex);
						//System.out.println(s1);
						String s2 = s1.substring(0,digit);
						//System.out.println(s2);
						ns = s2+bracketString(digit-s2.length(), "f")+digit+bracketString(digit-s1.length(), "b")+ns.substring(prevIndex-1);
					}
					
					else if(digit==prev)
					{
						ns = ns.substring(0, prevIndex)+ns.charAt(prevIndex)+digit+ns.substring(prevIndex+1);
					}
					
				}
				
				//System.out.println(ns);
				
				prev = digit;
				prevIndex = ns.indexOf(prev+'0');
				indexes.add(prevIndex);
			}
			
			
			
			System.out.println("Case #"+count+": "+ns);
			
			
			
			
			count+=1;
		}
		
	}
	
	static String bracketString(int n, String dir)
	{
		String tempString = "";
		for(int i=1;i<=n;i++)
		{
			if (dir.equals("f")) {
				tempString+="(";
			}
			else if (dir.equals("b")) {
				tempString+=")";
			}
				
			
			
		}
		
		return tempString;
	}
	
	public static String readInput()
	{
		String r="";
		r = in.next();
		return r;
	}
	
	

}


