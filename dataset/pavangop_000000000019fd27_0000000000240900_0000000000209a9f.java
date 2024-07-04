import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0;i<cases;i++){
			char row[] = scanner.nextLine().toCharArray();
			String ans = "";
			String revAns = "";
			int pre= 0;
			int cV = 0;
			for(int j=0;j<row.length;j++) {
				cV = Character.getNumericValue(row[j]);
				if(pre<cV) {
					ans = ans+getLParn(cV-pre)+cV;
				} else if(pre==cV) {
					ans = ans+cV;
				}
				else {
					ans = ans+getRParn(pre-cV)+cV;
				}
				pre=cV;
			}
			if(cV>0){
				ans = ans+getRParn(cV);
			}
			System.out.println("Case #"+(i+1)+": "+ans);
				
		}
		scanner.close();

	}

	private static String getLParn(int cV) {
		String ans="";
		for(int i=0;i<cV;i++){
			ans+="(";
		}
		return ans;
	}
	private static String getRParn(int cV) {
		String ans="";
		for(int i=0;i<cV;i++){
			ans+=")";
		}
		return ans;
	}

}
