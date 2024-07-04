import java.util.*;
import java.io.*;

public class Solution
{
    static IO io = new IO();
	static long x, y;
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas =1; cas<=T; cas++){
			x = io.getInt();
			y = io.getInt();
			long absX = Math.abs(x);
			long absY = Math.abs(y);
			char n,s,w,e;
			if(y == absY){
				n = 'N';
				s = 'S';
			}
			else{
				n = 'S';
				s = 'N';
			}
			if(x == absX){
				e = 'E';
				w = 'W';
			}
			else{
				e = 'W';
				w = 'E';
			}
			long next = getNextPowerOfTwo(Math.max(absX, absY)+1);
			//io.println("ne "+next);
			
			memo = new String[10][500][500];
			String tmp = solve(0,0,0);
			io.println("Case #"+cas+": "+((tmp == "#")? "IMPOSSIBLE" : tmp));
			
			if(T >  0)
				continue;
			String sol = "";
			if((absX^absY) == next-1){
				for(int i=0; i<32; i++){
					if((absX&(1<<i)) != 0)
						sol = sol + e;
					if((absY&(1<<i)) != 0)
						sol = sol + n;
				}
				io.println("Case #"+cas+": "+sol);
			}
			else if( ((next-absX)^absY) == next-1){
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
			else if( ((next-absY)^absX) == next-1){
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
				long rem = (next-1)-absX;
				long sum = 0;
				for(int i=31; i>=0; i--){
					if(((next-1)&(1<<i))==0)
						continue;
					if((rem&(1<<i))!=0){
						if(sum > absY){
							sum -= (1<<i);
							sol = s+sol;
						}
						else{
							sum += (1<<i);
							sol = n+sol;
						}
					}
					else{
						sol = e+sol;
					}
				}
				if(sum == absY){
					io.println("Case #"+cas+": "+sol);
				}
				else{
					
					rem = (next-1)-absY;
					 sum = 0;
					 sol = "";
					for(int i=31; i>=0; i--){
						if(((next-1)&(1<<i))==0)
							continue;
						if((rem&(1<<i))!=0){
							if(sum > absX){
								sum -= (1<<i);
								sol = w+sol;
							}
							else{
								sum += (1<<i);
								sol = e+sol;
							}
						}
						else{
							sol = n+sol;
						}
					}
					if(sum == absX){
						io.println("Case #"+cas+": "+sol);
					}
					else{
						io.println("Case #"+cas+": IMPOSSIBLE");
					}
					
					
				}
				
				
				
			}
			
			
			
			
			
		}
		
		
        io.close();
    }
	
	public static long getNextPowerOfTwo(long val) {
		val -= 1;
		for( int shift = 16; shift > 0; shift >>= 1) {
			val |= val >> shift;
		}
		return val + 1;
	}

	
	static String[][][] memo;
	static String solve(int pos, int mx, int my){
		//System.out.println(pos+" "+mx+" "+my);
		//System.out.println((mx==x)+" "+(my==y));
		if((mx == x) && (my == y)){
			//System.out.println("found");
			return "";
		}
		if(pos >= 8 )
			return "#";
		
		if(memo[pos][210+mx][210+my]!= null)
			return memo[pos][210+mx][210+my];
		
		String best = "#";
		String s = solve(pos+1, mx+(1<<pos), my);
		if(s != "#")
			best = "E"+s;
			//return memo[pos][210+mx][210+my]= "E"+s;
		s = solve(pos+1, mx-(1<<pos), my);
		if(s != "#" && (best == "#" || s.length() < best.length()))
			best = "W"+s;
			//return memo[pos][210+mx][210+my]="W"+s;
		s = solve(pos+1, mx, my+(1<<pos));
		if(s != "#" && (best == "#" || s.length() < best.length()))
			best = "N"+s;
			//return memo[pos][210+mx][210+my]="N"+s;
		s = solve(pos+1, mx, my-(1<<pos));
		if(s != "#" && (best == "#" || s.length() < best.length()))
			best = "S"+s;
			//return memo[pos][210+mx][210+my]="S"+s;
		return memo[pos][210+mx][210+my]=best;
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
