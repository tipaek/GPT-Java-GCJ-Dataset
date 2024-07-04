import java.util.Scanner;

public class Solution {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++)
		{
			String S = sc.next();
			S = "0" + S + "0";
			String result = "";
			
			char[] arr = S.toCharArray();
			
			for(int j = 0; j < arr.length - 1; j++)
			{
				int current = Integer.parseInt(arr[j] + "");
				int next = Integer.parseInt(arr[j + 1] + "");
				int diff = next - current;
				char bracket = '(';
				
				result = result + current;
				
				if(diff < 0)
				{
					bracket = ')';
					diff = -diff;
				}
				
				for(int k = 0; k < diff; k++)
				{
					result = result + bracket;
				}
				
			}

			System.out.println("Case #" + (i + 1) + ": " + result.substring(1));
			
		}

	}

}