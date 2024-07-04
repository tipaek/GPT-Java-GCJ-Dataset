import java.util.*;
import java.io.*;
class act implements Comparable<act>{
    int st;
    int end;
    int ind;
    public act(int start, int ending, int index){
        this.st = start;
        this.end = ending;
        this.ind = index;
    }
    public int compareTo(act activity){
        if(this.end == activity.end){
            return this.st - activity.st;
        }
        return activity.end- this.end;
    }
}
public class Solution {
    
    public static void canDo(act[] arr, int caseNum){
        
        char[] res = new char[arr.length];
        int Cfirst = 1500;
        int Jfirst = 1500;
        for(int i = 0 ; i < arr.length ; i++){
            if(Cfirst >= arr[i].end){
                res[arr[i].ind] = 'C';
                Cfirst = arr[i].st;
            }
            else if(Jfirst >= arr[i].end){
                res[arr[i].ind] = 'J';
                Jfirst = arr[i].st;
            }
            else{
                System.out.println("Case #"+caseNum+": IMPOSSIBLE");
                return;
            }
        }
        String ans = new String(res);
        System.out.println("Case #"+caseNum+": "+ans);

    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int j = 1; j <= t; ++j) {
        int n = in.nextInt();
        act[] arr = new act[n];
        for(int i = 0 ; i < n ; i++){
            int start = in.nextInt();
            int ending = in.nextInt();
            arr[i] = new act(start, ending, i);
        }
        Arrays.sort(arr);
        // for(int i = 0 ; i < n ; i++){
        //     System.out.println(arr[i].st+" "+arr[i].end+" "+i);
        // }
        canDo(arr, j);
    }
  }
}