import java.util.*;
import java.io.*;

public class Solution
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int T = io.getInt();
		out:
		for(int cas =1; cas<=T; cas++){
			int n = io.getInt();
			int d = io.getInt();
			long[] a = new long[n];
			HashMap<Long, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++){
				a[i] = io.getLong();
				if(!map.containsKey(a[i]))
					map.put(a[i], 1);
				else
					map.put(a[i], map.get(a[i])+1);
			}
			int ans = n;
			if(d == 2){
				for(Integer ii : map.values()){
					if(ii > 1)
					{
						io.println("Case #"+cas+": 0");
						continue out;
					}
				}
				io.println("Case #"+cas+": 1");
			}
			if(d == 3){
				for(Integer ii : map.values()){
					if(ii > 2)
					{
						io.println("Case #"+cas+": 0");
						continue out;
					}
				}
				for(Long ii : a){
					if(map.containsKey(2*ii)){
						io.println("Case #"+cas+": 1");
						continue out;
					}
				}
				
				io.println("Case #"+cas+": 2");
				
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
