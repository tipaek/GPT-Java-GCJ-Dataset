import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			long x = file.nextLong();
			long y = file.nextLong();
			boolean xPos = x >= 0 ? true : false;
			boolean yPos = y >= 0 ? true : false;
			x = Math.abs(x);
			y = Math.abs(y);
			long sum = x+y;
			if(sum % 2 == 0) {
				System.out.printf("Case #%d: IMPOSSIBLE%n", i);
			}
			else {
				boolean[] dir = new boolean[(int)Math.floor(Math.log(sum)/Math.log(2)+1)];
				for(int pow = dir.length-1; pow >= 0; pow--) {
					if(sum == 0) {
						System.out.println("oops");
						break;
					}
					if(sum > 0) {
						sum -= 1l<<pow;
						dir[pow] = true;
					}
					else {
						sum += 1l<<pow;
						dir[pow] = false;
					}
				}
				boolean xSmaller = x < y ? true : false;
				sum = Math.abs(x-y);
				boolean[] dir2 = new boolean[dir.length];
				for(int pow2 = dir2.length-1; pow2 >= 0; pow2--) {
					if(sum == 0) {
						break;
					}
					if(sum > 0) {
						sum -= 1l<<pow2;
						dir2[pow2] = true;
					}
					else {
						sum += 1l<<pow2;
						dir2[pow2] = false;
					}
				}
//				System.out.println(Arrays.toString(dir));
//				System.out.println(Arrays.toString(dir2));
				StringBuilder ans = new StringBuilder();
				for(int j = 0; j < dir.length; j++) {
					if(dir[j] == dir2[j]) {
						if(xSmaller) {
							if(yPos == dir[j])
								ans.append("N");
							else
								ans.append("S");
						}
						else {
							if(xPos == dir[j])
								ans.append("E");
							else
								ans.append("W");
						}
					}
					else {
						if(xSmaller) {
							if(xPos == dir[j])
								ans.append("E");
							else
								ans.append("W");
						}
						else {
							if(yPos == dir[j])
								ans.append("N");
							else
								ans.append("S");
						}
					}
				}
				System.out.printf("Case #%d: %s%n", i, ans);
//				long xCheck = 0;
//				long yCheck = 0;
//				for(int h = 0; h < ans.length(); h++) {
//					switch(ans.charAt(h)) {
//					case 'N':
//						yCheck += 1l<<h;
//						break;
//					case 'S':
//						yCheck -= 1l<<h;
//						break;
//					case 'E':
//						xCheck += 1l<<h;
//						break;
//					case 'W':
//						xCheck -= 1l<<h;
//						break;
//					}
//				}
//				System.out.println(xCheck + " " + yCheck);
			}
		}
		file.close();
	}

}
