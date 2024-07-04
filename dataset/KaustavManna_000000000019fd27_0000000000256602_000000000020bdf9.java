import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++)
        {
            List<Integer> c_list = new ArrayList<Integer>();
            List<Integer> j_list = new ArrayList<Integer>();
            String result = "";
            boolean possible = false;

            int taskcount = in.nextInt();

            for (int j = 0; j < taskcount; j++)
            {
                int start_time = in.nextInt();
                int end_time = in.nextInt();
                if (c_list.isEmpty() || isAvailable(c_list, start_time, end_time))
                {
                    c_list.add(start_time);
                    c_list.add(end_time);
                    possible = true;
                    result = result + "C";
                }
                else if (j_list.isEmpty() || isAvailable(j_list, start_time, end_time))
                {
                    j_list.add(start_time);
                    j_list.add(end_time);
                    possible = true;
                    result = result + "J";
                }
                else
                {
                    possible = false;
                    break;
                }
            }
            if (possible)
                System.out.println("Case #" + i + ": " + result);
            else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }

    private static boolean isAvailable(List<Integer> list, int start_time, int end_time)
    {
        for (int i = 0; i < list.size(); i++)
        {
            Integer task_start_time = list.get(i++);
            Integer task_end_time = list.get(i);
            if (end_time <= task_start_time || start_time >= task_end_time)
                continue;
            else
                return false;
        }
        return true;
    }
}