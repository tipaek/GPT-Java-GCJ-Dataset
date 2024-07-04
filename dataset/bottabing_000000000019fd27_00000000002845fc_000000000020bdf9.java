    import java.util.*;
    import java.io.*;

    public class Solution {
    	public static void main(String[] args) throws FileNotFoundException {
    		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		//File f = new File("tests/3.txt");
    		//Scanner in = new Scanner(f);
    		int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		Event[] map;
			boolean impossible;
    		
    		for (int test = 1; test <= testCount; test++) {
    			int totalEvents = in.nextInt();
    			map = new Event[totalEvents]; 
    			char[] solution = new char[totalEvents];
    			for(int event = 0; event < totalEvents; event++) {
    				Integer[] array = new Integer[2];

    				int startInt = in.nextInt();
    				int endInt = in.nextInt();
    				array[0] = endInt;
    				array[1] = event;
    				map[event] = new Event(startInt, endInt, event);
    			}
    			
//    			Integer[] x = new Integer[2];
//    			Integer[] y = new Integer[2];
//    			Integer[] z = new Integer[2];
//
//    			x[0] = 660;
//    			x[1] = 0;
//    			y[0] = 480;
//    			y[1] = 1;
//    			z[0] = 540;
//    			z[1] = 2;
//    			
//    			map.put(600, x);
//    			map.put(360, y);
//    			map.put(420, z);
    			
    			//Map<Integer, Integer[]> sortedMap = sortByValue(map); 
    			Arrays.sort(map);
    			
//    			for (Map.Entry<Integer, Integer[]> en : sortedMap.entrySet()) { 
//    	            System.out.println("Key = " + en.getKey() +  
//    	                          ", end = " + en.getValue()[0] +  
//    	                          ", index = " + en.getValue()[1]); 
//    	        } 
    			
//    			for(int i = 0; i < map.length; i++) {
//    				System.out.println(map[i].getStart());
//    				System.out.println(map[i].getEnd());
//    				System.out.println(map[i].getIndex());
//    			}
//    			System.exit(1);
    			
    			boolean cameronWorking = false;
    			int cameronStart = 0;
    			int cameronEnd = 0;
    			boolean jamieWorking = false;
    			int jamieStart = 0;
    			int jamieEnd = 0;
    			impossible = false;
    			
    			for (int i = 0; i < map.length; i++) { 
    				int currentStart = map[i].getStart();
    				int currentEnd = map[i].getEnd();
    				int index = map[i].getIndex();
    				
    				if(cameronEnd <= currentStart) {
    					cameronWorking = false;
    				}
    				if(jamieEnd <= currentStart) {
    					jamieWorking = false;
    				}
    				
    				if(!cameronWorking) {
    					cameronWorking = true;
    					cameronEnd = currentEnd;
    					solution[index] = 'C';
    				}
    				else if(!jamieWorking) {
    					jamieWorking = true;
    					jamieEnd = currentEnd;
    					solution[index] = 'J';
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
    				System.out.println("Case #" + test + ": " + new String(solution));
    			}
    		}
    		in.close();
    	}
   		public static HashMap<Integer, Integer[]> sortByValue(HashMap<Integer, Integer[]> map) 
    	{ 
    		List<Map.Entry<Integer, Integer[]> > list = 
    			new LinkedList<Map.Entry<Integer, Integer[]> >(map.entrySet()); 

    		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer[]> >() { 
    			public int compare(Map.Entry<Integer, Integer[]> o1, 
   								Map.Entry<Integer, Integer[]> o2) 
    			{ 
    				return (o1.getKey()).compareTo(o2.getKey()); 
    			} 
    		});
    		 HashMap<Integer, Integer[]> temp = new LinkedHashMap<Integer, Integer[]>(); 
    	        for (Map.Entry<Integer, Integer[]> aa : list) { 
    	            temp.put(aa.getKey(), aa.getValue()); 
    	        } 
    	        return temp;  
    	}	
   		
    }
    class Event implements Comparable<Event> {

    	private int start;
    	private int end;
    	private int index;

    	public Event(int start, int end, int index) {
    		this.start = start;
    		this.end = end;
    		this.index = index;
    	}

    	public int getStart() {
    		return start;
    	}

    	public int getEnd() {
    		return end;
    	}
    	public int getIndex() {
    		return index;
    	}

    	@Override
    	public int compareTo(Event o) {
    		return this.start - o.getStart();
    	}
    }