import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] l2 = {"","","12\n21\n","","21\n12"};
		String[] l3 = {"","","","123\n312\n231\n","","","123\n231\n312\n","","","312\n231\n123"};
		String[] l4 = {"","","","","1234\n2143\n3412\n4321\n","","1234\n2143\n4321\n3412\n","1234\n3142\n4321\n2413\n","1234\n4321\n3412\n2143\n","1234\n3421\n4312\n2143\n","1234\n3412\n2143\n4321\n","1234\n3421\n2143\n4312\n","2143\n3412\n4321\n1234\n","2413\n4321\n3142\n1234\n","3412\n4321\n2143\n1234\n","","4321\n3412\n2143\n1234"};
		String[] l5 = {"","","","","","12345\n21453\n45132\n53214\n34521\n","","21453\n12345\n45132\n53214\n34521\n","12345\n21453\n53214\n34521\n45132\n","12345\n21453\n45132\n34521\n53214\n","12345\n21453\n34521\n53214\n45132\n","12345\n53214\n45132\n21453\n34521\n","12345\n34521\n21453\n53214\n45132\n","12345\n34521\n53214\n45132\n21453\n","12345\n21453\n34521\n45132\n53214\n","12345\n34521\n45132\n21453\n53214\n","12345\n34521\n21453\n45132\n53214\n","34521\n45132\n53214\n12345\n21453\n","21453\n45132\n34521\n53214\n12345\n","45132\n53214\n34521\n12345\n21453\n","12345\n45132\n34521\n21453\n53214\n","53214\n34521\n21453\n45132\n12345\n","45132\n53214\n34521\n21453\n12345\n","45132\n54213\n31524\n23451\n12345\n","","53214\n45132\n34521\n21453\n12345"};
		
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalCase = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= totalCase; i++) {
			String[] in = sc.nextLine().split(" ");
			int size = Integer.parseInt(in[0]);
			int sum = Integer.parseInt(in[1]);
			
			String[] usel;
			if(size == 2) {
				usel=l2;				
			}else if (size==3) {
				usel=l3;
			}else if (size==4) {
				usel=l4;
			}else {
				usel=l5;
			}
			result.append(process(i, usel, sum));
		}
		System.out.print(result.toString());

	}
	
	public static String process(int c, String[] level, int sum) {
		StringBuilder result = new StringBuilder();
		result.append("Case #" + c + ": ");
		if (sum > level.length) {
			result.append("IMPOSSIBLE\n");
		}else {
			if(level[sum].equals("")) {
				result.append("IMPOSSIBLE\n");
			}else {
				String[] ans = level[sum].split("\n");
				result.append("POSSIBLE\n");
				for(int i =0 ; i< ans.length; i++) {
					for (int j = 0; j < ans[i].length(); j++) {
						result.append(ans[i].charAt(j));
						result.append(" ");
					}
					result.deleteCharAt(result.length()-1);
					result.append("\n");
				}
			}			
		}
		return result.toString();
	}

}
