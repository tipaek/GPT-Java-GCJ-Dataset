import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int N = sc.nextInt();
			int D = sc.nextInt();
			ArrayList<Long> slices = new ArrayList<Long>();
			for(int j = 0; j <N; j++){
				slices.add(sc.nextLong());
			}
			Collections.sort(slices);
			if(D==2){
				int res = 1;
				for(int j = 0; j <N-1; j++){
					if(slices.get(j)==slices.get(j+1)){
						res = 0;
						break;
					}
				}
				System.out.println("Case #"+i+ ": "+res);
			}else if(D==3){
				int res = 2;
				for(int j = 0; j <N-2; j++){
					if(slices.get(j)==slices.get(j+1) && slices.get(j)==slices.get(j+2)){
						res = 0;
						break;
					}
				}
				for(int j = 0; j < N-2; j++){ //so that there would be a slice bigger to cut
					if(slices.get(j)==slices.get(j+1)){
						res = 1;
						break;
					}
				}
				for(int j = 0; j < N; j++){ //so that there would be a slice bigger to cut
					if(slices.contains(slices.get(j)/2)){
						res = 1;
						break;
					}
				}
				System.out.println("Case #"+i+ ": "+res);
			}
			
		}
		sc.close();
	}

}
