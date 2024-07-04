import java.util.Scanner;
public class Solution {
	public static void Solution(String args[]) {
		Scanner a = new Scanner(System.in);
		String line = null;
		line = a.nextLine();
		int cases = 0;
		cases = Integer.parseInt(line);
		for(int i = 0; i<cases;i++) {
			int num=0;
			num = Integer.parseInt(a.nextLine());
			int[][] square = new int[num][num];
			for(int k=0; k<num;k++) {
				for(int j=0;j<num;j++) {
					square[k][j] = a.nextInt(); 
					
				}a.nextLine();
			}
			int dia = diagonal(square,num);
			int row = row(square,num);
			int col = col(square, num);
			System.out.println("Case #"+(i+1)+":"+ dia + row + col );
		}
	}
	
	static int diagonal(int [][]square,int num) {
		int dia=0;
		for(int i=0;i<num;i++) {
			dia+=square[i][i];
		}
		return dia;
	}
	
	static int row(int [][]square, int num) {
		int count=0;
			for(int row=0;row<num;row++) {
				int check=1;
				int a=0;
				while(check<=num && a<2 ) {
					a=0;
					for(int col=0;col<num;col++) {
						if(check==square[row][col]) {
							a++;
					    }
				    }
					check++;
			    }
				if(a>=2) {
					count++;
				}
				
		   }
			return count;
	}
	
	static int col(int [][]square, int num) {
		int count=0;
			for(int col=0;col<num;col++) {
				int check=1;
				int a=0;
				while(check<=num && a<2 ) {
					a=0;
					for(int row=0;row<num;row++) {
						if(check==square[row][col]) {
							a++;
					    }
				    }
					check++;
			    }
				if(a>=2) {
					count++;
				}
				
		   }
			return count;
	}
}
