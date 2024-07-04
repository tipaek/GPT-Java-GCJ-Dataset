import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] arg) {
		int testCases=sc.nextInt();
		int x = 1;
		
		while(testCases>0) {
			
			int rows = sc.nextInt(), columns = sc.nextInt(), ans = 0;
			int[][] floor = new int[rows][columns];
			for(int i =0; i< rows; i++) {
				for(int j =0; j< columns; j++) {
					floor[i][j] = sc.nextInt();
				}
			}
			Set<List<Integer>> eliminated = new HashSet<>();
			while(true) {
				Set<List<Integer>> thisRoundEliminated = new HashSet<>();
				for(int i =0; i< rows;i++) {
					for(int j =0; j< columns; j++) {
						if(eliminated.contains(Arrays.asList(i,j))) continue;
						ans+= floor[i][j];
						int totalNeighbors = 0;
						int totalNeighborsSkills = 0;
						for(int itr = j-1; itr>=0; itr--) {
							if(!eliminated.contains(Arrays.asList(i,itr))) {
								totalNeighbors++;
								totalNeighborsSkills+=floor[i][itr];
								break;
							}
						}
						for(int itr = j+1; itr<columns; itr++) {
							
							if(!eliminated.contains(Arrays.asList(i,itr))) {
								totalNeighbors++;
								totalNeighborsSkills+=floor[i][itr];
								break;
							}
							
						}for(int itr = i-1; itr>=0; itr--) {
							
							if(!eliminated.contains(Arrays.asList(itr,j))) {
								totalNeighbors++;
								totalNeighborsSkills+=floor[itr][j];
								break;
							}
						}for(int itr = i+1; itr<rows; itr++) {
							
							if(!eliminated.contains(Arrays.asList(itr,j))) {
								totalNeighbors++;
								totalNeighborsSkills+=floor[itr][j];
								break;
							}
						}
						if((double)floor[i][j] < (double)totalNeighborsSkills/(double)totalNeighbors) {
							List<Integer> temp = new ArrayList<>();
							temp.add(i);
							temp.add(j);
							thisRoundEliminated.add(temp);
						}
					}
				}
				if(thisRoundEliminated.isEmpty()) {
					break;
				}
				eliminated.addAll(thisRoundEliminated);
				
			}
			
			System.out.println("Case #"+x+": "+ans);
			
			x++;
			testCases--;
		}
	}
}