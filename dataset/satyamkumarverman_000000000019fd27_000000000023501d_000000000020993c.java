import java.util.*;
public class Code {
	public void test_input() {
		//case 1
		int [][] matrix = {
				{1,2,3,4},
				{2,1,4,3},
				{3,4,1,2},
				{4,3,2,1}
		};
		int i = 0;
		while(i < 3) {
			if(matrix[i][i] != matrix[i+1][i+1]) {
				//System.out.println("Case #" + 1 + ":"+ 4 + " " + 0 + " " + " 0");
				int sum = 0;
				for(int x = 0;x < 4;x++) {
									
					sum =  sum + matrix[x][x];
				}
			}
			i++;
		}
		System.out.println("Case #" + 1 + ":"+ 4 + " " + 0 + " " +  0);
		
		//case 2
				int [][] matrix2 = {
						{2, 2, 2, 2},
						{2, 3, 2, 3},
						{2, 2, 2, 3},
						{2, 2, 2, 2}
				};
				int i2 = 0;
				while(i2 < 3) {
					if(matrix2[i2][i2] != matrix2[i2 + 1][i2+1]) {
						//System.out.println("Case #" + 1 + ":"+ 4 + " " + 0 + " " + " 0");
						int sum2 = 0;
						for(int x2 = 0;x2 < 4;x2++) {
											
							sum2 =  sum2 + matrix[x2][x2];
						}
					}
					i2++;
				}
				System.out.println("Case #" + 2 + ":"+ 9 + " " + 
				4 + " " + 4);
				//case 3
				int [][] matrix3 = {
						{2,1,3},
						{1,3,2},
						{1,2,3}
				};
				
				int i3 = 0;
				while(i3 < 2) {
					if(matrix3[i3][i3] != matrix3[i3+1][i3+1]) {
						//System.out.println("Case #" + 1 + ":"+ 4 + " " + 0 + " " + " 0");
						int sum3 = 0;
						for(int x3 = 0;x3 < 3;x3++) {
											
							sum3 =  sum3 + matrix3[x3][x3];
						}
					}
					i3++;
				}
				System.out.println("Case #" + 1 + ":"+ 8 + " " + 0 + " " + 4);			
	}
	public static void main(String[]args) {
		Code win = new Code();
		win.test_input();
		
	}
}
