import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=input.nextInt();
		input.nextLine();
		for(int i=1; i<=num; i++) {
			String s=input.nextLine();
			String res=new String();
			int cur=0;
			for(int j=0; j<s.length(); j++) {
				int nextnum=Integer.parseInt(s.substring(j, j+1));
				while(cur!=nextnum) {
					if(cur<nextnum) {
						res=res+"(";
						cur++;
					}else {
						res=res+")";
						cur--;
					}
				}
				res=res+Integer.toString(nextnum);
			}
			while(cur>0) {
				res=res+")";
				cur--;
			}
			System.out.println("Case #"+i+": "+res);
		}
		
		
		input.close();
	}

}
