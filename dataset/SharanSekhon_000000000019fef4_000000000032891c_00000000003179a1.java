import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
	public static void input(HashMap<Integer, HashMap<String, Integer>> hp,int u) {
		Scanner sf = new Scanner(System.in);
		StringBuilder ans = new StringBuilder(new Integer(10));
		for (int i = 0; i < 10; i++) {
			ans.append("0");
		}
		int counter = 0;
		while(counter<10001) {
			int n = sf.nextInt();
			counter++;
			String s1 = sf.next();
			if(hp.containsKey(n)) {
				if(!hp.get(n).containsKey(s1)) {
					hp.get(n).put(s1, 1);
				}
			}
			else {
				hp.put(n, new HashMap<String, Integer>());
				hp.get(n).put(s1, 1);
			}
			System.out.println(counter);
		}
		int i = 1;
		int decrementer = 1;
		while(i<10) {
			if(hp.get(i).size()==1) {
				decrementer =1;
				ans.replace(i,i+1, hp.get(i).keySet().iterator().next());
				i++;
			}
			else {
				int j = i-decrementer;
				
				for(String keys : hp.get(j).keySet()) {
					hp.get(i).remove(keys);
				}
				decrementer++;
			}
		}
		HashSet<String> hs = new HashSet<String>();
		for (int j = 0; j < ans.length(); j++) {
			hs.add(ans.substring(j,j+1));
		}
		while(i<10001) {
			if(hp.containsKey(i)) {
				for(String keys : hp.get(i).keySet()) {
					for(String temp : keys.split("")) {
						if(!hs.contains(temp)) {
							ans.replace(0, 1, temp);
						}
					}
				}
			}
			i++;
		}
		System.out.println("Case #"+u+": "+ans);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for (int i = 1; i <=test; i++) {
			int u = s.nextInt();
			HashMap<Integer, HashMap<String, Integer>> hp = new HashMap<Integer, HashMap<String,Integer>>();
			input(hp,i);
		}
		s.close();
	}

}
