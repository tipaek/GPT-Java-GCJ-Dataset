import java.io.*;
import java.util.*;

public class Solution{
    final static String INPUT_FILE_NAME = "input.txt";

    public static void main(String [] args) throws Exception{
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int n=0; n<T; n++) {
            int r = 0;
            int c = 0;
            int k = 0;
            int size = in.nextInt();
            int[][] array = new int[size][size];
            for(int s=0; s<size; s++) {
                for (int si = 0; si < size; si++) {
                    array[s][si] = in.nextInt();
                }
            }
            for (int i = 0; i < array.length; i++) {
                int[] tempHorizontalArray = array[i];
                int[] tempVerticalArray = new int[array.length];
                for (int j = 0; j < array.length; j++) {
                    tempVerticalArray[j] = array[j][i];
                }
                r += checkForRepeat(tempHorizontalArray);
                c += checkForRepeat(tempVerticalArray);
                k += array[i][i];
            }
            System.out.printf("Case #%d: ", n+1);
            System.out.print(k+" ");
            System.out.print(r+" ");
            System.out.println(c);
        }
    }

    private static int checkForRepeat(int[] tempArray){
        int c = 0;
        int[] s = new int[tempArray.length];
        for(int i=0; i<tempArray.length; i++)
            s[i] = tempArray[i];
        Arrays.sort(s);
        for(int i=0; i<s.length -1; i++){
            if(s[i] == s[i+1]) {
                c++;
                return c;
            }
        }
        return c;
    }
}
