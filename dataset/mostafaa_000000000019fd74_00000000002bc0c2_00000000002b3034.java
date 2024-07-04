import java.io.*;
import java.util.*;



public class Solution {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String prefix = "";
			String sufix = "";	
			String subs="";		
			String result = "";
			Boolean flag = true;
			for(int i = 0; i<N; i++){
				String line = br.readLine();
				if(flag){
					String prefixN;
					String sufixN;
					String[] parts = line.split("\\*");
					 prefixN = parts[0];
					 sufixN = parts[parts.length-1];
					if(line.charAt(0) == '*')
						prefixN = "";
					if(line.charAt(line.length()-1) == '*')
						sufixN = "";
					
					for(int j = 1; j<line.length()-1; j++){
						if(line.charAt(j) != '*')
						subs += line.charAt(j);
					}
					
					
					prefix = getPrefix(prefix, prefixN);
					sufix = getSuffix(sufix, sufixN);
					if(prefix  == null || sufix==null)
							
							flag=false;
					
					result = flag ? prefix + subs + sufix : "*";	
				}
				else
					result="*";
						
			}
			if(t==T-1)
			pw.print(String.format("Case #%d: %s", t+1, result));
			else
			pw.println(String.format("Case #%d: %s", t+1, result));
		}
		

		pw.flush();
		pw.close();
	}
	static String getPrefix(String a, String b){
		if (a.equals(b))
		return a;
		if((b.length() > a.length()) && (b.substring(0, a.length()).equals(a)))
			return b;
		
		else
		if((b.length() < a.length()) && (a.substring(0, b.length()).equals(b)))
			return a;
		else
		 return null;
	}
	static String getSuffix(String a, String b){
		if (a.equals(b))
		 return a;
		if((b.length() > a.length()) && (b.substring(b.length()-a.length()).equals(a)))
			return b;
		
		else
		if((b.length() < a.length()) && (a.substring(a.length()-b.length()).equals(b)))
			return a;
		else
		 return null;
	}

}