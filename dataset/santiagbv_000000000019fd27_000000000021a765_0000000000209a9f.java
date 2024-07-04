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
				String[] arr = br.readLine().split("");
				String Sp = "";
				int k = 0;
				int cuenta = 0;
				
				for( int i = 0 ; i < arr.length ; ++i ){
					int num = Integer.parseInt(arr[i]);
					int temp = num - k;
					if( temp > 0 ){ for( int j = 0 ; j < temp ; ++j ) Sp+="("; cuenta+=temp;}
					else if( temp < 0 ){ for( int j = 0 ; j > temp ; --j ) Sp+=")"; cuenta+=temp;}
					Sp+=num;
					k = num;
				}
				
				for( int i = 0 ; i < cuenta ; ++i ) Sp+=")";
				builder.append("Case #"+(x+1)+": "+Sp+"\n");
			}
			System.out.println(builder.toString());
		}
		catch( Exception e ){
		}
	}
}
