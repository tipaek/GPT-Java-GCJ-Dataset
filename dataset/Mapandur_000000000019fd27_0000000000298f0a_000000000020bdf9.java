import java.util.*;
public class parenting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int z=1; z <= T; z++) {
        	int size=sc.nextInt();
        	//int[] cStart = new int[size];
        	List<Integer> cStart = new ArrayList<>();
        	List<Integer> cEnd = new ArrayList<>();
        	List<Integer> jStart = new ArrayList<>();
        	List<Integer> jEnd = new ArrayList<>();
        	//boolean c = false;
        	//boolean f = false;
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < size; i++) {
        		boolean c = false;
            	boolean f = false;
        		int val1 = sc.nextInt();
        		int val2 = sc.nextInt();
        		
        		if (cStart.size() == 0) {
        			cStart.add(val1);
    				cEnd.add(val2);
    				c = true;
    				sb.append("C");
        		}
        		else {
        			int m = cStart.size();
	        		for (int j = 0; j < m; j++) {
	        			if ((cStart.get(j) < val1 && cStart.get(j) <=val2)) {
	        				if (cEnd.get(j) <= val1  && cEnd.get(j) < val2) {
	        			
	        				cStart.add(val1);
	        				cEnd.add(val2);
	        				c = true;
	        				sb.append("C");
	        				break;
	        			}
	        			}
	        				
	        			else if ((cStart.get(j) >= val1  && cStart.get(j) > val2) && (cEnd.get(j) >= val1  && cEnd.get(j) > val2)) {
	        				cStart.add(val1);
	        				cEnd.add(val2);
	        				c = true;
	        				sb.append("C");
	        				break;
	        			}
	        		}
        		}
        		
        		if (c == true) continue;
        		
        		if (jStart.size() ==0) {
        			jStart.add(val1);
    				jEnd.add(val2);
    				f = true;
    				sb.append("J");
        		}
        		else {
        			int m = jStart.size();
	        		for (int j = 0; j < m; j++) {
	        			if ((jStart.get(j) < val1 && jStart.get(j) <=val2) && (jEnd.get(j) <= val1  && jEnd.get(j) < val2)) {
	        				jStart.add(val1);
	        				jEnd.add(val2);
	        				f = true;
	        				sb.append("J");
	        				break;
	        			}
	        				
	        			else if ((jStart.get(j) >= val1  && jStart.get(j) > val2) && (jEnd.get(j) >= val1  && jEnd.get(j) > val2)) {
	        				jStart.add(val1);
	        				jEnd.add(val2);
	        				f = true;
	        				sb.append("J");
	        				break;
	        			}
	        		}
        		}
        		
        		if (!c && !f) {
        			sb.replace(0, sb.length(), "IMPOSSIBLE");
        			//sb = "IMPOSSIBLE";
        			break;
        		}
        		
        	}

            System.out.println("Case #" +z+ ":" + " " +sb.toString());

        }
	}

}