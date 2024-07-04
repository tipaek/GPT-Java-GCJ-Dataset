import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Random;
import java.util.BitSet;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.AbstractMap;
import java.util.Objects;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;

public class Solution{

	public static class CharCounter implements Comparable<CharCounter>{
		
		public int count;
		public char c;
		
		public CharCounter(int count, char c){
			this.count = count;
			this.c = c;
		}
		
		@Override
		public int compareTo(CharCounter otherCharCounter){
			return Integer.compare(this.count, otherCharCounter.count)*(-1);
		}
		
		@Override
		public String toString(){
			return "count="+count+",c="+c;
		}
	}

	private static String solve(List<Integer> queries, List<String> responses){
		Map<Character, Integer> charCount = new HashMap<>();
		for(String response: responses){
			char c = response.charAt(0);
			if(charCount.containsKey(c)){
				charCount.put(c, charCount.get(c) + 1);
			} else {
				charCount.put(c, 1);
			}
		}
		List<CharCounter> charCounters = new ArrayList<>();
		for(Map.Entry<Character, Integer> entry: charCount.entrySet()){
			charCounters.add(new CharCounter(entry.getValue(), entry.getKey()));
		}
		Collections.sort(charCounters);
		StringBuilder sb = new StringBuilder(10);
		for(CharCounter charCounter: charCounters){
			sb.append(charCounter.c);
		}
		String oneToNine = sb.toString();
		for(String response: responses){
			char[] resChars = response.toCharArray();
			for(int i=0;i<resChars.length;i++){
				char c = resChars[i];
				if(!charCount.containsKey(c)){
					return c + oneToNine;
				}
			}
		}
		return "";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for(int t=1;t<=T;t++){
			int u = sc.nextInt();
			List<Integer> queries = new ArrayList<>();
			List<String> responses = new ArrayList<>();
			for(int i=0;i<10000;i++){
				queries.add(sc.nextInt());
				responses.add(sc.next());
			}
			String dictionary = solve(queries, responses);
			System.out.println("Case #" + t + ": " + dictionary);
		}
	}
}