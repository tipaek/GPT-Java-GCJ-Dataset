

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	
		for (int i = 0; i < t; i++) {
			
			String s=sc.next();
			StringBuffer ans=new StringBuffer();
			
			
			
			String [] stringTokens = s.toString().split("");
			int [] intArr = Stream.of(stringTokens)
				                  .mapToInt(strToken -> Integer.parseInt(strToken))
				                  .toArray();
			
			
			int flagg=0;
			for(int k=0;k<intArr[0];k++)
			{
				ans.append('(');
				flagg++;
			}
			
			ans.append(intArr[0]);
			for(int j=1;j<intArr.length;j++)
			{
				
				
				if(intArr[j]>intArr[j-1])
				{
				// 	for(int k=0;k<intArr[j-1];k++)
				// 	{
				// 		ans.append(')');
				// 		flagg--;
				// 	}
					
				// 	for(int k=0;k<intArr[j];k++)
				// 	{
				// 		ans.append('(');
				// 		flagg++;
				// 	}
				for(int k=0;k<intArr[j]-intArr[j-1];k++)
					{
						ans.append('(');
						flagg++;
					}
					
				}
				else if(intArr[j]<intArr[j-1])
				{
					for(int k=0;k<intArr[j-1]-intArr[j];k++)
					{
						ans.append(')');
						flagg--;
					}
				}
				
				
				ans.append(intArr[j]);
				
			}
			
			for(int k=0;k<flagg;k++)
			{
				ans.append(')');
			}
			System.out.print("Case #");
			System.out.print((i + 1) + ": ");
			System.out.print(ans);
			System.out.println();
		}
	}

}
