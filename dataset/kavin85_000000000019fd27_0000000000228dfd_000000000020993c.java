import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            int N = input.nextInt();
            int[][] array=new int[N][N];
            int[][] dummy=new int[N][N];
            int[][] dummytwo=new int[N][N];
            int rowcount=0;
            int columnCount=0;
            int trace=0;
            for(int i=0;i<N;i++){
            	for(int j=0;j<N;j++){
            		array[i][j]=input.nextInt();
            		dummy[i][array[i][j]-1]=1;
            		dummytwo[array[i][j]-1][j]=1;
            	}
            }
            for(int column=0;column<N;column++){
            	trace+=array[column][column];
            	int firstbreak=0;
            	int secondbreak=0;
            	for(int count=0;count<N;count++){
            		if(firstbreak==0&&dummy[column][count]==0){
            			rowcount++;
            			firstbreak=1;
            		}
            		if(secondbreak==0&&dummytwo[count][column]==0){
            			columnCount++;
            			secondbreak=1;
            		}
            	}
            }
            System.out.printf("Case #%d: "+trace+" "+rowcount+" "+columnCount, n + 1);
        }
        }
}
