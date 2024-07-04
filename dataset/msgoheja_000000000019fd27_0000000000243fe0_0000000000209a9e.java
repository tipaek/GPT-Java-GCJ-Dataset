import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
			
			
			String[] list = new String[8];
			
			bits[6] = 0;
			
			list[0] = complement(bits);
			list[1] = reversed(bits);
			list[2] = cr(bits);
			list[3] = unchanged(bits);
			
			bits[6] = 1;
			
			list[4] = complement(bits);
			list[5] = reversed(bits);
			list[6] = cr(bits);
			list[7] = unchanged(bits);
			
			System.out.println(1);
			read = in.nextInt();
			
			List<String> remaining = new ArrayList<>();
			
			for(int i = 0; i < 8; i++) {
				if(Integer.parseInt("" + list[i].charAt(0)) == read) {
					remaining.add(list[i]);
				}
			}
			
			boolean visited[] = new boolean[remaining.size()];
			
			int pos = 1;
			
			while(pos < 10) {
				int unmatchPos = -1;
				OUTER: for(int i = 0; i < remaining.size(); i++) {
					if(!visited[i]) {
						char ch = remaining.get(i).charAt(pos);
						for(int j = i+1; j < remaining.size(); j++) {
							if(!visited[j] && ch != remaining.get(j).charAt(pos)) {
								unmatchPos = pos;
								break OUTER;
							}
						}
					}
				}
				
				if(unmatchPos > -1) {
					System.out.println(pos+1);
					read = in.nextInt();
					for(int i = 0; i < remaining.size(); i++) {
						if(!visited[i] && remaining.get(i).charAt(pos) != (""+read).charAt(0)) {
							visited[i] = true;
						}
					}
				}
				pos++;
			}
			
			for(int i = 0; i < remaining.size(); i++) {
				if(!visited[i]) {
					System.out.println(remaining.get(i));
					String result = in.next();
					
					if(result.equals("Y")) break;
				}
			}
		}
		in.close();
	}
}
