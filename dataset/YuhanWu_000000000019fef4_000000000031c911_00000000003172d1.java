import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * Created by Harry on 5/2/20.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();
            double[] A = new double[n];
            HashMap<Double, Integer> map = new HashMap();
            for(int j=0; j<n; j++){
                double cur = in.nextDouble();
                A[j] = cur;
                map.put(cur, map.getOrDefault(cur, 0)+1);
            }
            if(d==2){
                boolean isResFound = false;
                for(int val : map.values()){
                    if(val>=2){
                        System.out.println("Case #"+i+": "+0);
                        isResFound = true;
                        break;
                    }
                }
                if(!isResFound) System.out.println("Case #"+i+": "+1);
            }
            else{
                boolean isResFound = false;
                for(double size : map.keySet()){
                    int freq = map.get(size);
                    if(freq>=3){
                        System.out.println("Case #"+i+": "+0);
                        isResFound = true;
                        break;
                    }
                    else if(map.containsKey(size/2)){
                        System.out.println("Case #"+i+": "+1);
                        isResFound = true;
                        break;
                    }
                }
                if(!isResFound) System.out.println("Case #"+i+": "+2);
            }
        }
    }
}
