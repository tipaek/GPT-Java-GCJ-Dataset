import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int testcase = 0;

		while(testcase < t) {
			testcase++;
			int x = sc.nextInt();
			int y = sc.nextInt();
			String line = sc.next().trim();
			int m = line.length();
			char arr[] = new char[m];
			for(int i=0; i<m; i++) {
				arr[i] = line.charAt(i);
			}
			
			int xpos = x;
			int ypos = y;
			boolean poss = false;
			for(int i=0; i<=m; i++) {
				if(poss) {
					break;
				}
				
				if(possible(xpos, ypos, i)) {
					poss = true;
					System.out.println("Case #"+testcase+": "+i);
				}else if(i<m) {
					char ch = arr[i];
					switch (ch) {
					case 'N': ypos++;
						
						break;
					case 'S': ypos--;
					
					break;
					case 'E': xpos++;
					
					break;
					case 'W': xpos--;
					
					break;

					default:
						break;
					}
				}
			}
			if(!poss) {
				System.out.println("Case #"+testcase+": IMPOSSIBLE");
			}
		}
		sc.close();
	}

	private static boolean possible(int xpos, int ypos, int m) {
		if((Math.abs(xpos) + Math.abs(ypos)) <= m) {
			return true;
		}
		return false;
	}

}
