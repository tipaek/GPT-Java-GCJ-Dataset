import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Solution {


	static Solution sol = new Solution();


	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();


		for(int usease = 0; usease< T;usease++) {

			List<Long> slicesAngle = new ArrayList<>();
			int N = scann.nextInt(); //Number of slice
			int D = scann.nextInt(); //Number of dinners

			for(int i =0 ;i < N;i++) {
				slicesAngle.add(scann.nextLong());
			}

			Collections.sort(slicesAngle);	
			int numberOfCut = 0;
			List<Long> sliceToBeServed = new ArrayList<>();
			//if(slicesAngle.size() >= D) {

			long minAngle = slicesAngle.get(0);
			sliceToBeServed.add(minAngle);

			for(int i = 1;i<slicesAngle.size();i++) {
				long currentSlice = slicesAngle.get(i);
				while(currentSlice > minAngle) {
					currentSlice = currentSlice - minAngle;
					numberOfCut++;
					sliceToBeServed.add(minAngle);
					if(currentSlice==minAngle) {
						sliceToBeServed.add(currentSlice);
						currentSlice=0;
					}
					if(sliceToBeServed.size() >= D) break;
				}
			}

			if(sliceToBeServed.size()==1) {
				numberOfCut = D;
			}

			//}
			System.out.println(String.format("Case #%s: %s",usease+1,numberOfCut));



		}


	}






}
