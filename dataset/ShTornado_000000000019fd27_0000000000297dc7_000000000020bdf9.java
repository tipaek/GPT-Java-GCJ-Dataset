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
            return activity.st - this.st;
        }
        return this.end - activity.end;
    }
}
public class Solution {
    
    public static void canDo(act[] arr, int caseNum){
        
        char[] res = new char[arr.length];
        int Clast = -1;
        int Jlast = -1;
        for(int i = 0 ; i < arr.length ; i++){
            
            if(Clast > arr[i].st && Jlast > arr[i].st){
                System.out.println("Case #"+caseNum+": IMPOSSIBLE");
                return;
            }
            
            if(Clast <= Jlast){
                if(Jlast <= arr[i].st){
                    res[arr[i].ind] = 'J';
                    Jlast = arr[i].end;
                }
                else{
                    res[arr[i].ind] = 'C';
                    Clast = arr[i].end;
                }
            }
            else{
                if(Clast <= arr[i].ind){
                    res[arr[i].ind] = 'C';
                    Clast = arr[i].end;
                }
                else{
                    res[arr[i].ind] = 'J';
                    Jlast = arr[i].end;
                }
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
        canDo(arr, j);
    }
  }
}