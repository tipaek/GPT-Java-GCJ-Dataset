import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution
{
	private final static String IMPOSSIBLE = "IMPOSSIBLE";
	private static boolean READ_FROM_FILE = false;
	private static boolean WRITE_TO_FILE = false;
	private static PrintWriter writer = null;

	public final static void main( String[] args ) throws IOException
	{
		Scanner in;
		File inFile=null;
		if ( READ_FROM_FILE )
		{
			inFile = new File(  args[ 0 ]);
			in = new Scanner( new BufferedReader( new FileReader( args[ 0 ] ) ) );
		}
		else
		{
			in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );
		}

		if ( WRITE_TO_FILE )
		{
			String fileOut;
			if(inFile==null){
				fileOut ="out-" + new SimpleDateFormat("YYYYMMdd-HHmmss").format( new Date( System.currentTimeMillis() ) ) + ".out";
			}else{
				fileOut=inFile.getParent()+"/"+inFile.getName().replace( ".in",new SimpleDateFormat("YYYYMMdd-HHmmss").format( new Date( System.currentTimeMillis() ) )+".out" );
			}
			writer = new PrintWriter(new BufferedWriter( new FileWriter(fileOut ) ));
		}

		int t = in.nextInt();
		for ( int i = 1; i <= t; ++i )
		{
			final Solution solution = new Solution();
			print( i, solution.solve( in ) );
		}

		if ( writer != null )
		{
			writer.flush();
			writer.close();
		}

	}

	public final static void print( int caseNumber, String result )
	{
		final String toWrite = "Case #" + caseNumber + ": " + result;
		if ( writer != null )
		{
				writer.println( toWrite );
		}
		else
		{
			System.out.println( toWrite );
		}
	}


	/******************************************************************************
	 *  Normally you should start coding from here:
	 ******************************************************************************/
	public Solution()
	{
	}

	public String solve( final Scanner in )
	{

		int N=in.nextInt();
		Interval[] intervals=new Interval[N];
		for (int i = 0; i < N; i++) {
			intervals[i] = new Interval(in.nextInt(),in.nextInt(),i);
		}
		char[] res =new char[N];
		Arrays.sort(intervals);
		int[] ends=new int[2];
		for (Interval i:intervals){
			int minIndex=(ends[0]<=ends[1])?0:1;
			if(ends[minIndex]>i.start){
				return IMPOSSIBLE;
			}
			ends[minIndex]=i.end;
			res[i.index]=(minIndex==0)?'C':'J';
		}
		return new String(res);
	}
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
final class Interval implements Comparable<Interval>{
	public Interval(int start, int end,int index) {
		this.start = start;
		this.end = end;
		this.index=index;
	}

	int start;
	int end;
	int index;

	@Override
	public int compareTo(Interval o) {
		return Integer.compare(start,o.start);
	}
}