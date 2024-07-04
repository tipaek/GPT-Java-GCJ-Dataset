import java.io.*;
import java.util.*;

public class Solution3 {
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(in.readLine());
		
		
		
		for (int t = 0; t < test; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			ArrayList<Long> slices = new ArrayList<Long>();
			int num = st2.countTokens();
			for (int i = 0; i < num; i++) {
				slices.add(Long.parseLong(st2.nextToken()));
			}
			
			slices.sort(null);
			
			long max = slices.get(slices.size() - 1);
			boolean hasDuplicate = false;
			boolean hasTriplet = false;
			boolean hasDouble = false;
			long duplicate = -1;
			
			for (int i = 0; i < slices.size() - 2; i++) {
				if (slices.get(i) == slices.get(i+1) && slices.get(i) == slices.get(i+2)) {
					hasTriplet = true;
					break;
				}
					
			}
			
			for (int i = 0; i < slices.size() - 1; i++) {
				if (hasDouble && hasDuplicate)
					break;
				if (slices.get(i) == slices.get(i+1)) {
					hasDuplicate = true;
					if (duplicate == -1)
						duplicate = slices.get(i);
				}
				for (int c = i+1; c < slices.size(); c++) {
					if (slices.get(c) == slices.get(i) * 2) {
						hasDouble = true;
						break;
					}
				}
			}
			
			if (d == 2) {
				if (hasDuplicate)
					System.out.println("Case #" + (t+1) + ": 0");
				else
					System.out.println("Case #" + (t+1) + ": 1");
			}
			else {
				if (hasTriplet)
					System.out.println("Case #" + (t+1) + ": 0");
				else if (hasDuplicate && duplicate < 1)
					System.out.println("Case #" + (t+1) + ": 1");
				else if (hasDouble)
					System.out.println("Case #" + (t+1) + ": 1");
				else
					System.out.println("Case #" + (t+1) + ": 2");
				
			}
//			System.out.println(slices);
//			System.out.println(hasDuplicate + " " + hasDouble);
			
			
		}
		
		
	}
}
