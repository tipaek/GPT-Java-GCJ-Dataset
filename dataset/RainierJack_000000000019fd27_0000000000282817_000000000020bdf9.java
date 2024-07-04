import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static class Activities {
		public final int id;
		public final int start;
		public final int end;
		
		public Activities (int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
	}
	public static class ActComparator implements Comparator<Activities> {
		@Override
		public int compare(Activities arg0, Activities arg1) {
			return (arg0.start - arg1.start);
		}	
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			Activities [] tab = new Activities[N];
			for (int i=0; i<N; i++)
				tab[i] = new Activities(i, in.nextInt(), in.nextInt());
			Arrays.sort(tab,new ActComparator());
			
			char[] assignements = new char[N];
			int Cavailable = 0;
			int Javailable = 0;
			boolean possible = true;
			String res = "";
			for (int i=0; i<N; i++) {
				int start = tab[i].start;
				if (Cavailable <= start) {
					assignements[tab[i].id] = 'C';
					Cavailable = tab[i].end;
				} else if (Javailable <= start){
					assignements[tab[i].id] = 'J';
					Javailable = tab[i].end;
				} else {
					possible = false;
					break;
				}
			}
			if (possible) {
				for (int i=0; i<N; i++)
					res += assignements[i];
			} else
				res = "IMPOSSIBLE";
				System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}
