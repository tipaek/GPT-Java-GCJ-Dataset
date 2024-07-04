import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String res = "";
            int flagc = 0;
            int flagj = 0;
            int N = in.nextInt();
            List<Integer> sc = new ArrayList<>();
            List<Integer> ec = new ArrayList<>();
            List<Integer> sj = new ArrayList<>();
            List<Integer> ej = new ArrayList<>();

            for(int k=0; k<N; k++){

                int start = in.nextInt();
                int end = in.nextInt();
                if(k==0){
                    sc.add(start);
                    ec.add(end);
                    res+="C";
                }
                else{
                    for(int j=0; j<sc.size(); j++){
                        if((start>=sc.get(j)&&start<ec.get(j))||(end>sc.get(j)&&end<ec.get(j))){
                            flagc = 1;
                            break;
                        }
                    }
                    for(int j=0; j<sj.size(); j++){
                        if(sj.isEmpty())
                            break;
                        else if((start>=sj.get(j)&&start<ej.get(j))||(end>sj.get(j)&&end<ej.get(j))){
                            flagj = 1;
                            break;
                        }
                    }
                    if(flagc==0 && flagj==1){
                        res+="C";
                        flagj = 0;
                        sc.add(start);
                        ec.add(end);
                    }
                    else if(flagj==0 && flagc==1){
                        res+="J";
                        flagc=0;
                        sj.add(start);
                        ej.add(end);
                    }
                    else if(flagj==0 && flagc==0){
                        res+="C";
                        sc.add(start);
                        ec.add(end);
                    }
                    
                }
            }
            if(flagc==1 && flagj==1)
                System.out.println("Case #"+i+": IMPOSSIBLE");
            else
                System.out.println("Case #"+i+": "+res);
        }
    }
}