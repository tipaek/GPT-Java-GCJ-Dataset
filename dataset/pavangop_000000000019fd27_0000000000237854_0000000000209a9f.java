import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0;i<cases;i++){
			char row[] = scanner.nextLine().toCharArray();
			String ans = "";
			char pre='0';
			for(int j=0;j<row.length;j++) {
				if(row[j] == '1' && pre=='0') {
					ans+="(1";
				} else if(row[j] == '1' && pre=='1') {
					ans+="1";
				} else if(row[j] == '0' && pre=='1') {
					ans+=")0";
				}
				else {
					ans+="0";
				}
				
				if(row[j] == '1' && row.length-1==j) {
						ans+=")";
				}
				pre = row[j];
			}
			System.out.println("Case #"+(i+1)+": "+ans);
				
		}
		scanner.close();

	}

}
