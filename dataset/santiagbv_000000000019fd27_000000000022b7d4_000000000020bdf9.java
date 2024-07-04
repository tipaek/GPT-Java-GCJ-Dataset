import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
public class Solution {

	public static void main(String[] args) {

		class Franja{
			int pos;
			int s;
			int e;
			String id;
			
			boolean solapan( Franja f1 ){
				return ( (f1.s <= s && f1.e > s) || ( s <= f1.s && e > f1.s));
			}
		}
		Comparator<Franja> c = new Comparator<Franja>() {

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
		Comparator<Franja> c1 = new Comparator<Franja>() {

			@Override
			public int compare(Franja o1, Franja o2) {
				return o1.pos-o2.pos;
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
					f.pos = i;
					f.s = Integer.parseInt(param[0]);
					f.e = Integer.parseInt(param[1]);
					list.add(f);
					list2.add(f);
				}
				list.sort(c);
				int mod = 0;
				list.get(0).id= "C";
				int ac = 0;
				for( int i = 1 ; i < m && ac < 2; ++i ){
					if(  list.get(i).solapan(list.get(i-1))){
						mod = (mod+1)%2;
						ac++;
						if( ac == 2 && !list.get(i).solapan(list.get(i-2))) ac--;
					}
					else{
						ac = 0;
					}
					list.get(i).id = (mod == 0)? "C": "J";
				}
				String resp = "";
				if( ac == 2 ){
					resp = "IMPOSSIBLE";
				}
				else{
					list.sort(c1);
					for( int i = 0 ; i < list.size() ; ++i ){
						resp += list.get(i).id;
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
