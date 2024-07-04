import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	private final static char J = 'J';
	private final static char C = 'C';
	private static Calendar startTime = Calendar.getInstance();
	
	private static List<Timestamp> startTimes = new ArrayList<Timestamp>();
	private static List<Timestamp> endTimes = new ArrayList<Timestamp>();
	private static List<Character> characters = new ArrayList<Character>();
	

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();

		startTime.set(Calendar.HOUR_OF_DAY,0);
		startTime.set(Calendar.MINUTE,0);
		startTime.set(Calendar.SECOND,0);
		
		
        for (int qItr = 0; qItr < t; qItr++) {
        	int n = scanner.nextInt();
        	String result = getResult(n);
        	
        	endTimes.clear();
        	startTimes.clear();
        	characters.clear();
        	
        	System.out.println(result);
        }

        
        scanner.close();
    }

	private static String getResult(int n) {
		String returnVal = "";
		
		Calendar c = Calendar.getInstance();
		boolean failed = false;
		for(int i=0;i<n;i++) {
			
			Timestamp st = new Timestamp(startTime.getTimeInMillis());
			Timestamp et = new Timestamp(startTime.getTimeInMillis());
			
			st.setTime(st.getTime() + TimeUnit.MINUTES.toMillis(scanner.nextInt()));
			et.setTime(et.getTime() + TimeUnit.MINUTES.toMillis(scanner.nextInt()));
			
			char ch = getChar(st,et);
			
			if(ch == 'X') {
				failed = true;
			}
			
			returnVal += ch;
			startTimes.add(st);
			endTimes.add(et);
			characters.add(ch);
			
		}
		if(failed)
			return "IMPOSSIBLE";
		
		return returnVal;
	}

	private static char getChar(Timestamp st, Timestamp et) {
		char returnVal = 'X';
		
		char currentVal = 'J';
		
		int count = 0;
		
		for(int i=0;i<startTimes.size();i++) {
			if((st.before(startTimes.get(i)) || st.equals(startTimes.get(i))) && et.after(startTimes.get(i))
				|| (st.before(endTimes.get(i)) && (et.equals(endTimes.get(i)) || et.after(endTimes.get(i))))
				|| st.after(startTimes.get(i)) && et.before(endTimes.get(i))
				|| st.equals(startTimes.get(i)) && et.equals(endTimes.get(i))) {
				if(count == 0 && characters.get(i) == 'J') 
					currentVal = 'C';
				else if(currentVal == characters.get(i)){
					currentVal = 'X';
					break;
				}
				count ++;
			}
		}
		
		returnVal = currentVal;
		return returnVal;
	}
}
