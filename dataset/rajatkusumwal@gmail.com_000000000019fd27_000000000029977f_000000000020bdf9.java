import java.util.*;
import java.io.*;


public class Solution {

    //t=0 we get start count t=1 we get end count
    private static ArrayList<Integer> searchCountStartOrEnd(ArrayList<ArrayList<Integer>> ts,int ti,int t){
        ArrayList<Integer> workIndexes = new ArrayList<Integer>();
        for(int r=0;r<ts.size();r++){
            if(ti==ts.get(r).get(t)){
                workIndexes.add(r);
            }
        }
        return workIndexes;
    }

    private static void solve(ArrayList<ArrayList<Integer>> ts,int cn){
        Boolean isJamA = Boolean.TRUE;
        Boolean isCamA = Boolean.TRUE;
        Integer jamIndex = -1;
        Integer camIndex = -1;
        String result = "";
        for(int x=0;x<=(24*60);x++){
            ArrayList<Integer> ei = searchCountStartOrEnd(ts,x,1);
            for(Integer wi: ei){
                if(jamIndex == wi){
                    isJamA = Boolean.TRUE;
                    jamIndex = -1;
                }
                if(camIndex == wi){
                    isCamA = Boolean.TRUE;
                    camIndex = -1;
                }
            }
            ArrayList<Integer> si = searchCountStartOrEnd(ts,x,0);
            for(Integer wi: si){
                if(!isJamA && !isCamA){
                    System.out.println("Case #" + cn + ": IMPOSSIBLE");
                    isCamA = Boolean.TRUE;
                    return;
                }
                if(isJamA){
                    isJamA = Boolean.FALSE;
                    jamIndex = wi;
                    result = result + "J";
                    continue;
                }
                if(isCamA){
                    isCamA = Boolean.FALSE;
                    camIndex = wi;
                    result = result + "C";
                    continue;
                }
            }
        }
        System.out.println("Case #" + cn + ": " +result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            ArrayList<ArrayList<Integer>> tl=new ArrayList<ArrayList<Integer>>();
            int n = in.nextInt();
            for(int x=0;x<n;x++){
                int t1 = in.nextInt();
                int t2 = in.nextInt();
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(t1);
                temp.add(t2);
                tl.add(temp);
            }
            solve(tl,i);
        }
    }

    //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
}