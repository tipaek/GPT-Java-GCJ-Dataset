import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int i = 1; i <= t; i++) {
			
			String s=scn.next();
			String ans="";
			
//			int onesl=0;
			int onesr=0;
			for(int j=0;j<s.length();)
			{
				if(s.charAt(j)=='1')
				{
					int k=1;
					while(j+1<s.length() && s.charAt(j+k)=='1')
					{
						onesr++;
						k++;
					}
					
					ans+="("+s.substring(j,j+onesr+1)+")";
					j+=onesr+1;
				}
				else
					{
					ans+=s.charAt(j);
					j++;
					}
				
				
					
			}
		
			System.out.println("Case #" + i + ": " + ans);

		}
	}

}
