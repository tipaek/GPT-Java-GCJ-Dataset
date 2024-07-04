import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        for(int i =1;i<=t;i++){
            boolean broke=false;
            //String dig = br.readLine();
            int n = Integer.parseInt(br.readLine());
            System.out.print("Case #"+i+": ");
            Pair[] arr = new Pair[n];
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int temp = Integer.parseInt(st.nextToken())*10000+Integer.parseInt(st.nextToken());
                arr[j] = new Pair(temp, j);
            }
            Arrays.sort(arr);
            char[] ans = new char[n];
            //int cStart=arr[0].times/10000; int cEnd=arr[0].times%10000;
            //int jStart=arr[1].times/10000; int jEnd=arr[0].times%10000;
            int latestC=0; int latestJ=1;
            ans[arr[0].index]='C';
            ans[arr[1].index]='J';
            loop:
            for(int j=2;j<n;j++){
                if(ans[arr[j-1].index]=='C'){
                    if(arr[j-1].times%10000 <= arr[j].times/10000){
                        ans[arr[j].index]='C';
                        latestC=j;
                    }
                    else{
                        if(arr[latestJ].times%10000<=arr[j].times/10000){
                            ans[arr[j].index]='J';
                            latestJ=j;
                        }
                        else{
                            System.out.println("IMPOSSIBLE");
                            broke=true;
                            break loop;
                        }
                    }
                }
                else if(ans[arr[j-1].index]=='J'){
                    if(arr[j-1].times%10000 <= arr[j].times/10000){
                        ans[arr[j].index]='J';
                        latestJ=j;
                    }
                    else{
                        if(arr[latestC].times%10000<=arr[j].times/10000){
                            ans[arr[j].index]='C';
                            latestC=j;
                        }
                        else{
                            System.out.println("IMPOSSIBLE");
                            broke=true;
                            break loop;
                        }
                    }
                }
            }
            if(!broke)
                System.out.println(String.valueOf(ans));



        }
    }
    static class Pair implements Comparable<Pair>{
        int times, index;
        public Pair(int times, int index){
            this.times=times; this.index=index;
        }
        public int compareTo(Pair other){
            return this.times-other.times;
        }
    }
}