import java.io.*;
import java.util.*;

public class Solution {
	public static final int EF_FLIP = 1;
	public static final int EF_REV = 2;
	public static final int EF_FLIP_REV = 3;
	public static final int EF_NOTHING = 0;

	public static void solve(Scanner input, int B) {
		int[][] bits = new int [B][10];
		int []temp = new int [10];
		int index = 0;
		int turn = 0;
		String res = "";
		String s = "";
		if (B < 11) {
			//no fluctuation occur 
			for (int i = index; i < index+10; ++i) {
				System.out.println(i+1);
				int cur = input.nextInt();
				bits[i][turn] = cur;
			}
			for (int i = 0; i < B; ++i) {
				res+=bits[i][0];
			}

			System.out.println(res);
		    s = input.next();
		    if (s.equals("Y")) {
		      return;
		} else if (B < 21) {
			for (int i = index; i < index+10; ++i) {
				System.out.println(i+1);
				int cur = input.nextInt();
				bits[i][turn] = cur;
				if (i == index + 9 && index + 10 < B) {
					index+=10;
					turn++;
				}
			}
			for (int eff = 0; eff < 4; eff++) {
				for (int i = 0; i < 11; ++i) {
					temp[i] = bits[i][1];
				}
				fluctuation(temp, eff);
				for (int i = 0; i <= 10; ++i) {
					res+=bits[i][0];
				}
				for (int i = 0; i <= 10; ++i) {
					res+=temp[i];
				}
				System.out.println(res);
				s = input.next();
			    if (s.equals("Y"))
			      return;
			    
			}

		}
		for (int i = 0; i < 10; ++i) {
			bits[i] = null;
		}
		bits = null;
		temp = null;
		index = 0;
		turn = 0;
	    
	  }
	}
	
	public static void fluctuation (int arr[], int effect) {
		switch (effect) {
		case EF_FLIP:
			for (int i = 0; i < arr.length; ++i) {
				arr[i] = arr[i] ^ (1 << 0);
			}
			break;
		case EF_REV:
			for (int i = 0; i < arr.length; ++i) {
				int temp = arr[i];
				arr[i] = arr[arr.length - 1 - i];
				arr[arr.length - 1 - i] = temp;
			}
			break;
		case EF_FLIP_REV:
			for (int i = 0; i < arr.length; ++i) {
				int temp = arr[i];
				arr[i] = arr[arr.length - 1 - i] ^ (1 << 0);
				arr[arr.length - 1 - i] = temp ^ (1 << 0);
			}
			break;
		case EF_NOTHING:
			break;
		}
	}


	  public static void main(String args[]) {
	    Scanner input = new Scanner(System.in);
	    int T = input.nextInt(); //test cases
	    int B = input.nextInt(); //bit number
	    for (int i = 1; i <= T; i++) {
	      solve(input, B);
	    }
	  }
}
