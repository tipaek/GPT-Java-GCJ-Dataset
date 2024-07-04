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
			String s = io.getWord();
			int min = 1000000000;
			for(int i=0; i<s.length(); i++){
				//io.println(i+": "+x+" "+y);
				if(Math.abs(x)+Math.abs(y) <= i){
					min = i;
					break;
				}
				if(s.charAt(i)=='N')
					y++;
				if(s.charAt(i)=='S')
					y--;
				if(s.charAt(i)=='W')
					x--;
				if(s.charAt(i)=='E')
					x++;
			}
			//io.println(": "+x+" "+y);
			if(min==1000000000 && Math.abs(x)+Math.abs(y) <= s.length())
				min = s.length();
			
			
			io.println("Case #"+cas+": "+((min<1000000000)?min:"IMPOSSIBLE"));
			
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
