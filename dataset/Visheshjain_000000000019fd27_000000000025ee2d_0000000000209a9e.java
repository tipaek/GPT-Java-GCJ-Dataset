
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int count;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		int B = sc.nextInt();

		while (t-- > 0) {
			int[] ans = new int[B + 1];
			boolean td = true;
			boolean pal = true;
			int ind = -1;
			int dif_ind = -1;
			 count=1;
			for (int i = 1; i <= (B+1) / 2; i++) {
				if (count % 5 == 1 && count!=1) {
					change(ans, td, pal, ind , dif_ind);
					
				}
				count+=2;

				System.out.println(i);
				System.out.flush();
				int biti = sc.nextInt();
				//System.out.flush();

				System.out.println(B - i + 1);
				System.out.flush();
				int bitn = sc.nextInt();
				ans[i] = biti;
				ans[B - i + 1] = bitn;
				if (biti == bitn && td) {
					td = false;
				}
				if (biti != bitn && pal)
					pal = false;

				if (ind == -1 && biti == bitn)
					ind = i;
				
				if (dif_ind == -1 && biti != bitn)
					dif_ind = i;
				

			}
			String print = "";
			for(int val : ans)
				print+=val+"";
		
			System.out.println(print.substring(1));
			System.out.flush();
           String res = sc.next();
           if(res.equals("N"))
        	   break;
		}
	}

	private static void change(int[] ans, boolean td, boolean pal, int ind , int dif_ind) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		if (td || pal) {
			System.out.println(1);
			System.out.flush();
			count++;
			int first = sc.nextInt();
			if (first == ans[1]) {
				
			}
			else
			comp(ans);
		
		}
		else {
	count+=2;
			System.out.println(ind);
		System.out.flush();
		int val_ind = sc.nextInt();
		
		if(ans[ind] == val_ind) {
			System.out.println(dif_ind);
			System.out.flush();
			int diff = sc.nextInt();
			if(ans[dif_ind] == diff) {
				
			}else {
				reverse(ans);
			}
		}else {
			System.out.println(dif_ind);
			System.out.flush();
			int diff = sc.nextInt();
			if(ans[dif_ind] == diff) {
				comp(ans);
				reverse(ans);
			}else {
				comp(ans);
			}
		}
		}
	}

	public static void reverse(int[] ans) {

		for (int i = 1; i <= ans.length / 2; i++) {
			int temp = ans[i];
			ans[i] = ans[ans.length - i];
			ans[ans.length - i] = temp;
		}
	}

	public static void comp(int[] ans) {

		for (int i = 1; i <= ans.length / 2; i++) {
			ans[i] = ~ans[i] + 2;

		}
	}

}
