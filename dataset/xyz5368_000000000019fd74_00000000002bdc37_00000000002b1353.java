import java.util.*;

public class Solution {
	
	//small case
	public static void cheese(int s){
		if(s <= 500){
			for(int i = 1; i <= s; i++){
				System.out.println(i + " " + i);
			}
		}else{
			System.out.println("1 1");
			System.out.println("2 1");
			System.out.println("3 1");
			System.out.println("3 2");
			System.out.println("3 3");
			//sum 6
			
			for(int i = 4; i <= s-3; i++){
				System.out.println(i + " " + i);
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a = 0; a < t; a++){
			int s = in.nextInt();
			System.out.printf("Case #%d:\n",a+1);
			if(s <= 501){
				cheese(s);
				continue;
			}
			
		}
	}

}
