import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String res = "";
		String s = in.next();
		D = new byte[s.length()];
		for (int i = 0; i < s.length(); i++) {
			D[i] = Byte.valueOf(s.charAt(i)+"");
		}
		return solve(0,D.length-1,0);
	}
	private String solve(int start,int end,int d){
		if(start<0 || end>=D.length){
			return "";
		}
		int minIndex = start;
		for (int i = start; i <=end ; i++) {
			if(D[i]<D[minIndex]) minIndex=i;
		}
		String left= (minIndex>start)?solve(start,minIndex-1,D[minIndex]):"";
		String right = (minIndex<end)?solve(minIndex+1,end,D[minIndex]):"";
		String res= left+D[minIndex]+right;
		for (int i = 0; i <D[minIndex]-d; i++) {
			res="("+res+")";
		}
		return res;
	}
	byte[] D;
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
