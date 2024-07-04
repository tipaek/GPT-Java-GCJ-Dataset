import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int noOfTestCase = in.nextInt();
			for (int z = 0; z < noOfTestCase; z++) {
				int a = in.nextInt();
				int b = in.nextInt();
				String result = null;
				if(b%a>0)
					result = "IMPOSSIBLE";
				else
					result="POSSIBLE";
				int testCaseNo = z + 1;
				System.out.println("Case #" + testCaseNo+ ":" +" " +result);
			}
		}
		catch (Exception e) {
		} finally {
			in.close();
		}

	}

}
