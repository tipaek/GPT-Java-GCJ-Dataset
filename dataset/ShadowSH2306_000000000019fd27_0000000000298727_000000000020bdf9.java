import java.util.*;
import java.io.*;
import java.time.Duration;

import java.time.LocalTime;

public class Solution {
	
	static String person;
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	static String fs="";
	static LocalTime[] stTime;
	static LocalTime[] enTime;
	static String[] people;

	
	public static void main(String[] args) throws IOException {
		
		
		
		int t = Integer.parseInt(in.next());
		
		int count=1;
		
		
		
		while(count <=t)
		{
			
			
			
			int n = Integer.parseInt(in.next());
			
			people = new String[n];
			for (int i = 0; i < n; i++) {
				
				people[i] = "C";
				
			}
			
			
			stTime = new LocalTime[n];
			enTime = new LocalTime[n];
			
			int cnt =0;
			
			while(cnt<n)
			{
				
			
				//System.out.println("Entered");
				
				//int st = Integer.parseInt(in.next());
				
				//int en = Integer.parseInt(in.next());
				String st_tempString="";
				String en_tempString="";
				int st=0,en=0;
				String tempString="";
				
				
				
				/*tempString = readInput();
				if (tempString.length()==0) {
					continue;
				}*/
				st_tempString = readInput();
				en_tempString = readInput();
				if (st_tempString.length()==0|en_tempString.length()==0 ) {
					continue;
					
				}
				
				st = Integer.parseInt(st_tempString);
				en = Integer.parseInt(en_tempString);
				
				

				//in.nextLine();
				
					
				
				
				tempString = tempString.trim();
				
				//System.out.println(tempString.substring(0, tempString.indexOf(" ")));
				//System.out.println(tempString.substring(tempString.indexOf(" ")+1));
				
				
				
				//st = Integer.parseInt(tempString.substring(0, tempString.indexOf(" ")));
				//en = Integer.parseInt(tempString.substring(tempString.indexOf(" ")+1));


				
				
				
				//st = Integer.parseInt(st_tempString.substring(0, st_tempString.indexOf(' ')));
				//en = Integer.parseInt(en_tempString.substring(st_tempString.indexOf(' ')+1));
				
				
				int st_h = st/60;
				int en_h = en/60;
				//System.out.println(st_h);
				//System.out.println(en_h);
				
				 st  -= (st_h*60);
				 en -=  (en_h*60);
				
				//System.out.println(en_h);
				
				if (en_h==24) {
					en_h = 23;
					en=59;
					
				}
				if (st_h==24) {
					st_h = 23;
					st=59;
					
				}
						
				stTime[cnt] = LocalTime.of(st_h, st);
				enTime[cnt] = LocalTime.of(en_h, en);
				cnt+=1;
				
				
			}
			
			//System.out.println("Exited");
			
			//System.out.println("Exited");
			fs="";
			
			 //f="C";
			person = "C";
			
			//LocalTime prev_st = stTime[0];
			//LocalTime prev_en = enTime[0];
			
			
			
			/*if (impossible) {
				System.out.println("Case #"+count+": "+"IMPOSSIBLE");
				count+=1;
				continue;
			}*/
			
			
			
			
			checkOverlap();
			boolean impossible = checkAgainOverlap();
			boolean impossible2 = checkImp();
			
				
			if (impossible || impossible2) {
				System.out.println("Case #"+count+": "+"IMPOSSIBLE");
				count+=1;
				continue;
			}
			
			
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
				fs+=people[j];
			}
			
			
			
			if (count!=t) {
				System.out.println("Case #"+count+": "+fs);
			}
			else {
				System.out.print("Case #"+count+": "+fs);
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
					/*Boolean isOverllaping = 
							(( stTime[i].isBefore(stTime[j]) && enTime[i].isAfter(stTime[j])) || 
					        (stTime[i].isBefore(enTime[j]) && enTime[i].isAfter(enTime[j])) || 
					        (stTime[i].isBefore(stTime[j]) && enTime[i].isAfter(enTime[j]) ) ||
					        
					        stTime[j].isBefore(stTime[i]) && enTime[j].isAfter(stTime[i])) || 
					        (stTime[j].isBefore(enTime[i]) && enTime[j].isAfter(enTime[i])) || 
					        (stTime[j].isBefore(stTime[i]) && enTime[j].isAfter(enTime[i]) 
									) ;	*/
					
					boolean overlaps = ( 
						    (( stTime[i].isBefore( enTime[j] ) ) 
						    && 
						    ( enTime[i].isAfter( stTime[j] ) ) 
						)|| ( stTime[j].isBefore( enTime[i] ) ) 
						    && 
						    ( enTime[j].isAfter( stTime[i] ) ) ) ;
					
					
					if (overlaps) {
						
						if (people[i].equals(people[j])) {
							if (people[j].equals("C") ){
								people[j]="J";
							}
							else if(people[j].equals("J"))
							{
								people[j]="C";
							}
						}
						
						
						
					}
						
				}
				
			}
		}
	}
	
	public static boolean checkAgainOverlap() {
		boolean check = false;
		
		for (int i = 0; i < enTime.length; i++) {
			
			for (int j = 0; j < enTime.length; j++) {
				
				if (i!=j) {
					/*Boolean isOverllaping = (( stTime[i].isBefore(stTime[j]) && enTime[i].isAfter(stTime[j])) || 
					        (stTime[i].isBefore(enTime[j]) && enTime[i].isAfter(enTime[j])) || 
					        (stTime[i].isBefore(stTime[j]) && enTime[i].isAfter(enTime[j]) ) ||
					        
					        stTime[j].isBefore(stTime[i]) && enTime[j].isAfter(stTime[i])) || 
					        (stTime[j].isBefore(enTime[i]) && enTime[j].isAfter(enTime[i])) || 
					        (stTime[j].isBefore(stTime[i]) && enTime[j].isAfter(enTime[i]) 
									) ;	*/
					
					boolean overlaps = ( 
						    (( stTime[i].isBefore( enTime[j] ) ) 
						    && 
						    ( enTime[i].isAfter( stTime[j] ) ) 
						)|| ( stTime[j].isBefore( enTime[i] ) ) 
						    && 
						    ( enTime[j].isAfter( stTime[i] ) ) ) ;
					
				
					if (overlaps && people[i].equals(people[j])) {
						
						
						return true;
					}
					else {
						check=false;
					}
						
				}
				
			}
		}
		return check;
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
		r = in.next();
		
		
		
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
	
	static String readInput2() throws IOException {
		 
	 	String tempString="";
	 	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	
	 	tempString = reader.readLine();
	 		tempString.trim();
	 		return tempString;
		
		
	 
}

		
	}


	


