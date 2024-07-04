public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++)
		{	
			List<String> list = new ArrayList<>();
			String starts = "";
			String middle = "";
			String ends = "";
			
			boolean possible = true;

			int N = sc.nextInt();
			
			for(int j = 0; j < N; j++)
			{
				list.add(sc.next());
			}
			
			for(int j = 0; j < N; j++)
			{
				String rule = list.get(i);
				
				if(rule.charAt(0) != '*')
				{
					
				}
				
				if(rule.charAt(rule.length() - 1) != '*')
				{
					
				}
				
				
			}
			
			System.out.println(starts + middle + ends);
		}

	}

}