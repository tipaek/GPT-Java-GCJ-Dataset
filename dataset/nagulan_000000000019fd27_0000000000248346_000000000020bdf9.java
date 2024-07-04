import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		FastReader ob=new FastReader();
		int t,tt,i,j,n,min,flag,ec,ej,temp;
		t=ob.nextInt();
		tt=t;
		while(t-->0) {
			String ss="";
			n=ob.nextInt();
			int s[]=new int[n];
			int e[]=new int[n];
			for(i=0;i<n;i++)
			{
				s[i]=ob.nextInt();
				e[i]=ob.nextInt();
			}
			for(i=0;i<n;i++) {
				min=i;
				for(j=i+1;j<n;j++) {
					if(s[min]>s[j])
						min=j;
				}
				temp=s[min];
				s[min]=s[i];
				s[i]=temp;
				temp=e[min];
				e[min]=e[i];
				e[i]=temp;
			}
			ec=0;
			ej=0;
			flag=0;
			for(i=0;i<n;i++) {
				if(ec<=s[i])
				{
					ss+="C";
					ec=e[i];
				}
				else if(ej<=s[i])
				{
					ss+="J";
					ej=e[i];
				}
				else {
					flag=1;
					break;
				}
			}
			if(flag==1)
				System.out.println("Case #"+(tt-t)+": IMPOSSIBLE");
			else
				System.out.println("Case #"+(tt-t)+": "+ss);
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
