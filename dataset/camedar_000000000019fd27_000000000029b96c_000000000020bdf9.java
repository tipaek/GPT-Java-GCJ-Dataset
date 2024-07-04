import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static boolean isOverlapped( List<Integer> ranges, int from, int until){
        int listSize = ranges.size();
        int i = 0;
        while(i < listSize){
            if( ( from > ranges.get(i) && from < ranges.get(i+1) ) || ( until > ranges.get(i) && until < ranges.get(i+1) )  ){
                return true;
            }
            i+=2;
        }
        return false;
    }
    public static void main(String... args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        boolean impossible = false;
        in.nextLine();
        for(int i=1;i<=t;i++){
            List<Integer> cameron = new ArrayList<>();
            List<Integer> jaimie = new ArrayList<>();
            String resultingString = "";
            impossible = false;
            int n = in.nextInt();
            in.nextLine();
            for (int j = 0; j < n; j++) {
                String[] rangeInMinutes = in.nextLine().split(" ");
                int startingTime = Integer.parseInt(rangeInMinutes[0]);
                int endingTime = Integer.parseInt(rangeInMinutes[1]);

                if(!isOverlapped(cameron,startingTime,endingTime)){//is Cameron available
                    cameron.add(startingTime);
                    cameron.add(endingTime);
                    resultingString += "C";
                } else if(!isOverlapped(jaimie,startingTime,endingTime)){//is Jaimie available
                    jaimie.add(startingTime);
                    jaimie.add(endingTime);
                    resultingString += "J";
                } else {
                    impossible = true;
                }
            }
            if(impossible)
                resultingString = "IMPOSSIBLE";
            // Output response for each test case
            System.out.printf("Case #" + i + ": " + resultingString);
        }

    }
}