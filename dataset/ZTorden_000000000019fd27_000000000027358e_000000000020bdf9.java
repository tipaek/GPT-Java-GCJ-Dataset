import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	Scanner scanner;
	PrintStream out;
	
	public Solution(InputStream in, PrintStream out) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
		this.out = out;
	}

	class Task{
		int originalIndex;
		int start;
		int end;
		char worker;
		Task(int originalIndex, int start, int end){
			this.originalIndex=originalIndex;
			this.start=start;
			this.end=end;
			this.worker=' ';
		}
	}
	
	class Point{
		int jobs;
		int occupation;
		public Point(int jobs, int occupation) {
			super();
			this.jobs = jobs;
			this.occupation = occupation;
		}
	}
	
	int N;
	Task[] tasks;
	Point[] points;
	StringBuilder result;
	boolean ispossible;
	
	private void readTest() {
		N=scanner.nextInt();
		tasks=new Task[N];
		points=new Point[24*60+1];
		for(int i=0;i<points.length;i++)
			points[i]=new Point(0,0);
		for(int i=0;i<N;i++) {
			int start=scanner.nextInt();
			points[start].jobs++;
			points[start].occupation=1;
			int end=scanner.nextInt();
			points[end].jobs--;
			points[end].occupation=1;
			tasks[i]=new Task(i, start, end);
		}
	}


	private void calculate() {
		int jobs=0;
		for(int i=0;i<points.length;i++) {
			jobs+=points[i].jobs;
			if (jobs>2) {
				ispossible=false;
				return;
			}
		}
		ispossible=true;
		result = new StringBuilder();
		Arrays.sort(tasks, new Comparator<Task>(){

			@Override
			public int compare(Task arg0, Task arg1) {
				return Integer.compare(arg0.start, arg1.start);
			}});
		
		for(int i=0;i<N;i++) {
			boolean canCdo = ((points[tasks[i].start].occupation<=2)&&((points[tasks[i].end].occupation==1)||(points[tasks[i].end].occupation==3)));
			if (canCdo)
				for(int j=tasks[i].start+1;j<tasks[i].end;j++)
					if(points[j].occupation>1) {
						canCdo = false;
						break;
					}
			if(!canCdo)
				tasks[i].worker='J';
			else {
				tasks[i].worker='C';
				if(points[tasks[i].start].occupation==1)
					points[tasks[i].start].occupation=3;
				else
					points[tasks[i].start].occupation=4;
					
				if(points[tasks[i].end].occupation==1)
					points[tasks[i].end].occupation=2;
				else
					points[tasks[i].end].occupation=4;
				for(int j=tasks[i].start+1;j<tasks[i].end;j++)
					if(points[j].occupation==1)
						points[j].occupation=4;
			}
		}
		Arrays.sort(tasks, new Comparator<Task>(){

			@Override
			public int compare(Task arg0, Task arg1) {
				return Integer.compare(arg0.originalIndex, arg1.originalIndex);
			}});		
		for(int i=0;i<tasks.length;i++)
			result.append(tasks[i].worker);
					
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");
		
		if(ispossible)
			sb.append(result);
		else
			sb.append("IMPOSSIBLE");
		
		out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Solution(System.in, System.out).run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}