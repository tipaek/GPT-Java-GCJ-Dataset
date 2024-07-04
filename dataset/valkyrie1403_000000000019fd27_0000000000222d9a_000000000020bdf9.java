import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    private static class Schedule implements Comparable<Schedule>
    {
        int start;
        int end;
        char parent;

        public Schedule(int start, int end)
        {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule schedule)
        {
            return start - schedule.start;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 0; i < t; i++)
        {
            int n = in.nextInt();
            Schedule [] schedules = new Schedule[n];
            for (int j = 0; j < n; j++)
                schedules[j] = new Schedule(in.nextInt(), in.nextInt());

            compute(i+1, schedules);
        }
    }

    private static void compute(int caseNum, Schedule[] schedules)
    {
        Schedule [] sorted = Arrays.copyOf(schedules, schedules.length);
        Arrays.sort(sorted);
        System.out.print("Case #" + caseNum + ": ");

        int jFree = 0;
        int cFree = 0;

        for (Schedule s : sorted)
        {
            if (cFree <= s.start)
            {
                cFree = s.end;
                s.parent = 'C';
            }
            else if (jFree <= s.start)
            {
                jFree = s.end;
                s.parent = 'J';
            }
            else
            {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        for (Schedule s : schedules)
            System.out.print(s.parent);

        System.out.println();
    }
}
