import java.util.ArrayList;
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
			ArrayList<Integer> pos = new ArrayList<>();
			
			for(int i=0;i<noOfAction; i++) {
				
				arr[i][0] = scan.nextInt();
				arr[i][1] = scan.nextInt();
				pos.add(i);
			}
			
			int temp = 0;
			//System.out.println(pos);
			
			for(int i=0;i<noOfAction;i++) {
			
				for(int j=0;j<noOfAction-i-1;j++) {
				
					if(arr[j][0] > arr[j+1][0]) {
					
						temp = arr[j][0];
						arr[j][0] = arr[j+1][0];
						arr[j+1][0] = temp;
						
						temp = arr[j][1];
						arr[j][1] = arr[j+1][1];
						arr[j+1][1] = temp;
						
						temp = pos.get(j);
						pos.set(j, pos.get(j+1));
						pos.set(j+1, temp);
					}
					
					//System.out.println(pos);
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
			
			String r="";
			
			//System.out.println(pos);
			
			//System.out.println();
			
			if(!result.equals("IMPOSSIBLE")) {
				
				int index = 0;
				
				for(int i=0;i<noOfAction;i++) {
					
					index = pos.indexOf(i);
					r = r + result.charAt(index);
				}
			
			
				//System.out.println(result);
				System.out.println("Case #" + (t+1) + ": " + r);
			}
			
			else
				System.out.println("Case #" + (t+1) + ": " + result);
		}
    }
}
