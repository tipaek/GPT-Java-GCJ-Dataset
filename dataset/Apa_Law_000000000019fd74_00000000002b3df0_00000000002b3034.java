import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			Integer n2 = Integer.parseInt(sc.nextLine());
			Map<Integer,String> mp = new HashMap<>();
			for(int i2 = 0;i2<n2;i2++) {
				String aux = sc.nextLine();
				mp.put(aux.length(),aux.replace("*", ""));
			}
			int p = 0;
			for(int x : mp.keySet()) {
				if( x>p ) p=x; 
			}
			String h = mp.get(p);
			boolean b = true;
			for(String sa: mp.values()) {
				if(!h.contains(sa)) {
					b=false;
					break;
				}
			}
			if(b==true) {
				System.out.println("Case #" + i + ": " + h);
			}else {
				System.out.println("Case #" + i + ": " + "*");
			}
		}
		sc.close();

	}
	

}