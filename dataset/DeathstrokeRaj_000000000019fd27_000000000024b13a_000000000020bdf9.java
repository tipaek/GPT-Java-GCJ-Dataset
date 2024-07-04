import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {
        Comparator<Time> comparator = new Comparator<Time>()
        {
            @Override public int compare(Time t1, Time t2)
            {
                return t1.startTime - t2.startTime;
            }
        };

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        char[] output;
        List<Time> time;
        for (int z = 1; z <= t; z++)
        {
            int n, j = 0, c = 0;
            n = scan.nextInt();
            output = new char[n];
            time = new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                time.add(new Time(scan.nextInt(), scan.nextInt(), i));

            }
            time.sort(comparator);
            for (int i = 0; i < n; i++)
            {
                if (time.get(i).startTime >= c)
                {
                    c = time.get(i).endTime;
                    output[time.get(i).index] = 'C';
                }
                else if (time.get(i).startTime >= j)
                {
                    j = time.get(i).endTime;
                    output[time.get(i).index] = 'J';
                }
                else
                {
                    c = -1;
                    break;
                }
            }
            if (c == -1)
            {
                System.out.println("Case #" + z + ": IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #" + z + ": " + new String(output));
            }
        }

    }
}
class Time
{
    public Time(int startTime, int endTime, int index)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
    int startTime;
    int endTime;
    int index;
}

