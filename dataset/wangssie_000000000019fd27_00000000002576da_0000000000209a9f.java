import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine(); // get rid of new line
        for (int t = 1; t <= T; t++) {
            String numbers = in.nextLine();
            int[] numArray = new int[numbers.length()];
            for (int i=0; i<numbers.length(); i++) {
                numArray[i] = Integer.parseInt(Character.toString(numbers.charAt(i)));
            }
            //System.out.println("Num array is for case " +t + " is : "+Arrays.toString(numArray));
            System.out.println("Case #"+t+": "+minElementArray(numArray, 0));
        }
    }

    public static String minElementArray(int[] array, int level) {
        int min = 10;
        int index = 0;
        int minIndex=0;

        /*base case*/
        if (array.length == 1) {
            min = ((array[0]+level)>=0)?array[0]+level:0;
            return repeatString("(",min) + array[0]+repeatString(")",min);
        }
        if (array.length == 0) {
            return "";
        }

        for (int element: array) {
            if (element+level<min) {
                min = (element+level>=0)?element+level:0;
                minIndex = index;
                if (min ==0) {
                    break;
                }
            }
            index++;
        }
        if (minIndex == 0) {
            int[] arrayRight = Arrays.copyOfRange(array, minIndex+1, array.length);
            return repeatString("(",min) + array[minIndex] +minElementArray(arrayRight, level-min)+repeatString(")",min);
        }
        else if (minIndex == array.length-1) {
            int[] arrayLeft = Arrays.copyOfRange(array, 0, minIndex);
            return repeatString("(",min) +minElementArray(arrayLeft, level -min) + array[minIndex] +repeatString(")",min);
        }
        else {
            int[] arrayLeft = Arrays.copyOfRange(array, 0, minIndex);
            int[] arrayRight = Arrays.copyOfRange(array, minIndex+1, array.length);
            return repeatString("(",min) + minElementArray(arrayLeft, level - min) +  array[minIndex] +  minElementArray(arrayRight, level - min) + repeatString(")",min);
        }
    }

    public static String repeatString(String string, int repeats) {
        String repeated = new String(new char[repeats]).replace("\0", string);
        return repeated;
    }
}
