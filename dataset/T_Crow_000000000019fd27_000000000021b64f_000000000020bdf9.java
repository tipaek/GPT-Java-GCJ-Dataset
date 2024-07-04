import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static Pareja task[];
	static String[] JC;

	static class Pareja implements Comparable<Pareja> {
		int in;
		int fin;
		public Pareja(int in, int fin) {
			super();
			this.in = in;
			this.fin = fin;
		}
		@Override
		public int compareTo(Pareja arg0) {
			int resultado = 0;

			if (this.in < arg0.in) {
				resultado = -1;
			} else if (this.fin > arg0.fin) {
				resultado = 1;
			} 
			return resultado;
		}
		@Override
		public String toString() {
			return "Pareja [in=" + in + ", fin=" + fin + "]";
		}


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader fr=new FastReader();

		int casos = fr.nextInt(),taskT,cant;

		for (int i = 1; i <= casos ; i++) {
			cant=fr.nextInt();
			JC=new String[cant];
			task=new Pareja[cant];
			Arrays.fill(JC, "F");
			for (int j = 0; j < cant; j++) {
				task[j]=new Pareja(fr.nextInt(), fr.nextInt());
			}
//			Arrays.sort(task);
			taskT=calcC()+ calcJ();
			System.out.print("Case #"+i+": ");
			if(taskT<cant) System.out.println("IMPOSSIBLE");
			else {
				System.out.println(Arrays.toString(JC).replace("[", "").replace("]", "").replace(",", "").replace(" ", ""));
			}
		}


	}

	static int calcC() {
		ArrayList<Pareja> aux = new ArrayList<Pareja>();
		boolean isAdd;
		int cant=0;
		for (int i = 0; i < task.length; i++) {
			if(!JC[i].equals("F")) continue;
			isAdd=true;
			if(aux.size()==0) {
				JC[i]="C";
				aux.add(task[i]);
			}
			else {
				for (int j = 0; j < aux.size(); j++) {
					if(((task[i].in>=aux.get(j).fin))) {
						continue; 
					}
					else if((aux.get(j).in>=task[i].fin)) continue;
					else {
						isAdd = false;
						break;
					}
				}
				if(isAdd) {
					JC[i]="C";
					aux.add(task[i]);
				}
			}
		}
		//System.out.println(aux.size()+"C");
		return aux.size();
	}

	static int calcJ() {
		ArrayList<Pareja> aux = new ArrayList<Pareja>();
		boolean isAdd;
		int cant=0;
		for (int i = 0; i < task.length; i++) {
			if(!JC[i].equals("F")) continue;
			isAdd=true;
			if(aux.size()==0) {
				JC[i]="J";
				aux.add(task[i]);
			}
			else {
				for (int j = 0; j < aux.size(); j++) {

					if(((task[i].in>=aux.get(j).fin))) {
						continue; 
					}
					else if((aux.get(j).in>=task[i].fin)) continue;
					else {
						isAdd = false;
						break;
					}
				}
				if(isAdd) {
					JC[i]="J";
					aux.add(task[i]);
				}
			}
		}
		//System.out.println(aux.size()+"J");
		return aux.size();
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
