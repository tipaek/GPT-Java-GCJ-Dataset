import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
	private static void calculate( int b, BufferedReader br, BufferedWriter bw ) throws Exception
	{
		//FileWriter fw = new FileWriter( "log" + System.currentTimeMillis() + ".txt" );
		
		Boolean[] bits = new Boolean[b+1];
		
		int sameP = 1;
		boolean sameValue = false;
		int diffP = 1;
		boolean diffValue = false;
		
		int p = 1;
		for ( ; p <= 5; p++ )
		{
			bw.append( p + "\n" );
			bw.flush();
			
			String reply = br.readLine();
			//fw.write( "Asked for " + p + ", got " + reply + "\n" );
			//fw.flush();
			bits[p] = "1".equals( reply );
			
			bw.append( (b - p + 1) + "\n" );
			bw.flush();
			reply = br.readLine();
			//fw.write( "Asked for " + (b - p + 1) + ", got " + reply + "\n" );
			//fw.flush();
			bits[b-p+1] = "1".equals( reply );
			
			if ( bits[p] == bits[b-p+1] )
			{
				sameP = p;
				sameValue = bits[p];
			}
			else
			{
				diffP = p;
				diffValue = bits[p];
			}
			
			//fw.write( "State: " + toString( bits ) + "\n" );
			//fw.flush();
		}
		p--;
		
		boolean sameChange = false;
		boolean diffChange = false;
		int i = 1;
		while ( p*2 < b )
		{
			if ( i % 10 == 1 )
			{
				bw.append( sameP + "\n" );
				bw.flush();
				
				String reply = br.readLine();
				//fw.write( "Asked for " + sameP + ", got " + reply + "\n" );
				//fw.flush();
				sameChange = ( sameValue != "1".equals( reply ) );
				i++;
			}
			else if ( i % 10 == 2 )
			{
				bw.append( diffP + "\n" );
				bw.flush();
				
				String reply = br.readLine();
				//fw.write( "Asked for " +diffP + ", got " + reply + "\n" );
				//fw.flush();
				diffChange = ( diffValue != "1".equals( reply ) );
				
				//fw.write( "sameChange: " + sameChange + ", diffChange: " + diffChange + "\n" );
				//fw.flush();

				if ( sameChange && diffChange )
				{
					for ( int j = 1; j < bits.length; j++ )
						bits[j] = ( bits[j] == null ? null : !bits[j] );
				}
				else if ( sameChange && !diffChange )
				{
					Boolean[] bitsv = new Boolean[b+1];
					for ( int j = 1; j < bits.length; j++ )
						bitsv[j] = ( bits[b-j+1] == null ? null : !bits[b-j+1] );
					bits = bitsv;
				}
				else if ( !sameChange && diffChange )
				{
					Boolean[] bitsv = new Boolean[b+1];
					for ( int j = 1; j < bits.length; j++ )
						bitsv[j] = ( bits[b-j+1] == null ? null : bits[b-j+1] );
					bits = bitsv;
				}
				i++;
				
				sameValue = bits[sameP];
				diffValue = bits[diffP];
				
				//fw.write( "State: " + toString( bits ) + "\n" );
				//fw.flush();
			}
			else
			{
				p++;
				bw.append( p + "\n" );
				bw.flush();
				
				String reply = br.readLine();
				//fw.write( "Asked for " + p + ", got " + reply + "\n" );
				//fw.flush();
				bits[p] = "1".equals( reply );
				
				bw.append( (b - p + 1) + "\n" );
				bw.flush();
				reply = br.readLine();
				//fw.write( "Asked for " + (b - p + 1) + ", got " + reply + "\n" );
				//fw.flush();
				bits[b-p+1] = "1".equals( reply );
				
				if ( bits[p] == bits[b-p+1] )
				{
					sameP = p;
					sameValue = bits[p];
				}
				else
				{
					diffP = p;
					diffValue = bits[p];
				}
				i += 2;
				
				//fw.write( "State: " + toString( bits ) + "\n" );
				//fw.flush();
			}
		}
		
		String s = toString( bits );
		bw.append( s + "\n" );
		bw.flush();
		
		String reply = br.readLine();
		//fw.write( "Guessed " + s + ", got " + reply + "\n" );
		//fw.flush();
	}
	
	private static String toString( Boolean[] bits )
	{
		String s = "";
		for ( int x = 1; x < bits.length; x++ )
			s += bits[x] == null ? "X" : bits[x] ? "1" : "0";
		return s;
	}
	
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		String[] data = br.readLine().split( " " );
		int numOfTestCases = Integer.parseInt( data[0] );
		int b = Integer.parseInt( data[1] );
		for ( int i = 0; i < numOfTestCases; i++ )
			calculate( b, br, bw );
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
