import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
	/* package codechef; // don't place package name! */
	public static HashSet<Character> glob;
	public static HashMap<Character, Character> res;
	public static Character mostFreq(ArrayList<Character> l) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(Character ch: l){
			map.put(ch, map.getOrDefault(ch,0)+1);
		}
		int freq = 0;
		char ans = l.get(0);
		for(Character ch: map.keySet()){
			if(freq<map.get(ch) ){
				freq=map.get(ch);
				ans = ch;
				glob.add(ch);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tt  =s.nextInt();
		for(int test=1; test<=tt; test++) {
			glob=new HashSet<>();
			res=new HashMap<>();
			HashMap<Character, ArrayList<Character>>map = new HashMap<>();
			map.put('0',new ArrayList<>());
			map.put('1',new ArrayList<>());
			map.put('2',new ArrayList<>());
			map.put('3',new ArrayList<>());
			map.put('4',new ArrayList<>());
			map.put('5',new ArrayList<>());
			map.put('6',new ArrayList<>());
			map.put('7',new ArrayList<>());
			map.put('8',new ArrayList<>());
			map.put('9',new ArrayList<>());
			int u = s.nextInt();
			int quer = 10000;
			while(quer-->0){
				int q = s.nextInt();
				String r = s.next();
				int len = r.length();
				int ten = (int)Math.pow(10,len-1);
				int val = 9*ten;
				int q2 = ten + new Random().nextInt(val);
				if(q==-1)
				q = 1+ new Random().nextInt(q);
				String one = Integer.toString(q).trim();
				if(one.length()!=r.length()) {
					q=-1;
				}
				String two  = Integer.toString(q2).trim();
				if(q!=-1){
					for(int i=0; i<one.length(); i++){
//						if(!res.containsKey(one.charAt(i))) {
//							res.put(one.charAt(i), r.charAt(i));
//							continue;
//						}
						ArrayList<Character> temp = map.get(one.charAt(i));
						temp.add(r.charAt(i));
						map.put(one.charAt(i), temp);
					}
				}else{
					
					for(int i=0; i<two.length(); i++){
//						if(!res.containsKey(two.charAt(i))) {
//							res.put(two.charAt(i), r.charAt(i));
//							continue;
//						}
						ArrayList<Character> temp = map.get(two.charAt(i));
						temp.add(r.charAt(i));
						map.put(two.charAt(i), temp);
					}
				}

			}
			String D = "";
			for(Character ch = '0'; ch<='9'; ch++){
//				if(res.containsKey(ch)) {
//					D+=res.get(ch);
//					continue;
//				}
				D+=mostFreq(map.get(ch));
			}
			System.out.println("Case #"+test+": "+D);
		}
	}
} 