import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static int max = 0;

	static TreeMap<Float, Integer> mapBuild(String[] line) {
		max = 0;
		TreeMap<Float, Integer> map = new TreeMap<Float, Integer>();
		for (int i = 0; i < line.length; i++) {
			if (map.containsKey(Float.parseFloat(line[i]))) {
				map.computeIfPresent(Float.parseFloat(line[i]),(k, v) -> v + 1);
				if (max <  map.get(Float.parseFloat(line[i]))) {
					max = map.get(Float.parseFloat(line[i]));
				}
			}
			else {
				map.put(Float.parseFloat(line[i]),1);
			}
		}
		
		return map;
	}
	
	
	static int solution(int D, int N, TreeMap<Float, Integer> map) {
		Float middle = 0F;
		Iterator<Entry<Float, Integer>> it = map.entrySet().iterator();
		if (it.hasNext()) {
			it.next().getKey();
		}
		if (it.hasNext()) {
			middle = it.next().getKey();
		}
		if (max >= D) {
			return 0;
		}
		else if (map.size() == 1) {
			return D-1;
		} else if (map.size() == 2 && D == 2) {
			return 1;
		} else if (map.size() == 2 && D == 3) {
			if (map.lastKey() == map.firstKey()*2) {
				return 1;
			}
			else {
				return 2;
			}
		} else if (map.size() == 3 && D==2 ) {
			
			return 1;
		} else if (map.size() == 3 && D==3 ) {

			if (map.lastKey() == map.firstKey()*2 || middle == map.firstKey()*2 || map.lastKey() == middle*2 ) {
				return 1;
			}
			else {
				return 2;
			}
		}

		
		return 0;
	}

	public static void main(String[] args) {
		int T =  Integer.parseInt(in.nextLine());
		String[] line;
		String solution = "";
		int D, N;
		
		
		for (int i = 1; i <= T; i++) {
			line =in.nextLine().split("\\s+");
			D = Integer.parseInt(line[1]);
			N = Integer.parseInt(line[0]);
			line =in.nextLine().split("\\s+");
			int a = solution(D, N, mapBuild(line));
			System.out.println("Case #" + i + ": " + a);
			
		}
		
	}

}
