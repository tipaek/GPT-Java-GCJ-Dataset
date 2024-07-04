import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int z = 0 ; z < test_case ; z++)
		{
			int n = sc.nextInt();
			int d = sc.nextInt();
			ArrayList<Long> list = new ArrayList<Long>();
		
			long ctr = 0;
			for(int i = 0 ; i < n  ; i++)
			{
				long x = Long.parseLong(sc.next());
				list.add(x);
	
			}
			long ans = 0;
			if(list.size() == 1 ) {
				System.out.println("Case #" + (z+1) + ": " + (d-1));
				continue;
			}
			while(true)
			{
				int l = list.size();
				Collections.sort(list);
				
				long temp = 0;
				long l1 = list.get(0);
				for(int i = 0 ; i < l ; i++)
				{
					if(list.get(i) == l1)
					{
						temp++;
						if(temp >= d )
						{
							break;
						}
						
					}
					else
					{
						l1 = list.get(i);
						temp = 1 ;
						
					}
				}
				ctr = temp;
				if(ctr == d)
					break;
				
				int index = l - 1;
				long b = list.get(index);
				long a = list.get(index - 1 );
				list.remove(index);
				list.add(a);
				list.add(b - a);
				
				ans++;
				
			}
		
			
			
			System.out.println("Case #" + (z+1) + ": " + ans);
		}
		sc.close();
	}

}