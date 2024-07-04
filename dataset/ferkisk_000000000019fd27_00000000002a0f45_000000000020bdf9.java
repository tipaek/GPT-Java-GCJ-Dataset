import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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

		ArrayList<Task> tasks = new ArrayList<Solution.Task>();

		for (int row = 0; row < N; row++) {
			Task t = new Task();
			t.start = in.nextInt();
			t.end = in.nextInt();
			t.person = 'C';
			t.idx = row;
			tasks.add(t);
		}

		List<List<Task>> allTasks = new ArrayList<List<Task>>();
		addOption(allTasks, tasks, 0);
		//System.out.println(allTasks.size());
		
		List<Task> validResult = null;
		for (List<Task> checkTask : allTasks)
		{
			boolean valid = true;
			//System.out.println("----------------");
			for (Task ct : checkTask)
			{
				if (!possible(checkTask, ct, ct.person))
				{
					valid = false;
					break;
				}
			}
			if (valid)
			{
				validResult = checkTask;
				break;
			}
			else
			{
				//System.out.println("Not valid");
				//for (Task t : checkTask) {System.out.print(t.person);} System.out.println();
				validResult = null;
			}
		}
		
		System.out.print("Case #" + (test) + ": ");
        if (validResult != null)
        {
            for (int row = 0; row < N; row++)
            {
               System.out.print(validResult.get(row).person);
            }
        }
        else
        {
        	System.out.print("IMPOSSIBLE");
        }
        
        System.out.println();
	}

	Set<String> added = new HashSet<String>(); 
	void addOption(List<List<Task>> allTasks, List<Task> current, int idx)
	{
		List<Task> tasks1 = new ArrayList<Solution.Task>();
		List<Task> tasks2 = new ArrayList<Solution.Task>();
		for (int i = 0; i < current.size(); i++)
		{
			if (i == idx)
			{
				Task t1 = current.get(i).clone();
				t1.person = 'C';
				tasks1.add(t1);
				
				Task t2 = current.get(i).clone();
				t2.person = 'J';
				tasks2.add(t2);
			}
			else
			{
				tasks1.add(current.get(i).clone());
				tasks2.add(current.get(i).clone());
			}
			
		}
		String s = getThem(tasks1);
		if (!added.contains(s))
		{
			allTasks.add(tasks1);
		}
		else
		{
			added.add(s);
		}
		//for (Task t : tasks1) {System.out.print(t.person);} System.out.println();
		s = getThem(tasks2);
		if (!added.contains(s))
		{
			allTasks.add(tasks2);
		}
		else
		{
			added.add(s);
		}
		
		//for (Task t : tasks2) {System.out.print(t.person);} System.out.println();
		
		if (idx < current.size())
		{
			addOption(allTasks, tasks1, idx + 1);
			addOption(allTasks, tasks2, idx + 1);
		}
		
	}
	
	boolean possible(List<Task> tasks, Task ct, char who)
    {
        Task t1 = ct;

        for (int row = 0; row < tasks.size(); row++)
        {
        	Task t2 = tasks.get(row);
        	    
        	if (t2.idx == ct.idx)
            {
                continue;
            }

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
	
	private String getThem(List<Task> tasks)
	{
		StringBuffer sb = new StringBuffer();
		for (Task t : tasks) {sb.append(t.person);};
		return  sb.toString();
	}
	
	

	class Task {
		public int start;
		public int end;
		public char person;
		public int idx;
		
		public Task clone()
		{
			Task result = new Task();
			result.start = start;
			result.end = end;
			result.person = person;
			result.idx = idx;
			return result;
		}
		
		@Override
		public String toString() {
			return  String.valueOf(person);
		}
	}
	
}
