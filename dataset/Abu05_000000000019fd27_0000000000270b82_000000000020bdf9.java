import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	private static final boolean DEBUG = false;
	
	private static boolean isTimeOverlap(int startTime,int endTime,int startTimeC,int endTimeC) {
		
		if(startTime==startTimeC)
			return true;
		else if(startTime==endTimeC || endTime==startTimeC)
			return false;
		else if(startTimeC>startTime && startTimeC<endTime)
			return true;
		else if(endTimeC>startTime && endTimeC<endTime)
			return true;
		else if(startTime>startTimeC && startTime<endTimeC) 
			return true;
		
		return false;
		
		}
		
	private static boolean checkTimeOverlap(List<String> list,int startTime,int endTime) {
		
		
		if(list.isEmpty())
			return false;
		
		for(String time:list) {
			
			String[] timeValues=time.split(" ");
			
			if(isTimeOverlap(startTime, endTime, Integer.parseInt(timeValues[0]), Integer.parseInt(timeValues[1]))) 
				return true;
			
		}
		
		return false;	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	  
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/parent.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
            	
            	String result="";
                
            	int noOfActvities=scanner.nextInt();
            
            	List<String> cameron=new ArrayList<String>();
            	
            	List<String> jamie=new ArrayList<String>();
            	
            	boolean isOverlapped=false;
            	
            	for(int loop=0;loop<noOfActvities;loop++) {
            		
            		int startTime=scanner.nextInt();
            		
            		int endTime=scanner.nextInt();
            		
            		if(loop%2==0) {
            			
            			if(!checkTimeOverlap(cameron, startTime, endTime)) {
            				
            				cameron.add(startTime+" "+endTime);
            				
            				result=result+"C";
            				
            			}else if(!checkTimeOverlap(jamie, startTime, endTime)) {
            				
            				jamie.add(startTime+" "+endTime);
            				
            				result=result+"J";
            				
            			}else {
            				
            				isOverlapped=true;
            				break;
            				
            			}
            		}else {
            			
                        if(!checkTimeOverlap(jamie, startTime, endTime)) {
                        	
                        	jamie.add(startTime+" "+endTime);
                        	
                        	result=result+"J";
            				
            			}else if(!checkTimeOverlap(cameron, startTime, endTime)) {
            				
            				cameron.add(startTime+" "+endTime);
            				
            				result=result+"C";
            				
            			}else {
            				
            				isOverlapped=true;
            				break;
            				
            			}
           
            		}
            			
            	}
            	if(isOverlapped)
            		result="IMPOSSIBLE";
            	
                System.out.println("Case #" + testNumber + ": "+result);
            }
        }
    }

}
