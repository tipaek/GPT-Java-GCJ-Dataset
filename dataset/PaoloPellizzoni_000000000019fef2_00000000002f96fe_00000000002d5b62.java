import java.util.*;
import java.io.*;

public class Solution
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas =1; cas<=T; cas++){
			int x = io.getInt();
			int y = io.getInt();
			int absX = Math.abs(x);
			int absY = Math.abs(y);
			char n,s,w,e;
			if(x == absX){
				n = 'N';
				s = 'S';
			}
			else{
				n = 'S';
				s = 'N';
			}
			if(y == absY){
				e = 'E';
				w = 'W';
			}
			else{
				e = 'W';
				w = 'E';
			}
			int next = getNextPowerOfTwo(Math.max(absX, absY)+1);
			//io.println("ne "+next);
			String sol = "";
			if((absX&absY) == 0){
				for(int i=0; i<32; i++){
					if((absX&(1<<i)) != 0)
						sol = sol + e;
					if((absY&(1<<i)) != 0)
						sol = sol + n;
				}
				io.println("Case #"+cas+": "+sol);
			}
			else if( ((next-absX)&absY) == 0){
				for(int i=0; i<32; i++){
					if( ((next-absX)&(1<<i)) != 0)
						sol = sol + w;
					if((absY&(1<<i)) != 0)
						sol = sol + n;
					if((next & (1<<i)) != 0)
						sol = sol + e;
				}
				io.println("Case #"+cas+": "+sol);
			}
			else if( ((next-absY)&absX) == 0){
				for(int i=0; i<32; i++){
					if( (absX&(1<<i)) != 0)
						sol = sol + e;
					if(((next-absY)&(1<<i)) != 0)
						sol = sol + s;
					if((next & (1<<i)) != 0)
						sol = sol + n;
				}
				io.println("Case #"+cas+": "+sol);
			}
			else{
				io.println("Case #"+cas+": IMPOSSIBLE");
			}
			
			
			
			
			
		}
		
		
        io.close();
    }
	
	public static int getNextPowerOfTwo(int val) {
		val -= 1;
		for( int shift = 16; shift > 0; shift >>= 1) {
			val |= val >> shift;
		}
		return val + 1;
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
