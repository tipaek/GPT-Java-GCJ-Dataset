import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) {
		InputStreamReader reader=new InputStreamReader(System.in);
		BufferedReader bufferReader=new BufferedReader(reader);
		Integer rows=null;
		try {
			Integer testCases=Integer.parseInt(bufferReader.readLine());
			for(int i=1;i<=testCases;i++){
				int[][] array=null;
				rows=Integer.parseInt(bufferReader.readLine());
				array=new int[rows][rows];
				long sum=rows*(rows+1)/2;
				int rowCounter=0,columnCounter=0;
				for(int j=1;j<=rows;j++){
					String [] temp=bufferReader.readLine().split(" ");
					for(String str: temp){
						array[rowCounter][columnCounter++]=Integer.parseInt(str);
					}
					rowCounter++;
					columnCounter=0;
					
					
				}
				System.out.println(Solution.calculate(array,rows,i,sum));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String calculate(int[][] input,int rows,int caseNum,long sum){
		int[] hash=new int[rows];
		
		long trace=0L;
		long rowsResults=0L;
		long columnResults=0L;
		for(int i=0;i<rows;i++){
			trace+=input[i][i];
		}
		for(int i=0;i<rows;i++){
			hash=null;
			hash=new int[rows];
			for( int j=0;j<rows;j++){
				if(hash[input[i][j]-1]!=0){
					rowsResults++;
					break;
				}
				else{
					hash[input[i][j]-1]++;
				}
			}
			
		}
		
		for(int i=0;i<rows;i++){
			hash=null;
			hash=new int[rows];
			for( int j=0;j<rows;j++){
				if(hash[input[j][i]-1]!=0){
					columnResults++;
					break;
				}
				else{
					hash[input[j][i]-1]++;
				}
			}
		}
	
		return "Case #"+caseNum+": "+trace+" "+rowsResults+" "+columnResults;
	}

}
