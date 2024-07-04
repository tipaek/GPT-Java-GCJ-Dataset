import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t = sc.nextInt();
		for(int i = 1;i<=t;i++) {
			int n = sc.nextInt();
			int[][]matrix = new int[n][n];
			for(int k = 0;k<n;k++) {
				for(int j = 0;j<n;j++) {
					matrix[k][j]=sc.nextInt();
				}
			}
			out.println("case"+" "+"#"+i+":"+" "+solvek(matrix)+" "+solver(matrix)+" "+solvec(matrix));
		}
		out.close();

	}
	public static int solvek (int[][]mat) {
		int sum = 0;
		for(int i = 0; i <mat.length;i++) {
			sum+=mat[i][i];	
		}
		return sum;
	}
	public static int solver (int[][]mat) {
		int sum = 0;
		for(int j = 0;j<mat.length;j++) {
		int[]arr= new int[mat.length];
		for(int i = 0; i <mat.length;i++) {
			arr[i]=mat[j][i];
		}
		Arrays.sort(arr);
		for(int k = 1;k<arr.length;k++) {
			if(arr[k]==arr[k-1]) {
				sum++;
				break;
			}
		}
		}
		return sum;
	}
	public static int solvec (int[][]mat) {
		int sum = 0;
		for(int j = 0;j<mat.length;j++) {
		int[]arr= new int[mat.length];
		for(int i = 0; i <mat.length;i++) {
			arr[i]=mat[i][j];
		}
		Arrays.sort(arr);
		for(int k = 1;k<arr.length;k++) {
			if(arr[k]==arr[k-1]) {
				sum++;
				break;
			}
		}
		}
		return sum;
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
