import java.util.*;
import java.io.*;
import java.time.LocalTime;

public class Solution {
	
	static String person;
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	static String f="";

	
	public static void main(String[] args) {
		
		
		in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		
		int count=1;
		
		LocalTime[] stTime;
		LocalTime[] enTime;
		
		
		while(count <=t)
		{
			
			int n=0;
			n = Integer.parseInt(readInput().trim());
			
			
			stTime = new LocalTime[n];
			enTime = new LocalTime[n];
			
			for(int i=0;i<n;i++)
			{
				//System.out.println("Entered");
				
				int st = Integer.parseInt(readInput().trim());
				
				int en = Integer.parseInt(readInput().trim());
				
				int st_h = st/60;
				int st_min = st-(st_h*60);
				int en_h = en/60;
				int en_min = en-(en_h*60);
				
				//System.out.println(en_h);
				
				if (en_h==24) {
					en_h = 23;
					en_min=59;
					
				}
				if (st_h==24) {
					st_h = 23;
					st_min=59;
					
				}
						
				stTime[i] = LocalTime.of(st_h, st_min);
				enTime[i] = LocalTime.of(en_h, en_min);
				
			}
			
			//System.out.println("Exited");
			f="";
			
			 f="C";
			person = "C";
			
			LocalTime prev_st = stTime[0];
			LocalTime prev_en = enTime[0];
			
			for(int i=1;i<stTime.length;i++)
			{
				boolean checkLap = checkOverlap(stTime[i], enTime[i], prev_st, prev_en);
				if (checkLap) {
					
					switchPerson();
					
					
				}
				
				f+=person;
				
				prev_st = stTime[i];
				prev_en = enTime[i];
				
				
				
			}
			
			System.out.println("Case #"+count+": "+f);
			
			
			count+=1;
			
		}
		
		
		
		} 
	
	public static void switchPerson() {
	
		if (person.equals("C")) {
			person = "J";
		}
		else if (person.equals("J")) {
			
			person = "C";
			
		} 
		
	
		
	}
	
	public static boolean checkOverlap(LocalTime current_start, LocalTime current_end, LocalTime prev_start, LocalTime prev_end) {
		
		Boolean isOverllaping = ( 
				current_start.isBefore(prev_start) && current_end.isAfter(prev_start)) || 
		        (current_start.isBefore(prev_end) && current_end.isAfter(prev_end)) || 
		        (current_start.isBefore(prev_start) && current_end.isAfter(prev_end) )  ;
		
		if (isOverllaping) {
			return true;
			
		}
		else {
			return false;
		}
		
	}
	
	public static String readInput()
	{
		String r="";
		r = in.nextLine();
		if ((!r.equals(""))) {
			return r;
		}
		
		return r=in.nextLine();
	}

		
	}
	


