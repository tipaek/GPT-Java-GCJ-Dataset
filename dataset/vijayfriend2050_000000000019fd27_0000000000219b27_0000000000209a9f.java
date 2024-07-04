import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int x = 1; x <= T; ++x) {
			char[] charArr = in.next().toCharArray();
			StringBuffer sb = new StringBuffer();
			char left = '0';
			for (int i=0;i<charArr.length;i++){
				char next = charArr[i];
				if (left == next){
					sb.append(next);
				} else if (left < next){
					sb.append(repeatN("(",next-left));
					sb.append(next);
				} else {
					sb.append(repeatN(")",left-next));
					sb.append(next);
				}
				left = next;
			}
			sb.append(repeatN(")",left-'0'));
			
			System.out.println("Case #" + x + ": " + sb.toString());
		}
	}
	
	private static String repeatN(String st, int times){
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<times;i++)
			sb.append(st);
		return sb.toString();
	}
}
