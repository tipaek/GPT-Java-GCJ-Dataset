import java.util.Scanner;
import java.util.*; 

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int b = in.nextInt();
		in.nextLine();
		char input;
		for (int i = 0; i < t; i++) {
			char[] bitarr = new char[b];
			for(int j = 0; j < b; j++) {
				bitarr[j] = 'N';
			}
			boolean isSamePair = false, isDifferentPair = false;
			int index = 1;
			int thresholdIndex = b;
			int queryNo = 0;
			int[] samePairIndexes = {0,0};
			int[] differentPairIndexes = {0,0};
			while (!(isSamePair && isDifferentPair) && index <= thresholdIndex) {
				//System.out.println(Arrays.toString(bitarr));
				//System.out.println("Finding pairs");
				if(queryNo !=0 && queryNo%10 == 0) {
					index = 1;
					thresholdIndex = b;
				}
				if(index == thresholdIndex) {
					System.out.println(index);
					input = in.nextLine().charAt(0);
					if(input == 'N') System.exit(0);
					bitarr[index-1] = input;
					break;
				}
				System.out.println(index);
				input = in.nextLine().charAt(0);
				if(input == 'N') System.exit(0);
				bitarr[index-1] = input;
				System.out.println(thresholdIndex);
				input = in.nextLine().charAt(0);
				if(input == 'N') System.exit(0);
				bitarr[thresholdIndex-1] = input;
				queryNo += 2;
				if(!isSamePair && bitarr[index-1] == bitarr[thresholdIndex - 1]) {
					//System.out.println("Found same pairs");
					isSamePair = true;
					samePairIndexes[0] = index-1;
					samePairIndexes[1] = thresholdIndex - 1;

				} else if (!isDifferentPair && bitarr[index-1] != bitarr[thresholdIndex - 1]){
					//System.out.println("Found different pairs");
					isDifferentPair = true;
					differentPairIndexes[0] = index-1;
					differentPairIndexes[1] = thresholdIndex - 1;
				}
				index++;
				thresholdIndex--;
			}
			
			while(queryNo <= 150 && index < thresholdIndex) {
				if(queryNo%10 == 0) {
					char[] response = {'N', 'N'};
					System.out.println(samePairIndexes[0]);
					input = in.nextLine().charAt(0);
					if(input == 'N') System.exit(0);
					response[0] = input;
					System.out.println(differentPairIndexes[0]);
					input = in.nextLine().charAt(0);
					if(input == 'N') System.exit(0);
					response[1] = input;
					queryNo += 2;
					if(bitarr[samePairIndexes[0]] == response[0] && bitarr[differentPairIndexes[0]] == response[1]) {
						// No change
					} else if (bitarr[samePairIndexes[0]] != response[0] && bitarr[differentPairIndexes[0]] != response[1]) {
						for(int j = 0; j < index; j++) {
							bitarr[j] = (bitarr[j] == '0')? '1' : '0';
						}
						for(int j = thresholdIndex-1; j < b; j++) {
							bitarr[j] = (bitarr[j] == '0')? '1' : '0';
						}
						// Bits flipped
					} else if(bitarr[samePairIndexes[0]] != response[0] && bitarr[differentPairIndexes[0]] == response[1]) {
						for (int j=0; j<b/2; j++) { 
							char temp = bitarr[j]; 
							bitarr[j] = bitarr[b -j -1]; 
							bitarr[b -j -1] = temp; 
						}
						int temp = b-index;
						index = b - thresholdIndex;
						thresholdIndex = temp;
						// interchange
					} else {
						// bit flipped and interchanged
						for(int j = 0; j < index; j++) {
							bitarr[j] = (bitarr[j] == '0')? '1' : '0';
						}
						for(int j = thresholdIndex - 1; j < b; j++) {
							bitarr[j] = (bitarr[j] == '0')? '1' : '0';
						}
						for (int j=0; j<b/2; j++) { 
							char temp = bitarr[j]; 
							bitarr[j] = bitarr[b -j -1]; 
							bitarr[b -j -1] = temp; 
						}
						int temp = b -index;
						index = b - thresholdIndex;
						thresholdIndex = temp;

					}

				} else {
					System.out.println(index);
					input = in.nextLine().charAt(0);
					if(input == 'N') System.exit(0);
					bitarr[index-1] = input;
					index++;
				}
			}
			if(index >= thresholdIndex) {
				String output = "";
				for(char c : bitarr) {
					output += String.valueOf(c);
				}
				System.out.println(output);
				input = in.nextLine().charAt(0);
				if(input == 'N') System.exit(0);
				
			}
			
		}
	}
}