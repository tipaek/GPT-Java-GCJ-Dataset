import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Solution {
	
	private static Logger logger = Logger.getLogger(Solution.class.getName());	
	
	private static final char _CAMERON='C';
	private static final char _JAMIE='J';


	/**
	 * Parent class to internally manage available time slots
	 * @author Caterina Lazaro
	 *
	 */
	public class Parent{
		//private static final int _START_DAY = 0;
		public static final char _UNAVAILABLE='X';

		private char identification;
		private int[][] activities;
		
		public Parent (char identification, int maxDailyActivities) {
			this.identification = identification;
			newDay(maxDailyActivities);
		}
		
		public boolean isAvailable(int[] newActivity) {
			for (int[] activity: activities) {
				if (activity[0]!=0 || activity[1]!=0) {
					//Assigned activity:
					if((activity[0]<=newActivity[0] && newActivity[0] < activity[1])||
						(activity[0]<newActivity[1] && 	newActivity[1]<=activity[1])){
						//Not available now
						logger.log(Level.FINE, "Not an available slot: parent busy");
						return false;
					}
				}else
					//Found one available slot of time
					return true; 
			}
			//Did not find any available slot
			return false;
		}
		
		/**
		 * Add a new activity and return the identification to show who is performing it
		 * @param activity activity
		 * @return id
		 */
		public char assignActivity(int[] activity) {
			if (isAvailable(activity)) {
				for (int i=0; i<activities.length;i++) {
					if (activities[i][0]==0 && activities[i][1]==0) {
						//Empty slot:
						activities[i][0]=activity[0];
						activities[i][1]=activity[1];
						return identification;
					}
				}
			}else
				return _UNAVAILABLE;
			logger.log(Level.WARNING, "Unfair system: all slots already covered?");
			return _UNAVAILABLE;
		}
		
		/**
		 * Start a new day, no activities assigned yet
		 * @param maxDailyActivities
		 */
		public void newDay(int maxDailyActivities) {
			activities = new int[maxDailyActivities][2];

		}
	}


	/**
	 * Read input stream
	 */
	public static String[] readInput(InputStream inStream) {
		ArrayList<String> lines  = new ArrayList<String>();
				//Use a bufferedReader
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			String line = reader.readLine();
			while (line != null) {
				//Add line to the list
				lines.add(line);
				//Get next line
				line = reader.readLine();
			}
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		 return lines.toArray(new String[lines.size()]);
	}
	
	
	/**
	 * Convert from string to int array
	 * @param activities
	 * @return int_array
	 */
	private int[][] convertActivities(String[] activities){
		int[][] convertedActivities = new int[activities.length][2];
		for (int i=0; i<activities.length; i++) {
			String[] timesString = activities[i].split(" ");
			convertedActivities[i][0] = Integer.parseInt(timesString[0]);
			convertedActivities[i][1] = Integer.parseInt(timesString[1]);
		}
		return convertedActivities;
	}
	
	
	
	/**
	 * Generate a valid schedule for C and J
	 * If activities overlap an a schedule is not possible, output IMPOSSIBLE
	 * @param activities
	 * @return
	 */
	public String computeSchedule(String[] activities, int numActivities, int scheduledDay) {
		String schedule = "";
		Parent parent1;
		Parent parent2;
		
		//Alternate starting the day
		if(scheduledDay%2 != 0) {
			 parent1 = new Parent(_CAMERON, activities.length);
			 parent2 = new Parent(_JAMIE, activities.length);
		}else {
			parent2 = new Parent(_CAMERON, activities.length);
			parent1 = new Parent(_JAMIE, activities.length);
		}
		
		if (activities.length == numActivities) {
			int[][] timeActivities = convertActivities(activities);
			for (int[] timeActivity: timeActivities) {
				//Extract init and final times
				
				//Try to assign the new activity
				char assignResult=Parent._UNAVAILABLE;
				if (timeActivity.length == 2) {
					if(parent1.isAvailable(timeActivity)) {
						assignResult = parent1.assignActivity(timeActivity);
						if (assignResult == Parent._UNAVAILABLE && parent2.isAvailable(timeActivity))
							assignResult = parent2.assignActivity(timeActivity);
					}else 
						//Try the next
						if(parent2.isAvailable(timeActivity))
							assignResult = parent2.assignActivity(timeActivity);
				}
				//Check a parent can take care of the activity
				if (assignResult == Parent._UNAVAILABLE) {
					logger.log(Level.WARNING, "Overlapping of schedules: "+schedule);
					schedule = "IMPOSSIBLE";
					break;
				}else 
					schedule += assignResult;
				}
		}else
			logger.log(Level.WARNING, "Wrong set of activities"+ activities.length);
		
		return schedule;
	}

	/**
	 * main method
	 * @param args arguments
	 */
	public static void main(String[] args) {
		 //Read the input file
        String[] lines = readInput(System.in);
        Solution solution = new Solution();
        
        //Get T = Test cases
        int T = Integer.parseInt(lines[0]);
        //Extract each ACTIVITIES group and compute an schedule
        int scheduleIndex = 1;
        int outputCase = 1;
        int totalLines = lines.length;
        int scheduledDays = 1;
        while(scheduleIndex < totalLines && T>0) {
        	int N = Integer.parseInt(lines[scheduleIndex]);
        	scheduleIndex ++;
        	String computedSchedule = solution.computeSchedule(Arrays.copyOfRange(lines,scheduleIndex, scheduleIndex+N), N, scheduledDays);
        	System.out.println(String.format("Case #%d: %s", outputCase, computedSchedule));
        	//If successfully scheduled, update
        	if (!computedSchedule.contains("IMPOSSIBLE"))
        		scheduledDays ++;
        	//Update indexes
        	outputCase ++;
        	scheduleIndex += N;
        	T--;
        }	        
        
      
	}
	

}
