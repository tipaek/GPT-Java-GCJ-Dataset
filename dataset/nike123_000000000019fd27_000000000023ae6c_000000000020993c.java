import java.util.Scanner;

public class LatinSquare {
	static int[][] ipmatrix = new int[100][100];
	static int[] map = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, N, element;
		T = sc.nextInt();
		for(int i =0 ; i < T; i++) {
			N = sc.nextInt();
			for (int j = 0 ; j <N; j++) {
				for (int k = 0 ; k < N; k++) {
					ipmatrix[j][k] = sc.nextInt();
				}
			}
			findSolution(N); 
		}
	}
	private static void findSolution(int n) {
		int trace =  0, r = 0, c = 0;
		for(int iter = 0; iter < n; iter ++) {
			trace = trace + ipmatrix[iter][iter];
		}
			for(int row = 0 ; row < n ; row++) {
				for(int j = 0; j < n ; j++) {
					map[j] = 0;
				}
				for(int j = 0; j < n ; j++) {
					int mapIdx = ipmatrix[row][j]-1;
					map[mapIdx]++;
					if(map[mapIdx] > 1) {
						r++;
						break;
					}
				}
			}
			for(int column = 0 ; column < n ; column++) {
				for(int j = 0; j < n ; j++) {
					map[j] = 0;
				}
				for(int j = 0; j < n ; j++) {
					int mapIdx = ipmatrix[j][column]-1;
					map[mapIdx]++;
					if(map[mapIdx] > 1) {
						c++;
						break;
					}
				}
			}
			System.out.println(trace + " " + r + " "+c);
		}


	}
