import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int t=0;t<T;t++) {
			
			int noOfAction = scan.nextInt();
			
			String result="";
			
			int startTime=0;
			int endTime = 0;
			
			int jStart = 0;
			int jEnd=0;
			int cStart = 0;
			int cEnd=0;
			
			int[][] arr = new int[noOfAction][noOfAction];
			
			for(int i=0;i<noOfAction; i++) {
				
				arr[i][0] = scan.nextInt();
				arr[i][1] = scan.nextInt();
				
			}
			
			int temp = 0;
			
			for(int i=0;i<noOfAction;i++) {
			
				for(int j=0;j<noOfAction-i-1;j++) {
				
					if(arr[j][0] > arr[j+1][0]) {
					
						temp = arr[j][0];
						arr[j][0] = arr[j+1][0];
						arr[j+1][0] = temp;
						
						temp = arr[j][1];
						arr[j][1] = arr[j+1][1];
						arr[j+1][1] = temp;
					}
				}
			}
			
			for(int i=0;i<noOfAction;i++) {
				
				startTime = arr[i][0];
				endTime = arr[i][1];
				
				if(jEnd <= startTime) {
					
					jStart = startTime;
					jEnd = endTime;
					result = result + "J";
				}
				
				else if(cEnd <= startTime) {
					
					cStart = startTime;
					cEnd = endTime;
					result = result + "C";
				}
				
				else {
					
					result = "IMPOSSIBLE";
					break;
				}
				
				//System.out.println(jStart + "  " + jEnd + "  " + cStart + "  " + cEnd);
				//System.out.println(result);
			}
			
			System.out.println("Case #" + (t+1) + ": " + result);
		}
    }
}