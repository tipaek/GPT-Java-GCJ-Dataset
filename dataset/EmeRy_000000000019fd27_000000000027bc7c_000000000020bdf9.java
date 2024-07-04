import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
	String impossible = "IMPOSSIBLE";
	Character Cameron = 'C';
	Character Jamie = 'J';
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= cases; ++t) {
	
	  boolean CameronOccupied = false; 
	  boolean JamieOccupied = false;
	  int CameronActualActivityIndex = -1;
	  int JamieActualActivityIndex = -1;
	  int CameronActualActivityEnds = 0;
	  int JamieActualActivityEnds = 0;
	  Hashtable S = new Hashtable();	  
	  Hashtable Scheduled = new Hashtable();	
		
	  int temp;
	  int tempI;
      int n = in.nextInt();
      for( int i = 0; i < n; i++)
      {
		int auxS = in.nextInt();
		int auxE = in.nextInt();
		S.put(i, auxS );
		Scheduled.put(i , auxE); 
	  }
	  
	  ArrayList<Integer> arrayS = new ArrayList<Integer>(S.values());	  
	  ArrayList<Integer> indexes_arrayS = new ArrayList<Integer>(S.keySet());	   
       for (int i = 1; i < arrayS.size(); i++) 
        for (int j = i; j > 0; j--) {
         if (arrayS.get(j) < arrayS.get(j - 1)) {
          temp = arrayS.get(j);
		  tempI= indexes_arrayS.get(j);
          arrayS.set(j ,  arrayS.get(j - 1) );
		  indexes_arrayS.set(j,  indexes_arrayS.get(j - 1) );
          arrayS.set(j-1, temp);
		  indexes_arrayS.set(j-1, tempI);
         }
        }
    
    //Start assigning activities
	boolean isPossible=true;
	StringBuilder solve = new StringBuilder();  
    for (int i = 0; isPossible && i < arrayS.size(); i++)
	{
		int startHour = arrayS.get(i);
		//checkDisponibility
		if(CameronOccupied) { 
			if(startHour >= CameronActualActivityEnds)
			{
			  CameronOccupied = false; 
			  CameronActualActivityIndex = -1;
			  CameronActualActivityEnds = 0;
			}
		}
		if(JamieOccupied) { 
			if(startHour >= JamieActualActivityEnds)
			{
			  JamieOccupied = false; 
			  JamieActualActivityIndex = -1;
			  JamieActualActivityEnds = 0;
			}
		}
		
		//Assign activity
		if(!CameronOccupied)
		{
			CameronOccupied = true;
			CameronActualActivityIndex = indexes_arrayS.get(i);
			CameronActualActivityEnds = (int) Scheduled.get(indexes_arrayS.get(i));
			solve.append('C');
		}
		else
		{
			if(!JamieOccupied)
			{
				JamieOccupied = true;
				JamieActualActivityIndex = indexes_arrayS.get(i);
				JamieActualActivityEnds =  (int)Scheduled.get(indexes_arrayS.get(i));
				solve.append('J');
			}
			else
			{
				isPossible =false;
				System.out.println("Case #" + t + ": " + impossible);
				break;
			}
		}
	}
	if(isPossible){
        System.out.println("Case #" + t + ": " + solve);  
    	}
    }
    
  }
}