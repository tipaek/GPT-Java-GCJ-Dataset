import java.util.Scanner;
public class probA {
	static Scanner sc = new Scanner(System.in);
	static String arr[] = new String[50];
	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			solve(i + 1);
		}
	}
	private static void solve(int i) {
		int n = sc.nextInt();
		int idx;
		String l, r;
		String left = "", right = "";
		for (int j = 0; j < n; j++) {
			arr[j] = sc.next();
			idx = arr[j].indexOf("*");
			if(idx >= 0 && idx < arr[j].length() - 1){
				r = arr[j].substring(idx + 1);
				if(r.length() > right.length())
					right = r;
			}
			if(idx > 0){
				l = arr[j].substring(0, idx);
				if(l.length() > left.length())
					left = l;
			}
		}
		String all = left + right, tmp;
		r = ""; l = "";
		boolean sw = true;
		for (int j = 0; j < n; j++) {
			idx = arr[j].indexOf("*");
			if(idx >= 0 && idx < arr[j].length() - 1){
				r = arr[j].substring(idx + 1);
			}
			if(idx > 0){
				l = arr[j].substring(0, idx);
			}
			int x = all.indexOf(l);
			int y = all.indexOf(r);
			if((x < 0 || y < 0) || x > y) sw = false;
		}
		System.out.print("Case #" + i + ": ");
		if(sw){
			System.out.print(all);
		}else{
			System.out.print("*");
		}
		System.out.println();
	}
	private static String conv(String s){
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '*')
				r += s.charAt(i);
		}
		return r;
	}
}