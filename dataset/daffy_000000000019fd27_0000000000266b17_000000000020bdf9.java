import java.util.Scanner;

//An interval has start time and end time  
class Interval  {  
	int start;  
	int end; 
	public Interval(int start, int end)  { 
	     super(); 
	     this.start = start; 
	     this.end = end; 
	}  
}

public class Solution {
	
	//Function to check if any two intervals overlap  
	public static int maxOverlap(Interval arr[], int n)  {  

	 int maxOverlap = 0;
	 int max_ele = 0;  

	 // Find the overall maximum element  
	 for (int i = 0; i < n; i++)  {  
	     if (max_ele < arr[i].end)  
	         max_ele = arr[i].end;  
	 }  

	 // Initialize an array of size max_ele  
	 int []aux = new int[max_ele + 1]; 
	 for (int i = 0; i < n; i++)  {  

	     // starting point of the interval  
	     int x = arr[i].start;  

	     // end point of the interval  
	     int y = arr[i].end;  
	     aux[x]++; 
	     aux[y ]--;  
	 }
	 
	 for (int i = 1; i <= max_ele; i++)  {  
	     // Calculating the prefix Sum  
	     aux[i] += aux[i - 1];  

	     // Overlap  
	     if (aux[i] > maxOverlap)  {
	    	 maxOverlap = aux[i];
	     }
	 }  
	 
	 // If we reach here, then no Overlap  
	 return maxOverlap;  
  }  
	
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = new Integer(in.nextLine()).intValue();
    for (int i = 1; i <= t; i++) {
        int n = new Integer(in.nextLine()).intValue();
        Interval[] interval = new Interval[n];
        
    	String result = "IMPOSSIBLE";
        for (int j = 0; j < n; j++)  {
        	String input = in.nextLine();
        	String[] input1 = input.split(" ");
            interval[j] = new Interval(new Integer(input1[0]).intValue(), new Integer(input1[1]).intValue());
        }
        
        if (maxOverlap(interval, n) == 1)  {
        	result = "";
        	for (int z = 0; z < n; z++)  {
        		result = result + "C";
        	}
        }
        else if (maxOverlap(interval, n) == 2)  {
        	result = "C";
        	Interval[] temp = new Interval[2];
        	
        	for (int x = 1; x < n; x++)  {
            	temp[0] = interval[x - 1];
            	temp[1] = interval[x];
            	if (maxOverlap(temp, 2) == 1)  {
            		if (result.charAt(result.length() - 1) == 'C')  {
            			result = result + "C";
            		}
            		else  {
            			result = result + "J";
            		}
            	}
            	else  {
            		if (result.charAt(result.length() - 1) == 'C')  {
            			result = result + "J";
            		}
            		else  {
            			result = result + "C";
            		}
            	}
        	}
        	
        }
        System.out.println("Case #" + i + ": " + result);
    }
    in.close();
  }
}