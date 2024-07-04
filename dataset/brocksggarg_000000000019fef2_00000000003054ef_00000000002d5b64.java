import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			new Solution().solve(i, br);
		}
	}

	private void solve(int t, BufferedReader br) throws IOException {
		String in[] = br.readLine().split(" ");
		int x = Integer.parseInt(in[0]);
		int y = Integer.parseInt(in[1]);
		// ArrayList<Integer> l=new ArrayList<>();
		String l = "";
		for (int i = 1; i <= y; i++) {
			for (int j = 1; j <= x; j++) {
				l = l + j;
			}
		}
		int res=0;
		ArrayList<String> res2= new ArrayList<>();
		int h = x;
		int count = y;
		int len = l.length() - 1;
		int end2 = 0;
		int end1 = 0;
		while (true) {
			if(((int)l.charAt(len)-48)==h && count==y) {
				--count;
				continue;
			}
			for (int j = len; j >= 0; j--) {
				if (h == ((int) l.charAt(j) - 48)) {
					continue;
				} else {
					end2 = j;
					break;
				}
			}
			for (int j = end2; j >= 0; j--) {
				if (h == ((int) l.charAt(j) - 48)) {
					end1 = j;
					break;
				}
			}
			res=res+1;
			int r1=end1+1;
			int r2=end2-end1;
			res2.add(r1+" "+r2);
			//System.out.println(end1 + 1);
			//System.out.println(end2 - end1);
			String temp = l.substring(end1 + 1, end2 + 1) + l.substring(0, end1 + 1) + l.substring(end2 + 1);
			l = temp;
			--count;
			if (count == 0) {
				count = y;
				--h;
				len = len - y;
			}
			if (h == 1) {
				break;
			}
		}
		
		System.out.println("Case #"+t+": "+res);
		for(int i=0;i<res2.size();i++) {
			System.out.println(res2.get(i));
		}
	}

}
