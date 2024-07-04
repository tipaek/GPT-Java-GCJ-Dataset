
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner a = new Scanner(System.in);
		int T=0;
		T = a.nextInt();
		a.nextLine();
		String[] s = new String[T];
		for(int i=0;i<T;i++) {
			String S = a.nextLine();
			char[]c = S.toCharArray();
			for(int k=0;k<S.length();k++) {
				int check =Character.getNumericValue(c[k]);
				String line =null;
				for(int j=0;j<check;j++) {
					if(i==0 && j==0) {
						line = "(";
					}else
						line+="(";
				}if(check==0 && k==0) {
					line = Integer.toString(check);
				}
				else {
					line += Integer.toString(check);
				}
				for(int j=0;j<check;j++) {
					line+=")";
				}if(i==0 && k==0) {
					s[i] = line;
				}else
					s[i]+=line;
			}if(s[i].contains("null")) {
				s[i] = s[i].replaceAll("null", "");
			}
			if(s[i].contains(")(")){
				String REGEX= "\\)\\(";
				s[i] = s[i].replaceAll(REGEX, "");
			}
		}
		for(int m=0;m<T;m++) {
			System.out.println("Case #"+ (m+1) +": "+ s[m]);
		}
	}
}