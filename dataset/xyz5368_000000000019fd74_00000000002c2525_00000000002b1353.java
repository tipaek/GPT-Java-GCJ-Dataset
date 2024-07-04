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
	
	public static void gen(int r){
		//r++;
		for(int i = 1; i <= r; i++){
			if(i%2==0){
				for(int j = 1; j <= i; j++){
					System.out.println(i + " " + j);
				}
			}else{
				for(int j = i; j > 0; j--){
					System.out.println(i + " " + j);
				}
			}
		}
	}
	
	public static void sgen(){
		gen(9);
		System.out.println("10 2");
		System.out.println("11 3");
		System.out.println("11 2");
		System.out.println("11 1");
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
			int[] ref = {1,3,7,15,31,63,127,255,511,966};
			int loc = 10;
			for(int i = 0; i < ref.length; i++){
				if(s <= ref[i]){
					loc = i;
					break;
				}
			}
			//int d = 0;
			if(loc < 10){
				gen(loc);
				if(loc == 8){
					for(int i = 0; i < s-ref[loc-1]; i++){
						System.out.println((i+loc) + " " + (i+loc));
						//d++;
					}
				}
				if(loc == 9){
					for(int i = 0; i < s-511; i++){
						System.out.println(i+loc+1 + " 1");
						//d++;
					}
				}
			}else{
				sgen();
				for(int i = 0; i < s-576; i++){
					System.out.println(i+loc+2 + " 1");
					//d++;
				}
			}
			//System.out.println(d);
			//System.out.println(loc);
		}
	}

}
