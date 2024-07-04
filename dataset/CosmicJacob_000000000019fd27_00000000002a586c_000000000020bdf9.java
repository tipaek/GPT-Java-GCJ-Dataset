import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        
        int numCases, n;
        String  ansString;
        char p1, p2;
        
        p1 = 'C';
        p2 = 'J';

        int[] schedule1 = new int[1440];
        int[] schedule2 = new int[1440];

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        numCases = sc.nextInt();
        
        for(int i = 1; i <= numCases; i++) {
ansString = "IMPOSSIBLE";
            int valueNoGood = 0;
            for(int j = 0; j < 1440; j++){
                schedule1[j] = 0;
                schedule2[j] = 0;
            }

            n = sc.nextInt();
            int[][] events = new int[n][n];

            for(int row = 0; row < n; row++){
                for(int col = 0; col < 2; col++){
                    events[row][col] = sc.nextInt();
                    if(events[row][col] > 1440){
                        valueNoGood = 1;
                    }
                }
            }

            if(valueNoGood == 0){
            ansString = schedule(n-1, schedule1, schedule2, events, p1, p2);
            if(ansString.length() > n){ansString = "IMPOSSIBLE";}}

            
            if(valueNoGood == 1){ansString = "IMPOSSIBLE";}

            System.out.println("Case #" + i + ": " + ansString);
        }

        sc.close();
    }

    private static String schedule(int eventsCount, int[] schedule1, int[] schedule2, int[][] events, char p1, char p2) {

        if(eventsCount < 0){
            return "";
        }
        else{
            if( openingCheck(events[eventsCount][0], events[eventsCount][1], schedule1) == 0 ){
                for(int j = events[eventsCount][0]; j < events[eventsCount][1]; j++){
                    schedule1[j] = 1;
                }
                return schedule(eventsCount-1, schedule1, schedule2, events, p1, p2) + p1;
            }
        else if( openingCheck(events[eventsCount][0], events[eventsCount][1], schedule2) == 0){
                for(int j = events[eventsCount][0]; j < events[eventsCount][1]; j++){
                    schedule2[j] = 1;
                }
                return schedule(eventsCount-1, schedule1, schedule2, events, p1, p2) + p2;
            }
        }

        return "IMPOSSIBLEEE";
    }

    private static int openingCheck(int i, int j, int[] schedule) {
        int count = 0;

        for(int index = i; index < j; index++){
            count = count + schedule[index];
        }

        return count;
    }
}
