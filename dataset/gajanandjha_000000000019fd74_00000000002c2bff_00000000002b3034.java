import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			boolean dm = false;
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr = new String[N];
			String head = "", tail = "";
			for(int i = 0; i < N; i++) {
				String str = br.readLine().trim();
				String sub1 = str.substring(0, str.indexOf("*")); 
				if(sub1.length() > head.length()) {
					head = sub1;
				}
				String rev = new StringBuilder(str).reverse().toString();
				String sub2 = rev.substring(0, rev.indexOf("*")); 
				if(sub2.length() > tail.length()) {
					tail = sub2;
				}
				arr[i] = str;
			}
			String middle = "";
			for(int i = 0; i < N; i++) {
				if(!arr[i].startsWith("*")) {
					String sub1 = arr[i].substring(0, arr[i].indexOf("*"));
					if(!matches(sub1.getBytes(), head.getBytes())) {
						dm = true;
						break;
					}
				}
				if(!arr[i].endsWith("*")) {
					String rev = new StringBuilder(arr[i]).reverse().toString();
					String sub2 = rev.substring(0, rev.indexOf("*")); 
					if(!matches(sub2.getBytes(), tail.getBytes())) {
						dm = true;
						break;
					}
				}
				String hd = arr[i].substring(0, arr[i].indexOf("*"));
				String rev = new StringBuilder(arr[i]).reverse().toString();
				String tl1 = rev.substring(0, rev.indexOf("*"));
				String tl = new StringBuilder(tl1).reverse().toString();
				hd = ";" + hd;
				tl = tl + ":";
				String mid = (";" + arr[i] + ":").split(hd)[1].split(tl)[0];
				middle += mid;
			}
			
			if(dm) {
				System.out.println("Case #" + t + ": *");
			} else {
				String out = head + middle + new StringBuilder(tail).reverse().toString();
				System.out.println("Case #" + t + ": " + out.replace("*", ""));
			}
		}
	}
	
	public static boolean matches(byte[] sh, byte[] lo) {
		int i = 0;
		for(byte b : sh) {
			if(b != lo[i]) {
				return false;
			}
			i++;
		}
		return true;
	}

}
