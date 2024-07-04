import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		FastReader ob=new FastReader();
		int t,e,i,j,sum,nc,nr,n,tt;
		t=ob.nextInt();
		tt=t;
		while(t-->0) {
			n=ob.nextInt();
			int fr[]=new int[n];
			int fc[]=new int[n];
			int r[][]=new int[n][n];
			int c[][]=new int[n][n];
			sum=0;
			nc=0;
			nr=0;
			for(i=0;i<n;i++) {
				for(j=0;j<n;j++)
				{
					e=ob.nextInt();
					if(i==j)
						sum+=e;
					if(fr[i]==0) {
						if(r[i][e-1]==0)
							r[i][e-1]+=1;
						else {
							nr+=1;
							fr[i]=1;
						}
					}
					if(fc[j]==0) {
						if(c[e-1][j]==0)
							c[e-1][j]+=1;
						else {
							nc+=1;
							fc[j]=1;
						}
					}
				}
			}
			System.out.println("Case #"+(tt-t)+": "+sum+" "+nr+" "+nc);
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
