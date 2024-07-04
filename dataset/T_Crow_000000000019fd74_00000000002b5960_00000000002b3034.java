import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FastReader fr=new FastReader();
		int t=fr.nextInt(),n,cont;
		StringBuilder st1, st2, res;
		boolean isEq;
		ArrayList<StringBuilder> aux = new ArrayList<StringBuilder>();
		for (int i = 1; i <= t; i++) {
			aux.clear();
			n=fr.nextInt();
			st1=new StringBuilder(fr.nextLine());
			st1.deleteCharAt(0);
			aux.add(st1);
			isEq=true;
			for (int j = 0; j < n-1; j++) {
				st2=new StringBuilder(fr.nextLine());
				st2.deleteCharAt(0);
				aux.add(st2);
				if(st2.length()>st1.length()) st1=new StringBuilder(st2);
			}
			
			for (int j = 0; j <aux.size(); j++) {
				cont=st1.length()-1;
				for (int j2 = aux.get(j).length()-1;j2>=0; j2--) {
					if(!((st1.charAt(cont)+"").equals((aux.get(j).charAt(j2))+""))) {
						isEq=false;
						break;
					}
					cont--;
				}
			}
			System.out.print("Case #"+i+": ");
			System.out.println(isEq?st1:"*");
		}
		
	}
	
	static class FastReader{
		BufferedReader bf;
		StringTokenizer st;
		
		public FastReader() throws FileNotFoundException{
			bf= new BufferedReader(new InputStreamReader(System.in));
			//bf=new BufferedReader(new FileReader("pruebas.txt"));
		}
		
		String read() {
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
			return Integer.parseInt(read());
		}
		long nextLong() {
			return Long.parseLong(read());
		}
		double nextDouble() {
			return Double.parseDouble(read());
		}
		String nextLine() throws IOException {
			return bf.readLine();
		}
		boolean ready() throws IOException {
			return bf.ready() || (st!=null && st.hasMoreElements());
		}
	}

}
