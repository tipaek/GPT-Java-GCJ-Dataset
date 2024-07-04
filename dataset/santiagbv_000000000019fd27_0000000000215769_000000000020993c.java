import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {

		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			StringBuilder builder = new StringBuilder();
			int n = Integer.parseInt(line);

			for( int x = 0 ; x < n ; ++x ){
				int m = Integer.parseInt(br.readLine());
				int[][] matrix = new int[m][m];
				int k = 0;
				for( int i = 0 ; i < m ; ++i ){
					line = br.readLine();
					String[] vals = line.split(" ");
					for( int j = 0 ; j < m ; ++j ){
						int value = Integer.parseInt(vals[j]);
						if( i == j ) k += value;
						matrix[i][j] = value;
					}
				}
				int r = 0;
				for( int i = 0 ; i < m ; ++i ){
					boolean f = false;
					for( int j = 0 ; j < m-1 && !f ; ++j ){
						for( int l = j+1 ; l < m && !f ; ++l ){
							if( matrix[i][j] == matrix[i][l] ) f = true;
						}
					}
					if(f) r++;
				}
				int c = 0;
				for( int j = 0 ; j < m ; ++j ){
					boolean f = false;
					for( int i = 0 ; i < m-1 && !f ; ++i ){
						for( int l = i+1 ; l < m && !f ; ++l ){
							if( matrix[i][j] == matrix[i][l] ) f = true;
						}
					}
					if(f) c++;
				}
				builder.append("Case #"+(x+1)+": "+k+" "+r+" "+c+"\n");
			}
			System.out.println(builder.toString());
		}
		catch( Exception e ){
		}
	}

}
