    import java.util.*;
    import java.io.*;

    public class Solution {
    	public static void main(String[] args) throws FileNotFoundException {
    		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		//File f = new File("tests/3.txt");
    		//Scanner in = new Scanner(f);
    		int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		HashMap<Integer, Integer> map;
    		StringBuilder sb = new StringBuilder();
			boolean impossible;
    		
    		for (int test = 1; test <= testCount; test++) {
    			map = new HashMap<Integer, Integer>(); 
    			int totalEvents = in.nextInt();
    			for(int event = 0; event < totalEvents; event++) {
    				map.put(in.nextInt(), in.nextInt());
    			}
    			
    			Map<Integer, Integer> sortedMap = sortByValue(map); 
    			
    			boolean cameronWorking = false;
    			int cameronStart = 0;
    			int cameronEnd = 0;
    			boolean jamieWorking = false;
    			int jamieStart = 0;
    			int jamieEnd = 0;
    			sb = new StringBuilder();
    			impossible = false;
    			
    			for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) { 
    				int currentStart = entry.getKey();
    				int currentEnd = entry.getValue();
    				
    				if(cameronEnd <= currentStart) {
    					cameronWorking = false;
    				}
    				if(jamieEnd <= currentStart) {
    					jamieWorking = false;
    				}
    				
    				if(!cameronWorking) {
    					cameronWorking = true;
    					cameronEnd = currentEnd;
    					sb.append("C");
    				}
    				else if(!jamieWorking) {
    					jamieWorking = true;
    					jamieEnd = currentEnd;
    					sb.append("J");
    				}
    				else {
    					impossible = true;
    					break;
    				}
    			}
    			if(impossible) {
    				System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
    			}
    			else {
    				System.out.println("Case #" + test + ": " + sb.toString());
    			}
    		}
    		in.close();
    	}
   		public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map) 
    	{ 
    		List<Map.Entry<Integer, Integer> > list = 
    			new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet()); 

    		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
    			public int compare(Map.Entry<Integer, Integer> o1, 
   								Map.Entry<Integer, Integer> o2) 
    			{ 
    				return (o1.getKey()).compareTo(o2.getKey()); 
    			} 
    		}); 
    			
    		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
    		for (Map.Entry<Integer, Integer> aa : list) { 
   				temp.put(aa.getKey(), aa.getValue()); 
    		} 
    		return temp; 
    	} 
    }