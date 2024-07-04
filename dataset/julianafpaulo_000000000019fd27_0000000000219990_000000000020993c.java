import java.util.Scanner;

public class Main
{ 
    public static int countColumns(int[][] matrix,int size){
        int rows = 0;
        int i,j;
        for (i = 0; i < size-1; i++) {
                for (j = 0; j < size; j++) {
                    if(matrix[i][j] == matrix[i+1][j]){
                        rows++;
                        j = size;
                }
                }
    	    }
        return rows+1;
    }
    
    public static int countRows(int[][] matrix,int size){
        int rows = 0;
        int i,j;
        for (i = 0; i < size; i++) {
                for (j = 0; j < size-1; j++) {
                    if(matrix[i][j] == matrix[i][j+1]){
                        rows++;
                        j = size;
                }
                }
    	    }
    	    if( rows==0) return 0;
    	    else return rows+1;
    }
    public static int getTrace(int[][] matrix,int size){
        int sum = 0;
        int i,j;
        for(i=0;i<size;i++){ 
              for(j=0;j<size;j++){ 
                 if(i==j){
                       sum = sum + matrix[i][j];
                  }
             }
         }
         return sum;
    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    
    	int tests = Integer.parseInt(input.next());
    	
    	int  y,i,j;
    	int rows=0;
    	int columns=0;
    	for(y=0; y<tests; y++){
    	    int size = Integer.parseInt(input.next());
    	    int first[][] = new int[size][size]; 
    	    for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    first[i][j] = input.nextInt();
                }
    	    }
    	    int trace = getTrace(first,size);
    	   if(trace == size){
    	       rows = 0;
    	       columns = 0;
    	   }else{
    	       rows = countRows(first,size);
    	       columns = countColumns(first,size);
    	   }
    	   System.out.println("Case #"+y+": "+trace+" "+rows+" "+ columns);
    	   
    	}
	}
}
