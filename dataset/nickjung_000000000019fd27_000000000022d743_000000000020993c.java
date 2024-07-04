package problem;

import java.util.Scanner;

public class Problem {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int shapeCount = sc.nextInt();

		int []cross_result = new int[shapeCount];
		int []row_result = new int[shapeCount];
		int []col_result = new int[shapeCount];

		int flag = 0;
	
		for (int count = 0; count <shapeCount ; count++) {
			
			int shapeSize = sc.nextInt();	
			int[][] shape = new int[shapeSize][shapeSize];

			
			for (int i = 0; i < shape.length; i++) {
				for (int j = 0; j < shape.length; j++) {
					shape[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < shape.length; i++) {
				cross_result[count]+=shape[i][i];
			}
			flag = 0;
			
			for (int i = 0; i < shape.length; i++) {
				for (int j = 0; j < shape.length; j++) {
					for (int x = j+1; x < shape.length; x++) {
						if(shape[i][j]==shape[i][x]) {
							row_result[count]+=1;
							flag = 1;
						}if(flag==1) {
							break;
						}
					}
					if(flag==1) {
						break;
					}
				}

				flag = 0;
			}
			
			flag = 0;
			
			for (int i = 0; i < shape.length; i++) {
				for (int j = 0; j < shape.length; j++) {
					for (int x = j+1; x < shape.length; x++) {
						if (shape[j][i] == shape[x][i]) {
							col_result[count]+=1;
							flag = 1;
						}if(flag==1) {
							break;
						}
					}
					if(flag==1) {
						break;
					}
				}
				flag = 0;
			}
			
		}
		
		for (int i = 0; i < col_result.length; i++) {
			System.out.print("Case #"+(i+1)+": "+cross_result[i]+" "+row_result[i]+" "+col_result[i]);
			System.out.println();
		}
		
	}

}
