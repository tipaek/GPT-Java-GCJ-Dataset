import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner file = new Scanner(System.in);
        int testCases = file.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int n = file.nextInt();
            int[][] acts = new int[n][2];
            for (int j = 0; j < n; j++)
            {
                acts[j] = new int[]{file.nextInt(), file.nextInt()};
            }
            System.out.printf("Case #%d: %s\n", i + 1, color(acts));
        }
    }
    
    static String color(int[][] acts)
    {
        char[] coloring = new char[acts.length];
        for (int i = 0; i < acts.length; i++)
        {
            if (coloring[i] == 0)
            {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(i);
                coloring[i] = 'C';
                while (!deque.isEmpty())
                {
                    int curr = deque.poll();
                    for (int j = 0; j < acts.length; j++)
                    {
                        if (overlaps(acts[curr], acts[j]))
                        {
                            if (coloring[curr] == coloring[j])
                            {
                                return "IMPOSSIBLE";
                            }
                            else if (coloring[j] == 0)
                            {
                                coloring[j] = coloring[curr] == 'C' ? 'J' : 'C';
                                deque.add(j);
                            }
                        }
                    }
                }
            }
        }
        return new String(coloring);
    }

    static boolean overlaps(int[] a, int[] b)
    {
        return a[0] > b[0] && a[0] < b[1] || a[1] > b[0] && a[1] < b[1] || a[0] < b[0] && a[1] > b[1];
    }
}
