import java.util.*;
class Solution
{
	static class Activity
    {

        int startTime;
        int finishTime;

        Activity(int startTime, int finishTime)
        {
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

			ArrayList<Activity> as = new ArrayList<>();

			for(int i=0;i<n;i++)
				as.add(new Activity(sc.nextInt(), sc.nextInt()));

			class SortByFinishTime implements Comparator<Activity>
        	{
            	@Override
            	public int compare(Activity o1, Activity o2)
            	{
                return o1.finishTime - o2.finishTime;
            	}
        	};

			Collections.sort(as, new SortByFinishTime());

			s += "CJ";
			cBusyAt = 0;
			jBusyAt = 1;

			for(int i=2;i<n;i++)
			{
				if(as.get(i).startTime >= as.get(cBusyAt).finishTime)
				{
					s += "C";
					cBusyAt = i;

				}
				else if(as.get(i).startTime >= as.get(jBusyAt).finishTime)
				{
					s += "J";
					jBusyAt = i;
				}

			}

			s = (s.length() == n) ? s : "IMPOSSIBLE";

			System.out.println("Case #"+(pos-t)+": "+s);
		}
	}
}
