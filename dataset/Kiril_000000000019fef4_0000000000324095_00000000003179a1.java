
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final InputStream is;
		if (args.length == 0) {
			is = System.in;
		} else {
			is = new FileInputStream(args[0]);
		}
		final Scanner s = new Scanner(new BufferedInputStream(is));
		final PrintStream pw = System.out;
		final int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			pw.print("Case #");
			pw.print(i);
			pw.print(": ");
			solution(s, pw);
		}
		pw.flush();
	}

	private static void solution(Scanner s, PrintStream pw) {
		int u = s.nextInt();
		long upper = (long) Math.pow(10, u); // exclusive for me
		Map<String, List<Long>> result = new HashMap<>();
		Map<Long, List<String>> requests = new HashMap<>();
		for (int i = 0; i < 10_000; i++) {
			long q = s.nextLong();
			String r = s.next();
			requests.compute(q, (k, v) -> {
				if (v == null) {
					v = new ArrayList<String>();
				}
				v.add(r);
				return v;
			});
			if (q != -1) {
				result.compute(r, (k, v) -> {
					if (v == null) {
						v = new ArrayList<Long>();
					}
					v.add(q);
					return v;
				});
			}
		}
		Set<Character> set = new HashSet<>();
		char[] d = new char[10];
		for (Map.Entry<String, List<Long>> e : result.entrySet()) {
			long min = Long.MAX_VALUE;
			long max = Long.MIN_VALUE;
			for (Long n : e.getValue()) {
				min = Math.min(min, n);
				max = Math.max(max, n);
			}
			for(char ch : e.getKey().toCharArray()) {
				set.add(ch);
			}
			if(min < 10) {
				d[(int) min] = e.getKey().charAt(0);
			}
//			Case #1: TPFOXLUSHB
//			          PFOXLUSHB
		}
		
		for(char ch : d) {
			set.remove(ch);
		}
		
		LinkedList<Character> stack = new LinkedList<>(set);
		test(d, stack, requests, pw);
		
//		System.out.println(new String(d));
//		System.out.println(set);
	}

	private static boolean test(char[] d, LinkedList<Character> stack, Map<Long, List<String>> requests, PrintStream pw) {
//		char[] t = new char[10];
		if(stack.isEmpty()) {
			if(verify(d, requests)) {
				pw.println(new String(d));
			}
			return false; 
		}
		 
		for(int i = 0; i < d.length; i++) {
			if(d[i] == 0) {
				d[i] = stack.poll(); 
				
				if(test(d, stack, requests, pw)) {
					return true;
				}
				
				stack.add(d[i]); 
			}			
		}
		
		return false;
	}

	private static boolean verify(char[] d, Map<Long, List<String>> requests) {
		Map<Character, Integer> mm = new HashMap<>();
		for(int i = 0; i < d.length; i++) {
			mm.put(d[i], i);
		}
		for(Map.Entry<Long, List<String>>  e : requests.entrySet()) {
			for(String l : e.getValue()) {
				if(num(l, mm) > e.getKey()) {
					return false;
				}
			}
		}
		return true;
	}

	private static long num(String l, Map<Character, Integer> mm) {
		long r = 0;
		for(int i = 0; i < l.length(); i++) {
			r = r * 10 + mm.get(l.charAt(i));
		}
		return r;
	}

}
