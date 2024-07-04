import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) { // for each case
			String output = "";
			String[] listS = sc.next().split("");
			for(int j=0;j<listS.length;j++) { // for each character
				int repeat = Integer.parseInt(listS[j]);
				String oP = String.join("", Collections.nCopies(repeat, "("));
				String cP = String.join("", Collections.nCopies(repeat, ")"));
				output = output+oP+listS[j]+cP;
			}
			do {
				output = output.replaceAll("\\)\\(", "");
			}while(output.contains(")("));
			System.out.printf("Case #%d: %s\n",i+1,output);
		}
		sc.close();
	}
	
}
