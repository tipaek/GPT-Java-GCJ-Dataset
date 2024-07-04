import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x=1;
        while(t-->0)
        {
            int n = sc.nextInt();
            List<Task> tasks = new ArrayList<>();
            for(int i=0;i<n;++i)
            {
                int s = sc.nextInt();
                int e = sc.nextInt();
                tasks.add(new Task(s,e,i));
            }
            Collections.sort(tasks);
            System.out.println(String.format("Case #%d: %s", x,solve(tasks)));
            x++;
        }
    }
    static String solve(List<Task> tasks)
    {
        Task c = new Task(0,0,0);
        Task j = new Task(0,0,0);
        char[] ans = new char[tasks.size()];
        for(Task task : tasks)
        {
            if(c.end <= task.start)
            {
                ans[task.index] = 'C';
                c = task;
            }
            else if(j.end <= task.start)
            {
                ans[task.index] = 'J';
                j = task;
            }
            else
            {
                return "IMPOSSIBLE";
            }
        }
        return new String(ans);
    }

    static class Task implements Comparable<Task>
    {
        int start;
        int end;
        int index;

        public Task(int s, int e, int i)
        {
            this.start = s;
            this.end = e;
            this.index = i;
        }

        @Override
        public int compareTo(Task other)
        {
            if (this.start == other.start)
            {
                return this.end - other.end;
            }
            return this.start - other.start;
        }

        public String toString()
        {
            return String.format("Start: [%d] End: [%d] Index: [%d]", start,end,index);
        }
    }
}