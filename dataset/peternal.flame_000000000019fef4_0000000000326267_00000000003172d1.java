import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class Solution {

    private static int count(ArrayList<Long>arr, long num){
        int count = 0;
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i)==num){
                count++;
            }
        }
        return count;
    }

    private static boolean highest(ArrayList<Long>arr, long el){
        for(long i: arr){
            if(i>el){
                return false;
            }
        }
        return true;
    }

    private static boolean twice(ArrayList<Long>arr, long el){
        for(long i: arr){
            if(i==2*el){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            int n = in.nextInt();
            int d = in.nextInt();
            ArrayList<Long> ds = new ArrayList<>();
            for(int i = 0; i<n; i++){
                ds.add(in.nextLong());
            }
            System.out.print("Case #" + tt + ": ");
            if(d==2){
                boolean zero = false;
                for(int i = 0; i<ds.size(); i++){
                    if(count(ds, ds.get(i))>1){
                        zero = true;
                        break;
                    }
                }
                if(zero){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            } else{
                boolean three = false;
                for(int i = 0; i<ds.size(); i++){
                    if(count(ds, ds.get(i))>2){
                        three = true;
                        break;
                    }
                }
                if(three){
                    System.out.println(0);
                }else{
                    boolean one = false;
                    for(int i = 0; i<ds.size(); i++){
                        if(count(ds, ds.get(i))>1 && !highest(ds, ds.get(i))){
                            one = true;
                            break;
                        }
                        if(twice(ds, ds.get(i))){
                            one = true;
                            break;
                        }
                    }
                    if(one){
                        System.out.println(1);
                    }else{
                        System.out.println(2);
                    }

                }
            }


        }
    }

}
