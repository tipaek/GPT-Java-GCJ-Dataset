import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		//Scanner in = new Scanner(new File("solution.in"));
		int cases = Integer.parseInt(in.nextLine());

		for(int p = 0; p < cases; p++){
			int size = in.nextInt();
			String out = "J";
			Interval[] arr = new Interval[size];
			int[] amount = new int[size];
			for(int r = 0; r < size; r++){
				in.nextLine();
				arr[r] = new Interval(Integer.parseInt(in.next()), Integer.parseInt(in.next()));
			}

			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					if(overlap(arr[i].start,arr[j].start,arr[i].end,arr[j].end) && j!=i)
						amount[i]++;
				}
			}

			for(int x = 1; x < size; x++){
				if(amount[x] >= size-1){
					out = "IMPOSSIBLE";
					break;
				}
				else if(overlap(arr[0].start,arr[x].start,arr[0].end,arr[x].end))
					out+="C";
				else
					out+="J";

			}
			System.out.println("Case #" + (p+1)+ ": " + out);


		}
	}
	public static boolean overlap(int a1, int b1, int a2, int b2){
		return Math.max(a2, b2) - Math.min(a1, b1) < (a2 - a1) + (b2 - b1);
	}

}

class Interval{
	int start;
	int end; 

	public Interval(int start, int end){
		super();
		this.start = start;
		this.end = end;
	}
}