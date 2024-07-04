import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			int s = Integer.parseInt(br.readLine());
			int start[] = new int[s];
			int end[] = new int[s];
			int index[] = new int[s];
			for(int j=0;j<s;j++){
				String s1[] = br.readLine().split(" ");
				start[j] = Integer.parseInt(s1[0]);
				end[j] = Integer.parseInt(s1[1]);
			}	
			for(int j = 0 ;j<s;j++)
        		index[j] = j;
			
			// One by one move boundary of unsorted subarray
        	for (int j = 0; j < s-1; j++)
        	{
            	// Find the minimum element in unsorted array
            	int min_idx = j;
            	for (int k = j+1; k < s; k++)
	                if (start[k] < start[min_idx])
    	                min_idx = k;
 
        	    // Swap the found minimum element with the first
            	// element
            	int temp = start[min_idx];
            	int temp1 = end[min_idx];
            	int temp2 = index[min_idx];
            	
	            start[min_idx] = start[j];
	            end[min_idx] = end[j];
	            index[min_idx] = index[j];
	            
    	        start[j] = temp;
    	        end[j] = temp1;
    	        index[j] = temp2;
        	}
        	
        	String value = new Solution().schedule("Z",start,end,0,0,0);
        	char s2[] = value.toCharArray();
        	String value2 = "";
        	for(int j = 0;j<s2.length;j++)
        		value2 += s2[index[j]];
        	if(value2.indexOf("X") != -1)
        		System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        	else
        		System.out.println("Case #"+(i+1)+": "+value);
		}
	}
	
	String schedule(String value,int[] start,int[] end,int jam,int cam,int index){
		// System.out.println("Starting:"+value);
		if(index >= start.length)
			return value;
		else if(index == 0){
			value = schedule("C",start,end,jam,end[index],index+1);
			// System.out.println("if index == 0 :"+value);
		}
		else{
			if(jam <= start[index] & cam > start[index]){
				// System.out.println("Index:"+index+" jam:"+jam+" cam:"+cam+" value:"+value);
				value = schedule(value+"J",start,end,end[index],cam,index+1);
				// System.out.println("if 1:"+value);
			}
			else if(jam > start[index] & cam <= start[index]){
				// System.out.println("Index:"+index+" jam:"+jam+" cam:"+cam+" value:"+value);
				value = schedule(value+"C",start,end,jam,end[index],index+1);
				// System.out.println("if 2:"+value);
			}
			else if(jam <= start[index] & cam <= start[index]){
				// System.out.println("Index:"+index+" jam:"+jam+" cam:"+cam+" value:"+value);
				String t1 = schedule(value+"J",start,end,end[index],cam,index+1);
				String t2 = schedule(value+"C",start,end,jam,end[index],index+1);
				if(t2.indexOf("X") != -1){
					// System.out.println("if 3.1:"+t1);
					return t1;
				}
				else{
					// System.out.println("if 3.2:"+t2);
					return t2;
				}
			}
			else 
				return "X";
		}
		return value;
	}
}