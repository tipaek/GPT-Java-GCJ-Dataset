import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            int N = input.nextInt();
            int[][] array=new int[N][N];
            int sum=(N*(N+1))/2;
            int rowcount=0;
            int columnCount=0;
            int trace=0;
            int[] localcolum=new int[N];
            for(int i=0;i<N;i++){
            	int localsum=0;
            	for(int j=0;j<N;j++){
            		array[i][j]=input.nextInt();
            		localsum+=array[i][j];
            		localcolum[j]+=array[i][j];
            	}
            	if(localsum!=sum){
            		rowcount++;
            	}
            }
            for(int column=0;column<N;column++){
            	trace+=array[column][column];
            	if(localcolum[column]!=sum){
            		columnCount++;
            	}
            }
            System.out.printf("Case #%d: "+trace+" "+rowcount+" "+columnCount, n + 1);
        }
    }
}
