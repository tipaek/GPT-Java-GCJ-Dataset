import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
//        BufferedReader br = null;


        Scanner br = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//            br = new BufferedReader(new InputStreamReader(input));
        int count = Integer.parseInt(br.nextLine());


        // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= count; ++i) {
            boolean isCameronWork = false;
            String result = "";
            List<int[]> taskCameron = new ArrayList<>();
            List<int[]> taskJame = new ArrayList<>();

            int times = Integer.parseInt(br.nextLine());

            for (int a = 0; a < times; a++) {
                StringTokenizer sk = new StringTokenizer(br.nextLine());
                int [] workTime = new int[]{Integer.parseInt(sk.nextToken()), Integer.parseInt(sk.nextToken())};
                boolean cameronBusy = false;
                boolean jameBusy = false;
                for(int[] cameron : taskCameron){
                    if(isBeteen(workTime[0] , cameron[0] , cameron[1])){
                        cameronBusy = true;
                        break;
                    }else if (isBeteen(workTime[1] , cameron[0] , cameron[1])){
                        cameronBusy = true;
                        break;
                    }
                    
                }

                for(int [] jame : taskJame){
                    if(isBeteen(workTime[0] , jame[0] , jame[1])){
                        jameBusy = true;
                        break;
                    }else if  (isBeteen(workTime[1] , jame[0] , jame[1])){
                        cameronBusy = true;
                        break;
                    }
                }
                if(cameronBusy != true){
                    result += "J";
                    taskCameron.add(workTime);
                }else if( jameBusy != true){
                    result += "C";
                    taskJame.add(workTime);
                }else{
                    result = "IMPOSSIBLE";
                }

            }
            System.out.println("Case #" + i + ": "  + result);

        }
    }
    private static boolean isBeteen(int time , int min , int max){
        if(min<time && time < max){
            return true;
        }else{
            return false;
        }

    }

}
