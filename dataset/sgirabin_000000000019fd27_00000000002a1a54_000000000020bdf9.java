import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    
    	class Task {
		int index;
		int start;
		int end;
		
		public Task(int index, int start,int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}
	}
	
	class SortedTask {
		public Task[] compare(Task[] tasks, int n) {
			Arrays.sort(tasks, new Comparator<Task>() {
				@Override
				public int compare(Task t1, Task t2) {
					return t1.start -  t2.start;
				}
				
			});
			
			return tasks;
		}
	}

	private Scanner scanner;
	private PrintWriter writer;

	public Solution(InputStream in, OutputStream out) {
		scanner = new Scanner(in);
		writer = new PrintWriter(out);
	}
	

	public void solve() {

		String C = "C";
		String J = "J";
		
		int T = scanner.nextInt();
        for (int i=0;i<T;i++) {

        	int N = scanner.nextInt();

        	Task[] tasks = new Task[N];
        	for (int j=0;j<N;j++) {
                int start  = scanner.nextInt();
                int finish = scanner.nextInt();
                tasks[j] = new Task(j, start,finish);
        	}
        	
        	String[] sb = new String[N];
        	int cLastEnd = 0;
        	int jLastEnd = 0;
        	SortedTask sortedTask = new SortedTask();
        	Task[] sortedTasks = sortedTask.compare(tasks, N);
        	for (int j=0;j<N;j++) {
        		Task task = sortedTasks[j];
        		if (task.start>=cLastEnd) {
        			sb[task.index] = C;
        			cLastEnd=task.end;
        		}else if  (task.start>=jLastEnd) {
        			sb[task.index] = J;
        			jLastEnd=task.end;
        		}else {
        			for (int k=0;k<N;k++) {
        				sb[k]="";
        			}
        			sb[0]="IMPOSSIBLE";
        			j=N;
        		}
        	}

        	StringBuffer out = new StringBuffer();
			for (int k=0;k<N;k++) {
				out.append(sb[k]);
			}
            writer.printf("Case #%d: %s%n",i+1,out.toString());            
        }
        writer.flush();
        writer.close();
	}


	public static void main(String[] args) {
    	Solution solution = new Solution(System.in, System.out);
        solution.solve();
    }
}