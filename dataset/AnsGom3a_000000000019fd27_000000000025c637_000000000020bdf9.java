public class Solution {
	public static void main(String[] arg){
		java.util.Scanner input = new java.util.Scanner(System.in);
		byte t = input.nextByte();
		for(byte x=1; x<=t; x++) {
			boolean possible = true;
			short n = input.nextShort();
			short[][] arr = new short[n][3];
			for(short i=0; i<n; i++) {
				short s = input.nextShort();
				short e = input.nextShort();
				if(possible) {
					if(isFree((short)1,s,e,arr)) {
						arr[i][0] = (short)1;
						arr[i][1] = s; arr[i][2] = e;
					}else if(isFree((short)2,s,e,arr)) {
						arr[i][0] = (short)2;
						arr[i][1] = s; arr[i][2] = e;
					}else 
						possible = false;
				}
			}
			if(possible) {
				String s = "";
				for(short i=0; i<n; i++) {
					if(arr[i][0] == 1)
						s += 'J';
					else 
						s += 'C';
				}
				System.out.println("case #"+x+": "+s);
			}else
				System.out.println("case #"+x+": IMPOSSIBLE");
		}
		input.close();
	}
	public static boolean isFree(short who, short s, short e,short[][] arr) {
		short n = (short) arr.length;
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