import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++) {
			String[] str = stdReader.readLine().split(" ");
			int GX = Integer.parseInt(str[0]);
			int GY = Integer.parseInt(str[1]);
			Queue<String> q = new LinkedList<String>();
			q.add("0,0,0,A");
			String WAY = "";
			while(!q.isEmpty()) {
				str = q.poll().split(",");
				long X = Long.parseLong(str[0]);
				long Y = Long.parseLong(str[1]);
				int turn = Integer.parseInt(str[2]);
				String wa = str[3];
				if(X == GX && Y == GY) {
					WAY = wa;
					break;
				}else {
					long l = (long)Math.pow(2, turn);
					if(turn <= 8) {
						q.add((X + l)+","+Y+","+(turn + 1)+","+(wa + "E"));
						q.add((X - l)+","+Y+","+(turn + 1)+","+(wa + "W"));
						q.add(X+","+(Y + l)+","+(turn + 1)+","+(wa + "N"));
						q.add(X+","+(Y - l)+","+(turn + 1)+","+(wa + "S"));
					}
				}
			}
			if(!WAY.equals("")) {
				System.out.println("Case #"+(i+1)+": "+WAY.substring(1,WAY.length()));
			}else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
		stdReader.close();
	}
}