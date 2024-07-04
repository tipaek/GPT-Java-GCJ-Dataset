import java.util.*;
import java.io.*;

class Pair{
    int a;
    int b;
    Pair(int i, int j){
        a=i;
        b=j;
    }
}
public class Solution{

    public static ArrayList<Pair> f(int r, int s){
        ArrayList<Pair> arr = new ArrayList<Pair>();
        while(r>1){
            for(int i=1;i<s;i++){
                int t = r*s - r -i;
                arr.add(new Pair(r,t));
            }
            r--;
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int r = sc.nextInt();
            int s = sc.nextInt();
            ArrayList<Pair> arr = f(r,s);
            String st = "Case #"+Integer.toString(t+1)+": "+Integer.toString(arr.size());
            System.out.println(st);
            for(int i=0;i<arr.size();i++){
                System.out.println(arr.get(i).a+" "+arr.get(i).b);
            }
        }
        
    }
}