import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0;i<t;i++) {
			String line = sc.nextLine();
			int [] n = new int[line.length()];
			for (int j = 0;j<line.length();j++)
			{
				Integer dig = new Integer(line.substring(j, j+1));
				n[j] = dig.intValue();
			}
			
			String newLine = "";
			int nesting = 0;
			
			for (int j = 0;j<n.length;j++) {
				while (n[j]>nesting) {
					newLine+="(";
					nesting++;
				}
				
				while (n[j]<nesting) {
					newLine+=")";
					nesting--;
				}
				newLine += new Integer(n[j]).toString();
			}
			
			while (nesting>0) {
				newLine+=")";
				nesting--;
			}
			System.out.println("Case #"+(i+1)+": "+newLine);
		}
	}
}
