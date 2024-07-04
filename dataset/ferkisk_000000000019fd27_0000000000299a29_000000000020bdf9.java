import java.util.Scanner;

public class Solution {
	
	public Solution() 
	{

	}

	public static void main(String[] args) 
	{
		new Solution().run();
	}

	Scanner in = null;

	public void run() 
	{
		in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			solve(i);
		}
		//System.out.println("Done 123");
	}

	private void solve(int test) 
	{
		int N = in.nextInt();

		Task[] tasks = new Task[N];

		for (int row = 0; row < N; row++) {
			Task t = new Task();
			t.start = in.nextInt();
			t.end = in.nextInt();
			tasks[row] = t;
		}

		tasks = assignSimple(tasks, 0);
		
		System.out.print("Case #" + (test) + ": ");
        if (tasks != null)
        {
            for (int row = 0; row < N; row++)
            {
            	System.out.print(tasks[row].person);
            }
        }
        else
        {
        	System.out.print("IMPOSSIBLE");
        }
        System.out.println();
	}

	Task[]  assignSimple(Task[] tasks, int fromIdx) 
	{
		if (fromIdx >= tasks.length) 
		{
			return null;
		}
		
		Task[] result = null;
		
		for (int row = fromIdx; row < tasks.length; row++)
        {
			if (possible(tasks, row, 'C'))
	        {
	            tasks[row].person = 'C';
	            result = tasks;
	        }
	        else if (possible(tasks, row, 'J'))
	        {
	            tasks[row].person = 'J';
	            result = tasks;
	        }
	        else
	        {
	        	
	        	result = null;
                if (tasks[row - 1].person == 'C' && possible(tasks, row - 1, 'J'))
                {
                    tasks[row - 1].person = 'J';
                    result = assignSimple(tasks, row);
                }
                if (result == null)
                {
                    if (tasks[row - 1].person == 'J' && possible(tasks, row - 1, 'C'))
                    {
                        tasks[row - 1].person = 'C';
                        result = assignSimple(tasks, row);
                    }
                }
                return result;
	        }
        }
		return result;
	}
	
	boolean possible(Task[] tasks, int task, char who)
    {
        Task t1 = tasks[task];

        for (int row = 0; row < tasks.length; row++)
        {
            if (row == task)
            {
                continue;
            }

            Task t2 = tasks[row];

            if (t2.person == who)
            {
                if (t1.start >= t2.start && t1.start < t2.end)
                {
                    return false;
                }
                if (t1.end > t2.start && t1.end < t2.end)
                {
                    return false;
                }
                if (t1.start <= t2.start && t1.end > t2.start)
                {
                    return false;
                }
            }

        }
        return true;
    }

	class Task {
		public int start;
		public int end;
		public char person;
	}

}
