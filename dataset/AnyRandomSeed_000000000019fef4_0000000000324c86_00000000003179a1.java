import java.io.*;
import java.util.*;

public class Solution{
		private static boolean testMode = false;
		
		public static void main(String[] args) {
			if (testMode)
				try {
					System.setIn(new FileInputStream(
							System.getProperty("user.dir")+"/src/"+"sample.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Scanner sc = new Scanner(new BufferedReader(
					new InputStreamReader(System.in)));
			int t = sc.nextInt();
			for (int i=1; i<=t; i++) {
				Solution inst = new Solution();
				sc.nextInt();
				String[] r = new String[10000];
				for (int j=0; j<10000; j++) {
					sc.nextInt();
					r[j] = sc.nextLine().trim();
				}
				System.out.println("Case #"+i+": "+inst.solve(r));
			}
			sc.close();
		}
		
		private String solve(String[] r) {
			HashMap<Character, Long> map = new HashMap<>();
			for (int i=0; i<r.length; i++) {
				for (int j=0; j<r[i].length(); j++) {
					map.put(r[i].charAt(j), map.getOrDefault(r[i].charAt(j), 0l)+1);
				}
			}
			char[] res = new char[10];
			long min = Long.MAX_VALUE;
			for (Map.Entry<Character, Long> e : map.entrySet()) {
				if (e.getValue()<min) {
					min = e.getValue();
					res[0] = e.getKey();
				}
			}
			map.remove(res[0]);
			for (int i=9; i>=1; i--) {
				min = Long.MAX_VALUE;
				for (Map.Entry<Character, Long> e : map.entrySet()) {
					if (e.getValue()<min) {
						min = e.getValue();
						res[i] = e.getKey();
					}
				}
				map.remove(res[i]);
			}
			return String.valueOf(res);
		}
		
		long count2sinRangeAtDigit(long number, long d, int dig)
		{
		    long entired = number/(d*10);
		    long rest = (number/d)%10;
		    if (rest==dig) return (entired*d+number%d+1);
		    else if (rest<dig) return entired*d;
		    else return (entired+1)*d;
		}
		/* Counts the number of '2' digits between 0 and n */
		long numberOfDigsinRange(long number, int dig)
		{
		    int d=1;
		    int sum=0;
		    long num = number;
		    while (num>0){
		        sum += count2sinRangeAtDigit(number, d, dig);
		        d *= 10;
		        num /= 10;
		    }
		    return sum;
		}
	}