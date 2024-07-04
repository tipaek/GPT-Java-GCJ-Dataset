import java.io.*;
import java.util.*;

public class Solution {

    public static void solve(BufferedReader in, int tcase) throws Exception {
	StringTokenizer st = new StringTokenizer(in.readLine());
	StringBuilder sb = new StringBuilder("");
	int x = Integer.parseInt(st.nextToken());
	int y = Integer.parseInt(st.nextToken());
	while (true) {
	    boolean xodd = Math.abs(x - 1) % 2 == 0;
	    boolean yodd = Math.abs(y - 1) % 2 == 0;
//	    System.out.println(x+" "+y);
//	    Thread.sleep(500);
	    if (x == 0 && y == 0) {
		System.out.println("Case #" + tcase + ": " + sb.toString());
		return;
	    }
	    if (xodd ^ yodd) {
		if(x==0) {
		    if(y%2==0) {
			break;
		    }
		    if(y<0) {
			y+=1;
			y/=2;
			sb.append("S");
			continue;
		    }else {
			y-=1;
			y/=2;
			sb.append("N");
			continue;
		    }
		}
		if(y==0) {
		    if(x%2==0) {
			break;
		    }
		    if(x<0) {
			x+=1;
			x/=2;
			sb.append("W");
			continue;
		    }else {
			x-=1;
			x/=2;
			sb.append("E");
			continue;
		    }
		}
		if (xodd) {
		    int x2 = (x - 1) / 2;
		    int y2 = y / 2;
		    boolean x2odd = Math.abs(x2 - 1) % 2 == 0;
		    boolean y2odd = Math.abs(y2 - 1) % 2 == 0;
		    if (x2odd ^ y2odd||(x2==0&&y2==0)) {
			sb.append("E");
			x=x2;
			y=y2;
			continue;
		    }
		    x2 = (x + 1) / 2;
		    y2 = y / 2;
		    x2odd = Math.abs(x2 - 1) % 2 == 0;
		    y2odd = Math.abs(y2 - 1) % 2 == 0;
		    if (x2odd ^ y2odd||(x2==0&&y2==0)) {
			sb.append("W");
			x=x2;
			y=y2;
			continue;
		    }
		    break;
		} else {
		    int x2 = x / 2;
		    int y2 = (y - 1) / 2;
		    boolean x2odd = Math.abs(x2 - 1) % 2 == 0;
		    boolean y2odd = Math.abs(y2 - 1) % 2 == 0;
		    if (x2odd ^ y2odd||(x2==0&&y2==0)) {
			sb.append("N");
			x=x2;
			y=y2;
			continue;
		    }
		    x2 = x / 2;
		    y2 = (y + 1) / 2;
		    x2odd = Math.abs(x2 - 1) % 2 == 0;
		    y2odd = Math.abs(y2 - 1) % 2 == 0;
		    if (x2odd ^ y2odd||(x2==0&&y2==0)) {
			sb.append("S");
			x=x2;
			y=y2;
			continue;
		    }
		    break;
		}
	    } else {
		break;
	    }
	}
	System.out.println("Case #" + tcase + ": IMPOSSIBLE");
    }

    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(in.readLine());
	for (int tcase = 1; tcase <= t; tcase++) {
	    solve(in, tcase);
	}
    }

}
