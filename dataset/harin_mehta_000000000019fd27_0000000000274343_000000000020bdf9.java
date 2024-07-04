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
        	helper(schedules, 0, "", cSet, jSet);
        	System.out.println("Case #"+x+": "+result);
            x++;
            testCases--;
            result = "IMPOSSIBLE";
        }
    }
    static String result = "IMPOSSIBLE";
    
    public static boolean helper(List<List<Integer>> schedules, int index, String ans, Set<List<Integer>> cSet, Set<List<Integer>> jSet) {
    	
    	if(index >=schedules.size()) {
    		result = ans;
    		return true;
    	}
   	  	if(!collide(schedules.get(index), jSet)) {
       		jSet.add(schedules.get(index));
       		ans+= "J";
       		if(helper(schedules, index+1, ans, cSet, jSet)) return true;
       		jSet.remove(schedules.get(index));
       		ans= ans.substring(0,ans.length()-1);
       	}
       	if(!collide(schedules.get(index), cSet)) {
       		cSet.add(schedules.get(index));
       		ans+= "C";
       		if(helper(schedules, index+1, ans, cSet, jSet))return true;
       		cSet.remove(schedules.get(index));
       		ans= ans.substring(0,ans.length()-1);
       	}
       	return false;
    }
    private static boolean collide(List<Integer> schedule, Set<List<Integer>> set) {
    	Iterator<List<Integer>> itr = set.iterator();
    	List<Integer> available;
    	while(itr.hasNext()) {
    		available = itr.next();
    		if(available.get(0) < schedule.get(0) && available.get(1) > schedule.get(0)) return true;
    		if(available.get(0) > schedule.get(0) && available.get(0) < schedule.get(1)) return true;
    		if(available.get(1) > schedule.get(0) && available.get(1) < schedule.get(1)) return true;
    	}
    	return false;
    }    
}
