import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Record {
	   int startTime;
	   int endTime;
	   public Record(int startTime,int endTime ) {
		   this.startTime = startTime;
		   this.endTime = endTime;
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
				if(mapCameron.size()==0)
				{
					mapIntegerCount++;
					mapCameron.put(mapIntegerCount, new Record(startTime,endTime));
					output = output + "C";
					flag = true;
					continue;
				}
				
				if(mapJamie.size()==0)
				{
					mapIntegerCount++;
					mapJamie.put(mapIntegerCount, new Record(startTime,endTime));
					output = output + "J";
					flag = true;
					continue;
				}
				
				for (Map.Entry<Integer, Record> map : mapCameron.entrySet()) {
					if(  !(map.getValue().startTime <= startTime && startTime < map.getValue().endTime)  && !(map.getValue().startTime < endTime && endTime <= map.getValue().endTime))
					{
						mapIntegerCount++;
						mapCameron.put(mapIntegerCount, new Record(startTime,endTime));
						output = output + "C";
						flag = true;
						break;
					}
				}
				if(flag == true)
					continue;
				
				for (Map.Entry<Integer, Record> map : mapJamie.entrySet()) {
					if(  !(map.getValue().startTime <= startTime && startTime < map.getValue().endTime)  && !(map.getValue().startTime < endTime && endTime <= map.getValue().endTime))
					{
						mapIntegerCount++;
						mapJamie.put(mapIntegerCount, new Record(startTime,endTime));
						output = output + "J";
						flag = true;
						break;
					}
				}
				if(flag == true)
					continue;
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
    
    
    
    
  
 