import java.util.*;
import java.io.*;

public class ParentingPartneringReturns {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
                          // t is the number of test cases

    for (int test = 1; test <= t; ++test) {
      int n = in.nextInt(); // number of activities during the day

      int [] day_mins = new int[24*60]; // initialize an array for each min of day with 0
      char [] output = new char[n];

      // Parents are "true" if already occupied
      boolean Cameron = false;
      boolean Jamie = false;

      // Create a Hashtable Dictionary to store start:end (<key>:<value> pair)
      LinkedHashMap<Integer, Integer> activities_dict = new LinkedHashMap<Integer, Integer>();

      final int minute_init = 24*60 + 1; //not a valid minute value

      for (int activity = 1; activity <= n; activity++) {
          // check start and end of each activity
          int s = in.nextInt();
          int e = in.nextInt();


          // CHECK IF WE CAN HAVE MULTIPLE S
          activities_dict.put(s,e);

          // in the day_mins arrray, +1 for each minute that there is an activity
          for (int i = s; i < e ; i++){
              day_mins[i] += 1;
          }
    }

    // Create a list with the keys, to be able to correspond N activity based on start timer
    List<Integer> keyPos = new ArrayList<Integer>(activities_dict.keySet());

    boolean impossible = false;
    int activities = 0;
    int pos;
    int stopC, stopJ;
    stopC = stopJ = minute_init; // initialize when each activity stops to a non-valid value

    // Start checking minute by minute for activities
    for (int minute=0; minute < 24*60; minute++) {
        // If it is time for an activity to stop, make parent available
        if (minute == stopC) {
            Cameron = false;
            activities -= 1;
        }
        if (minute == stopJ) {
            Jamie = false;
            activities -= 1;
        }
        if (day_mins[minute] > 2) { // more than 2 activities at the same time, impossible
            impossible = true;
            break;
        } else if (day_mins[minute] > 0) { // we have at least one ongoing activity

            if (activities == 0 ) { //one activity starts
                activities = 1;
                Cameron = true; //Always occupy Cameron first if both parents available
                stopC = activities_dict.get(minute);
                pos = keyPos.indexOf(minute);
                output[pos] = 'C';
            } else if (activities == 1 && day_mins[minute] == 2){ //Two activities, check available parent
                activities = 2;
                if (Cameron){ //Cameron is busy, use Jamie
                    Jamie = true;
                    stopJ = activities_dict.get(minute);
                    pos = keyPos.indexOf(minute);
                    output[pos] = 'J';
                } else if (Jamie){ //Jamie is busy, use Cameron
                    Cameron = true;
                    stopC = activities_dict.get(minute);
                    pos = keyPos.indexOf(minute);
                    output[pos] = 'C';
                }
            }


        }
    }

    String result = new String(output); // Array of chars -> String

    if (impossible){
        System.out.println("Case #" + test + ": IMPOSSIBLE");
    } else {
        System.out.println("Case #" + test + ": " + result);
    }
    }
  }
}
