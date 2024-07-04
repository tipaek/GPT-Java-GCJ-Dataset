
import java.util.*;
import java.io.*;

public class Solution {
	static String a="";
	Scanner scanner;
	public String run(Scanner scanner) {
		int U = scanner.nextInt();
		Hashtable<String,Integer> numbers = new Hashtable<String,Integer>();
		int maxQ = 0;
		for (int i=0;i<10000;i++) {
			int q=scanner.nextInt();
			String s = scanner.next();
			maxQ = Math.max(maxQ,q);
			if (numbers.get(s)!=null){
				numbers.put(s,Math.min(numbers.get(s), q));
			}
			else numbers.put(s,q);
		}
		char[] ans = new char[10];
		Hashtable<Integer,String> n = new Hashtable<Integer,String>();
		for (String i: numbers.keySet()) {
			n.put(numbers.get(i),i);
		}
		for (int i=1;i<maxQ;i++) {
			if (i<10) {
				ans[i]=(n.get(i).charAt(0));
			}
			if (i==10) {
				ans[0]=n.get(i).charAt(1);
			}
		}
		for (int i=0;i<10;i++) {
			a+=ans[i];
		}
		return ans.toString();
	}
	public static void main(String[]args){
		final String inputFileName = "input.in";
		File inputFile = new File(inputFileName);
		Scanner scanner=null;
		try {
			scanner = new Scanner(inputFile);
		}catch(Exception e) {
			System.out.println("No file");
		}
		int t = scanner.nextInt();
		for (int i=1;i<=t;i++) {
			A3B ta = new A3B();
			ta.run(scanner);
			
			System.out.println("Case #"+i+": "+ta.a);		
		}
	}
}
