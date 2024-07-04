import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner file = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = file.nextInt();
		file.nextLine();
		for (int i = 1; i <= t; i++) {
			String temp = file.nextLine();
			int[] hey = new int[temp.length()];
			for (int j = 0; j < hey.length; j++) {
				hey[j] = temp.charAt(j) - 48;
			}
			System.out.println("Case #" + i + ": " + method(hey));
		}
	}
	
	public static String method(int[] k) {
		String pp = "";
		int layer = 0;
		for (int i = 0; i < k.length; i++) {
			while(layer < k[i]) {
				pp += "(";
				layer++;
			}
			while(layer > k[i]) {
				pp += ")";
				layer--;
			}
			pp += k[i];
		}
		for (int i = layer; i > 0; i--) {
			pp += ")";
		}
		return pp;
	}
}