import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        String[] strings = new String[T];
        //int [][] strings = new int[][];
        String[] newStrings = new String[T];
        for (int i = 0; i<T; i++){
            strings[i] = in.next();
            newStrings[i] = parser(strings[i]);
        }


        for (int i = 1; i< T+1; i++) {
            //System.out.println(strings[i-1]);
            System.out.print("Case #" + i+ ": " + newStrings[i-1]);
            System.out.println();
        }
    }



    static String parser(String s){

        int[] ints = stringConverter(s);

        if (ints.length == 1){
            if (ints[0] == 0)
                return "0";
            else
                return "(1)";
        }

        //generate new substrings and divide by 0
        String newS = "";
        //number of substrings divided by 0
        int count = 1;
        for(int i = 0; i<ints.length; i++){
            if (ints[i]==0)
                count++;
        }


        String[] subS = subStringGenerator(ints, count);
        //System.out.println(subS[0].toString());
        for (int i = 0; i<count; i++){
            if (i==0){
                if (subS[i] != "")
                    newS += "(" + subS[i].toString() + ")";

            }else {
                if (subS[i] != "" && subS[i] !=null)
                    newS += "0(" + subS[i] + ")";
                else
                    newS += "0";
            }
        }

        return newS;
    }

    static String[] subStringGenerator(int[] ints, int count){

        String[] subS = new String[count];
        int j = 0;
        for(int i = 0; i< count; i++) {
            subS[i] = "";
            while (ints[j] != 0) {
                subS[i] += ints[j];
                if (j < ints.length-1)
                    j++;
                else
                    break;
            }
            if (j<ints.length-1)
                j++;
            else
                break;
        }
        if (subS[0] == null)
            subS[0] = "";
        return subS;
    }

    static int[] stringConverter(String s){
        int[] ints = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            ints[i] = Integer.parseInt(s.substring(i,i+1));
        }
        return ints;
    }

}