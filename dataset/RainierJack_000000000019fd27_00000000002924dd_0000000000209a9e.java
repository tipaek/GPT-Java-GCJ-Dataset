import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int B = in.nextInt();

			int found = 0;

			int[] set = new int[B];

			int state = 0; // 0 normal, 1 inverted, 2 reversed, 3 rev+inv

			// 1: 5 first + 5 last
			for (int i=0; i<5; i++) {
				System.out.println(i+1);
				set[i] = in.nextInt();
			}
			for (int i=0; i<5; i++) {
				System.out.println(B-i);
				set[B-i-1] = in.nextInt();
			}

			int cmp = -1; // 0 if same, 1 if inverted, 2 if different
			int same = -1; // bit in common -> inverted or not
			int diff = -1; // bit in difference -> start or end
			int valueS = -1;
			int valueD = -1;

			for (int i=0; i<5; i++) {
				boolean b = set[i] == set[B-i-1];
				if (cmp == -1) {
					if (b) {
						cmp = 0;
						same = i;
						valueS = set[i];
					}
					else {
						cmp = 1;
						diff = i;
						valueD = set[i];
					}
				}
				if (cmp == 0) {
					if (!b) {
						cmp = 2;
						diff = i;
						valueD = set[i];
						break;
					}
				}
				if (cmp == 1) {
					if (b) {
						cmp = 2;
						same = i;
						valueS = set[i];
						break;
					}
				}
			}
			found = 10;
			int ind = 5;

			// if same
			if (cmp == 0) {
				while (cmp == 0 && found < B) {
					// next 10 queries
					System.out.println(1);
					in.next();
					System.out.println(1);
					boolean inverted = (in.nextInt() != set[0]);
					if (inverted)
						state = 1;
					int cpt=0;
					while (cpt<4 && ind+cpt<B/2) {
						System.out.println(ind+cpt+1);
						if (inverted)
							set[ind+cpt] = 1-in.nextInt();
						else
							set[ind] = in.nextInt();
						System.out.println(B-ind-cpt);
						if (inverted)
							set[B-1-ind-cpt] = 1-in.nextInt();
						else
							set[B-1-ind-cpt] = in.nextInt();
						found += 2;
						cpt++;
					}
					// check if still the same
					for (int i=0; i<cpt; i++) {
						if (set[ind+i] != set[B-1-ind-i]) {
							cmp = 2;
							diff = ind+i;
							valueD = set[ind+i];
							break;
						}
					}
					ind += cpt;
				}
			}
			// if inverted
			if (cmp == 1) {
				while (cmp == 1 && found < B) {
					// next 10 queries
					System.out.println(1);
					in.next();
					System.out.println(1);
					boolean reversed = (in.nextInt() != set[0]);
					if (reversed)
						state = 2;
					int cpt=0;
					while (cpt<4 && ind+cpt<B/2) {
						System.out.println(ind+cpt+1);
						if (reversed)
							set[B-1-ind-cpt] = in.nextInt();
						else
							set[ind] = in.nextInt();
						System.out.println(B-ind-cpt);
						if (reversed)
							set[ind+cpt] = in.nextInt();
						else
							set[B-1-ind-cpt] = in.nextInt();
						found += 2;
						cpt++;
					}
					// check if still inverted
					for (int i=0; i<cpt; i++) {
						if (set[ind+i] == set[B-1-ind-i]) {
							cmp = 2;
							same = ind+i;
							valueS = set[ind+i];
							break;
						}
					}
					ind += cpt;
				}
			}

			// now there is a difference, or we are at the end
			while (found < B) {
				System.out.println(same+1);
				if (in.nextInt() == valueS) {
					System.out.println(diff+1);
					if (in.nextInt() == valueD)
						state = 0;
					else
						state = 1;
				} else {
					System.out.println(diff+1);
					if (in.nextInt() == valueD)
						state = 3;
					else
						state = 2;
				}
				int cpt = 0;
				while (cpt<4 && ind+cpt<B/2) {
					switch (state) {
					case 0:
						System.out.println(ind+cpt+1);
						set[ind+cpt] = in.nextInt();
						System.out.println(B-ind);
						set[B-1-ind-cpt] = in.nextInt();
						break;
					case 1:
						System.out.println(ind+cpt+1);
						set[ind+cpt] = 1-in.nextInt();
						System.out.println(B-ind);
						set[B-1-ind-cpt] = 1-in.nextInt();
						break;
					case 2:
						System.out.println(ind+cpt+1);
						set[B-1-ind-cpt] = in.nextInt();
						System.out.println(B-ind);
						set[ind+cpt] = in.nextInt();
						break;
					case 3:
						System.out.println(ind+cpt+1);
						set[B-1-ind-cpt] = 1-in.nextInt();
						System.out.println(B-ind);
						set[ind+cpt] = 1-in.nextInt();
						break;
					}
					found += 2;
					cpt++;
				}				
			}
			
			// send answer
			String res = "";
			switch (state) {
			case 0:
				for (int i=0; i<B; i++)
					res += set[i];
				break;
			case 1:
				for (int i=0; i<B; i++)
					res += 1-set[i];
				break;
			case 2:
				for (int i=0; i<B; i++)
					res += set[B-1-i];
				break;
			case 3:
				for (int i=0; i<B; i++)
					res += 1-set[B-1-i];
				break;
			}
			System.out.println(res);
			if (in.next() != "Y") {
				System.out.println("Bruh");
				break;
			}
		}
		in.close();
	}

}

