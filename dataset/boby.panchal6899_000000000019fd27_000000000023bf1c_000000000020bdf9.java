import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i=1; i<=cases; i++) {
			int n = sc.nextInt();
			List<List<Integer>> arr = new ArrayList<>();
			for(int j=0; j<n; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr.add(new ArrayList<Integer>(Arrays.asList(a, b)));
			}
			int c = 0;
			int j = 0;
			String newStr = "";
			boolean check = true;
			for(int a=0; a<arr.size(); a++) {
				if(c <= arr.get(a).get(0)) {
					c = arr.get(a).get(1);
					j -= c;
					newStr += "C";
				} else if(j <= arr.get(a).get(0)) {
					j = arr.get(a).get(1);
					c -= j;
					newStr += "J";
				} else {
					check = false;
					break;
				}
			}
			if(!check)
				newStr = "IMPOSSIBLE";
			System.out.println("Case #" + i + ": " + newStr);
		}
	}
}
