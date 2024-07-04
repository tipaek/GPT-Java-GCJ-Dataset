import java.util.*;
import java.io.*;

public class Solution
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas=1; cas<=T; cas++){
			long ll = io.getLong();
			long rr = io.getLong();
			long l =  Math.max(ll, rr);
			long r = Math.min(ll, rr);
			boolean inv = false;
			long diff = l - r;
			long n =  (long)((Math.sqrt(8*diff +1)-1)/2);
			long n0 = n+1;
			l-= n*(n+1)/2;
			diff = l - r;
			//io.println(l+" "+r+"  "+n);
			long tmp = bound(1000000000, n0, l);
			if(tmp<=0) tmp = 0;
			else{
				l -= n0*tmp + tmp*(tmp-1);
				r -= (n0+1)*(tmp) + tmp*(tmp-1);
			}
			
			n += tmp*2;
			//io.println(l+" "+r+"  "+n);
			while(l >= n+1 && r>= n+2){
				l-= n+1;
				r -= n+2;
				n+=2;
			}
			if(l >= n+1){
				l-= n+1;
				n++;
			}
			if(!inv)
				io.println("Case #"+cas+": "+n+" "+l+" "+r);
			else
				io.println("Case #"+cas+": "+n+" "+r+" "+l);
		}
		
		
        io.close();
    }
	
	
	static long bound(long high, long n, long l) //true: lower_bound, false: upper_bound
	{	
		long first = 1;
		long last = high;
		long mid;
		while (first < last) {
			mid = first + ((last - first) >> 1); 
			if (l - (n*mid + mid*(mid-1)) > 0) 
				first = mid + 1; 
			else 
				last = mid;
		}
		//io.println(first);
		return first-1;
	}
}



class IO extends PrintWriter {
	public IO() {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(System.in));
    }

    public IO(String fileName) {
        super(new BufferedOutputStream(System.out));
        try{
            r = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            this.println("File Not Found");
        }
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

	public String getLine(){
        try{
            st = null;
            return r.readLine();
        }
        catch(IOException ex){}
        return null;
    }
	

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
