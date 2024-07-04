import java.util.*;
public class Solution {
	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			long dest_x = sc.nextLong();
			long dest_y = sc.nextLong();
			String val = "";
			int pow = 0;
			String result = expogo(0, 0, dest_x, dest_y, val, pow);
			System.out.println("Case #"+i+": "+result);
		}
	}

	private static String expogo(int curr_x, int curr_y, long dest_x, long dest_y, String val, int pow) {
		int pos = (int)Math.pow(2, pow);
		if((curr_x==dest_x) && (curr_y==dest_y))
			return val;
		if((Math.abs(curr_x)>Math.abs(dest_x)) || (Math.abs(curr_y)>Math.abs(dest_y)))
			return "IMPOSSIBLE";
		String s1 = expogo(curr_x+pos, curr_y, dest_x, dest_y, val+"E", pow+1);
		String s2 = expogo(curr_x-pos, curr_y, dest_x, dest_y, val+"W", pow+1);
		String s3 = expogo(curr_x, curr_y+pos, dest_x, dest_y, val+"N", pow+1);
		String s4 = expogo(curr_x, curr_y-pos, dest_x, dest_y, val+"S", pow+1);
		if(s1.equals("IMPOSSIBLE") && s2.equals("IMPOSSIBLE") && s3.equals("IMPOSSIBLE") && s4.equals("IMPOSSIBLE"))
			return "IMPOSSIBLE";
		return Minimum(s1,s2,s3,s4);
	}

	private static String Minimum(String s1, String s2, String s3, String s4) {
		int min = Integer.MAX_VALUE;
		String result = "";
		ArrayList<String> val = new ArrayList<String>();
		val.add(s1);
		val.add(s2);
		val.add(s3);
		val.add(s4);
		for(int i=0;i<val.size();i++) {
			if(!val.get(i).equals("IMPOSSIBLE") && min>val.get(i).length()) {
				result = val.get(i);
				min = val.get(i).length();
			}
				
		}
		return result;
	}

}
