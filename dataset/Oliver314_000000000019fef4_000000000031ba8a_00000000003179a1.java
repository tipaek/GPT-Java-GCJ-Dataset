import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			//int n = sc.nextInt();
			
			int U = sc.nextInt();

			//ArrayList<Long> qi = new ArrayList<Integer>();
			ArrayList<String> ri = new ArrayList<String>();
			HashMap<Character, Integer> riC = new HashMap<Character, Integer>();
			for(int j = 0; j < 10000; j++){
				sc.next();
				//qi.add(sc.nextInt());
				String resp = sc.next();
				ri.add(resp);
				if(resp.length()>U-1){
					char c = resp.charAt(0);
					if(riC.containsKey(c)){
						int csofar = riC.get(c);
						csofar++;
						riC.put(c, csofar);
					}else{
						riC.put(c, 1);
					}
				}
			}
			for(int j = 0; j < 10000 && riC.size()< 10; j++){
				char[] x = ri.get(j).toCharArray();
				for(char c: x){
					if(!riC.containsKey(c)){
						riC.put(c, 10000);
					}
				}
			}
			//System.out.println(riC);
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < 10; j++){
				int maxi = 0;
				char n = '-';
				for(char c: riC.keySet()){
					if(maxi < riC.get(c)){
						maxi = riC.get(c);
						n = c;
					}
				}
				sb.append(n);
				riC.remove(n);
			}
			System.out.println("Case #"+i+ ": " + sb.toString());
		}
		sc.close();
	}

}
