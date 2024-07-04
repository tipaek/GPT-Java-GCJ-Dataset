import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static class Activities {
		public final int start;
		public final int end;
		
		public Activities (int start, int end) {
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
				tab[i] = new Activities(in.nextInt(), in.nextInt());
			Arrays.sort(tab,new ActComparator());
			int Cavailable = 0;
			int Javailable = 0;
			String res = "";
			for (int i=0; i<N; i++) {
				int start = tab[i].start;
				if (Cavailable <= start) {
					res += "C";
					Cavailable = tab[i].end;
				} else if (Javailable <= start){
					res += "J";
					Javailable = tab[i].end;
				} else {
					res = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}
