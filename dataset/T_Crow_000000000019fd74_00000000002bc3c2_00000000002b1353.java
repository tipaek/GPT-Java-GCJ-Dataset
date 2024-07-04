import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		FastReader fr= new FastReader();
		long t=fr.nextLong(),n,potAct,cont,d;

		for (long i = 1; i <= t; i++) {
			n=fr.nextInt();
			potAct=0;
			cont=0;
			System.out.println("Case #"+i+": ");
			//System.out.println(1+" "+1);
			d=1;
			for (int j = 0; true; j++) {
				if(cont+Math.pow(2, potAct)>n) break;
				else {
					cont+=Math.pow(2, potAct);
					potAct++;
					System.out.println(genPair(potAct,d));
					if(d==1) d=0;
					else d=1;
				}
			}
			potAct++;
			if(cont!=n) {
				while(cont!=n) {
					if(d!=1) {
						System.out.println(potAct+" "+potAct);
						potAct++;
						cont++;
						//System.out.println("s");
					}else {
						System.out.println(potAct+" "+1);
						potAct++;
						cont++;
					}

				}
			}
		}
	}


	static String genPair(long n,long d) {
		StringBuilder res=new StringBuilder("");
		if(d==1) {
			for (long i =1; i <=n ; i++) {
				res.append(n+" "+i);
				if(!(i+1>n))res.append("\n"); 
			}
		}
		else {
			for (long i =n; i >=1 ; i--) {
				res.append(n+" "+i);
				if(!(i-1==0))res.append("\n"); 
			}
			
		}
		return res.toString();
	}

	static class FastReader {
		BufferedReader bf;
		StringTokenizer st;


		public FastReader() throws FileNotFoundException {
			bf=new BufferedReader(new InputStreamReader(System.in));
			//nf = new BufferedReader(new FileReader("pruebas.txt"));
		}

		String next() {
			while(st==null || !st.hasMoreElements()) {
				try {
					st=new StringTokenizer(bf.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() throws IOException {
			return bf.readLine();
		}
		boolean ready() throws IOException {
			return bf.ready() || (st!=null && st.hasMoreElements()); 
		}

	}
}
