import java.util.Scanner;
final class Vestigium {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt(); //the number of test cases
		for (int h=1 ; h<=T ; h++) {
			int N = input.nextInt();//the size of the matrix to explore
			int[][] arr = new int[N][N];
			for (int i=0 ; i<N ; i++) {
				System.out.println();
				for (int j=0 ; j<N ; j++)
					arr[i][j]=input.nextInt();	
			}//end for[i]
			int k = 0; //the trace of the matrix
			for (int i=0 ; i<N ; i++)
				k += arr[i][i];
			int r = 0; //the number of rows of the matrix that contain repeated elements
			for (int i=0 ; i<N ; i++) {	
				int counter =0;
				for (int j=0 ; j<N ; j++) {
					for (int l=0 ; l<N ; l++) {
						if(arr[i][j]==arr[i][l] && j!=l)
							counter++;
					}//end for[k]
				}//end for[j]
				if (counter > 0)
					r++;
			}//end for[i]
			
			int c = 0; //the number of columns of the matrix that contain repeated elements
			for (int i=0 ; i<N ; i++) {	
				int counter =0;
				for (int j=0 ; j<N ; j++) {
					for (int l=0 ; l<N ; l++) {
						if(arr[j][j]==arr[l][i] && j!=l)
							counter++;
					}//end for[k]
				}//end for[j]
				if (counter > 0)
					c++;
			}//end for[i]
			
			System.out.println("case #" + h + ":" + " " + k + " " + r + " " +c);

		}//end for[h] - T/number of cases time

	}//end main
}//end class