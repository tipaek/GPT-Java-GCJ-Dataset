import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T  = Integer.parseInt(input.readLine());
        for(int t = 0; t<T; t++){
            output.print("Case #" + (t+1) + ": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            double[] cake = new double[N];
            st = new StringTokenizer(input.readLine());
            if(N == 1){
                output.println(D-1);
                continue;
            }
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            double max = 0;
            int maxn = 1;
            for(int n = 0; n<N; n++){
                cake[n] = Double.parseDouble(st.nextToken());
                if(map.containsKey(cake[n])){
                    map.replace(cake[n], map.get(cake[n])+1);
                    if(map.get(cake[n])>maxn){
                        maxn = map.get(cake[n]);
                        max = cake[n];
                    }
                }
                else map.put(cake[n], 1);
                //output.println(cake[n] + " " + map.get(cake[n]) + " " + maxn);
            }
            if(maxn>=D){
                output.println(0);
                continue;
            }
            if(maxn == 1){
                Arrays.sort(cake);
                int least = Integer.MAX_VALUE;
                for(int j = 0; j<N; j++){
                    double min = cake[j];
                    int index = N-1;
                    int cuts = 0;
                    for(int i = j+1; i<N; i++){
                        if(cake[i]%min == 0){
                            cuts+=cake[i]/min - 1;
                            maxn+=cake[i]/min;
                            cake[i] = 0;
                        }
                    }
                    if(maxn == D){
                        output.println(cuts);
                        continue;
                    }
                    else if(maxn>D){
                        cuts = D-1;
                    }
                    else{
                        while(maxn<D && index>=0){
                            int m = (int)(cake[index]/min);
                            cuts+=m-1;
                            maxn+=m;
                        }
                        if(maxn > D){
                            cuts = D-1;
                        }
                    }
                    if(cuts<least) least = cuts;
                }
                output.println(least);
            }
            
           if(D%maxn == 0){
                output.println(D/maxn);
            }
            else{
                output.println((int)(D/maxn) + D%maxn);
            }
            
        }
        output.flush();
        output.close();
    }
}