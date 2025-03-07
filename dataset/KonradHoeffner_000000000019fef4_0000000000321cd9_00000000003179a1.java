

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution
{
	static class Response
	{
		public final int Q;
		public final String R;

		public Response(int q, String r)
		{	
			Q = q;
			R = r;
		}

		@Override
		public String toString()
		{			
			return Q+" "+R;
		}
	}

	static String solve(Collection<Response> responses)
	{
		Map<Character,Set<Integer>> candidates = new HashMap<>();
		Set<Character> chars = new HashSet<Character>();
		for(Response resp : responses)
		{
			for(Character c: resp.R.toCharArray())
			{
				chars.add(c);
			}
		}
		for(Character c: chars)
		{
			candidates.put(c, new HashSet<>(IntStream.range(0, 10).boxed().collect(Collectors.toSet())));
		}
		// ************************************		
		for(Response resp : responses)
		{
			String qs = String.valueOf(resp.Q);
			char firstChar = resp.R.charAt(0);
			candidates.get(firstChar).remove(0); // no leading zeroes
			//System.err.println("qs "+qs);
			if(qs.length()>resp.R.length()) {continue;} // could be anything
			int firstDigitQ = Integer.valueOf(String.valueOf(qs.charAt(0)));
			
			for(int k=firstDigitQ+1;k<10;k++)
			{
				candidates.get(firstChar).remove(k);
			}
			
			//System.err.println(firstDigitQ);
//			for(int i=0;i<resp.R.length();i++)
//			{
//				//int digit = Integer.valueOf(qs.charAt(i));
//				
//			}
		}
		boolean changed;
		do
		{
			changed = false;
		// if something has only one element, remove it from the others
			Set<Character> onlyOne = candidates.entrySet().stream().filter(e->e.getValue().size()==1).map(e->e.getKey()).collect(Collectors.toSet());
			for(char single: onlyOne)
			{
				int digit = candidates.get(single).iterator().next();
				Set<Character> others = new HashSet<>(chars);
				others.remove(single);
				for(char c: others)
				{
					if(candidates.get(c).contains(digit))
					{
						changed = true;
						candidates.get(c).remove(digit);
					}
				}
			}
		}
		while(changed);
		
		Stream<Character> st = candidates.keySet().stream().sorted((c1,c2) -> candidates.get(c1).iterator().next()-candidates.get(c2).iterator().next());
		String output = st.map(String::valueOf).collect(Collectors.joining()); 
		//System.err.println(output);
				
		//return candidates.toString();
		
		//return chars.toString();
		return output;
	}

	public static void main(String[] args) throws IOException
	{	
		try(Scanner in = new Scanner(System.in))
		{
			PrintStream out = System.out; 
			{
				int T = in.nextInt();
				List<Response> responses = new ArrayList<>(); 
				for(int t=1;t<=T;t++)
				{					
					int U = in.nextInt();									
					for(int i=0;i<10_000;i++)
					{
						int Q = in.nextInt();
						String R = in.nextLine().trim();
						Response r = new Response(Q,R);
						responses.add(r);
						System.out.println(r);
					}
					out.println("Case #"+t+": "+solve(responses));
				}
			}
		}
	}
}