import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			int n = s.nextInt();
			String[] arr = new String[n];
			for(int i=0;i<n;i++) {
				arr[i] = s.next();
			}
			StringBuilder sb = new StringBuilder();
			boolean flag = true;
			int j = 0;
			while(true) {
				TreeSet<Character> set = new TreeSet<>();
				for(int i=0;i<n;i++) {
					if(arr[i].length()-1-j>=0 && arr[i].charAt(arr[i].length()-1-j)=='*') {
						continue;
					}
					else if(arr[i].length()-1-j>=0){
						set.add(arr[i].charAt(arr[i].length()-1-j));
					}
				}
				if(set.size()>1) {
					flag = false;
					break;
				}
				else if(set.size()==1) {
					sb.append(set.first());
					j++;
				}
				else {
					break;
				}
			}
			String ans;
			if(flag) {
				ans = sb.reverse().toString();
			}
			else {
				ans = "*";
			}
			System.out.println("Case #"+ti+": "+ans);

		}
	}
}