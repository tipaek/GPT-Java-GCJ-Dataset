import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Solution {

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			int[][] arrival = new int[n][2];
			for (int j = 0; j < n; j++) {
				arrival[j][0] = sc.nextInt();
				arrival[j][1] = sc.nextInt();
			}

			Arrays.sort(arrival, new Comparator<int[]>() {

				public int compare(int[] x, int[] y) {
					return x[0] - y[0];
				};
			});

		//	System.out.println(Arrays.deepToString(arrival));
			Stack<int[]> jack = new Stack<>();

			Stack<int[]> carr = new Stack<>();
			String ans = "";
			for (int j = 0; j < arrival.length; j++) {
				if (jack.size() == 0) {
					jack.push(arrival[j]);
					ans += "J";

				} else {
					boolean b1 = checkwithStack(arrival[j], jack);
					 
					boolean b2 = checkwithStack(arrival[j], carr);
					if (b1 == false && b2 == false) {
						ans = "IMPOSSIBLE";
						break;
					}
					  ans+=b1==true?"J":"C";

				}
			}
			System.out.print("Case #");
			System.out.print((i + 1) + ": ");
			System.out.print(ans);
			System.out.println();

		}
		sc.close();
	}

	private static boolean checkwithStack(int[] is, Stack<int[]> jack) {
		  
		if(jack.size()==0)
		{
			jack.push(is);
			return true;
		}
		
		int[] arr=jack.peek();
		if(arr[1]<=is[0])
		{
			jack.pop();
			jack.push(is);
			return true;
			
		}
		return false;
	}
}
