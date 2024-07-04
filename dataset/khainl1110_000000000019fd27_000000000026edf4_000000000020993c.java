

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

private class CodeJam {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int current = 1;
		while(cases>0)
		{
			int N  = sc.nextInt();
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); //arr contains matrix info
			for(int i=0;i<N;i++)
			{
				ArrayList<Integer> rows = new ArrayList<>();
				for(int x=0;x<N;x++)
				{
					rows.add(sc.nextInt());
				}
				arr.add(rows);
			}
			
			//compute trace and dupR
			int trace = 0;
			int dupR = 0;
			int dupC = 0;
			for(int i =0; i<N;i++)
			{
				trace+=arr.get(i).get(i);
				HashMap<Integer,Integer> checkDupR = new HashMap<Integer,Integer>();
				HashMap<Integer,Integer> checkDupC = new HashMap<Integer,Integer>();
				for(int x =0;x<N;x++)
				{
					int temp = arr.get(i).get(x);
					if(checkDupR.containsKey(temp)) checkDupR.put(temp, checkDupR.get(temp)+1);
					else checkDupR.put(temp, 1);
					if(checkDupR.get(temp)>1) 
					{
						dupR++; break;
					}
				}
				
				//for dupColumn
				for(int x=0;x<N;x++)
				{
					int temp = arr.get(x).get(i);
					if(checkDupC.containsKey(temp)) checkDupC.put(temp, checkDupC.get(temp)+1);
					else checkDupC.put(temp, 1);
					if(checkDupC.get(temp)>1) 
					{
						dupC++; break;
					}
				}
				
			}
			//compute dupC
		
			System.out.print("Case #" +current+": " + trace + " " + dupR + " " + dupC);
			System.out.println();
			current++;
			cases--;
		}
				
	}
}
