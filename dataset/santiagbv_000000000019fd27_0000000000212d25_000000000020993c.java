import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vestigium {

	public static void main(String[] args) {

		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			StringBuilder builder = new StringBuilder();
			int n = Integer.parseInt(line);
			
			for( int x = 0 ; x < n ; ++x ){
				int m = Integer.parseInt(br.readLine());
				int[] rows = new int[m];
				int[] cols = new int[m];
				int k = 0;
				
				for( int i = 0 ; i < m ; ++i ){
					line = br.readLine();
					String[] vals = line.split(" ");
					for( int j = 0 ; j < m ; ++j ){
						int value = Integer.parseInt(vals[j]);
						if( i == j ) k += value;
						rows[i]+= value;
						cols[j]+= value;
					}
				}
				
				int cert = m*(m+1)/2;
				int r = 0;
				int c = 0;
				for( int i = 0 ; i < m ; ++i ){
					if( rows[i] != cert ) r++;
					if( cols[i] != cert ) c++;
				}
				builder.append("Case #"+(x+1)+": "+k+" "+r+" "+c+"\n");
			}
			System.out.println(builder.toString());
		}
		catch( Exception e ){
		}
	}

}
