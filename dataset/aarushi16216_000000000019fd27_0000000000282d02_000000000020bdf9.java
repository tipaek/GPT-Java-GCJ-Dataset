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
            
            while(startIndex < startTime.length && endIndex < endTime.length)
            {
//            	System.out.println(startIndex +" "+endIndex +" " + freeC +" "+freeJ);
            	if(startTime[startIndex] < endTime[endIndex])
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
            		int counter = 0;
            		if(freeJ != -1) 
            		{
            			ArrayList<Integer> arr = hmap.get(freeJ);
            			for(int i = 0; i<arr.size(); i++)
            			{
            				if(arr.get(i).equals(endTime[endIndex]))
            				{
            					counter = 1;
            					freeJ = -1;     
            					break;
            				}
            			}
            		}
            		
            		if(counter!=1 && freeC != -1)
            		{
            			ArrayList<Integer> arr = hmap.get(freeC);
            			for(int i = 0; i<arr.size(); i++)
            			{
            				if(arr.get(i).equals(endTime[endIndex]))
            				{
            					freeC = -1;   
            					break;
            				}
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
	            
	            int index = 0;
	            while(index < originalStartTime.length)
	            {
	            	ArrayList<Character> arr = order.get(originalStartTime[index]);
	            	while((index+1 < originalStartTime.length) && (originalStartTime[index+1] == originalStartTime[index]))
	            	{
	            		//System.out.println(index);
	            		index += 1;
	            	}
	            	
	            	for(int j=0; j<arr.size(); j++)
	            	{
	            		temp += arr.get(j);
	            	}
	            	index+=1;
	            }
	            str = temp;
            }
            
            System.out.println("Case #"+ k +": "+str);            
        }
    }
}