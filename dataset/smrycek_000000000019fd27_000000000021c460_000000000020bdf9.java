import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
        int t = s.nextInt();

        for (int test = 0; test < t; test++)
        {
            int n = s.nextInt();
            boolean[] sched1 = new boolean[1441];
            boolean[] sched2 = new boolean[1441];
            String output = "";
            boolean impossible = false;

            for (int task = 0; task < n; task++)
            {
                int startTime = s.nextInt();
                int endTime = s.nextInt();

                if (impossible)
                    continue;

                boolean goodTaskA = true;
                boolean goodTaskB = true;
                for (int time = startTime; time < endTime; time++)
                {
                    if (sched1[time] == true)
                    {
                        goodTaskA = false;
                    }
                    if (sched2[time] == true)
                    {
                        goodTaskB = false;
                    }
                }

                if (!goodTaskA && !goodTaskB)
                {
                    impossible = true;
                    continue;
                }
                if (goodTaskA)
                {
                    for (int time = startTime; time < endTime; time++)
                    {
                        sched1[time] = true;
                    }
                    output += "C";
                } else if (goodTaskB)
                {
                    for (int time = startTime; time < endTime; time++)
                    {
                        sched2[time] = true;
                    }
                    output += "J";
                }
            }

            if (impossible)
            {
                output = "IMPOSSIBLE";
            }
            System.out.println("Case #" + (test + 1) + ": " + output);
        }
    
	}
}
