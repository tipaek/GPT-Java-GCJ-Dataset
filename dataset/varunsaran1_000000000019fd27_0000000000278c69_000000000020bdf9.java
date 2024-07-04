import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = in.nextInt(); // Number of Test Cases
        int caseNumber = 1 ;
        while (caseNumber <= num) {

            int numOfActivities = in.nextInt() ;

            boolean[] cameroonArray = new boolean[1441] ;
            boolean[] jamieArray = new boolean[1441] ;
            boolean isPossible = true ;
            StringBuilder orderString = new StringBuilder() ;

            for (int i = 0 ; i< numOfActivities ; i++) {
                int startTime = in.nextInt() ;
                int endTime = in.nextInt() ;

                if (isPossible) {
                    boolean isCameroonFree = true ;
                    boolean isJamieFree = true ;

                    //cameroon check
                    for (int j = startTime ; j <= endTime ; j++) {
                        if (cameroonArray[j]) {
                            isCameroonFree = false ;
                            break ;
                        }
                    }

                    //jamie check
                    for (int j = startTime ; j <= endTime ; j++) {
                        if (jamieArray[j]) {
                            isJamieFree = false ;
                            break ;
                        }
                    }

                    if (isCameroonFree) {
                        orderString.append("C") ;
                        for (int j = startTime + 1 ; j < endTime ; j++) {
                            cameroonArray[j] = true ;
                        }
                    } else if (isJamieFree) {
                        orderString.append("J") ;
                        for (int j = startTime + 1 ; j < endTime ; j++) {
                            jamieArray[j] = true ;
                        }
                    } else {
                        orderString = new StringBuilder("IMPOSSIBLE") ;
                        isPossible = false ;
                    }

                }
            }

            System.out.println("Case #" + caseNumber + ": " + orderString.toString());
            caseNumber++ ;
        }


    }

}
