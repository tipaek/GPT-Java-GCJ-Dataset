import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static class Task
	{
		private final int start;
		private final int end;
		private final int pos;
		
		private char assignee;

		public Task( int start, int end, int pos )
		{
			this.start = start;
			this.end = end;
			this.pos = pos;
		}
		
		
	}
	
	private static void calculate( int N, int[][] S, BufferedWriter bw, int n ) throws Exception
	{
		List<Task> tasks = new ArrayList<>();
		for ( int i = 0; i < N; i++ )
		{
			Task task = new Task( S[i][0], S[i][1], i );
			tasks.add( task );
		}
		tasks.sort( new Comparator<Task>() {
			@Override
			public int compare( Task task1, Task task2 ) {
				return task1.start - task2.start;
			}
		} );
		
		int cBusy = 0;
		int jBusy = 0;
		
		for ( Task task : tasks )
		{
			if ( cBusy > task.start && jBusy > task.start )
			{
				bw.append( "Case #"+n+": IMPOSSIBLE\n" );
				bw.flush();
				return;
			}
			
			if ( cBusy <= task.start )
			{
				task.assignee = 'C';
				cBusy = task.end;
			}
			else
			{
				task.assignee = 'J';
				jBusy = task.end;
			}
		}
		
		tasks.sort( new Comparator<Task>() {
			@Override
			public int compare( Task task1, Task task2 ) {
				return task1.pos - task2.pos;
			}
		} );
		String s = "";
		for ( Task task : tasks )
			s += task.assignee;
		
		bw.append( "Case #"+n+": " + s + "\n" );
		bw.flush();
	}
	
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		int numOfTestCases = Integer.parseInt( br.readLine() );
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		Scanner s = new Scanner( br );
		for ( int i = 0; i < numOfTestCases; i++ )
		{
			int N = s.nextInt();

			int[][] S = new int[N][2];
			for ( int j = 0; j < N; j++ )
			{
				S[j][0] = s.nextInt();
				S[j][1] = s.nextInt();
			}
			
			calculate( N, S, bw, i+1 );
		}
		
		s.close();
		bw.flush();

		br.close();
		bw.close();
	}
}
