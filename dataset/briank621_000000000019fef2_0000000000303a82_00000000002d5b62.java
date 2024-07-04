import java.util.*;
import java.io.*;

class Solution{

	public static boolean cover(String x, String y){
		int xl = x.length();
		int yl = y.length();
		if(yl > xl)
			return cover(y, x);
		int max = Math.max(xl, yl);
		int min = Math.min(xl, yl);

		for(int i = 0; i < min; i++){
			if(x.charAt(xl - 1 - i) == y.charAt(yl - 1 - i)){
				return false;
			}
		}
		for(int i = 0; i < max - min; i++){
			if(x.charAt(i) == '0')
				return false;
		}
		return true;
	}

	public static String negate(String x){
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for(int i = 0; i < x.length(); i++){
			if(x.charAt(i) == '0'){
				index = i;
				break;
			}
		}
		for(int i = index; i < x.length(); i++){
			sb.append(x.charAt(i) == '0' ? '1' : '0');
		}
		return sb.toString();
	}

	// starts with strings of ones and that's it
	public static int startsWithOnes(String x){
		int index = 0;
		for(int i = 0; i < x.length(); i++){
			if(x.charAt(i) == '0'){
				index = i;
				break;
			}
		}

		for(int i = index; i < x.length(); i++){
			if(x.charAt(i) == '1')
				return -1;
		}
		return x.length() - index;
	}

	public static String flipX(String s){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'E')
				sb.append('W');
			else if(s.charAt(i) == 'W')
				sb.append('E');
			else
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static String flipY(String s){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'N')
				sb.append('S');
			else if(s.charAt(i) == 'S')
				sb.append('N');
			else
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static String build(String x, String y, String negX, String negY){
		// combinations are just x, y
		// x, y = kx, (neg = flipx)
		// x = ky, y, (neg = flipy)
		
		// System.out.println("x: " + x);
		// System.out.println("y: " + y);
		// System.out.println("negX: " + negX);
		// System.out.println("negY: " + negY);

		StringBuilder sb = new StringBuilder();
		int index = 0;
		int xl = x.length();
		int yl = y.length();
		int nx = negX.length();
		int ny = negY.length();

		int max = Math.max(Math.max(xl, yl), Math.max(nx, ny));
		// System.out.printf("%d %d %d %d\n", xl, yl, nx, ny);
		// System.out.println("max: " + max);

		for(int i = 0; i < max; i++){
			if(i < xl && x.charAt(xl - 1 - i) == '1'){
				sb.append('E');
			}
			else if(i < yl && y.charAt(yl - 1 - i) == '1'){
				sb.append('N');
			}
			else if(i < nx && negX.charAt(nx - 1 -i) == '1'){
				sb.append('W');
			}
			else if(i < ny && negY.charAt(ny - 1 - i) == '1'){
				sb.append('S');
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());


		for(int tc = 1; tc <= t; tc++){
			String[] l = br.readLine().split(" ");
			int x = Integer.parseInt(l[0]);
			int y = Integer.parseInt(l[1]);
			boolean fx = false;
			boolean fy = false;
			if(x < 1){
				x *= -1;
				fx = true;
			}
			if(y < 1){
				y *= -1;
				fy = true;
			}

			String sx = Integer.toBinaryString(x);
			String sy = Integer.toBinaryString(y);
			// System.out.println("sx: " + sx);
			// System.out.println("sy: " + sy);
			int xl = sx.length();
			int yl = sy.length();
			int max = Math.max(xl, yl);
			int min = Math.min(xl, yl);
			String ans = "";
			int minLength = Integer.MAX_VALUE;

			if(cover(sx,sy)){
				String s = build(sx, sy, "", "");
				if(s.length() < minLength){
					minLength = s.length();
					ans = s;
				}
			}
			// negate y
			String flipY = negate(sy);
			String flipX = negate(sx);
			int nx = Integer.parseInt(flipX, 2);
			int ny = Integer.parseInt(flipY, 2);
			int kx = nx + y;
			int ky = ny + x;
			String k = Integer.toBinaryString(kx);
			String kk = Integer.toBinaryString(ky);

			// System.out.println("flipY: " + flipY);
			// System.out.println("kk: " + kk);
			// System.out.println("flipY: " + flipY);

			// System.out.println("here");

			if(((kx & x) == 0) && ((kx & nx) == 0)){
				if(startsWithOnes(k) == xl){
					// System.out.println("sx: " + sx);
					// System.out.println("k: " + k);
					// System.out.println("flipX: " + flipX);
					// System.out.println("here");
					String s = build(sx, k, "", flipX);
					if(s.length() < minLength){
						minLength = s.length();
						ans = s;
					}
				}
			}

			if(((ky & y) == 0) && ((ky & ny) == 0)){
				if(startsWithOnes(kk) == yl){
					String s = build(kk, sy, flipY, "");
					if(s.length() < minLength){
						minLength = s.length();
						ans = s;
					}
				}
			}

			if(fx){
				ans = flipX(ans);
			}
			if(fy){
				ans = flipY(ans);
			}

			// Case #1: SEN
			if(ans.equals("")){
				System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
			}
			else{
				System.out.printf("Case #%d: %s\n", tc, ans);
			}

		}


	}

}
