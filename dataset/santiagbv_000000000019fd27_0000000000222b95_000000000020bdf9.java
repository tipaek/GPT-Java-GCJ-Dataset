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
			System.out.println(n);

			for( int x = 0 ; x < n ; ++x ){
				int numer = 24*60+1;
				int[] franjas = new int[numer];

				int m = Integer.parseInt(br.readLine() );
				int[][] horario = new int[m][2];

				System.out.println(m);
				System.out.println("bien");

				for( int i = 0 ; i < m ; ++i ){
					String[] temp = br.readLine().split(" ");
					int s = Integer.parseInt(temp[0]);
					int e = Integer.parseInt(temp[1]);
					franjas[s]+=1;
					franjas[e]-=1;
					horario[i][0] = s;
					horario[i][1] = e;
				}
				int suma = 0;
				int temp = 0;
				int[] simul = new int[numer];
				for( int i = 0 ; i < franjas.length && suma < 3; ++i){
					suma+=franjas[i];
					simul[i] = temp+franjas[i];
					temp= simul[i];
				}
				String resp = "";
				if( suma == 0 ){
					for( int i = 0 ; i < m ; ++i ){
						if(simul[horario[i][0]] == 1) resp +="C";
						else if(simul[horario[i][0]] == 2) resp +="J";
					}
				}
				else{
					resp = "IMPOSSIBLE";
				}
				builder.append("Case #"+(x+1)+": "+resp+"\n");

			}
			System.out.println(builder.toString());
		}
		catch( Exception e ){
			System.out.println("fallo");
		}

	}

}