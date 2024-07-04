import java.util.*;
import java.io.*;

public class Solution
{
    static IO io = new IO();
    public static void main(String[] args)
    {
		int T = io.getInt();
		for(int cas =1; cas<=T; cas++){
			int U = io.getInt();
			TreeMap<Long, ArrayList<String>> map = new TreeMap<>();
			HashSet<Character> allch = new HashSet<>();
			int n = 10000;
			for(int i=0; i<n; i++){
				long m = io.getLong();
				String s = io.getWord();
				for(int j=0; allch.size()<10 && j<s.length(); j++){
					allch.add(s.charAt(j));
				}
				if(!map.containsKey(m))
					map.put(m, new ArrayList<String>());
				map.get(m).add(s);
			}
			char[] digits = new char[10];
			HashSet<Character> charset = new HashSet<>();
			digloop:
			for(int digTof = 1; digTof <10; digTof++){
				for(int l = 2; l<=U; l++){
					long low = digTof*(long)Math.pow(10, l-1);
					long high = (digTof+1)*(long)Math.pow(10, l-1);
					SortedMap<Long, ArrayList<String>> sm = map.subMap(low, high);
					for(ArrayList<String> list : sm.values()){
						for(String ss : list){
							if(ss.length()==l && !charset.contains(ss.charAt(0))){
								digits[digTof] = ss.charAt(0);
								charset.add(ss.charAt(0));
								continue digloop;
							}
						}
					}
				}
			}
			
			for(Character cc : allch){
				if(!charset.contains(cc))
					digits[0] = cc;
			}
			String ans = "";
			for(Character cc : digits)
				ans += cc;
			
			io.println("Case #"+cas+": "+ans);
			
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
