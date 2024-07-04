import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");
			
			int u = Integer.parseInt(br.readLine());
			
			a[] as = new a[10000];
			
			for(int i = 0; i < 10000; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				as[i] = new a(Integer.parseInt(st.nextToken()),st.nextToken());
			}
			
			Arrays.sort(as);
			
			int x = 1;
			int y = 2;
			
			HashSet<String> set = new HashSet<String>();
			
			String[] key = new String[10];
			
			for(int i = 0; i < 10000; i++) {
				
				int num = as[i].num;
				String str = as[i].str;
				
				if(num >= x*10 && num < y*10) {
					if(str.length() == 1) {
						set.add(str);
					}
					
					if(str.length() == 2) {
						String k = str.substring(0,1);
						set.add(str.substring(1,2));
						//System.out.println(k);
						boolean found = false;
						
						for(int j = 0; j < x; j++) {
							if(k.equals(key[j])) {
								found = true;
							}
						}
						
						if(!found) {
							key[x] = k;
							x++;
							y++;
						}
					}
				}		
			}
			
			for(Object o : set.toArray()) {
				boolean found = false;
				for(int i = 0; i < 10; i++) {
					if(o.equals(key[i])) {
						found = true;
					}
				}
				//System.out.println(o);
				if(!found) {
					key[0] = (String)o;
				}
			}
			
			for(String k : key) {
				System.out.print(k);
			}
		}
	}
	
	public static class a implements Comparable{
		int num;
		String str;
		
		public a(int n, String s) {
			num = n;
			str = s;
		}
		
		public int compareTo(Object o) {
			a c = (a) o;
			return num-c.num;
		}
		
		public String toString() {
			return num + " " + str;
		}
	}
}
