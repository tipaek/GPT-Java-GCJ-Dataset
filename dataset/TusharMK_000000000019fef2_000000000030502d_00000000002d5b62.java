import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		int num = 6;
		while(num < 1000000000)
		{
			list.add(num);
			num *=2; 
		}
		ArrayList<Integer> index = new ArrayList<Integer>();
		index.add(0);
		index.add(1);
		index.add(2);
		index.add(4);
		num = 8;
		while(num < 1000000000)
		{
			index.add(num);
			num *=2; 
		}
		int test_case = sc.nextInt();
		for(int z = 0 ; z < test_case ; z++)
		{
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(Math.abs(x) == Math.abs(y)) {
				System.out.println("Case #" + (z+1) + ": IMPOSSIBLE");
				continue;
			}
			
			
			if(list.contains(Math.abs(x)) && list.contains(Math.abs(y)))
			{
				String s = "";
				
				while(x != 0 || y != 0)
				{
					int i = Math.abs(x);
					int j = Math.abs(y);
					if(i > j)
					{
						int in = list.indexOf(i);
						if(j == 0 && i != 1)
						{
							for(int k = 1 ; k < list.indexOf(i) ; k++)
							{
								if(x > 0)
								{
									s += 'E';
								}
								else
								{
									s += 'W';
								}
							}
							break;
						}
						if(x>0)
						{
							s+= 'E';
							x = x - index.get(in); 
						}
						else
						{
							s+= 'W';
							x = x + index.get(in);
						}
						
					}
					else
					{
						int in = list.indexOf(j);
						if(x == 0 && j != 1)
						{
							for(int k = 1 ; k < list.indexOf(j) ; k++)
							{
								if(y > 0)
								{
									s += 'S';
								}
								else
								{
									s += 'N';
								}
							}
							break;
							
						}
						if(y > 0)
						{
							s+= 'N';
							y = y - index.get(in); 
						}
						else
						{
							s+= 'S';
							y = y + index.get(in);
						}
						
					}
					
				}
				
				
				System.out.print("Case #" + (z+1) + ": ");
				for(int k = s.length()-1 ; k >=0 ; k--)
				{
					System.out.print(s.charAt(k));
				}
				System.out.println();
				
			}
			else
			{
				
				System.out.println("Case#" + (z+1) + ": IMPOSSIBLE");
			}
			
		
			
			
			
		}
		sc.close();
	}

}
