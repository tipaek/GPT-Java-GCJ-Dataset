import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	InputStream in;
	PrintStream out;
	Scanner scanner;

	
	Solution(InputStream in, PrintStream out){
		this.in = in;
		this.out=out;
		scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
	}
	
	class Letter {
		long min;
		public Letter(long min, long max) {
			super();
			this.min = min;
			this.max = max;
		}
		long max;
	}
	
	long u;
	long[] q;
	String[] m;
	Map<Character,Letter> letters;
	
	private void readTest() {
		q = new long[10000];
		m = new String[10000];
		u = scanner.nextLong();
		letters = new HashMap<Character, Letter>();
		for(int i=0;i<10000;i++) {
			q[i]=scanner.nextLong();
			m[i]=scanner.nextLine().trim();
			for(int j=0;j<m[i].length();j++)
				letters.put(m[i].charAt(j),new Letter(0,10));
		}
	}

	private void setMin(Character c, long min) {
		Letter l = letters.get(c); 
		if (l.min < min)
			l.min = min;
	}
	
	private void setMax(Character c, long max) {
		Letter l = letters.get(c); 
		if (l.max > max)
			l.max = max;
	}

	private long left(long n) {
		while(n>10)
			n/=10;
		return n;
	}
	
	private long right(long n) {
		return n%10;
	}

	private void calculate() {
		for(int i=0;i<10000;i++) {
			if(q[i] != -1) {
				String s=String.valueOf(q[i]);
				if(s.length() == m[i].length()) {
					setMax(m[i].charAt(0), left(q[i]));
				}
			}else {
				setMin(m[i].charAt(0), 1);
			}
		}
			
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");
		
		if(q[0]!=-1) {
			for(int j=0;j<10;j++) {
				for(Map.Entry<Character,Letter> entry : letters.entrySet()) {
					if(entry.getValue().max == j){
						sb.append(entry.getKey());
						break;
					}
					if(entry.getValue().max == 10){
						sb.append(entry.getKey());
						entry.getValue().max = j;
						break;
					}
					
				}
			}
		}else {
			int j=0;
			for(Map.Entry<Character,Letter> entry : letters.entrySet()) {
				if(entry.getValue().min == 0){
					sb.append(entry.getKey());
					entry.getValue().max = 0;
					j++;
					break;
				}
			}
			
			for(;j<10;j++) {
				for(Map.Entry<Character,Letter> entry : letters.entrySet()) {
					if(entry.getValue().max == 10){
						sb.append(entry.getKey());
						entry.getValue().max = j;
						break;
					}
				}
			}
		}
		
		out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Solution(System.in, System.out).run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}