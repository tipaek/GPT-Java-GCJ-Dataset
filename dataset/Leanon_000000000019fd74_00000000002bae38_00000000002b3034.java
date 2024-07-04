import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner c = new Scanner(System.in);
		int t = c.nextInt();
		int cnt = 1;
		while (t>0) {
			int n = c.nextInt();
			c.nextLine();
			ArrayList<Character> match = new ArrayList<Character>();
			String[] patterns = new String[n];
			int max = 0, index = 0;
			for (int i=0;i<n;i++) {
				patterns[i]=c.nextLine();
				if (patterns[i].length()>max) {
					max=patterns[i].length();
					index = i;
				}
			}
			for (int i=patterns[index].length()-1;i>=0;i--) {
				match.add(patterns[index].charAt(i));
			}
			
			t--;
			boolean f = true;
			int i=0;
			for (i=0;i<n;i++) {
				if (i==index) {
					continue;
				}
				int k=0;
				for (int j=patterns[i].length()-1;j>=0;j--) {
					//System.out.println(match.get(k)+" "+patterns[i].charAt(j));
					if (match.get(k)==patterns[i].charAt(j)) {
						k++;
					}
					else {
						if (patterns[i].charAt(j)=='*') {
							if (j-1<0) {
								//System.out.println("3");
								break;
							}
							else {
								while (k<match.size()) {
									if (match.get(k)=='*' || match.get(k)==patterns[i].charAt(j+1)) {
										break;
									}k++;
								}
								f= false;
								//System.out.println("1");
								break;
							}
							
						}
						else if (match.get(k)=='*') {
							match.add(k, patterns[i].charAt(j));
						}
						else {
							f=false;
							//System.out.println("2");
							break;
						}
					}
				}
				
			}
			System.out.print("Case #"+cnt+": ");
			if (f) {
				for (int j=match.size()-1;j>=0;j--) {
					if (match.get(j)!='*') {
						System.out.print(match.get(j));
					}
				}
				System.out.println();
			}
			else {
				System.out.println('*');
			}
			cnt++;
			
		}
		
	}
}
