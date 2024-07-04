import java.util.*;


import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int t = 0; t < testCases; ++t) {		
			int n = in.nextInt();
			Schedule array[] = new Schedule[n];
			for(int i =0; i<n; i++) {
				int a,b;
				a = in.nextInt();	
				b = in.nextInt();
				array[i] = new Schedule(a, b, i);
			}
			if(array.length > 1) {
				Arrays.sort(array, new Comparator<Schedule>() {
					@Override
					public int compare(Schedule first, Schedule second) {
						if(first.startTime <= second.startTime) {
							return -1;
						} else {
							return 1;
						}
					}
				});	
			}
			int cEnd = 0;
			int jEnd = 0;
			char arr[] = new char[n];
			Arrays.fill(arr, 'a');
			
			boolean flag = true;
			int flags[] = new int[n];
			Arrays.fill(flags, 0);
			
			String answer = "";
	        for(int i = 0; i < n; i++)
	        {
	            int start = array[i].startTime;
	            if(cEnd <= start)
	            {
	                arr[array[i].position] = 'C';
	                cEnd = array[i].endTime;
	                flags[array[i].position] = 1;
	            }
	        }
	        for(int i = 0; i < n; i++)
	        {
	            int start = array[i].startTime;
	            if(flags[array[i].position] !=1)
	            {
	                if  (jEnd <= start)
	                {
	                    arr[array[i].position] = 'J';
	                    jEnd = array[i].endTime;
	                    flags[array[i].position] = 1;
	                }
	            }
	            
	        }
	        
	        for(int i = 0; i < n; i++){
	            if(flags[i] == 0){
	                flag = false;
	                answer = "IMPOSSIBLE";
	                break;
	            }
	        }
			System.out.print("Case #" + t + ": ");
			if(flag){
				for(int i = 0 ; i < n; i++) {
					System.out.print(arr[i]);
				}
			}
	        else
	            System.out.println(answer);
		}
	}
}

class Schedule {
	int startTime;
	int endTime;
	int position;

	public Schedule(int sT, int eT, int pos) {
		startTime = sT;
		endTime = eT;
		position = pos;
	}
}