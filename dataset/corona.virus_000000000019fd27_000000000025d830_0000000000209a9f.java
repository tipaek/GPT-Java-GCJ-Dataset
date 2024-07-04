import java.io.*;
public class Solution{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int sc=1;
		while(T-->0){
		    String str = br.readLine();
		    bw.append("Case #"+(sc++)+": "+solve(str));
		    if(T>0) bw.append("\n");
		}
		bw.close();
    }
    
     private static String solve(String str){
    	int nr_b=0;
    	StringBuilder sb = new StringBuilder();
    	for(char c : str.toCharArray()) {
    		int rem=Character.getNumericValue(c)-nr_b;
    		while(rem>0) {
    			sb.append("(");
    			rem--;
    		}
    		while(rem<0) {
    			sb.append(")");
    			rem++;
    		}
    		sb.append(c);
    		nr_b = Character.getNumericValue(c);
    	}
    	while(nr_b>0) {
			sb.append(")");
			nr_b--;
		}
        return sb.toString();
    }
}