import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String ans = "";
            List<Pair<Integer,Integer>> activityList = new ArrayList<>();
            for(int j=0;j<n;j++){
                activityList.add(new Pair<Integer,Integer>(in.nextInt(),in.nextInt()));
            }
            List<Pair<Integer,Integer>> cList = new ArrayList<>();
            List<Pair<Integer,Integer>> jList = new ArrayList<>();
            cList.add(activityList.get(0));
            ans+="C";
            for(int j=1;j<n;j++){
                if(checkAndPush(jList,activityList.get(j))){
                    ans+="J";
                }else if(checkAndPush(cList,activityList.get(j))){
                    ans+="C";
                }else{
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " +ans);
        }
    }

    public static boolean checkAndPush(List<Pair<Integer,Integer> > list,Pair<Integer,Integer> pair){
        if(list.size()<1){
            list.add(pair);
            return true;
        }
        for(int i=0;i<list.size();i++){
            int x1 = list.get(i).getKey();
            int y1 = list.get(i).getValue();

            int x2 = pair.getKey();
            int y2 = pair.getValue();


            if(y1> Math.min(x2,y2) && y1< Math.max(x2,y2)){
                return false;
            }

            if(y2>Math.min(x1,y1) && y2<Math.max(x1,y1)){
                return false;
            }

        }
        list.add(pair);
        return true;
    }
}