import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        int T = fr.nextInt();
        for(int t = 1; t<=T;t++){
            int N = fr.nextInt();
            List<List<Integer>> jList = new ArrayList<>();
            List<List<Integer>> cList = new ArrayList<>();
            List<List<Integer>> tList = new ArrayList<>();
            for(int i=0;i<N;i++){
                int S =fr.nextInt(), E = fr.nextInt();
                if(S>=0 && S <= E && E <= 1440){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(S);
                    temp.add(E);
                    tList.add(temp);
                }
            }

            boolean possible = true;
            StringBuilder ans = new StringBuilder();
            for(int i=0;i<N;i++){

                int start = tList.get(i).get(0);
                int end = tList.get(i).get(1);
                if(available(start,end,jList)){
                    assignTask(start,end,jList);
                    ans.append("J");
                }
                else if(available(start,end,cList)){
                    assignTask(start,end,cList);
                    ans.append('C');
                }else{
                    possible = false;
                    break;
                }
            }
            if(possible)
                System.out.println("Case #"+ +t+": "+ ans.toString());
            else
                System.out.println("Case #"+ +t+": "+ "IMPOSSIBLE");
            System.out.println();
        }
    }

    public static boolean available(int start, int end, List<List<Integer>> list){
        if(list.size() == 0)
            return true;
        for(List<Integer> temp : list){
            int s = temp.get(0), e = temp.get(1);
            if(start > s && start < e || end > s && end < e || start < s && end > e)
                return false;
        }
        return true;
    }
    public static void assignTask(int start, int end, List<List<Integer>> list){
        if(start>= 0 && end <= 1440 && start <=end){
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            list.add(temp);
        }
    }
}
