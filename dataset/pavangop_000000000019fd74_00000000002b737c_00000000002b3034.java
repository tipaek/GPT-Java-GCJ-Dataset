import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();

		for (int i = 0; i < cases; i++) {
			String ans = "";
			int maxLen=0;
			String maxEle="";
			boolean ansInd = true;
			HashSet<String> patterns = new HashSet<>();
			int N = scanner.nextInt();
			for (int j = 0; j < N; j++) {
				String t = scanner.next();
				patterns.add(t);
				if(maxLen<t.length()){
					maxLen = t.length();
					maxEle = t;
				}
			}
			maxEle = maxEle.replace("*", "");
			for(String sT:patterns){
				if(!Pattern.matches("."+sT, maxEle)){
					ansInd = false;
					
				}
			}
			if(ansInd){
				System.out.println("Case #"+(i+1)+": "+maxEle);
			} else
			{
				System.out.println("Case #"+(i+1)+": *");
			}
		}
	}

}
