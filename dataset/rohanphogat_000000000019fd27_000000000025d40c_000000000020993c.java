import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static int findColumnRepeats(int arr[][], int size){
        int columnRepeats = 0;
        boolean hasRepeatinGivenColumn = false;
        HashMap<Integer, Integer> myhash;

        for(int vary = 0; vary < size; vary++){
            myhash = new HashMap<Integer, Integer>();
            hasRepeatinGivenColumn = false;
            for(int varx = 0; varx < size; varx++){
                int val = arr[varx][vary];

                if(myhash.get(val)!=null){
                    hasRepeatinGivenColumn = true;
                }
                myhash.put(val, 1);
                arr[varx][vary] = val;
            }
            if(hasRepeatinGivenColumn){
                columnRepeats++;
            }
        }
        return columnRepeats;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numcases = in.nextInt();
        for(int tc = 0; tc < numcases; tc++){
            int arrsize = in.nextInt();
            int arr[][] = new int[arrsize][arrsize];
            int trace = 0;
            int rowrepeats = 0;
            int columnrepeats = 0;

            boolean hasRepeatinGivenRow = false;
            HashMap<Integer, Integer> myhash;
            for(int varx = 0; varx < arrsize; varx++){
                myhash = new HashMap<Integer, Integer>();

                hasRepeatinGivenRow = false;
                for(int vary = 0; vary < arrsize; vary++){
                    int val = in.nextInt();
                    if(varx == vary){
                        trace = trace + val;
                    }
                    if(myhash.get(val)!=null){
                        hasRepeatinGivenRow = true;
                    }
                    myhash.put(val, 1);
                    arr[varx][vary] = val;
                }
                if(hasRepeatinGivenRow){
                    rowrepeats++;
                }
            }
            columnrepeats = findColumnRepeats(arr, arrsize);
            System.out.println("Case #"+tc+": "+trace+" "+rowrepeats+" "+columnrepeats);
        }
    }

}