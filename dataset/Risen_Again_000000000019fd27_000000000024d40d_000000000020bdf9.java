import java.util.*;

class Solution
{
    private static class Activity
    {
        int start;
        int end;
        char color = 'U';
    }

    private static boolean graph[][];
    private static Activity[] activities;
    private static int n;

    private static boolean intersect(Activity a, Activity b)
    {
        if(a.end <= b.start || b.end <= a.start)
        {
            return false;
        }
        return true;
    }

    private static boolean BFS(int src)
    {
        activities[src].color = 'J';
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);

        while(!q.isEmpty())
        {
            int x = q.poll();
            for(int i = 0;i < n;i++)
            {
                if(graph[x][i] && activities[i].color == 'U')
                {
                    activities[i].color = activities[x].color == 'J' ? 'C' : 'J';
                    q.add(i);
                }
                else if(graph[x][i] && activities[i].color == activities[x].color)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++)
        {
            n = sc.nextInt();
            activities = new Activity[n];
            for(int i = 0;i < n;i++)
            {
                activities[i] = new Activity();
                activities[i].start = sc.nextInt();
                activities[i].end = sc.nextInt();
            }

            graph = new boolean[n][n];
            for(int i = 0;i < n;i++)
            {
                for(int j = 0;j < n;j++)
                {
                    if((i != j) && intersect(activities[i], activities[j]))
                    {
                        graph[i][j] = true;
                        graph[j][i] = true;
                    }
                }
            }

            boolean possible = true;
            for(int i = 0;(i < n) && possible;i++)
            {
                if(activities[i].color == 'U')
                {
                    possible &= BFS(i);
                }
            }
            System.out.print("Case #" + t + ": ");
            if(possible)
            {
                for(int i = 0;i < n;i++)
                {
                    System.out.print(activities[i].color);
                }
                System.out.println();
            }
            else
            {
                System.out.println("IMPOSSIBLE");
            }

        }

    }
}