import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.*;

class Tester {

	static class Print
	{
	    private final BufferedWriter bw;
	    public Print()
	    {
	        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
	    }
	    public void print(Object object)throws IOException
	    {
	        bw.append(""+object);
	    }
	    public void println(Object object)throws IOException
	    {
	        print(object);
	        bw.append("\n");
	    }
	    public void close()throws IOException
	    {
	        bw.close();
	    }
	}
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Vestigium();
		
	}

	private static void Vestigium() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int c = 1;
		while(c <= t) {
			
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			int trace = 0;
			for(int i=0; i<n; i++) {
				trace += a[i][i];
			}
			int nr = 0;
			for(int i=0; i<n; i++) {
				int count[] = new int[n+1];
				for(int j=0; j<n; j++) {
					int index = a[i][j];
					count[index]++;
					if(count[index] > 1)
					{
						nr++;
						break;
					}
				}
			}
			
			int nc = 0;
			for(int i=0; i<n; i++) {
				int count[] = new int[n+1];
				for(int j=0; j<n; j++) {
					int index = a[j][i];
					count[index]++;
					if(count[index] > 1)
					{
						nc++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+c+": "+trace+" "+nr+" "+nc);
			c++;
		}
	}

	
}

