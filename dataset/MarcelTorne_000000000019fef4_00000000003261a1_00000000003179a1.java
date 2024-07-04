
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) {
		
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			int u = in.nextInt();
			String sol =  findSol();
			System.out.println("Case #"+i+": "+sol);
		}
	}
	static String findSol() {
		TreeMap<Character,Integer> map = new TreeMap<>();
		TreeSet<Character> all = new TreeSet<>();
		for(long i =0; i<Math.pow(10, 4);++i) {
			int value = in.nextInt();
			String letter = in.next();
			for(int j = 0; j<letter.length();++j) {
				all.add(letter.charAt(j));
			}
			if(letter.length()==1) {
				char l = letter.charAt(0);
				if(map.containsKey(l)) {
					if(map.get(l)>value) {
						map.put(l, value);
					}
				}else {
					map.put(l, value);
				}
			}
		}
		System.out.println(map);
		char[] tab = new char[10];
		for(Map.Entry<Character,Integer> e: map.entrySet()) {
			
				tab[e.getValue()]=e.getKey();
				all.remove(e.getKey());
			
		}
		if(!all.isEmpty()) {
			tab[0]=all.first();
		}
		String sol = "";
		for(int j = 0; j<tab.length;++j) {
			sol = sol + tab[j];
		}
		return sol;
	}
	
}
