import java.io.IOException;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(System.in);
		Integer testNo = 1;
		in.nextLine();
		while (in.hasNext()) {
			String inputString = in.next();
			char[] characters = inputString.toCharArray();
			StringBuilder sb = new StringBuilder();

			for(int i=0;i<characters.length;i++) {
				if(characters[i]=='1') {
					sb.append("(1");
					for(int j=i+1;j<=characters.length;j++) {
						if(j<characters.length && characters[j]=='1') {
							sb.append("1");
							i=j;
						}else if(j>=characters.length || characters[j]!='1'){
							sb.append(")"); 
							break;
						}
					}
				}
				else {
					sb.append("0");
				}
			}
			 System.out.println("Case #" + testNo+": "+sb.toString());
			testNo++;
		}
	}

}