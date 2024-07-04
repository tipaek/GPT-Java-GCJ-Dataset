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
		System.out.println("Done 123");
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

		boolean ok = assignSimple(tasks, 0);
		
		System.out.print("Case #" + (test) + ": ");
        if (ok)
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

	boolean assignSimple(Task[] tasks, int fromIdx) 
	{
		if (fromIdx >= tasks.length) 
		{
			return false;
		}
		
		boolean result = false;
		
		for (int row = fromIdx; row < tasks.length; row++)
        {
			if (possible(tasks, row, 'C'))
	        {
	            tasks[row].person = 'C';
	            result = true;
	        }
	        else if (possible(tasks, row, 'J'))
	        {
	            tasks[row].person = 'J';
	            result = true;
	        }
	        else
	        {
	        	return false;
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
