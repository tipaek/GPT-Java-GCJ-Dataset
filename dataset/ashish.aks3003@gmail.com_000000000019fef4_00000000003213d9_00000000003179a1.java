import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int t = scan.nextInt();
		for(int i = 0; i<t; i++) {
			int u = scan.nextInt();
			Map<Character, Integer> aphabetMap = new HashMap<Character, Integer>();
			for(int j=0; j<10000; j++) {
				String M = scan.next();
				String code = scan.next();
				long num = Long.parseLong(M);
				if(num<0) 
					continue;
				else if(M.length()>code.length() && aphabetMap.size()==10) {
					continue;
				}else if(M.length()>code.length()) {
					for(int k=0; k<code.length() && aphabetMap.size()<10;k++) {
						if(!aphabetMap.containsKey(code.charAt(k))) {
							aphabetMap.put(code.charAt(k), -1);
						}
					}
				}else {
					int digit = M.charAt(0) - '0';
					char character = code.charAt(0);
					if(!aphabetMap.containsKey(character)) {
						aphabetMap.put(character, digit);
					}else {
						int presentLimit = aphabetMap.get(character);
						if(digit<presentLimit || presentLimit==-1)
							aphabetMap.put(character, digit);
					}
					for(int k=1; k<code.length() && aphabetMap.size()<10;k++) {
						if(!aphabetMap.containsKey(code.charAt(k))) {
							aphabetMap.put(code.charAt(k), -1);
						}
					}
				}
			}
			StringBuilder result = new StringBuilder("$$$$$$$$$$");
			ArrayList<Character> notFound = new ArrayList<Character>();
			for(char alphabet:aphabetMap.keySet()) {
				if(aphabetMap.get(alphabet)!=-1)
					result.setCharAt(aphabetMap.get(alphabet), alphabet);
				else {
					notFound.add(alphabet);
				}
			}
			if(notFound.size()>1) {
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}else if(notFound.size()==0) {
				System.out.println("Case #"+(i+1)+": "+result);
			}else {
				for(int j=0; j<10;j++) {
					if(result.charAt(j)=='$') {
						result.setCharAt(j,notFound.get(0));
						break;
					}
				}
				System.out.println("Case #"+(i+1)+": "+result);
			}
		}
		
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));			
		}
		
		String next(){
			while(st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
