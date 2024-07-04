import java.util.*;
import java.io.*;
import java.math.*;

public class Solution
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int T = io.getInt();
		casel:
		for(int cas=1; cas<=T; cas++){
			int n = io.getInt();
			String[] s = new String[n];
			for(int i=0; i<n; i++)
				s[i] = io.getWord();
			String ans1 = "";
			String ans2 = "";
			boolean ok = true;
			int[] l = new int[n];
			int[] r = new int[n];
			for(int i=0; i<n; i++){
				while(s[i].charAt(l[i]) != '*'){
					if(l[i] < ans1.length())
					{
						if(s[i].charAt(l[i]) != ans1.charAt(l[i])){
							io.println("Case #"+cas+": *");
							continue casel;
						}
					}
					else{
						ans1 = ans1+s[i].charAt(l[i]);
					}
					l[i]++;
					
				}
				
				while(s[i].charAt(s[i].length()-1-r[i]) != '*'){
					if(r[i] < ans2.length())
					{
						if(s[i].charAt(s[i].length()-1-r[i]) != ans2.charAt(r[i])){
							io.println("Case #"+cas+": *");
							//System.out.println(ans2+" "+i+" "+r[i]);
							continue casel;
						}
					}
					else{
						ans2 = ans2+s[i].charAt(s[i].length()-1-r[i]);
					
					}
					r[i]++;
				}
			}
			StringBuilder sb = new StringBuilder(ans1);
			for(int i=0; i<n; i++){
				for(int j = l[i]; j<s[i].length()-1-r[i]; j++){
					if(s[i].charAt(j) != '*')
						sb.append(s[i].charAt(j));
				}
			}
			for(int i=ans2.length()-1; i>= 0; i--)
				sb.append(ans2.charAt(i));
			
			
			io.println("Case #"+cas+": "+sb.toString());
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
