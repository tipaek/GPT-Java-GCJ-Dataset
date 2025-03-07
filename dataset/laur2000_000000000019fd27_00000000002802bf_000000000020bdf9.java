import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int caso = 1; caso <= casos; caso++) {
			int N = sc.nextInt();
			Set<Pair> tareas = new TreeSet<Pair>();
			for(int i = 0; i < N; i++) {
			    int v1 = sc.nextInt();
			    int v2 = sc.nextInt();
				tareas.add(new Pair(v1,v2,i));
				
			}
			Iterator<Pair> it = tareas.iterator();
			Pair[] haciendose = new Pair[2];
			haciendose[0] = it.next();
			haciendose[1] = it.next();
			char[] res = new char[N];
			res[haciendose[0].pos] = 'J';
			res[haciendose[1].pos] = 'C';
			Boolean impossible = false;
			while(it.hasNext() && !impossible) {
				Pair siguiente = it.next();
				if(siguiente.v1>=haciendose[0].v2) {
					haciendose[0] = siguiente;
					res[siguiente.pos] = 'J';
				}
				else if(siguiente.v1>=haciendose[1].v2) {
					haciendose[1] = siguiente;
					res[siguiente.pos] = 'C';
				}
				else {
					impossible = true;
				}
			}
			System.out.println(String.format("Case #%d: %s", caso,impossible?"IMPOSSIBLE":new String(res)));
		}
		
	
	}
	
	

}


class Pair implements Comparable<Pair>{
	public int v1 = 0,v2 = 0;
	public int pos = 0;
	public Pair(int v1, int v2,int pos) {
		this.v1 = v1;
		this.v2 = v2;
		this.pos = pos;
	}
	
	
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		int res = this.v1-o.v1;
		if(res == 0) {
			res = this.v2-o.v2;
		}
		return res;
	}
}