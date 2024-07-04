import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
public class Solution {

	public static void main(String[] args) {

		class Franja{
			int s;
			int e;
			String id;
		}
		Comparator<Franja> comp = new Comparator<Franja>() {

			@Override
			public int compare(Franja o1, Franja o2) {
				if( o1.s < o2.s) return -1;
				else if( o1.s > o2.s) return 1;
				else{
					if( o1.e < o2.e) return -1;
					else if( o1.e > o2.e) return 1;
					else{ return 0;}
				}
			}
		};

		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			StringBuilder builder = new StringBuilder();

			int n = Integer.parseInt(line);
			for( int x = 0 ; x < n ; ++x ){
				ArrayList<Franja> list = new ArrayList<>();
				ArrayList<Franja> list2 = new ArrayList<>();
				int m = Integer.parseInt(br.readLine() );
				for( int i = 0 ; i < m ; ++i ){
					String[] param = br.readLine().split(" ");
					Franja f = new Franja();
					f.s = Integer.parseInt(param[0]);
					f.e = Integer.parseInt(param[1]);
					list.add(f);
					list2.add(f);
				}
				list.sort(comp);

				int c = -1;
				int j = -1;
				boolean imposible = false;
				for( int i = 0 ; i < list.size() && !imposible; ++i ){
					if( list.get(i).s >= c ){
						c = list.get(i).e;
						list.get(i).id = "C";
					}
					else if( list.get(i).s >= j ){
						j = list.get(i).e;
						list.get(i).id = "J";
					}
					else{
						imposible = true;
					}
				}
				String resp = "";
				if( imposible ){
					resp = "IMPOSSIBLE";
				}
				else{
					for( int i = 0 ; i < list2.size() ; ++i ){
						resp += list2.get(i).id;
					}
				}
				builder.append("Case #"+(x+1)+": "+resp+"\n");

			}
			System.out.println(builder.toString());
		}
		catch( Exception e ){
		}

	}
}
