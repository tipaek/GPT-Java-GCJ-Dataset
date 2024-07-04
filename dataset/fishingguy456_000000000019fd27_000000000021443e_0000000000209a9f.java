import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			String s = sc.next();
			int p = s.length();
			String add = "";
			for(int j = 0; j < (int)s.charAt(0)-48; j++) {
				add+="(";
			}
			s = add+s;
			for(int j = add.length()+1; j < s.length(); j++) {
				int dif = (int)s.charAt(j)-(int)s.charAt(j-1);
				//System.out.println(s.charAt(j)+" "+s.charAt(j-1)+" "+dif);
				if(dif<0) {//add close brackets
					String addclose = "";
					for(int k = 0; k < Math.abs(dif); k++) {
						addclose+=")";
					}s = s.substring(0, j)+addclose+s.substring(j);
				}else if(dif>0){
					String addopen = "";
					for(int k = 0; k < dif; k++) {
						addopen+="(";
					}s = s.substring(0, j)+addopen+s.substring(j);
				}j+=Math.abs(dif);
			}String end = "";
			for(int j = 0; j < s.charAt(s.length()-1)-48; j++) {
				end+=")";
			}
			System.out.println("Case #"+(i+1)+": "+s+end);
		}
	}

}
