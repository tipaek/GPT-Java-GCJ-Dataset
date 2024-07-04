import java.util.*;
import java.io.*;

public class Solution {	
	public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCount = sc.nextInt();
        for (int testcase = 1; testcase <= testCount; testcase++) {
        	StringBuilder resultBuilder = new StringBuilder();
            Partner cameron = new Partner();
            Partner jamie = new Partner();
            int activityCount = sc.nextInt();

            for (int i = 0; i < activityCount; i++)
            {
                Occupied time = new Occupied(sc.nextInt(), sc.nextInt());

                if (!cameron.IsOccupiedDuring(time))
                {
                    cameron.Occupied.add(time);
                    resultBuilder.append('C');
                }
                else if (!jamie.IsOccupiedDuring(time))
                {
                    jamie.Occupied.add(time);
                    resultBuilder.append('J');
                }
                else
                {
                    resultBuilder = new StringBuilder();
                    resultBuilder.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + testcase + ": " + resultBuilder.toString());
        }
        
        sc.close();

	}

	static class Partner
    {
        public List<Occupied> Occupied;

        public Partner()
        {
            Occupied = new ArrayList<Occupied>();
        }

        public boolean IsOccupiedDuring(Occupied targetTime)
        {
        	for(Occupied occupied: Occupied)
        	{
                if (occupied.From < targetTime.From && occupied.To > targetTime.From || occupied.From < targetTime.To && occupied.To > targetTime.To)
                    return true;
            }

            return false;
        }
    }

    static class Occupied
    {
        public int From;
        public int To;
        
        public Occupied(int from, int to)
        {
        	From = from;
        	To = to;
        }
    }
}