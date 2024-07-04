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
                if(isAvailable(c_list, task))
                {
                    c_list.add(task);
                    possible = true;
                    result = result + "C";
                }
                else if(isAvailable(j_list, task))
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
        boolean check = true;
        for(int i = 0; i < list.size(); i++)
        {
            Task list_task = list.get(i);
            if(check_task.getEnd_time() <= list_task.getStart_time() || check_task.getStart_time() >= list_task.getEnd_time())
                check = true;
            else
                check = false;
        }
        return check;
    }
}

class Task
{
    private int start_time;
    private int end_time;

    public Task(int start_time, int end_time)
    {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getStart_time()
    {
        return this.start_time;
    }

    public int getEnd_time()
    {
        return this.end_time;
    }
}
