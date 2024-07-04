import java.util.*;
import java.io.*;
public class Solution {
	static boolean debug = false;
	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	static void reverse(int[] arr) {
		for(int i=0; i<arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}		
	}
	
	static void complement(int[] arr) {
		for(int k=0; k<arr.length; k++) {
			arr[k] = (arr[k]+1)%2;
		}
	}

	static int[] solve(int b, Scanner in) {
		int[] result = new int[b];
		int index = 0;
		int query = 0;
	
		System.out.println(1);
		System.out.flush();
		result[0] = in.nextInt();
		if (b==1)
			return result;

		System.out.println(b);
		System.out.flush();
		result[b-1] = in.nextInt();

		query = 2;
		index = 1;

		while(query<150 && index<b/2) {
			if (debug) System.out.println("Query: " + query);

			if (query%10 == 0) {
				System.out.println(1);
				System.out.flush();
				int resLeftFirst = in.nextInt();
				query = query + 1;

				int resLeftSecond = -1;
				int secondIndex = -1;

				for(int i=1; i<index; i++) {
					if ((result[b-1] != result[0] && result[b-i-1] == result[i]) || 
							(result[b-1] == result[0] && result[b-i-1] != result[i])){
						secondIndex = i;
						System.out.println(i+1);
						System.out.flush();
						resLeftSecond = in.nextInt();
						query = query + 1;
						break;
					}
				}
				
				if (secondIndex == -1) {
					System.out.println(1);
					System.out.flush();
					in.nextInt();
					query = query + 1;

					if (resLeftFirst != result[0]) {
							if (debug) System.out.println("Complement");
							complement(result);
					}
				} else {
					int diff = 0;
					if (resLeftFirst != result[0]) diff++;
					if (resLeftSecond != result[secondIndex]) diff++;

					if (diff == 2) {				
						if (debug) System.out.println("Complement");
						complement(result);
					}
					if (diff == 1) {
						if ((resLeftFirst != result[b-1]) ||  (resLeftSecond != result[b-secondIndex-1])) {
							if (debug) System.out.println("Reverse/Complement");
							reverse(result);
							complement(result);
						} else {
							if (debug) System.out.println("Reverse");
							reverse(result);							
						}
					}
				}
			}
			
			System.out.println(index+1);
			System.out.flush();
			result[index] = in.nextInt();

			System.out.println(b-index);
			System.out.flush();
			result[b-index-1] = in.nextInt();

			index++;
			query = query + 2;
			if (debug) printArray(result);
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		int b = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			printArray(solve(b, in));
			System.out.flush();
			if (in.next() == "N")
				break;
		}
		in.close();
	}

}
