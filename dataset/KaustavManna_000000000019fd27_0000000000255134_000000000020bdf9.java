import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 1; i <= n; i++)
        {
            List<Task> c_list = new ArrayList<Task>();
            List<Task> j_list = new ArrayList<Task>();
            String result = "";
            boolean possible = false;

            int taskcount = in.nextInt();

            for(int j = 0; j < taskcount; j++)
            {
                Task task = new Task(in.nextInt(), in.nextInt());
                if(c_list.isEmpty() || isAvailable(c_list, task))
                {
                    c_list.add(task);
                    possible = true;
                    result = result + "C";
                }
                else if(j_list.isEmpty() || isAvailable(j_list, task))
                {
                    j_list.add(task);
                    possible = true;
                    result = result + "J";
                }
                else
                {
                    possible = false;
                    break;
                }
            }
            if(possible)
                System.out.println("Case #" + i + ": " + result);
            else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }

    private static boolean isAvailable(List<Task> list, Task check_task)
    {
        for(int i = 0; i < list.size(); i++)
        {
            Task list_task = list.get(i);
            if(check_task.end_time <= list_task.start_time || check_task.start_time >= list_task.end_time)
                continue;
            else
                return false;
        }
        return true;
    }

    static class Task
    {
        int start_time;
        int end_time;

        public Task(int start_time, int end_time)
        {
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }
}
