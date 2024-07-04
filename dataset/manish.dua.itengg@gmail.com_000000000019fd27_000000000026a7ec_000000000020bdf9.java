import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Record implements Comparable<Record>{
	   int startTime;
	   int endTime;
	   
	 
	   public Record(int startTime,int endTime ) {
		   this.startTime = startTime;
		   this.endTime = endTime;
	}


	@Override
	public int compareTo(Record o) {
		return this.startTime-o.startTime;
	}
	   
	}



public class Solution {
	static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int testCaseCount=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = s.nextInt();
        
        //QualificationRoundGoogleCodeJam problem = new QualificationRoundGoogleCodeJam();
        for (int i = 1; i <= testCount; i++) {
        	testCaseCount++;
            solve(testCount,testCaseCount);
        }
        br.close();
    }

    	static void solve(int testCount, int testCaseCount) throws IOException
    	{
    		int N = s.nextInt();
    		takeInputAndCalculate(testCount,N,testCaseCount);
    	}

		private static void takeInputAndCalculate(int testCount, int N, int testCaseCount) throws IOException {
			ArrayList<Record> records = new ArrayList<Record>();
			boolean flag = false;
			String output = "";
			int mapIntegerCount=0;
			Map<Integer,Record> mapCameron = new HashMap<Integer, Record>();
			Map<Integer,Record> mapJamie = new HashMap<Integer, Record>();
			for(int j=0 ; j<N; j++)
			{
				flag = false;
				int startTime = s.nextInt();
				int endTime = s.nextInt();
				records.add(new Record(startTime, endTime));
				
			}
			//Collections.sort(records);
			for(Record r : records)
			{
				if(mapCameron.size()==0)
				{
					mapIntegerCount++;
					mapCameron.put(mapIntegerCount, r);
					output = output + "C";
					flag = true;
					continue;
				}
				
				
				for (Map.Entry<Integer, Record> map : mapCameron.entrySet()) {
					if(  (map.getValue().startTime < r.endTime) && (r.startTime < map.getValue().endTime))
					{
						flag= false;
						break;
					}
					flag = true;
				}
				
				if(flag == true)
				{
					mapIntegerCount++;
					mapCameron.put(mapIntegerCount, r);
					output = output + "C";
					continue;
				}
				
				if(mapJamie.size()==0)
				{
					mapIntegerCount++;
					mapJamie.put(mapIntegerCount, r);
					output = output + "J";
					flag = true;
					continue;
				}
				
				
				for (Map.Entry<Integer, Record> map : mapJamie.entrySet()) {
					if(  (map.getValue().startTime < r.endTime) && (r.startTime < map.getValue().endTime))
					{
						
						flag = false;
						break;
					}
					flag = true;
				}
				if(flag == true)
				{
					mapIntegerCount++;
					mapJamie.put(mapIntegerCount, r);
					output = output + "J";
					continue;
				}
					
				else
					break;
			}
			if(flag==false)
			{
				System.out.println("Case #" + testCaseCount + ": IMPOSSIBLE");
			}
			else
				
				System.out.println("Case #" + testCaseCount + ": " + output);
		}
    }
    
    
    
    
  
 