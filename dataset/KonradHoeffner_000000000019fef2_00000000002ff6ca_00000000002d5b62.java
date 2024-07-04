import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution
{
	static final int MAX = 100;

	static Integer[] values = {-1,0,1};

	static List<List<Integer>>combinations(int bits)
	{
		List<List<Integer>> xx = new ArrayList<>();
		if(bits==1)
		{
			return Arrays.stream(values).map(v->Collections.singletonList(v)).collect(Collectors.toList());
		}
		for(int i=0;i<values.length;i++)
		{			
			List<List<Integer>> yy = combinations(bits -1);
			for(List<Integer> y: yy)
			{
				List<Integer> x = new ArrayList<>(y);
				x.add(values[i]);
				xx.add(x);
			}			
		}
		return xx;
	}

	static String merge(List<Integer> aa, List<Integer> bb)
	{
		aa = new ArrayList<>(aa);
		bb = new ArrayList<>(bb);
		// remove trailing zeroes on both
		while((aa.get(aa.size()-1)==0)&&(bb.get(bb.size()-1)==0))
		{
			aa.remove(aa.size()-1);
			bb.remove(bb.size()-1);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<aa.size();i++)
		{
			int a = aa.get(i);
			int b = bb.get(i);
			if(!((a==0)^(b==0))) {return null;}
			if(a==1) {sb.append("E");continue;}
			if(a==-1) {sb.append("W");continue;}
			if(b==1) {sb.append("N");continue;}
			sb.append("S");
		}
		return sb.toString();
	}

	static String solve(int X, int Y)
	{
		List<List<Integer>> xCombs = combinations.stream().filter(comb -> amounts.get(comb)==X).collect(Collectors.toList());
		List<List<Integer>> yCombs = combinations.stream().filter(comb -> amounts.get(comb)==Y).collect(Collectors.toList());

		Set<String> solutions = new HashSet<>();
		for(List<Integer> xComb: xCombs)
		{
			for(List<Integer> yComb: yCombs)
			{
				String solution = merge(xComb,yComb);
				if(solution!=null) {solutions.add(solution);}
			}
		}
		if(solutions.isEmpty()) {return "IMPOSSIBLE";}
		String shortest = solutions.stream()
        .sorted((e2, e1) -> e1.length() > e2.length() ? -1 : 1)
        .findFirst().get();
		return shortest;
		//System.out.println(xCombs);
		//System.out.println(yCombs);
		//return X+" "+Y;		
	}

	static int bits = (int)Math.ceil(Math.log(MAX)/Math.log(2))+1;
	static List<List<Integer>> combinations = combinations(bits);
	static Map<List<Integer>,Integer> amounts = new HashMap<>();

	public static void main(String[] args) throws IOException
	{		

		for(List<Integer> combination: combinations)
		{
			//System.out.println(combination);
			int amount = 0;
			for(int i=0;i<combination.size();i++)
			{
				//System.out.println((1 << i) * combination.get(i));
				amount+= (1 << i) * combination.get(i);
			}
			amounts.put(combination, amount);
		}

		//System.out.println(amounts);

		try(Scanner in = new Scanner(System.in))
		{
			PrintStream out = System.out; 
			{
				int T = in.nextInt();
				for(int t=1;t<=T;t++)
				{					
					int X = in.nextInt(); // number of people									
					int Y = in.nextInt(); // maximum index both x and y
					out.println("Case #"+t+": "+solve(X,Y));
				}
			}
		}
	}
}