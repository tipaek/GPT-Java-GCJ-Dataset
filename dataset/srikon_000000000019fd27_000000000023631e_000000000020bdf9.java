import java.util.*;
import java.io.*;

class Schedule{
    int Index;
    int StartTime;
    int EndTime;
    char AssignedTo;

    public static Comparator<Schedule> StartTimeComparator = new Comparator<Schedule>() 
    {
        public int compare(Schedule sch1, Schedule sch2)
        {
            return sch1.StartTime - sch2.StartTime;
        }
    };

    public static Comparator<Schedule> IndexComparator = new Comparator<Schedule>() 
    {
        public int compare(Schedule sch1, Schedule sch2)
        {
            return sch1.Index - sch2.Index;
        }
    };
}

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = reader.nextInt();
        for (int testNum = 1; testNum <= testCount; testNum++)
        {
            int scheduleCount = reader.nextInt();
            Schedule schedules[] = new Schedule[scheduleCount];
            for (int index = 0; index < scheduleCount; index++) 
            {
                schedules[index] = new Schedule();
                schedules[index].Index = index;
                schedules[index].StartTime = reader.nextInt();
                schedules[index].EndTime = reader.nextInt();
            }

            Arrays.sort(schedules, Schedule.StartTimeComparator);

            int earliestCameronEndTime = 0;
            int earliestJamieEndTime = 0;
            boolean impossible = false;
            for (int index = 0; index < scheduleCount; index++) 
            {
                if (earliestCameronEndTime <= schedules[index].StartTime)
                {
                    schedules[index].AssignedTo = 'C';
                    earliestCameronEndTime = earliestCameronEndTime < schedules[index].EndTime ? schedules[index].EndTime : earliestCameronEndTime;
                }
                else if (earliestJamieEndTime <= schedules[index].StartTime)
                {
                    schedules[index].AssignedTo = 'J';
                    earliestJamieEndTime = earliestJamieEndTime < schedules[index].EndTime ? schedules[index].EndTime : earliestJamieEndTime;
                }
                else
                {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible)
            {
                result.append("Impossible");
            }
            else
            {
                Arrays.sort(schedules, Schedule.IndexComparator);
                for (int index = 0; index < scheduleCount; index++) 
                {
                    result.append(schedules[index].AssignedTo);
                }
            }

            System.out.println(String.format("Case #%d: %s", testNum, result.toString()));
        }

    }
}
