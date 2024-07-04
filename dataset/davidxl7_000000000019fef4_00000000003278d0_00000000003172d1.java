import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1;i<=T;i++){
            System.out.print("Case #"+i+": ");
            solve(in);
        }
    }
    public static void solve(Scanner in){
        int N = in.nextInt();
        int D = in.nextInt();
        long[]vals = new long[N];
        HashSet<Long>possible = new HashSet<>();
        for(int i = 0;i<N;i++){
            vals[i]=in.nextLong()*D;
            possible.add(vals[i]);
            possible.add(vals[i]/D);
        }
        Arrays.sort(vals);
        //System.out.println(Arrays.toString(vals));
        long ans = D-1;
        for(long size:possible){
            long slices = 0;
            long cuts = 0;
            ArrayList<Long>Good = new ArrayList<>();
            ArrayList<Long>Bad = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(vals[i]>=size&&vals[i]%size==0){
                    Good.add(vals[i]);
                }
                else{
                    Bad.add(vals[i]);
                }
            }
            boolean success = false;
            for(int i = 0;i<Good.size();i++){
                slices+=Good.get(i)/size;
                cuts+=Good.get(i)/size;
                if(slices==D+1||slices==D){
                    cuts--;
                    success = true;
                    break;
                }
                if(slices>D){
                    cuts-=(slices-D);
                    success=true;
                    break;
                }
                cuts--;
            }
            if(!success)
            for(int i = 0;i<Bad.size();i++){
                slices+=Bad.get(i)/size;
                cuts+=Bad.get(i)/size;
                if(slices>=D){
                    cuts-=(slices-D);
                    success= true;
                    break;
                }
            }
            if(success)
                ans = Math.min(ans,cuts);
        }


        System.out.println(ans);

    }
}
