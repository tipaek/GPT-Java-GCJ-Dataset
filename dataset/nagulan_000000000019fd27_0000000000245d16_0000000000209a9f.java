import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		FastReader ob=new FastReader();
		int t,tt,i,j,n;
		String s;
		t=ob.nextInt();
		tt=t;
		while(t-->0) {
			s=ob.next();
			n=s.length();
			int a[][]=new int[n][2];
			for(i=0;i<n;i++) {
				j=(int)s.charAt(i)-48;
				if(i==0) {
				a[i][0]=j;
				a[i][1]=j;
				}
				else
				{
					a[i][1]=j;
					if(a[i-1][1]>j)
					{
						a[i-1][1]-=j;
					}
					else {
						a[i][0]=j-a[i-1][1];
						a[i-1][1]=0;
					}
				}
			}
			System.out.print("Case #"+(tt-t)+": ");
			for(i=0;i<n;i++) {
				for(j=0;j<a[i][0];j++)
					System.out.print("(");
				System.out.print(s.charAt(i));
				for(j=0;j<a[i][1];j++)
					System.out.print(")");
			}
			System.out.println();
		}

	}
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

	float nextFloat() {
            return Float.parseFloat(next());
        }

	double nextDouble() {
            return Double.parseDouble(next());
        }
    }


}
