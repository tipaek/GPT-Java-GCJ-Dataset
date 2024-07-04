import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	
	static String complement(int[] bits) {
		String output = "";
		for(int i = 1; i < bits.length; i++) {
			output += ("" + ((bits[i] == 1) ? 0 : 1));
		}
		return output;
	}
	
	static String reversed(int[] bits) {
		String output = "";
		for(int i = bits.length-1; i > 0; i--) {
			output += bits[i];
		}
		return output;
	}
	
	static String cr(int[] bits) {
		String output = "", result = "";
		output = complement(bits);
		for(int i = output.length()-1; i >= 0; i--) {
			result += output.charAt(i);
		}
		return result;
	}
	
	static String rc(int[] bits) {
		String output = "", result = "";
		output = reversed(bits);
		for(int i = 0; i < output.length(); i++) {
			result += (output.charAt(i) == '1' ? '0' : '1');
		}
		return result;
	}
	
	static String unchanged(int[] bits) {
		String output = "";
		for(int i = 1; i < bits.length; i++) {
			output += ("" + bits[i]);
		}
		return output;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int[] bits;
		int T = in.nextInt();
		int b = in.nextInt();
		int read;
		
		if(b > 10) System.exit(0);
		
		for(int tc = 1; tc <= T; tc++) {
			bits = new int[b+1];
			
				System.out.println(1);
				read = in.nextInt();
				
				for(int i = 1; i <= 5; i++) {
					System.out.println(i);
					read = in.nextInt();
					bits[i] = read;
					
				}
				
				for(int i = 10; i > 6; i--) {
					System.out.println(i);
					read = in.nextInt();
					bits[i] = read;
					
				}
				
				
				bits[6] = 0;
				
				String complement = complement(bits);
				String reverse = reversed(bits);
				String cpr = cr(bits);
				String normal = unchanged(bits);
				
				String result = "";
				
				System.out.println(complement);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.out.println(reverse);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.out.println(cpr);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.out.println(normal);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				
				bits[6] = 1;
				
				
				complement = complement(bits);
				reverse = reversed(bits);
				cpr = cr(bits);
				normal = unchanged(bits);
				
				result = "";
				
				System.out.println(complement);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.out.println(reverse);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.out.println(cpr);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.out.println(normal);
				result = in.next();
				if(result.equals("Y")) {
					break;
				}
				
				System.exit(0);
		}
		in.close();
	}
}
