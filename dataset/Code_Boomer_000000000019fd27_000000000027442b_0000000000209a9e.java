import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int B = sc.nextInt();
		for(int i=0;i<T;i++) {
			String d = sc.next();
			ArrayList<Integer> temp = new ArrayList<>();
			int count = 1;
			for(int j=0;j<B;j++) {
				if(count%10==1) {
					j--;
				}
				else {
				    System.out.println(j);
				    System.out.flush();
					temp.add(sc.nextInt());
				}
				count++;
			}
			String r = "";
			for(int j=0;j<temp.size();j++) {
				r+=temp.get(j);
			}
			System.out.println(r);
			System.out.flush();
			String check = sc.next();
			if(check.equals("N"))
				break;
		}
	}
}

