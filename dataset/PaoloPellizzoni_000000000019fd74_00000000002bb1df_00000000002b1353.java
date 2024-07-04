import java.util.*;
import java.io.*;
import java.math.*;

public class Solution
{
    static IO io = new IO();
	static int[][] memo;
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas=1; cas<=T; cas++){
			int n = io.getInt();
			io.println("Case #"+cas+": ");
			io.println("1 1");
			if(n > 1){
				int r = 2; int c = 1;
				int num = 2;
				io.println(r+" "+c);
				n -= 2;
				while(n - num >= 0){
					r++; c++;
					io.println(r+" "+c);
					n -= num;
					//io.println(n);
					num++;
				}
				
				if(n > 0){
					r--;
					io.println(r+" "+c);
					n--;
					while(n > 0){
						r++; c++;
						io.println(r+" "+c);
						n--;
					}
				}
			}
			
			
		}
		
		
        io.close();
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
