import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int testCases = Integer.parseInt(s);
        int caseNr = 1;
        while(testCases > 0)
        {
            s = br.readLine();
            int N = Integer.parseInt(s);
            schedule(N, br, caseNr);

            caseNr++;
            testCases--;
        }
    }

    private static void schedule(int N , BufferedReader br, int caseNr ) throws IOException {

        List<Task> tasks = new ArrayList<Task>();
        Stack<Task> C = new Stack<Task>();
        Stack<Task> J = new Stack<Task>();

        for (int i = 0; i < N; i++)
        {
            String s = br.readLine();

            String[] times = s.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            tasks.add(new Task(start, end));
        }

        //now assign tasks
        Collections.sort(tasks);
        boolean skip = false;
        StringBuilder sb = new StringBuilder();

        for (Task task : tasks)
        {
            if(skip)
                break;

            if(addToCalendar(C, task))
            {
                sb.append("C");
            }
            else if( addToCalendar(J, task))
            {
                sb.append("J");
            }
            else
            {
                sb = new StringBuilder();
                sb.append("IMPOSSIBLE");
                skip = true;
            }
        }

        System.out.println("Case #" + caseNr+ ": " + sb.toString());
    }

    private static boolean addToCalendar(Stack<Task> personCalendar, Task task)
    {
        if(personCalendar.empty())
        {
            personCalendar.push(task);
            return true;
        }
        if( personCalendar.peek().endTime > task.startTime )
        {
            return false;
        }
        else
        {
            personCalendar.push(task);
            return true;
        }
    }
}



class Task implements Comparable<Task>
{
    Integer startTime;
    Integer endTime;

    Task(int startTime, int endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Task o) {
        if( startTime == o.startTime)
            return this.endTime.compareTo(o.endTime);

        return this.startTime.compareTo(o.startTime);
    }
}