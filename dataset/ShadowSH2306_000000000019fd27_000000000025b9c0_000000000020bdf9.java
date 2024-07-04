import java.util.*;
import java.io.*;
import java.time.Duration;

import java.time.LocalTime;

public class Solution {
	
	static String person;
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	static String f="";
	static LocalTime[] stTime;
	static LocalTime[] enTime;
	static String[] people;

	
	public static void main(String[] args) {
		
		
		
		int t = in.nextInt();
		
		int count=1;
		
		
		
		
		while(count <=t)
		{
			
			int n = in.nextInt();
			
			people = new String[n];
			for (int i = 0; i < people.length; i++) {
				
				people[i] = "C";
				
			}
			
			
			stTime = new LocalTime[n];
			enTime = new LocalTime[n];
			
			for(int i=0;i<n;i++)
			{
				//System.out.println("Entered");
				
				int st = in.nextInt();;
				
				int en = in.nextInt();;
				
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
			
			 //f="C";
			person = "C";
			
			LocalTime prev_st = stTime[0];
			LocalTime prev_en = enTime[0];
			
			boolean impossible = checkImp();
			
			if (impossible) {
				System.out.println("Case #"+count+": "+"IMPOSSIBLE");
				count+=1;
				continue;
			}
			
			
			checkOverlap();
			
			/*for(int i=1;i<stTime.length;i++)
			{
				boolean checkLap = checkOverlap(stTime[i], enTime[i], prev_st, prev_en, i);
				if (checkLap) {
					
					switchPerson();
					
					
				}
				
				f+=person;
				
				prev_st = stTime[i];
				prev_en = enTime[i];
				
				
				
			}*/
			
			
			
			for (int j = 0; j < stTime.length; j++) {
				f+=people[j];
			}
			
			while (f=="") {
				for (int j = 0; j < stTime.length; j++) {
					f+=people[j];
				}
				
				
			}
			
			if (count!=t) {
				System.out.println("Case #"+count+": "+f);
			}
			else {
				System.out.print("Case #"+count+": "+f);
			}
			
			
			
			
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
	
	public static void checkOverlap() {
		//boolean check = false;
		
		for (int i = 0; i < enTime.length; i++) {
			
			for (int j = 0; j < enTime.length; j++) {
				
				if (i!=j) {
					Boolean isOverllaping = ( 
							stTime[i].isBefore(stTime[j]) && enTime[i].isAfter(stTime[j])) || 
					        (stTime[i].isBefore(enTime[j]) && enTime[i].isAfter(enTime[j])) || 
					        (stTime[i].isBefore(stTime[j]) && enTime[i].isAfter(enTime[j]) )  ;	
					
					if (isOverllaping) {
						
						if (people[i]==people[j]) {
							if (people[j]=="C") {
								people[j]="J";
							}
							else if(people[j]=="J")
							{
								people[j]="C";
							}
						}
						
						
						
					}
						
				}
				
			}
		}
	}
			
			
			
			
			
			
			
			/*if (i!=ind) {
				
			
				
				Boolean isOverllaping = ( 
						current_start.isBefore(stTime[i]) && current_end.isAfter(stTime[i])) || 
				        (current_start.isBefore(enTime[i]) && current_end.isAfter(enTime[i])) || 
				        (current_start.isBefore(stTime[i]) && current_end.isAfter(enTime[i]) )  ;				
					
				if (!isOverllaping) {
					check=false;
					
					
				}
				else {
					check=true;
					break;
				}
			}*/
				
			
			
			
		
		
		//return check;
		
	
	
	public static String readInput()
	{
		String r="";
		r = in.nextLine();
		
		return r;
		
		
		
	}
	
	public static int findMaxInterval() {
		
		long mm=0;
		int ind=0;
		
		for (int i = 0; i < stTime.length; i++) {
			Duration duration = Duration.between(stTime[i], enTime[i]);
			if (duration.toMinutes()>mm) {
				mm= duration.toMinutes();
				ind = i;
			}
			
		}
		
		return ind;
		
		
	}
	
	public static boolean checkImp() {
		
		int maxInd = findMaxInterval();
		boolean check=false;
		
		
		for (int i = 0; i < enTime.length; i++) {
			if (i!=maxInd) {
				
				Boolean isOverllaping = ( stTime[maxInd].isBefore(stTime[i]) && enTime[maxInd].isAfter(enTime[i]));
				if (isOverllaping) {
					check=true;
				}
				else {
					check=false;
					break;
				}
				
			}
			
			
		}
		
		return check;
		
		
	}

		
	}
	


