import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < testSetSize; ++i) {
            int numberActivities = in.nextInt();
            List<Integer> cameronStarting = new ArrayList<>();
            List<Integer> cameronEnding = new ArrayList<>();
            List<Integer> jamieStarting = new ArrayList<>();
            List<Integer> jamieEnding = new ArrayList<>();
            int startingTime,endingTime,result;
            String answer = "";
            boolean isImpossible = false;
            int j;
            for( j= 0; j< numberActivities;j++){
                startingTime = in.nextInt();
                endingTime = in.nextInt();
                if(!isImpossible){
                    result = tryGiveActivity(startingTime,endingTime,cameronStarting,cameronEnding);
                    if(result == 0){
                        result = tryGiveActivity(startingTime,endingTime,jamieStarting,jamieEnding);
                        if(result == 0){
                            isImpossible = true;
                            answer = "IMPOSSIBLE";

                        }else{
                            answer += "J";
                        }
                    }else{
                        answer+= "C";
                    }
                }

            }

            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }

    private static int tryGiveActivity(int startingTime, int endingTime, ArrayList<Integer> startingArray, ArrayList<Integer> endingArray){
        boolean doestFit = false;
        boolean first,second,third,fourth,fifth;
        int startingTimeI, endingTimeI;
        for(int i=0;i< startingArray.size() && !doestFit;i++){
            startingTimeI = startingArray.get(i);
            endingTimeI = endingArray.get(i);
            first = (startingTime >  startingTimeI && startingTime < endingTimeI);
            second = (endingTime > startingTimeI && endingTime < endingTimeI);
            third = (startingTime < startingTimeI && endingTime > endingTimeI);
            fourth = (startingTime == startingTimeI);
            fifth = (endingTime == endingTimeI);
            if( first || second || third || fourth || fifth){
                doestFit = true;
            }
        }
        if(doestFit){
            return 0;
        }
        startingArray.add(startingTime);
        endingArray.add(endingTime);
        return 1;
    }
}