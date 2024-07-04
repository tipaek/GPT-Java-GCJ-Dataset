import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int i = 1; i <= T; i++)
		{
			String S = in.next();
			int N = S.length();
			StringBuilder result = new StringBuilder();
			int [] loop = new int[N];
			
			for(int j=0; j < N; j++)
			{
				loop[j] = S.charAt(j) - '0';
			}
			
			for(int j=0; j < N; j++)
			{
				if(loop[j] == 0)
				{	
					result.append("0");
				}
				else
				{
					if(!result.toString().contains("(") || loop[j-1] == 0)
						result.append('(');
						
					if(j == 0 || (j != 0  && loop[j] != loop[j-1]))
					{
						for(int l = 0; l < loop[j]-1 ; l++)
							result.append('(');	
					}

					
					result.append(loop[j]);
					int stop = 0;
					
					if(j != N-1 && loop[j+1] < loop[j])
					{
						stop = loop[j] - loop[j+1];
					}
					else if( j == N-1)
					{
						stop =  loop[j];
					}
					
					for(int l = 0; l < stop ; l++)
						result.append(')');	

					
				}
	
			}

			
			System.out.printf("Case #%d: %s\n", i, result);
			
		}
		
		in.close();
	}

}
