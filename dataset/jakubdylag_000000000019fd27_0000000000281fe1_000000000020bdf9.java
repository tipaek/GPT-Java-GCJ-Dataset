import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String ans = "";
            int n = in.nextInt();

            ArrayList<int[]> acts = new ArrayList<>();


            for (int j = 0; j < n; j++) { //for each activity
                int[] act = {in.nextInt(),in.nextInt(),-1, j};
                //act[0] = ; //start
                //act[1] = in.nextInt(); //finish
                acts.add(act);
            }


            //C gets first task
            //then start time => end time
            //until reaches end of arraylist

            //sort by start time
            sort(acts,0,n-1);

            int endtime = 0;
            for (int dude = 0; dude < 2; dude++) {
                endtime = 0;
                for (int[] activity: acts) {
                    if( activity[0] >= endtime && activity[2] == -1){
                        endtime = activity[1];
                        activity[2] = dude; //assign to dude
                    }
                }
            }

            //check for -1 and print letters
            char[] ansStr = new char[n];
            for (int[] activity: acts) {
                //ans+=activity[2]+", ";
                if(activity[2] == -1){
                    ans = "IMPOSSIBLE";
                    break;
                } else if( activity[2] == 0){
                    ansStr[activity[3]] = 'C';
                    //ans+="C";
                } else if( activity[2] == 1){
                    ansStr[activity[3]] = 'J';
                    //ans+="J";
                }
            }
            if(ans != "IMPOSSIBLE") {
                ans = String.valueOf(ansStr);
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
    

    public static int partition(ArrayList<int[]> arr, int low, int high)
    {
        int pivot = arr.get(high)[0];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr.get(j)[0] < pivot)
            {
                i++;

                // swap arr.get(i] and arr.get(j]
                int temp = arr.get(i)[0];
                arr.get(i)[0] = arr.get(j)[0];
                arr.get(j)[0] = temp;
                int temp2 = arr.get(i)[1];
                arr.get(i)[1] = arr.get(j)[1];
                arr.get(j)[1] = temp2;
                int temp3 = arr.get(i)[3];
                arr.get(i)[3] = arr.get(j)[3];
                arr.get(j)[3] = temp3;
            }
        }

        // swap arr.get(i+1] and arr.get(high] (or pivot)
        int temp = arr.get(i+1)[0];
        arr.get(i+1)[0] = arr.get(high)[0];
        arr.get(high)[0] = temp;
        int temp2 = arr.get(i+1)[1];
        arr.get(i+1)[1] = arr.get(high)[1];
        arr.get(high)[1] = temp2;
        int temp3 = arr.get(i+1)[3];
        arr.get(i+1)[3] = arr.get(high)[3];
        arr.get(high)[3] = temp3;

        return i+1;
    }

    public static void sort(ArrayList<int[]> arr, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr.get(pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}