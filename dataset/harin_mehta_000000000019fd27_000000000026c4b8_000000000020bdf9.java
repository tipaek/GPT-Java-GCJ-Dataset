import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
class Solution{
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int x = 1;
        while(testCases>0){
            int n = sc.nextInt();
        	List<List<Integer>> schedules = new ArrayList<>(n);
        	for(int i = 0; i<n; i++) {
        		List<Integer> schedule = new ArrayList<>();
        		for(int j = 0; j<2; j++) {
        			schedule.add(sc.nextInt());
        		}
        		schedules.add(schedule);
        	}
        	
        	String ans = "";
        	Set<List<Integer>> cSet = new HashSet<>();
        	Set<List<Integer>> jSet = new HashSet<>();
        	
        	for(List<Integer> schedule : schedules) {
        		
        		if(!collide(schedule, cSet)) {
        			cSet.add(schedule);
        			ans+= "C";
        		}
        		else if(!collide(schedule, jSet)) {
        			jSet.add(schedule);
        			ans+= "J";
        		}
        		else {
        			ans = "IMPOSSIBLE";
        			break;
        		}
        	}
        	System.out.println("Case #"+x+": "+ans);
            x++;
            testCases--;
        }
        
    }
    
    private static boolean collide(List<Integer> schedule, Set<List<Integer>> set) {
    	
    	Iterator<List<Integer>> itr = set.iterator();
    	List<Integer> available;
    	while(itr.hasNext()) {
    		
    		available = itr.next();
    		
    		if(available.get(0) < schedule.get(0) && available.get(1) > schedule.get(1)) return true;
    		if(available.get(0) > schedule.get(0) && available.get(0) < schedule.get(1)) return true;
    		if(available.get(1) > schedule.get(0) && available.get(1) < schedule.get(1)) return true;
    		
    	}
    	
    	return false;
    }
    
    
}


