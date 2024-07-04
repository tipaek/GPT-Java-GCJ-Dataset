import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int x = 0; x<cases; x++){
			String ans = "";
			int times = input.nextInt();
			ArrayList<Integer> all = new ArrayList<Integer>(); // list containing all times
			ArrayList<Integer> start = new ArrayList<Integer>(); // list containing start times
			ArrayList<Integer> end = new ArrayList<Integer>(); // list containing end times
			int[][] A = new int[times][2];
			for(int i = 0; i<times; i++){
				for(int j = 0; j<2; j++){
					A[i][j] = input.nextInt();
					if(!all.contains(A[i][j])){
						all.add(A[i][j]);
					}
					if(j%2==0){
						start.add(A[i][j]);
					}
					if(j%2==1){
						end.add(A[i][j]);
					}
				}
			}
			Collections.sort(all);
			Collections.sort(start);
			Collections.sort(end);
			TreeMap<Integer, Character> map = new TreeMap<Integer, Character>(); // maps starting time to person who is doing event
			TreeMap<Integer, Integer> map2 = new TreeMap<Integer, Integer>(); // maps end time to start time
			for(int i = 0; i<times; i++){
				map2.put(A[i][1], A[i][0]);
			}
			// availability of parents
			boolean J = true;
			boolean C = true;
			boolean impossible = false;
			for(int i = 0; i<all.size(); i++){
				int time = all.get(i);
				if(end.contains(time)){
					if(map.get(map2.get(time)) == 'J'){
						J = true;
					}
					if(map.get(map2.get(time)) == 'C'){
						C = true;
					}
				}
				if(start.contains(time)){
					if(J){
						J = false;
						map.put(time, 'J');
					}
					else if(C){
						C = false;
						map.put(time, 'C');
					}
					else{
						ans = "IMPOSSIBLE";
						impossible = true;
						break;
					}
				}
				
			}
			if(!impossible){
				for(int i = 0; i<times; i++){
					ans+= map.get(A[i][0]);
				}
			}
			//System.out.print(all);
			//System.out.print(start);
			//System.out.println(end);
			System.out.println("Case #" + (x+1) + ": " + ans);
			
		}
			
	}

}
