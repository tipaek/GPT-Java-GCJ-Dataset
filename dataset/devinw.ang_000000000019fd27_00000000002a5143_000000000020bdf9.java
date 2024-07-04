import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
public class Solution {

	public static void main(String[] args) throws Exception{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = sc.nextInt();
		for(int i = 0;i<n;i++) {
			solve(i+1,sc,out);
		}
		out.close();
	}
	public static void solve(int testNumber, FastReader sc, PrintWriter pw) {
		int n  = sc.nextInt(); 
        tup[]arr = new tup[n*2];
        int[]test = new int[n*2];
        int in = 0;
        for(int i = 0;i<arr.length;i+=2) {
        	arr[i]=new tup(sc.nextInt(),in+1);
        	arr[i+1]=new tup(sc.nextInt(),-in-1);
        	in++;
        	test[i]=arr[i].a;
        	test[i+1]=arr[i+1].a;
        }
        System.out.println(Arrays.toString(test));
        Arrays.sort(arr);
        for(tup each0 : arr) {
        	System.out.print(each0.a+" ");
        	
        }
        System.out.println();
        for(tup each0 : arr) {
        	System.out.print(each0.b+" ");
        }
        ArrayList<Integer>C = new ArrayList<Integer>();
        ArrayList<Integer>J = new ArrayList<Integer>();
        int c = 0;
        int j = 0;
        int index1 = 0;
        int index2 = 0;
        for(tup each:arr) {
        	if(each.b>0) {
        		if(c==0) {
        			index1=each.b;
        			c++;
        			C.add(each.b);
        		}else if(j==0) {
        			index2=each.b;
        			j++;
        			J.add(each.b);
        		}else {
        			pw.printf("Case #%d: IMPOSSIBLE%n",testNumber);
                    return;
        		}
        	}else {
        		if(Math.abs(each.b)==index1) {
        			c = 0;
        		}else if(Math.abs(each.b)==index2){
        			j = 0;
        		}
        	}
        }
        System.out.println();
        for(int u = 0;u<C.size();u++) {
        	System.out.print(C.get(u)+" ");
        }
        System.out.println();
        pw.print("Case"+" "+"#"+testNumber+":"+" ");
        for(int x = 1; x<=n;x++) {
        	if(C.contains(x)) {
        		pw.print("C");
        	}else {
        		pw.print("J");
        	}
        }
        pw.println();
	}
	/*public static String solve(int[][]mat,int n) {
		ArrayList<Integer>cmin = new ArrayList<Integer>();
		ArrayList<Integer>cmax = new ArrayList<Integer>();
		ArrayList<Integer>jmin = new ArrayList<Integer>();
		ArrayList<Integer>jmax = new ArrayList<Integer>();
		String str = "";
		for(int i=0;i<n;i++) {
			if(cmin.size()==0) {
				cmin.add(mat[0][0]);
				cmax.add(mat[0][1]);
				str+="C";
			}else
			if(works(mat[i],cmin,cmax)) {
				str+="C";
				cmin.add(mat[i][0]);
				cmax.add(mat[i][1]);
			}else if(jmin.size()==0) {
				str+="J";
				jmin.add(mat[i][0]);
				jmax.add(mat[i][1]);
			}else if(works(mat[i],jmin,jmax)) {
				str+="J";
				jmin.add(mat[i][0]);
				jmax.add(mat[i][1]);
			}else {
				str = "IMPOSSIBLE";
				return str;
			}
			/*System.out.println(cmin);
			System.out.println(cmax);
			System.out.println(jmin);
			System.out.println(jmax);
		}
		String str = "";
		return str;
	}*/
	public static Boolean works(int[]arr,ArrayList<Integer>min,ArrayList<Integer>max) {
		for(int i = 0;i<min.size();i++) {
			if((arr[0]>min.get(i)&&arr[0]<max.get(i))||arr[0]==min.get(i)) {
				return false;
			}
			if(arr[1]>min.get(i)&&arr[1]<max.get(i)||arr[1]==max.get(i)) {
				return false;
			}
			if(arr[0]>min.get(i)&&arr[1]<max.get(i)) {
				return false;
			}
			if(arr[0]<min.get(i)&&arr[1]>max.get(i)) {
				return false;
			}
			
		}
		return true;
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	static class tup implements Comparable<tup>{
	    int a,b;
	    tup(int a, int b){
	        this.a=a;
	        this.b=b;
	    }
	    @Override
	    public int compareTo(tup o2){
	        return a==o2.a?Integer.compare(b,o2.b):Integer.compare(a,o2.a);
	    }

}
}
