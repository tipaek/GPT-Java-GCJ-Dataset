import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int cases = kbd.nextInt();
		for (int i = 1; i <= cases; i++) {
			String line = kbd.next();
			System.out.println("Case #" + i + ": " + insertPara(subst(line)));
		}
		kbd.close();

	}

	public static ArrayList<String> subst(String line) {
		ArrayList<String> digits= new ArrayList<String>();
		while(line.length() > 0) {
			String sub = line.substring(0, 1);
			int j = 1;
			while (j!= line.length() && line.substring(0, 1).equals(line.substring(j, j + 1))) {
				sub += line.substring(j, j + 1);
				j++;
			}
			digits.add(sub);
			line = line.replaceFirst(sub, "");
		}
		return digits;
	}
	public static String insertPara(ArrayList<String> arr) {
		String result = "";
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).charAt(0) == '1') {
				result += "(" + arr.get(i) + ")";
			}
			else {
				result += arr.get(i);
			}
		}
		return result;
	}

}
