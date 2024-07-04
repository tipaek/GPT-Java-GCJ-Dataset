import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; test_case++) {
			String s = sc.next();
			String answer = "";
			int closing_num = 0;
			int[] num_arr = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				num_arr[i] = Character.getNumericValue(s.charAt(i));
//				System.out.println(num_arr[i] );
			}
//			System.out.println("-------------------------");
			for(int i=0;i<s.length();i++) {
				if(i == 0) {
					int num = num_arr[i];
					for(int j = 0; j<num ; j++) {
						answer = answer + "(";
						closing_num ++;
					}
					answer = answer + s.substring(i, i+1); 
				}
				
				else if((i>0 && num_arr[i-1]<num_arr[i])){//small->big
//					System.out.println("closing num : "+closing_num);
					for(int j = 0; j<closing_num; j++) {
//						System.out.println("num_arr[i-1] : "+num_arr[i-1]);
//						System.out.println("num_arr[i] : "+num_arr[i]);
						answer = answer + ")";
					}
					closing_num = 0;
					for(int j = 0;j<num_arr[i];j++) {
						answer = answer + "(";
						closing_num++;
					}
					answer = answer + s.substring(i, i+1);
				}
				else if((i>0 && num_arr[i-1]>num_arr[i])){
					for(int j = 0;j<num_arr[i-1]-num_arr[i];j++) {
						answer = answer + ")";
						closing_num--;
					}
					answer = answer + s.substring(i, i+1);
				}
				else {
					answer = answer + s.substring(i, i+1);
				}
				if((i == s.length()-1 )) {
//					answer = answer + s.substring(i, i+1);
					for(int j=0; j<closing_num;j++) {
						answer = answer + ")";
					}
					
				}
			}
			System.out.println("Case #"+(test_case)+": "+answer);
		}
		sc.close();
		
	}
}