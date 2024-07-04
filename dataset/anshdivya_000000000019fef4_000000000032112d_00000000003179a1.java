import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int a=1;a<=t;a++) {
			int u = s.nextInt();
			
			HashSet<Integer>[] set = new HashSet[26];
			
			for(int i=0;i<26;i++)
				set[i] = new HashSet<>();
			int[] qi = new int[10000];
			String[] str = new String[10000];
			for(int i=0;i<10000;i++) {
				qi[i] = s.nextInt();
				str[i] = s.next();
				
				for(int j=0;j<str[i].length();j++) {
					int v = str[i].charAt(j) - 'A';
					
					if(set[v].size() == 0) {
						for(int k=0;k<10;k++)
							set[v].add(k);
					}
				}
			}
			
			for(int i=0;i<10000;i++) {
				if(qi[i] == -1)
					continue;
				else {
					if(countDigits(qi[i]) == str[i].length()) {
						int ch = str[i].charAt(0)-'A';
						for(int j=getFirst(qi[i]) + 1;j <10;j++) {
							set[ch].remove(j);
						}
							
					}
				}
			}
			int count = 0;
			boolean[] done = new boolean[26];
			while(count < 10) {
				for(int i=0;i<26;i++) {
					if(set[i].size()==0||set[i].size()>1 || done[i])
						continue;
					
					else { 
						done[i] = true;
						count++;
						int v = 0;
						
						for(Integer in: set[i])
							v = in;
						for(int j=0;j<26;j++) {
							if(j==i)
								continue;
							else {
								set[j].remove(v);
							}
						}
					}
				}
			}
			
			char[] D = new char[10];
			
			for(int i=0;i<26;i++) {
				for(Integer in: set[i]) {
					D[in] = (char)('A' + i);
				}
			}
			
			System.out.println("Case #"+a+": "+D);
		}

	}
	
	public static int countDigits(int val) {
		int count = 0;
		
		if(val == 0)
			return 1;
		while(val != 0) {
			val = val/10;
			count++;
		}
		
		return count;
			
	}
	
	public static int getFirst(int val) {
		String s = val + "";
		return s.charAt(0) - '0';
	}

}
