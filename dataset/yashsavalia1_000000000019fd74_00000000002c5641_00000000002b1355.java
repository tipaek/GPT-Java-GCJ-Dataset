import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		int[] interestScores = new int[testCases];
		for (int i = 0; i < testCases; i++) {
			int interestScore = 0;
			
			String[] rows_columns = in.nextLine().split(" ");
			
			int rows = Integer.parseInt(rows_columns[0]);
			int columns = Integer.parseInt(rows_columns[1]);
			Competitor[][] comps = new Competitor[rows][columns];
			
			
			for (int j = 0; j < rows; j++) {
				String[] row = in.nextLine().split(" ");
				for (int k = 0; k < columns; k++) {
					comps[j][k] = new Competitor(Integer.parseInt(row[k]), comps, j, k);
					interestScore += comps[j][k].value;
				}
			}
			
			
			boolean removedPeople;
			int tempInterest;
			do {
				for(int j = 0; j < rows; j++) {
					for(int k = 0; k < columns; k++) {
						comps[j][k].setAverage(comps, j, k);
					}
				}
				tempInterest = 0;
				removedPeople = false;
				for(int l = 0; l < rows; l++) {
					for(int m = 0; m < columns; m++) {
						if(comps[l][m].value != 0 && !comps[l][m].isSkillLevel(comps, l, m)) {
							comps[l][m].value = 0;
							removedPeople = true;
						} else {
							tempInterest += comps[l][m].value;
						}
					}
				}
				if(removedPeople) {
					interestScore += tempInterest;
				}
			} while(removedPeople);
			
			interestScores[i] = interestScore;
		}
		
		for(int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i+1) + ": " + interestScores[i]);
		}
	}

}

class Competitor {
	public double average;
	public int value;

	public Competitor(int value, Competitor[][] comps, int row, int column) {
		this.value = value;
	}
	
	public boolean isSkillLevel(Competitor[][] comps, int row, int column) {
		return value >= average;
	}

	public void setAverage(Competitor[][] comps, int row, int column) {
		double sum = comps[row][column].value;
		int count = 1;
		if(row > 0 && comps[row - 1][column].value != 0) {
			sum += comps[row - 1][column].value;
			count++;
		}
		if(row < comps.length - 1 && comps[row + 1][column].value != 0) {
			sum += comps[row + 1][column].value;
			count++;
		}
		
		if(column > 0 && comps[row][column - 1].value != 0) {
			sum += comps[row][column - 1].value;
			count++;
		}
		
		if(column < comps[0].length - 1 && comps[row][column + 1].value != 0) {
			sum += comps[row][column + 1].value;
			count++;
		}
		
		average = sum / count;
	}

}
