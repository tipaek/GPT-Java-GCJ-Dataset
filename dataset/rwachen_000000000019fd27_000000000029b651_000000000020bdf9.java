import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.valueOf(scanner.nextLine());
		    String[] input = new String[N];
		    for (int j = 0; j < N; j++) {
		        input[j] = scanner.nextLine();
		    }
		    int[][] activities = new int[N][2];
		    int[][] sortedActivities = new int[N][2];
		    for (int j = 0; j < N; j++) {
		        String[] inputs = input[j].split(" ");
		        for (int k = 0; k < inputs.length; k++) {
		            activities[j][k] = Integer.valueOf(inputs[k]);
		            sortedActivities[j][k] = Integer.valueOf(inputs[k]);
		        }
		    }
		    sortbyColumn(sortedActivities, 0);
		    solve(activities, sortedActivities, N, i);
		}
	}

		
	public static void solve (int[][] unsortedInput, int[][] sortedInput, int N, int number) {
		//C = 1
		//J = 0
		int cBusyUntil = sortedInput[0][1];
		int jBusyUntil = 0;
		String solution = "1";
		for (int i = 1; i < N; i++) { //goes 1 by 1 activities
			if (sortedInput[i][0] >= cBusyUntil) {
				solution += "1";
				cBusyUntil = sortedInput[i][1];
			} else if (sortedInput[i][0] >= jBusyUntil) {
				solution += "0";
				jBusyUntil = sortedInput[i][1];
			} else {
				solution = "IMPOSSIBLE";
				break;
			}
		}
		if (solution == "IMPOSSIBLE") {
			System.out.println("Case #" + (number + 1) + ": " + solution);
		} else {
			int[][] sortedSolution = new int[N][3];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					sortedSolution[i][j] = sortedInput[i][j];
				}
				sortedSolution[i][2] = Integer.valueOf(solution.substring(i, i+1));
			}
			unSort(unsortedInput, sortedSolution, N, number);
		}		
	}	
	
	public static void unSort(int[][] unsortedInput, int[][] sortedSolution, int N, int number) {
		String solution = "";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (unsortedInput[i][0] == sortedSolution[j][0] && unsortedInput[i][1] == sortedSolution[j][1] && sortedSolution[j][2] != 2) {
					if (sortedSolution[j][2] == 1) {
						solution += "C";
						sortedSolution[j][2] = 2;
					} else {
						solution += "J";
						sortedSolution[j][2] = 2;
					}
					break;
				}
			}
		}
		System.out.println("Case #" + (number + 1) + ": " + solution);
	}
	
	
	
	public static void sortbyColumn(int arr[][], int col) {
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
}