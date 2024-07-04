import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int z = 0 ; z < test_case ; z++)
		{
			long n = sc.nextLong();
			long d = sc.nextLong();
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
				
				int index = 0 ;
				long temp = 0;
				long curmx = 0;
				long l1 = list.get(0);
				for(int i = l-1 ; i >= 0 ; i--)
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
						if(temp > curmx)
						{
							curmx = temp;
							index = i+(int)temp ;
						}
						temp = 1 ;
						
					}
				}
				ctr = temp;
				if(ctr >= d)
					break;
				
				if(l == 2 )
				{
					index = 1;
				}
				if(l== 3 )
				{
					index = 2 ;
				}
				long b = list.get(index);
				long a = list.get(index - 1 );
				list.remove(index);
				list.add(a);
				list.add(b - a);
				
				ans++;
				
			}
		
			if(ans > d )
			{
				System.out.println("Case #" + (z+1) + ": " + d);
			}
			else
			{
				System.out.println("Case #" + (z+1) + ": " + ans);
			}
		}
		sc.close();
	}

}