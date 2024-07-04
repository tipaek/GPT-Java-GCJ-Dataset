import java.util.*;
class Solution
{
	static class Activity
    {

		int userIndex;
        int startTime;
		int finishTime;

        Activity(int userIndex, int startTime, int finishTime)
        {
			this.userIndex = userIndex;
            this.startTime = startTime;
            this.finishTime = finishTime;
		}

	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int pos = t;
		while(t-- > 0)
		{
			int n = sc.nextInt();
			String s = "";
			int cBusyAt = 0;
			int jBusyAt = 0;

			List<Activity> as = new ArrayList<>();

			for(int i=0;i<n;i++)
				as.add(new Activity(i, sc.nextInt(), sc.nextInt()));

			class SortByFinishTime implements Comparator<Activity>
        	{
            	@Override
            	public int compare(Activity o1, Activity o2)
            	{
                return o1.finishTime - o2.finishTime;
            	}
        	};

			Collections.sort(as, new SortByFinishTime());

			Map<Integer, Character> map = new HashMap<>();

			map.put(as.get(0).userIndex, 'J');
			map.put(as.get(1).userIndex, 'C');

			jBusyAt = 0;
			cBusyAt = 1;

			for(int i=2;i<n;i++)
			{
				if(as.get(i).startTime >= as.get(jBusyAt).finishTime)
				{
					map.put(as.get(i).userIndex, 'J');
					jBusyAt = i;

				}
				else if(as.get(i).startTime >= as.get(cBusyAt).finishTime)
				{
					map.put(as.get(i).userIndex, 'C');
					cBusyAt = i;
				}
			}

			for(Character c:map.values())
				s += c;

			s = (s.length() == n) ? s : "IMPOSSIBLE";

			System.out.println("Case #"+(pos-t)+": "+s);
		}
	}
}
