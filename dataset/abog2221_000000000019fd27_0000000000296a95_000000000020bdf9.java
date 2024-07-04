import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main (String[] args) throws IOException{
		  FastReader sc=new FastReader();  
		  PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		  int t=sc.nextInt();
		  for(int z=1;z<=t;z++) {
			  int n=sc.nextInt();
			  tup[] time=new tup[n];
			  for(int i=0;i<n;i++) {
				  int a=sc.nextInt();
				  int b=sc.nextInt();
				  time[i]=new tup(a,b,i);
			  }
			  //out.println(Arrays.toString(time));
			  Arrays.sort(time);
			  //out.println(Arrays.toString(time));
			  char[] res=new char[n];
			  res[time[0].c]='C';
			  boolean c=true;
			  boolean j=false;
			  String bro="";
			  int jend=0;
			  int cend=time[0].b;
			 out: for(int i=1;i<n;i++) {
				  int start1=time[i].a;
				  int end1=time[i].b;
				  if(i==0&&time[0].b<=start1) {
					  c=false;
				  }
				  if(start1>=cend) {
					  c=false;
				  }
				  if(start1>=jend) {
					  j=false;
				  }
				  if(!c) {
					  int cstart=time[i].a;
					  cend=time[i].b;
					  res[time[i].c]='C';
					  c=true;
				  }
				  else if(!j) {
					  int jstart=time[i].a;
					  jend=time[i].b;
					  res[time[i].c]='J';
					  j=true;
				  }
				  else {
					  bro="IMPOSSIBLE";
					  break out;
				  }
			  }
			  String res2="";
			  for(int i=0;i<res.length;i++) {
				  res2+=res[i];
			  }
			  if(bro.equals("IMPOSSIBLE")) {
			  out.println("Case #" + z + ": "+bro);}
			  else out.println("Case #" + z + ": "+res2);
		  }
			  
		  out.close();
	}
	
	static class tup implements Comparable<tup>{
        int a,b,c;
        tup(int a, int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
        @Override
        public int compareTo(tup o2){
            return a==o2.a?Integer.compare(b,o2.b):Integer.compare(a,o2.a);
        }
        @Override
        public String toString() {
        	return a+" "+b;
        }
    }
	
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            public FastReader(String s) throws FileNotFoundException {
                br = new BufferedReader(new FileReader(new File(s)));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
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

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) { e.printStackTrace();
                }return str;
        }
    }
	
	
}
