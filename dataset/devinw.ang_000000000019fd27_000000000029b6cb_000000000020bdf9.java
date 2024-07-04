import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t = sc.nextInt();
		for(int i = 1;i<=t;i++) {
			int num = sc.nextInt();
			int[][]matrix = new int[num][2];
			for(int k = 0;k<num;k++) {
				for(int j = 0;j<2;j++) {
					matrix[k][j]=sc.nextInt();
				}
			}
			out.println("case"+" "+"#"+i+":"+" "+solve(matrix,num));
		}
		out.close();
	}
	public static String solve(int[][]mat,int n) {
		ArrayList<Integer>cmin = new ArrayList<Integer>();
		ArrayList<Integer>cmax = new ArrayList<Integer>();
		ArrayList<Integer>jmin = new ArrayList<Integer>();
		ArrayList<Integer>jmax = new ArrayList<Integer>();
		String str = "";
		cmin.add(mat[0][0]);
		cmax.add(mat[0][1]);
		str+="C";
		for(int i=1;i<n;i++) {
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
			System.out.println(jmax);*/
		}
		return str;
	}
	public static Boolean works(int[]arr,ArrayList<Integer>min,ArrayList<Integer>max) {
		for(int i = 0;i<min.size();i++) {
			if(arr[0]>min.get(i)&&arr[0]<max.get(i)) {
				return false;
			}
			if(arr[1]>min.get(i)&&arr[1]<max.get(i)) {
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

}
