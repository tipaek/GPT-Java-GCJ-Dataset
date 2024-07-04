import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    //150 qs
    //output P = index to look at
    //every 10 qs on lsd 1s alters array
    //1 = 0
    //reversed
    //or both
    //or none

    //so check same place again + corresponding reverse pos
    //int rev = arr[b-index+1]



    //output string chars currently in arr
    //if feedback == Y
    //continue;
    //else
    //

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt(); // size of each arr
        for (int i = 1; i <= t; ++i) {
            int[] arr = new int[b];
            String ans = "";

            for (int j = 1; j <= b; j++) {
                System.out.println(j);
                System.out.flush();
                //arr[j] = in.nextInt();
                ans += in.nextInt();
            }


            //int index = 1;
            //request index
            //request b-(index-1) //reverse of index
            //index++


            System.out.println(ans);
            System.out.flush();
            String s = in.next();
            if(s=="Y"){

            } else if(s=="N"){
                System.out.println(ans);
                System.out.flush();
            }

            //in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }

        //System.out.flush();
        //TODO flush buffer
    }

    //"C:\Users\jakub\AppData\Local\Programs\Python\Python38-32\python.exe interactive_runner.py python local_testing_tool.py 0 -- java Solution"


}