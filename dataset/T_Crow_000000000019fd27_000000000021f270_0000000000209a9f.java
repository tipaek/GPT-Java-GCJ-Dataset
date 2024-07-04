import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FastReader fr = new FastReader();
		
		int caso = fr.nextInt(),mayor,ind;
		StringBuilder res,entr,temp;
		ArrayList<StringBuilder> aux;
		ArrayList<Integer> may;
		ArrayList<Integer> index;
		for (int i = 1; i <= caso; i++) {
			entr=new StringBuilder(fr.nextLine());
			res=new StringBuilder("");
			temp=new StringBuilder("");
			aux= new ArrayList<StringBuilder>();
			may= new ArrayList<Integer>();
			index= new ArrayList<Integer>();
			mayor=0;
			ind=0;
			for (int j = 0; j < entr.length(); j++) {
				if((entr.charAt(j)+"").equals("1")) {
					temp.append("(");
					while(j<entr.length() && (entr.charAt(j)+"").equals("1")) {
						temp.append("1");
						j++;
					}
					j--;
					temp.append(")");
					res.append(temp);
					temp=new StringBuilder("");
				}
				else {
					res.append("0");
				}
			}
			System.out.println("Case #"+i+": "+res);
		}
	}
	

	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;

		public FastReader()  {
			bf = new BufferedReader(new InputStreamReader(System.in));
			//bf = new BufferedReader(new FileReader("p.txt"));
		}
		String next() {
			while(st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt()  {
			return Integer.parseInt(next());
		}
		long nextLong()  {
			return Long.parseLong(next());
		}
		double nextDouble()  {
			return Double.parseDouble(next());
		}
		String nextLine() throws IOException {
			return bf.readLine();
		}
		boolean ready() throws IOException {
			return bf.ready() || (st != null && st.hasMoreElements());
		}
	}
}
