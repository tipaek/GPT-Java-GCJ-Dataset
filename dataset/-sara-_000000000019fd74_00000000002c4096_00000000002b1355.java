import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int c = in.nextInt();
			Integer[][] skills = new Integer[r][c];
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					skills[j][k] = in.nextInt();
				}
			}
			int roundLevel = getRoundLevel(skills, r, c);
			int competitionLevel = roundLevel;
			skills = eliminateDancers(skills, r, c);
			while(getRoundLevel(skills, r, c) != roundLevel) {
				roundLevel = getRoundLevel(skills, r, c);
				competitionLevel = competitionLevel + roundLevel;
				skills = eliminateDancers(skills, r, c);
			}
			System.out.println("Case #" + i + ": " + competitionLevel);
		}
		in.close();
	}
	
	private static int getRoundLevel(Integer[][] skills, int r, int c) {
		int roundLevel = 0;
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				if(skills[j][k] != null) {
					roundLevel = roundLevel + skills[j][k];
				}
			}
		}
		return roundLevel;
	}
	
	private static Integer[][] eliminateDancers(Integer[][] skills, int r, int c) {
		Integer[][] newSkills = new Integer[r][c];
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				newSkills[j][k] = skills[j][k];
			}
		}
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				if (skills[j][k] == null) {
					continue;
				}
				double sumNeighbours = 0;
				double nbNeighbours = 0;
				for (int l = j-1; l >= 0; l--) {
					if(skills[l][k] != null) {
						sumNeighbours = sumNeighbours + skills[l][k];
						nbNeighbours++;
						break;
					}
				}
				for (int l = j+1; l < r; l++) {
					if(skills[l][k] != null) {
						sumNeighbours = sumNeighbours + skills[l][k];
						nbNeighbours++;
						break;
					}
				}
				for (int l = k-1; l >= 0; l--) {
					if(skills[j][l] != null) {
						sumNeighbours = sumNeighbours + skills[j][l];
						nbNeighbours++;
						break;
					}
				}
				for (int l = k+1; l < c; l++) {
					if(skills[j][l] != null) {
						sumNeighbours = sumNeighbours + skills[j][l];
						nbNeighbours++;
						break;
					}
				}
				double avgNeighbours = 0;
				if(nbNeighbours != 0) {
					avgNeighbours = sumNeighbours / nbNeighbours;
				}
				if(skills[j][k] < avgNeighbours) {
					newSkills[j][k] = null;
				}
			}
		}
		return newSkills;
	}
}
