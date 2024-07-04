import java.util.Scanner;

public class Sol1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int i=0;i<testCases;i++){
			int squareMatrix  = sc.nextInt();
			if (squareMatrix < 2)
				continue;
			else{
				int sum = 0;
				int countRow = 0;
				int countCol = 0;
				int flag = 0;
				int[][] arr = new int[squareMatrix][squareMatrix];
				for(int row = 0; row < squareMatrix; row++){            //sum calc
					for(int col = 0; col < squareMatrix; col++){
						arr[row][col] = sc.nextInt();
						if(row == col)
							sum += arr[row][col];
					}
				}
				for(int row = 0; row < squareMatrix; row++){            //row
					for(int col = 0; col < squareMatrix; col++){
						flag = 0;
						for(int j = col+1; j < squareMatrix; j++){
							if(arr[row][col] == arr[row][j]) {
								flag = 1;
								break;
							}
						}
						if(flag == 0)
							continue;
						else{
							countRow++;
							break;
						}
					}
				}
				for(int row = 0; row < squareMatrix; row++){            //col
					for(int col = 0; col < squareMatrix; col++){
						flag = 0;
						for(int j = col+1; j < squareMatrix; j++){
							if(arr[col][row] == arr[col][j]){
								flag = 1;
								break;
							}
						}
						if(flag == 0)
							continue;
						else{
							countCol++;
							break;
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+sum+" "+countRow+" "+countCol);
			}
		}

	}
}
