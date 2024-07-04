public class Solution {
	public static void main(String[] arg){
		java.util.Scanner input = new java.util.Scanner(System.in);
		byte t = input.nextByte();
		for(byte x=1; x<=t; x++) {
			String s ="0"+ input.next(), nS = "";
			byte len = (byte) s.length();
			byte opened=0;
			byte temp=0;
			for(byte i=0; i<len-1; i++) {
				temp = (byte) (s.charAt(i+1)-s.charAt(i));
				if(temp>0) {
					while(temp-->0) {
						nS += '(';
						opened++;
					}
				}else {
					while(temp++<0) {
						nS += ')';
						opened--;
					}
				}
				nS += s.charAt(i+1);
			}
			while(opened-->0) {
				nS += ')';
			}
			System.out.println("case #"+x+": "+nS);
		}
		input.close();
	}
}