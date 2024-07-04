import java.util.*;
import java.lang.Math.*;
import java.io.*;

public class Solution{

     public static void main(String []args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
       for(int idx = 1; idx <= test; idx++) {
            String[] vals = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(vals[0]);
            int d = Integer.parseInt(vals[1]);
            int count = 0;
            int min = 1;
            long value = 0;
            long minValue = 999999999;
            
            String[] line = br.readLine().trim().split(" ");
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            //long[] arr = new long[n];
            
            for(int i = 0; i < n; i++) {
                long val = Long.parseLong(line[i]);
                if(minValue > val) {
                    minValue = val;
                }
                if(map.containsKey(val)) {
                    int a = map.get(val);
                    a++;
                    
                    if(min < a) {
                        min = a;
                        value = val;
                    }
                    map.put(val, a);
                }
                else {
                    map.put(val, 1);
                }
            }
            //System.out.println(minValue);
            if(n == 1 && minValue == 1) {
                count = d -1;
            }
            else {
                if(min == d) {
                    count = 0;
                    //System.out.println(min);
                }
                else {
                    //System.out.println("min1 : " + min);
                    if(value > 0) {
                        
                        d = d - min;
                        //System.out.println("d: " + d);
                        Iterator<Map.Entry<Long, Integer>> itr = map.entrySet().iterator();
                        while(d > 0 && itr.hasNext()) 
                        { 
                            //System.out.println("abc");
                            Map.Entry<Long, Integer> entry = itr.next();
                            long key = entry.getKey();
                            //System.out.println("abc : " + key);
                            while(d > 0 && key > value) {
                                count++;
                                key = key - value;
                                d--;
                            }
                        }
                          
                    }
                    else {
                        //System.out.println("min : " + minValue);
                        Iterator<Map.Entry<Long, Integer>> itr = map.entrySet().iterator();
                        while(d > 0 && itr.hasNext()) 
                        { 
                            Map.Entry<Long, Integer> entry = itr.next();
                            long key = entry.getKey();
                            while(key > minValue) {
                                //System.out.println("abc");
                                count++;
                                key = key - minValue;
                                d--;
                            }
                            if(key == minValue) {
                                d--;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + idx + ": " + count);
        }
     }
}