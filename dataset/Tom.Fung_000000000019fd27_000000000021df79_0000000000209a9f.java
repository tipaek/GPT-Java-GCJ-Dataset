import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalCase = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= totalCase; i++) {
			StringBuilder subResult = new StringBuilder();
			char[] in = sc.nextLine().toCharArray();
			int level = 0;
			//0=48 //9=59
			for(int j = 0; j < in.length; j++) {
				
				if(level < in[j]-48) {
					subResult.append(build((in[j]-48)-level));
					level = in[j]-48;					
				}else if (level > in[j]-48) {
					subResult.append(rBuild(level-(in[j]-48)));
					level = in[j]-48;
				}
				subResult.append(in[j]);
			}
			
			if (level!=0) {
				subResult.append(rBuild(level));				
			}

			result.append("Case #" + i + ": " + subResult.toString() + "\n");
		}
		System.out.print(result.toString());

	}
	
	public static String build(int times) {
		StringBuilder res = new StringBuilder();
		for (int i =0  ;i < times; i++) {
			res.append('(');
		}
		return res.toString();		
	}
	
	public static String rBuild(int times) {
		StringBuilder res = new StringBuilder();
		for (int i =0  ;i < times; i++) {
			res.append(')');
		}
		return res.toString();		
	}

}
