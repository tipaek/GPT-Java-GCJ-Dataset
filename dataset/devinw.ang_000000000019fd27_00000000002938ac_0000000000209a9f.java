import java.io.*;
import java.util.StringTokenizer;

public class Sultion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t = sc.nextInt();
		for(int i = 1;i<=t;i++) {
			String stri = sc.next();
			out.println("Case"+" "+"#"+i+":"+" "+solve(stri));
		}
		out.close();

	}
	public static String solve (String str) {
		String result = "";
		int o = 0;
		int c = 0;
		
		if(str.length()==1) {
			int n = Integer.parseInt(str);
			for(int j = 0;j<n;j++) {
				result+="(";
			}
			result+=str;
			for(int k = 0;k<n;k++) {
				result+=")";
			}
			return result;
		}
		if(str.length()==0) {
			return "";
		}
		int k = Integer.parseInt(str.substring(0,1));
		for(int j = 0;j<k;j++) {
			result+="(";
			o++;
		}
		result+=str.substring(0,1);
		for(int i = 1;i<str.length();i++) {
			int n = Integer.parseInt(str.substring(i,i+1));
			int d = n - Integer.parseInt(str.substring(i-1,i));
			if(d>0) {
				for(int m = 0;m<d;m++) {
					result+="(";
					o++;
				}
			}
			if(d<0) {
				for(int l = 0;l<Math.abs(d);l++) {
					result+=")";
					c++;
				}
			}
			result+=str.substring(i,i+1);
		}
		while(o!=c) {
			result+=")";
			c++;
		}
		
		/*
		for(int i = 1;i<str.length();i++){
			if(str.substring(i,i+1).equals(sub.substring(0,1))){
				sub+=str.substring(i,i+1);
			}
			else {
				int n = Integer.parseInt(sub.substring(0,1));
				for(int j = 0;j<n;j++) {
					result+="(";
				}
				result+=sub;
				for(int k = 0;k<n;k++) {
					result+=")";
				}
				sub = str.substring(i,i+1);
			}
			if(i ==str.length()-1) {
				int n = Integer.parseInt(sub.substring(0,1));
				for(int j = 0;j<n;j++) {
					result+="(";
				}
				result+=sub;
				for(int k = 0;k<n;k++) {
					result+=")";
				}
				sub = str.substring(i,i+1);
			}
			
		}
		*/
		return result;
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

}
