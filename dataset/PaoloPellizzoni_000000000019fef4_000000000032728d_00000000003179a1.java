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
			HashSet<Character> allch0 = new HashSet<>();
			HashMap<Character, Integer> cnt = new HashMap<>();
			int n = 10000;
			boolean rnd = false;
			for(int i=0; i<n; i++){
				long m = io.getLong();
				if(m == -1)
					rnd = true;
				String s = io.getWord();
				for(int j=0; allch.size()<10 && j<s.length(); j++){
					allch.add(s.charAt(j));
				}
				allch0.add(s.charAt(0));
				if(s.length() == 16){
					if(!cnt.containsKey(s.charAt(0)))
						cnt.put(s.charAt(0), 0);
					cnt.put(s.charAt(0), cnt.get(s.charAt(0))+1);
				}
				/*
				for(int j=0;j<s.length(); j++){
					if(!cnt.containsKey(s.charAt(j)))
						cnt.put(s.charAt(j), 0);
					cnt.put(s.charAt(j), cnt.get(s.charAt(j))+1);
				}
				*/
				if(!map.containsKey(m))
					map.put(m, new ArrayList<String>());
				map.get(m).add(s);
			}
			if(!rnd){
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
			else{
				String ans = "";
				for(Character cc : allch){
					if(!allch0.contains(cc)){
						ans+=cc;
						cnt.put(cc, -1);
						break;
					}
				}
				for(int dd = 1; dd<10; dd++){
					int max = -1;
					char maxi ='-';
					for(Character cc : cnt.keySet()){
						if(cnt.get(cc) > max){
							max = cnt.get(cc);
							maxi = cc;
						}
					}
					ans+=maxi;
					cnt.put(maxi, -1);
				}
				
				
				io.println("Case #"+cas+": "+ans);
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
