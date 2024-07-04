import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int k = 1; k<=t; k++)
        {
            int numTasks = sc.nextInt();
            int startTime[] = new int[numTasks];
            int originalStartTime[] = new int[numTasks];
            int endTime[] = new int[numTasks];
            
            HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
            for(int i=0 ;i<startTime.length; i++)
            {
            	startTime[i] = sc.nextInt();
            	originalStartTime[i] = startTime[i];
            	endTime[i] = sc.nextInt();
            	
            	if(hmap.get(startTime[i])==null)
            		hmap.put(startTime[i],new ArrayList<Integer>());
            	
            	hmap.get(startTime[i]).add(endTime[i]);
            }
            
            Arrays.sort(startTime);
            Arrays.sort(endTime);     
            
            int freeJ = -1;
            int freeC = -1;
            
            int startIndex = 0;
            int endIndex = 0;
            
            String str = "";   
            int impossible = 0;
            
            while(startIndex < startTime.length || endIndex < endTime.length)
            {
            	if(startIndex < startTime.length && startTime[startIndex] < endTime[endIndex])
            	{
            		if(freeJ == -1)
            		{
            			str += "J";
            			freeJ = startTime[startIndex];
            		}
            		else if(freeC == -1)
            		{
            			str += "C";
            			freeC = startTime[startIndex];
            		}
            		else
            		{
            			impossible = 1;
            			break;
            		}
            		
            		startIndex += 1;
            	}
            	
            	else
            	{
            		if(freeJ != -1) 
            		{
            			ArrayList<Integer> arr = hmap.get(freeJ);
            			for(int i = 0; i<arr.size(); i++)
            			{
            				if(arr.get(i).equals(endTime[endIndex]))
            					freeJ = -1;            					
            			}
            		}
            		
            		if(freeC != -1)
            		{
            			ArrayList<Integer> arr = hmap.get(freeC);
            			for(int i = 0; i<arr.size(); i++)
            			{
            				if(arr.get(i).equals(endTime[endIndex]))
            					freeC = -1;            					
            			}
            		}
            		endIndex += 1;
            	}
            	
            }
            
            if(impossible == 1)
            	str = "IMPOSSIBLE";
            else
            {
	            HashMap<Integer, ArrayList<Character>> order = new HashMap<>();
	            String temp = "";
	            for(int i=0; i<str.length(); i++)
	            {
	            	if(order.get(startTime[i])==null)
	            		order.put(startTime[i], new ArrayList<Character>());
	            	order.get(startTime[i]).add(str.charAt(i));
	            }
	            for(int i=0 ;i<originalStartTime.length;i++)
	            {
	            	ArrayList<Character> arr = order.get(originalStartTime[i]);
	            	for(int j=0; j<arr.size(); j++)
	            	{
	            		temp += arr.get(j);
	            	}
	            }
	            str = temp;
            }
            
            System.out.println("Case #"+ k +": "+str);            
        }
    }
}