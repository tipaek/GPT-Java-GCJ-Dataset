import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws Exception{

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer numberOfTestCases = Integer.parseInt(br.readLine().trim());
		
		for(int i =1; i <= numberOfTestCases;i++)
		{
			Integer numberOfEntries = Integer.parseInt(br.readLine().trim());
			Parenting[] parent = new Parenting[numberOfEntries];
			int[][] input = new int[numberOfEntries][2];
			
			for(int j =0 ; j < numberOfEntries;j++)
			{
				String[] entry = br.readLine().split(" ");
				
				Parenting p = new Parenting();
				for(int k =0; k < 2;k++)
				{
					input[j][k] = Integer.parseInt(entry[k]);
					
				}
				p.a = input[j][0];
				p.b = input[j][1];
				
				parent[j] = p;
			}
			
			Arrays.sort(parent);
			
			Boolean[] isRowValid = new Boolean[numberOfEntries];
			
			int firstEnd = 0;
			int secondEnd = 0;
			
			String output = "";
			for(int j =0; j < numberOfEntries;j++)
			{
				if(parent[j].a >= firstEnd)
				{
					output += "C";
					firstEnd = parent[j].b;
					
				}else {
					if(parent[j].a >= secondEnd)
					{
						output += "J";
						secondEnd =parent[j].b;
					}else {
						output = "IMPOSSIBLE";
						break;
					}
				}
			}
			
			if(!output.equals("IMPOSSIBLE"))
			{
				String actualOutput= "";
				HashSet<Integer> indexesCovered = new HashSet<Integer>();
				for(int j =0; j < numberOfEntries;j++)
				{
					for(int k =0; j < numberOfEntries;k++)
					{
						if(!indexesCovered.contains(k) && input[j][0] == parent[k].a && input[j][1] == parent[k].b)
						{
							actualOutput += output.charAt(k);
							indexesCovered.add(k);
							break;
						}
					}
				}
				System.out.println("Case #" + i + ": " + actualOutput);
			}else {
				System.out.println("Case #" + i + ": " + output);
			}
		}
	}
	
	static class Parenting implements Comparable{
		
		int a,  b;
		
		public int compareTo(Object O)
		{
			Parenting p = (Parenting)O;
			if(a < p.a) return -1;
			if(a> p.a) return 1;
			if(b < p.b) return -1;
			if(b > p.b) return 1;
			
			return 0;
		}
		
	}

}
