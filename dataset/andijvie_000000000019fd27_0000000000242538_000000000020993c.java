import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int grids = scanIntLine(scanner);
		for(int i = 1; i <= grids; i++) {
			int rows = scanIntLine(scanner);
			int[][] grid = scanGrid(scanner, rows, rows);
			System.out.println("Case #" + i + ": " + trace(grid) + " " + uniqueH(grid) + " " + uniqueV(grid));
		}
	}
	public static int scanIntLine(Scanner scanner) {
		int output = scanner.nextInt();
		scanner.nextLine();
		return output;
	}
	public static int[][] scanGrid(Scanner scanner, int width, int height) {
		int[][] output = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int number = scanner.nextInt();
				output[x][y] = number;
			}
			scanner.nextLine();
		}
		return output;
	}
	public static int trace(int[][] grid) {
		int output = 0;
		for(int i = 0; i <  grid.length; i++) {
			output += grid[i][i];
		}
		return output;
	}
	public static int uniqueH(int[][] grid) {
		int tot = 0;
		for(int i = 0; i < grid[0].length; i++) {
			boolean unique = true;
			for(int j = 0; j < grid.length - 1; j++) {
				for(int k = j + 1; k < grid.length; k++) {
					if(grid[j][i] == grid[k][i])
						unique = false;
				}
			}
			if(!unique)
				tot++;
		}
		return tot;
	}
	public static int uniqueV(int[][] grid) {
		int tot = 0;
		for(int i = 0; i < grid.length; i++) {
			boolean unique = true;
			for(int j = 0; j < grid[0].length - 1; j++) {
				for(int k = j + 1; k < grid[0].length; k++) {
					if(grid[i][j] == grid[i][k])
						unique = false;
				}
			}
			if(!unique)
				tot++;
		}
		return tot;
	}
}
