import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> xs = new ArrayDeque<Integer>();
		ArrayDeque<Integer> ys = new ArrayDeque<Integer>();
		ArrayDeque<String> path = new ArrayDeque<String>();
		StringTokenizer st;
		for(int i = 0 ; i < T; i++) {
			xs.clear();
			ys.clear();
			path.clear();
			st = new StringTokenizer(br.readLine());
			int gx = Integer.parseInt(st.nextToken());
			int gy = Integer.parseInt(st.nextToken());
			if(Math.abs(gx+gy)%2==0) {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
				continue;
			}
			xs.add(0);
			ys.add(0);
			path.add("");
			while(true) {
				int currx = xs.pop();
				int curry = ys.pop();
				//System.out.println(currx+", "+curry);
				String currpath = path.pop();
				int jumpnum = currpath.length()+1;
				int moveby = (int) Math.pow(2, jumpnum-1);
				if(currx==gx&&curry==gy) {
					System.out.println("Case #"+(i+1)+": "+currpath);
					break;
				} else {
					xs.add(currx);
					ys.add(curry+moveby);
					path.add(currpath+"N");
					xs.add(currx);
					ys.add(curry-moveby);
					path.add(currpath+"S");
					xs.add(currx+moveby);
					ys.add(curry);
					path.add(currpath+"E");
					xs.add(currx-moveby);
					ys.add(curry);
					path.add(currpath+"W");
				}
			}
		}

	}

}
