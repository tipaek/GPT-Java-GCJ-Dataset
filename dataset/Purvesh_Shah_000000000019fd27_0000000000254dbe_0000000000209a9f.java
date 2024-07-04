import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		
		for(int i=1;i<=T;i++)
		{
			
			String S=scan.next();
			String news=new String();
			String last=new String();
			for(int j=0;j<S.length();j++)
			{
				Character.getNumericValue(S.charAt(j));
				int n=Character.getNumericValue(S.charAt(j));
				
				for(int k=0;k<n;k++)
				{
					news=news+"(";
				}
				news=news+S.charAt(j);
				for(int k=0;k<n;k++)
				{
					news=news+")";
				}
				
			}
			for(int j=0;j<10;j++)
			{
			last=news.replace(")(","");
			news=last;
			}
			System.out.println("Case #"+i+": "+last);
		}

	}

}
