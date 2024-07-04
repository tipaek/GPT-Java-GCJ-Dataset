import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int b = in.nextInt();

		for (int i = 0; i < t; ++i) {
			ArrayList<Integer> array = new ArrayList<>(b);

			System.out.println(1);
			array.set(0, in.nextInt());

			int known = 1, queries = 1;

			while (known < b) {
				if (queries % 10 != 0) {
					int index = known % 2 == 0 ? (known/2) + 1 : b - (known/2);
					System.out.println(index);
					array.set(index - 1, in.nextInt());
					++queries;
					++known;
				} else {
					ArrayList<ArrayList<Integer>> candidates = candidates(array);
					int possible = 0b1111;
					
					int index = 0;
					while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
						//int index = mostDiffIndex(candidates, possible);
						++queries;
						System.out.println(index + 1);
						int bit = in.nextInt();
						possible = possible(candidates, index, bit, possible);
						++index;
					}
					
					switch (possible) {
					case 0b1000 : 
						array = candidates.get(3);
						break;
					case 0b0100 :
						array = candidates.get(2);
						break;
					case 0b0010 :
						array = candidates.get(1);
						break;
					default :
						array = candidates.get(0);
					}
				}
			}
			
			for (int n : array) {
				System.out.print(n);
			}
			
			System.out.println();
		}
	}
	
	public static int possible(ArrayList<ArrayList<Integer>> candidates, int index, int bit, int possible) {
		for (int i = 0; i < candidates.size(); ++i) {
			if (((possible >> i) & 1) == 1 && candidates.get(i).get(index) != bit) {
				possible -= 1 << i;
			}
		}
		
		return possible;
	}

/*	public static int mostDiffIndex(ArrayList<ArrayList<Integer>> candidates, int possible) {
		for (int i = 0; i < )
	} */
	
	public static ArrayList<ArrayList<Integer>> candidates(ArrayList<Integer> array) { // complement, reverse, both, nothing
		int b = array.size();

		ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();
		for (int i = 0; i < 4; ++i) {
			candidates.add(new ArrayList<>());
		}
		
		for (int i = 0; i < b; ++i) {
			candidates.get(0).add(1 - array.get(i));
			candidates.get(1).add(array.get(b - i - 1));
			candidates.get(2).add(1 - candidates.get(1).get(i));
			candidates.get(3).add(array.get(i));
		}

		return candidates;
	}
}