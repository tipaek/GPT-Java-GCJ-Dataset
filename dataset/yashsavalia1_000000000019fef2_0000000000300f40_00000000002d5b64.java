import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		String[] results = new String[testCases];
		int[] length = new int[testCases];

		for (int i = 0; i < testCases; i++) {
			String[] str = in.nextLine().split(" ");
			int ranks = Integer.parseInt(str[0]);
			int suits = Integer.parseInt(str[1]);
			Card[] deck = new Card[ranks * suits];
			int count = 0;
			for(int j = 1; j <= suits; j++) {
				for(int k = 1; k <= ranks; k++) {
					deck[count] = new Card(k, j);
					count++;
				}
 			}
			count = 0;
			int[][] ABs = new int[(suits - 1) * (ranks - 1)][2];
			for(int rank = ranks; rank > 1; rank--) {
				for(int suit = 1; suit < suits; suit++) {
					ABs[count][0] = rank * suit;
					ABs[count][1] = rank - 1;
					count++;
				}
			}
			String str1 = "";
			for(int j = 0; j < ABs.length - 1; j++) {
				str1 += ABs[j][0] + " " + ABs[j][1] + "\n";
			}
			str1 += ABs[ABs.length - 1][0] + " " + ABs[ABs.length - 1][1];
 			results[i] = str1;
 			length[i] = ABs.length;
		}
		
		for(int i = 1; i <= testCases; i++) {
			System.out.println("Case #" + i + ": " + length[i - 1]);
			System.out.println(results[i - 1]);
		}
		
		in.close();
	}

}

class Card {
	int rank;
	int suit;
	
	public Card(int r, int s) {
		rank = r;
		suit = s;
	}	
}
 