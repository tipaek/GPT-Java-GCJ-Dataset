
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		for(int k=0; k<tc; k++){
			String str=sc.next();
			findParanthesis(str, k+1);
		}
	}

	private static void findParanthesis(String str, int k) {
		// TODO Auto-generated method stub
		char[] ch=str.toCharArray();
		StringBuilder build = new StringBuilder();
		int Brackets=0;
		for(int i=0; i<str.length(); i++){
			int current = ch[i]-48;
			if(current>Brackets){
				for(int j=Brackets; j<current; j++){
					build.append("(");
					Brackets++;
				}
			}
			if(current<Brackets){
				for(int j=Brackets; j>current; j--){
					build.append(")");
					Brackets--;
				}
			}
			if(current==Brackets){
				build.append(current);
			}
			if(i==str.length()-1){
				for(int j=Brackets; j>0; j--){
					build.append(")");
					Brackets--;
				}
			}
			
		}
		System.out.println("Case #"+k+": "+build);
	}

}
