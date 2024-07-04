import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int i = 0; i < T; i++) {
			String s = in.nextLine();
			int [] c = new int[s.length()];
			for (int j = 0; j < s.length(); j++) {
				c[j]=Integer.parseInt(s.charAt(j)+"");
			}
			
			int act=0;
			String sol ="";
			for (int j = 0; j < c.length; j++) {
				sol = sol + addP(act,c[j])+c[j];
				act=c[j];
			}
			sol=sol+addP(act,0);
			System.out.println("Case #"+(i+1)+": "+sol);
		}

	}

	public static String addP(int act, int i) {
		String ret="";
		if(act<i){
			for (int j = 0; j < i-act; j++) {
				ret= ret+"(";
			}
			
		}else{
			for (int j = 0; j < act-i; j++) {
				ret= ret+")";
			}
		}
		return ret;
	}

}