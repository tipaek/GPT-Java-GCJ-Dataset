import java.util.*;

public class Solution{


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		sc.nextLine();
        int T = t;
        while (t-- > 0) {
            String line = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			int firstDigit = line.charAt(0) - '0';
			for (int i = 0; i < firstDigit; i++) {
				sb.append("(");
			}
			char[] charAr = line.toCharArray();
			for (int i = 0; i < charAr.length - 1; i++){
				sb.append(charAr[i]);
				int diff = charAr[i] - charAr[i+1];
				char par = diff < 0 ? '(' : ')';
				for (int j = 0; j < Math.abs(diff); j++)
					sb.append(par);
			}
			sb.append(charAr[charAr.length -1]);
			int lastDigit = charAr[charAr.length -1] - '0';
			for (int i = 0; i < lastDigit; i++) {
				sb.append(")");
			}
            System.out.println("Case #" + (T - t) + ": " + sb.toString());
        }

    }
}
