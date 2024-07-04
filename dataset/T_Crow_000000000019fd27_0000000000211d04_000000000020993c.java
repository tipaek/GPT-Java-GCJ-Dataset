import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader fr=new FastReader();
		int casos =fr.nextInt(),tam,cont,cantR,cantC;
		int entr[][];
		boolean col[],row[],ch;
		
		
		for (int i = 1; i <= casos; i++) {
			tam=fr.nextInt();
			cont=0;cantR=0;cantC=0;
			col=new boolean[1000];
			entr=new int[tam][tam];
			for (int j = 0; j < tam; j++) {
				row=new boolean[1000];
				ch=false;
				for (int j2 = 0; j2 < tam; j2++) {
					entr[j][j2] = fr.nextInt();
					if(j==j2) cont+=entr[j][j2];
					if(row[entr[j][j2]] && !ch) {
						ch=true;
						cantR++;
					}
					else {
						row[entr[j][j2]]=true;
					}
				}
			}
			for (int j = 0; j < tam; j++) {
				col=new boolean[1000];
				ch=false;
				for (int j2 = 0; j2 < tam; j2++) {
					if(col[entr[j2][j]] && !ch) {
						ch=true;
						cantC++;
					}
					else {
						col[entr[j2][j]]=true;
					}
				}
			}
			System.out.println("Case #"+i+": "+cont+" "+cantR+" "+cantC);
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
