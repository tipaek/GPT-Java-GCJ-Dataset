import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t < T; t++){
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
                }
                else map.put(cake[n], 1);
            }
            int least = D-1;
            Arrays.sort(cake);
            out: for(int i = 0; i<N; i++){
                int count = map.get(cake[i]);
                int cuts = 0;
                if(count>=D){
                    least = Math.min(least,cuts);
                    continue out;
                }
                
                TreeSet<Double> mod = new TreeSet<Double>();
                TreeSet<Double> notMod = new TreeSet<Double>();
                for(int j = i+1; j<N; j++){
                    if(cake[j]%cake[i]==0) mod.add(cake[j]);
                    else notMod.add(cake[j]);
                }
                for(double key : mod){
                    double x = key;
                    while(x>cake[i]){
                        count++;
                        cuts++;
                        x-=key;
                        if(count>=D){
                            least = Math.min(least,cuts);
                            continue out;
                        }
                    }
                }
                for(double key : notMod){
                    double x = key;
                    while(x>cake[i]){
                        count++;
                        cuts++;
                        x-=key;
                        if(count>=D){
                            least = Math.min(least,cuts);
                            continue out;
                        }
                    }
                }
            }
            output.println(least);
        }
        output.flush();
        output.close();
    }
}
