import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int z = 0 ; z < test_case ; z++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.next();
			
			long ctr = 0;
			long ans = (long) (9 * (Math.pow(10, 9)));
			
			int len = s.length();
			
			for(int i = 0 ; i < len ; i++ )
			{
				long temp = Math.abs(x-0) + Math.abs(y-0);
				if(ctr >= temp)
					ans = Math.min(ans, ctr);
				if(s.charAt(i) == 'S')
					y -= 1;
				if(s.charAt(i) == 'N')
					y += 1;
				if(s.charAt(i) == 'W')
					x -= 1;
				if(s.charAt(i) == 'E')
					x += 1;
				ctr++;
				
				temp = Math.abs(x-0) + Math.abs(y-0);
				if(ctr >= temp )
					ans = Math.min(ans, ctr);
			}
			
			if(ans == 9 * (Math.pow(10, 9)))
				System.out.println("IMPOSSIBLE");
			else
				System.out.println("Case #" + (z+1) + ": "+ ans);
		}
		sc.close();
	}

}
