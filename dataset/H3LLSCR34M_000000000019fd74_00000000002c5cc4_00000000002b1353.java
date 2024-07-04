import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
        int n = in.nextInt();
        int sum = 0;
        while(sum < n){
            arr[w] += (++sum)+" "+1 + "\n";
        }
    }
    in.close();
    for(String s:arr)
        System.out.println(s);
    
}
}