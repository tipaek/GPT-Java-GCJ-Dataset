import java.util.*;
class Solution
{
	public static String[] readInput(int lines)
	{
		Scanner input = new Scanner(System.in);
		int cases = Integer.parseInt(input.nextLine());
		String result[] = new String[cases*lines+1];
		result[0]=Integer.toString(cases);
		int count=1;
		for(int i=1;i<=cases;i++)
		{
			for(int j=1;j<=lines;j++)
			{
				result[count]=input.nextLine();
				count++;
			}
		}
		//System.out.println("Cases: " + cases);
		return result;
	}
	
	
	public static void main(String[] args)
	{
		String input[] = readInput(1);
		for(int i=1;i<input.length;i++)
		{
			char values[] = input[i].toCharArray();
			int depth=0;
			ArrayList<Character> list = new ArrayList<Character>();
			for(int j=0;j<values.length;j++)
				list.add(values[j]);
			
			for(int j=0;j<list.size();j++)
			{
				int element=Integer.parseInt(list.get(j).toString());
				if(element>depth)
				{
					while(element>depth)
					{
						list.add(j,'(');
						depth++;
						j++;
					}
				}
				else if(element<depth)
				{
					while(element<depth)
					{
						list.add(j,')');
						depth--;
						j++;
					}
				}
			}
			while(depth>0)
			{
				list.add(')');
				depth--;
			}
			
			System.out.print("Case #"+i+": ");
			for(char ch : list)
				System.out.print(ch);
			
			System.out.println("");
		}
	}
}