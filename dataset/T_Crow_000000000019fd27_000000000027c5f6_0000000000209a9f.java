import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FastReader fr = new FastReader();

		int caso = fr.nextInt(),mayor,ind,parAct,numAct;
		StringBuilder res,entr,temp,temp2;
		ArrayList<StringBuilder> aux;
		ArrayList<Integer> may;
		ArrayList<Integer> index;
		for (int i = 1; i <= caso; i++) {
			entr=new StringBuilder(fr.nextLine());
			res=new StringBuilder("");
			temp=new StringBuilder("");
			temp2=new StringBuilder("");
			aux= new ArrayList<StringBuilder>();
			may= new ArrayList<Integer>();
			index= new ArrayList<Integer>();
			ind=0;
			for (int j = 0; j < entr.length(); j++) {
				numAct=Integer.parseInt(entr.charAt(j)+"");
				if(!(numAct==0)) {
					while(true) {
						numAct=Integer.parseInt(entr.charAt(j)+"");
						if(numAct!=0) {
							temp.append(String.valueOf(numAct));
							//System.out.println(temp);
						}
						else if(numAct==0) {
							j--;
							break;
						}
						if(j+1>=entr.length()) break;
						else j++;
					}
					temp2.append("(");
					parAct=1;
					for (int j2 = 0; j2 < temp.length(); j2++) {
						numAct=Integer.parseInt(temp.charAt(j2)+"");
						//System.out.println(numAct==parAct);
						if(numAct>parAct) {
							while(numAct!=parAct) {
								temp2.append("(");
								parAct++;
							}
							temp2.append(String.valueOf(numAct));
						}
						else if(numAct==parAct) {
							temp2.append(String.valueOf(numAct));
						}
						else {
							while(numAct!=parAct) {
								temp2.append(")");
								parAct--;
							}
							temp2.append(numAct);
						}
					//	System.out.println(temp2);
					}
					while(parAct>0) {
						temp2.append(")");
						parAct--;
					}
					res.append(temp2);
					temp=new StringBuilder("");
					temp2=new StringBuilder("");
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
