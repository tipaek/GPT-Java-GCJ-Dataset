import java.util.*;
import java.io.*;
public class Solution{
public static boolean inRange(HashMap<Integer, Integer> map, int timeSlot[]){
    if(map.isEmpty()) return true;
    else {
        Iterator mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)mapIterator.next(); 
        int first = (int)mapElement.getKey();
        int second = (int)mapElement.getValue();
        if (!(second <= timeSlot[0] || first >= timeSlot[1]))
        return false;
    } 
    return true;
    }
    }
    

 public static void main(String []args){
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCase = input.nextInt();
    for(int t = 1; t <= testCase ; t++ ){
        String y = "";
        HashMap<Integer, Integer> J = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> C = new HashMap<Integer, Integer>();
        int N = input.nextInt();
        int[] timeSlot = new int[2];
        for(int n = 0; n < N; n++){
            timeSlot[0] = input.nextInt();
            timeSlot[1] = input.nextInt();
            if (inRange(J, timeSlot)){
                J.put(timeSlot[0], timeSlot[1]);
                y = y.concat("J");
            }  else if (inRange(C, timeSlot)){
                C.put(timeSlot[0], timeSlot[1]);
                y = y.concat("C");
            } else {
                y = "IMPOSSIBLE";
                break;
            }
        }
        System.out.println("Case #" + t + ": " + y);
    }
 }
}