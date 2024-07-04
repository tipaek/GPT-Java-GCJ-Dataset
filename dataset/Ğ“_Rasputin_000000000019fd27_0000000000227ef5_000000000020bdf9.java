
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class activity implements Comparable<activity>{
		int st , end ;
		String person ;
		public activity(int st , int end) {
			this.st= st ;this.end=end;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + st;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			activity other = (activity) obj;
			if (end != other.end)
				return false;
			if (st != other.st)
				return false;
			return true;
		}

		@Override
		public int compareTo(activity o) {
			if( this.st == o.st)
				return this.end - o.end;
			else
				return this.st - o.st;
		}
	}
	
	static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(3000);}
    }
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();int p = 1 ;
		while(t-- > 0) {
			int n = sc.nextInt();
			activity [] arr = new activity [n];
			for(int i= 0 ; i < n ; i++) arr[i] = new activity(sc.nextInt(), sc.nextInt());
			activity[] arr2 = arr.clone();
			Arrays.sort(arr);
			boolean j = true ,c = true , Imp = false ;
			int jLimit = 0 , cLimit =0 ;
			all :for(int i = 0 ; i < n ; i++) {
				activity curr = arr[i];
				if(jLimit <= curr.st) {
					 jLimit = curr.end;curr.person = "j";
				}
				else if( cLimit <= curr.st) {
					 cLimit = curr.end;curr.person = "c";
				}
				else {
					Imp = true ;break all ;
				}
			}
			String out = "";
			for(activity act : arr2) {
				out += act.person;
			}
			if(Imp)
				System.out.println("Case #"+p+": IMPOSSIBLE");
			else
				System.out.println("Case #"+p+": "+out);
			p++;
		}
		
	}

}
