import java.util.*;
public class Solution {
    public static class Pair implements Comparable<Pair>{
		int index,main, other;
		boolean start;
		Pair(int i,boolean s,int m,int o) {
			index = i;
			start = s;
			main = m;
			other = o;
		}
		public int compareTo(Pair o) {
			return Integer.compare(main, o.main);
		}
	}
	
	
	public static StringBuilder answer(int times[][])
	{
//		int t[] = new int[(24*60)+1];
//		char c[] = new char[t.length];
		StringBuilder ans = new StringBuilder();
		char answer[] = new char[times.length];
		StringBuilder impossible = new StringBuilder("IMPOSSIBLE");
		Pair s[] = new Pair[times.length];
		Pair e[] = new Pair[times.length];
		for(int i=0;i<times.length;i++)
		{
			s[i] = new Pair(i, true, times[i][0], times[i][1]);
			e[i] = new Pair(i, false, times[i][1], times[i][0]);
		}
		Arrays.sort(s);
		Arrays.sort(e);
		Pair t[] = new Pair[2*s.length];
		int jFreeTime = 0, cFreeTime = 0;
		int i = 0, j = 0, k = 0;
		while(i < s.length && j < s.length) {
			if(s[i].main < e[j].main) {
				
				if(jFreeTime <= s[i].main) {
					jFreeTime = s[i].other;
					answer[s[i].index] = 'C';
					i++;
				}
				else if(cFreeTime <= s[i].main) {
					cFreeTime = s[i].other;
					answer[s[i].index] = 'J';
					i++;
				}
				else return impossible;
			}
			else j++;
		}
		for(char c : answer) 
			ans.append(c);
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int q=1;q<=t;q++)
		{
			int n = scn.nextInt();
			int times[][] = new int[n][2];
			for(int i=0;i<n;i++) {
				times[i][0] = scn.nextInt();
				times[i][1] = scn.nextInt();
			}
			System.out.println("Case #" + q + ": " + answer(times));
		}

	}
}