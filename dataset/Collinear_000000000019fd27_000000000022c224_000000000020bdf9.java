import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int x = 0; x<cases; x++){
			String ans = "";
			int times = input.nextInt();
			time[] A = new time[times];
			for(int i = 0; i<times; i++){
				int start2 = input.nextInt();
				int end2 = input.nextInt();
				A[i] = new time(start2,end2, i);
			}
			// availability of parents
			int Jend = -1; // ending times for the tasks J and C are assigned to
			int Cend = -1;
			boolean impossible = false;
			Arrays.sort(A);
			for(int i = 0; i<A.length; i++){
				if(A[i].start >= Jend){
					A[i].person = 'J';
					Jend = A[i].end;
				}
				else if(A[i].start >= Cend){
					A[i].person = 'C';
					Cend = A[i].end;
				}
				else{
					ans = "IMPOSSIBLE";
					impossible = true;
					break;
				}
			}
			// creating answer string
			if(!impossible){
				for(int i = 0; i<times; i++){
					for(int j = 0; j<A.length; j++){
						if(i == A[j].pos){
							ans+=A[j].person;
							break;
						}
					}
				}
			}
			System.out.println("Case #" + (x+1) + ": " + ans);
			
		}
			
	}

}

class time implements Comparable<time>{
	int start;
	int end;
	int pos;
	char person; 
	public time(int start, int end, int pos){
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
	public int compareTo(time other){
		if(this.start < other.start){
			return -1;
		}
		else if(this.start > other.start){
			return 1;
		}
		return 0; 
	}
}
