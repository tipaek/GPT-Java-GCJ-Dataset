import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = in.nextInt() ; // Number of Test Cases
        int caseNumber = 1 ;
        while (caseNumber <= num) {

            int numOfActivities = in.nextInt() ; 

            List<Availability> cameroonAvailability = new ArrayList<>() ;
            List<Availability> jamieAvailability = new ArrayList<>() ;
            boolean isPossible = true ;
            StringBuilder orderString = new StringBuilder() ;

            while (numOfActivities-- > 0) {
                int startTime = in.nextInt() ; 
                int endTime = in.nextInt() ; 
                Availability availability = new Availability(startTime, endTime) ;

                if (isPossible) {
                    boolean isCameroonFree = true ;
                    boolean isJamieFree = true ;

                    //cameroon check
                    for (Availability avail : cameroonAvailability) {
                        if ((startTime >= avail.startTime && startTime < avail.endTime)
                                || (endTime > avail.startTime && endTime <= avail.endTime)
                                || (startTime < avail.startTime && endTime > avail.endTime)) {
                            isCameroonFree = false ;
                            break ;
                        }
                    }

                    if (isCameroonFree) {
                        orderString.append("C") ;
                        cameroonAvailability.add(availability) ;

                    } else {
                        //jamie check
                        for (Availability avail : jamieAvailability) {
                            if ((startTime >= avail.startTime && startTime < avail.endTime)
                                    || (endTime > avail.startTime && endTime <= avail.endTime)
                                    || (startTime < avail.startTime && endTime > avail.endTime)) {
                                isJamieFree = false ;
                                break ;
                            }
                        }
                        if (isJamieFree) {
                            orderString.append("J") ;
                            jamieAvailability.add(availability) ;

                        } else {
                            orderString = new StringBuilder("IMPOSSIBLE") ;
                            isPossible = false ;
                        }
                    }

                }
            }

            System.out.println("Case #" + caseNumber + ": " + orderString.toString());
            caseNumber++ ;
        }


    }
    static class Availability {
        public int startTime ;
        public int endTime ;

        public Availability(int startTime, int endTime) {
            this.startTime = startTime ;
            this.endTime = endTime ;
        }
    }
}
