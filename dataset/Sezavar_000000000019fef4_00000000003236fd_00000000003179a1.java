import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

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
		HashMap<Character,Integer> map = new HashMap<>();
		HashSet<Character> all = new HashSet<>();
		int U = in.nextInt();
		for (int i = 0; i < 10000; i++) {
			int Q = in.nextInt();
			String R = in.next();
			if(Q!=-1){
				char ch = R.charAt(0);
				int pr ;
				for(Character c: R.toCharArray()){
					if(!map.containsKey(c)){
						map.put(c,9);
					}
				}
				all.add(R.charAt(0));
				pr = map.get(R.charAt(0));
				String qStr =String.valueOf(Q);
				if(qStr.length()==R.length()) {
					int firstDigit = Character.getNumericValue(qStr.charAt(0));
					if (firstDigit < pr) {
						map.put(ch, firstDigit);
					}
				}
			}else{
				return "ABCDEFGHIJ";
			}
		}
		StringBuilder sb = new StringBuilder();
		char firstChar = 'A';
		for(Map.Entry<Character,Integer> entry:map.entrySet()){
			if(!all.contains(entry.getKey())){
				firstChar = entry.getKey();
			}
		}
		sb.append(firstChar);
		map.remove(firstChar);
		for (int i = 1; i < 10; i++) {
			Map.Entry<Character,Integer> max = null;
			for(Map.Entry<Character,Integer> entry:map.entrySet()){
				if(max==null){
					max=entry;
				}else{
					if(entry.getValue()<max.getValue()){
						max = entry;
					}
				}
			}
			sb.append(max.getKey());
			map.remove(max.getKey());
		}
		return sb.toString();
	}
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
