import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
		int B = in.nextInt();

		for (int t=0; t<T; t++) {

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
			int diff = -1; // bit in difference -> reversed or not

			for (int i=0; i<5; i++) {
				boolean b = set[i] == set[B-i-1];
				if (cmp == -1) { // first bit
					if (b) {
						cmp = 0;
						same = i;
					}
					else {
						cmp = 1;
						diff = i;
					}
				}
				if (cmp == 0) {
					if (!b) {
						cmp = 2;
						diff = i;
						break;
					}
				}
				if (cmp == 1) {
					if (b) {
						cmp = 2;
						same = i;
						break;
					}
				}
			}
			found = 10;
			int ind = 5;

			// if same
			while (cmp == 0 && found < B) {
				// next 10 queries
				System.out.println(1); // check first bit for inv or not
				in.next();
				System.out.println(1);
				boolean inverted = (in.nextInt() != set[0]);
				if (inverted)
					state = 1;
				else
					state = 0;
				int cpt=0;
				while (cpt<4 && ind+cpt<B/2) { // do the 8 remaining queries, stop if middle is reached
					System.out.println(ind+cpt+1);
					if (inverted)
						set[ind+cpt] = 1-in.nextInt();
					else
						set[ind+cpt] = in.nextInt();
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
						break;
					}
				}
				ind += cpt;
			}
			// if inverted
			while (cmp == 1 && found < B) {
				// next 10 queries
				System.out.println(1);
				in.next();
				System.out.println(1);
				boolean reversed = (in.nextInt() != set[0]);
				if (reversed)
					state = 2;
				else
					state = 0;
				int cpt=0;
				while (cpt<4 && ind+cpt<B/2) {
					System.out.println(ind+cpt+1);
					if (reversed)
						set[B-1-ind-cpt] = in.nextInt();
					else
						set[ind+cpt] = in.nextInt();
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
						break;
					}
				}
				ind += cpt;
			}

			// now there is a difference, or we are at the end
			while (found < B) {
				System.out.println(same+1);
				if (in.nextInt() == set[same]) {
					System.out.println(diff+1);
					if (in.nextInt() == set[diff])
						state = 0;
					else
						state = 2;
				} else {
					System.out.println(diff+1);
					if (in.nextInt() == set[diff])
						state = 3;
					else
						state = 1;
				}
				int cpt = 0;
				while (cpt<4 && ind+cpt<B/2) {
					switch (state) {
					case 0:
						System.out.println(ind+cpt+1);
						set[ind+cpt] = in.nextInt();
						System.out.println(B-ind-cpt);
						set[B-1-ind-cpt] = in.nextInt();
						break;
					case 1:
						System.out.println(ind+cpt+1);
						set[ind+cpt] = 1-in.nextInt();
						System.out.println(B-ind-cpt);
						set[B-1-ind-cpt] = 1-in.nextInt();
						break;
					case 2:
						System.out.println(ind+cpt+1);
						set[B-1-ind-cpt] = in.nextInt();
						System.out.println(B-ind-cpt);
						set[ind+cpt] = in.nextInt();
						break;
					case 3:
						System.out.println(ind+cpt+1);
						set[B-1-ind-cpt] = 1-in.nextInt();
						System.out.println(B-ind-cpt);
						set[ind+cpt] = 1-in.nextInt();
						break;
					}
					found += 2;
					cpt++;
				}
				ind += cpt;
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
			if (!in.next().equals("Y")) {
				System.out.println("Bruh");
				break;
			}
		}
		in.close();
	}

}

