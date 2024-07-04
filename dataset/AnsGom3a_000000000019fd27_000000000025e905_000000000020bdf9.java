public class Solution {
	public static void main(String[] arg){
		java.util.Scanner input = new java.util.Scanner(System.in);
		int t = input.nextInt();
		for(int x=1; x<=t; x++) {
			boolean possible = true;
			int n = input.nextInt();
			int[][] arr = new int[n][3];
			for(int i=0; i<n; i++) {
				int s = input.nextInt();
				int e = input.nextInt();
				if(possible) {
					if(isFree(1,s,e,arr)) {
						arr[i][0] = 1;
						arr[i][1] = s; arr[i][2] = e;
					}else if(isFree(2,s,e,arr)) {
						arr[i][0] = 2;
						arr[i][1] = s; arr[i][2] = e;
					}else 
						possible = false;
				}
			}
			if(possible) {
				String s = "";
				for(int i=0; i<n; i++) {
					if(arr[i][0] == 1)
						s += 'J';
					else 
						s += 'C';
				}
				System.out.println("Case #"+x+": "+s);
			}else
				System.out.println("Case #"+x+": IMPOSSIBLE");
		}
		input.close();
	}
	public static boolean isFree(int who, int s, int e,int[][] arr) {
		int n = arr.length;
		for(short i=0; i<n; i++) {
			if(arr[i][0] == 0)
				break;
			if(arr[i][0] == who) {
				if( (s>arr[i][1] && s<arr[i][2]) || (e>arr[i][1] && e<arr[i][2]) )
					return false;
			}
		}
		return true;
	}
}