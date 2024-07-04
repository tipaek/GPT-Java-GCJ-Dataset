import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test = sf.nextInt();
		for (int k = 1; k <= test; k++) {
			String s1 = sf.next();
			int init = 0;
			int curr = 0;
			int end = 0;
			String ans = "";
			for (int i = 0; i < s1.length()+1; i++) {
				if(i!=s1.length()) {
					curr = Integer.parseInt(s1.substring(i,i+1));
					
					if(curr>init) {
						while(curr!=init) {
							ans = ans+"(";
							curr--;
						}
					}
					else if(curr<init) {
						while(curr!=init) {
							ans = ans + ")";
							curr++;
						}
					}
					ans = ans + s1.substring(i,i+1);
					init = Integer.parseInt(s1.substring(i,i+1));
				}
				else {				
					if(init>end) {
						while(init!=end) {
							ans = ans+")";
							init--;
						}
					}
					else if(init<end) {
						while(end!=init) {
							ans = ans + "(";
							init++;
						}
					}
				}
			}
			System.out.println("Case #"+k+": "+ans);
		}
		sf.close();
	}

}
