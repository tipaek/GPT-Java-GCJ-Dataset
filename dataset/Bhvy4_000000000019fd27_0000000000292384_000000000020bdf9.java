import java.util.*;

class Pair
{
	private int start, finish;

	public Pair(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}

	public int getFinish() {
		return finish;
	}

	public int getStart() {
		return start;
	}

};

public class Solution
{
	// Activity-Selection problem
	public static String selectActivity(List<Pair> activities)
	{
		int k = 0;
		int l =1;
		String ans = "JC";
		for (int i = 2,j = 3; i < activities.size()&& j < activities.size(); )
		{

			if (activities.get(i).getStart() >= activities.get(k).getFinish())
			{
				ans+="J";
				k = i;	
				i=j+1;
			}
			if (activities.get(j).getStart() >= activities.get(l).getFinish())
			{
				ans+="C";
				l = j;	
				j=i+1;
			}
		}
		if(ans.length()<activities.size()) return "IMPOSSIBLE";
		return ans;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int s = 1;
		while(s<=t)
		{
			int n = sc.nextInt();
			List<Pair> activities = new ArrayList<Pair> ();
			for(int i=0; i<n; i++)
			{
				activities.add(new Pair(sc.nextInt(),sc.nextInt()));
			}

		Collections.sort(activities, (a, b) -> a.getFinish() - b.getFinish());
		String ans = selectActivity(activities);
		System.out.println("Case #"+s+": "+ans);
		
			s++;
		}
	}
}