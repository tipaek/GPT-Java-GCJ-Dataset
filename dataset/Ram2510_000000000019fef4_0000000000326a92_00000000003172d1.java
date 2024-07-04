import java.util.*;

public class Solution {
	
	public static int pancake(long a[],int d) {
		HashMap<Long,Integer> m = new HashMap<>();
		for(long i : a) 
		{
			if(m.containsKey(i)) {
				if(d == 2) return 0;
				m.put(i, m.get(i)+1);
				if(d == 3 && m.get(i) == 3) return 0;
			}
			else m.put(i, 1);
		}
		
		if(d == 2) return 1;
		for(long key : m.keySet()) {
			for(long k : m.keySet()) {
				if(k == 2*key)
					return 1;
			}
			if(m.get(key) == 2)
			{
				for(long k : m.keySet()) 
					if(k > key) return 1;
			}
		}
		return 2;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int qq=1;qq<=t;qq++) {
			int n = scn.nextInt(), d = scn.nextInt();
			long a[] = new long[n];
			
			for(int i=0;i<n;i++) {
				a[i] = scn.nextLong();
				
			}
			System.out.println("Case #" + qq + ": " + pancake(a,d));
		}
	}
}