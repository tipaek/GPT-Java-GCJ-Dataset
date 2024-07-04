import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Solution {
    public static class interval{
        int s;
        int e;
        int pos;
        String person="C";
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //int trace=0;
        int t=in.nextInt();
        for(int k=0;k<t;k++){
            ArrayList<interval> chores=new ArrayList<>();
            int N=in.nextInt();
            for(int i=0;i<N;i++){
                interval p= new interval();
                p.s=in.nextInt();
                p.e=in.nextInt();
                p.pos=i;
                chores.add(p);
            }
            int[] arr=new int[24*60];
            Arrays.fill(arr, 0);
            for(interval x:chores){
                for(int j=x.s;j<x.e;j++){
                    arr[j]+=1;
                    //System.out.println(arr[j]);
                }
            }
            int p=0;
            for (int value : arr) {
                if (value > 2) {
                    System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
                    p=1;
                }
            }
            if(p==1){
                continue;
            }
           // ArrayList<interval> check=new ArrayList<>();
            chores.sort(Comparator.comparingInt(a -> a.s));
            for(int i=0;i<N;i++){
                ArrayList<interval> check=new ArrayList<>();
                for(int j=i;j<N;j++){
                    if(chores.get(i).s<chores.get(j).s && chores.get(i).e>chores.get(j).s ){
                        check.add(chores.get(j));
                        if(chores.get(i).person.equals("C"))
                            chores.get(j).person="J";
                        else
                            chores.get(j).person="C";
                    }
                }
            }
            chores.sort(Comparator.comparingInt(a->a.pos));
            System.out.print("Case #"+(k+1)+": ");
            for (interval chore : chores) {
                System.out.print(chore.person);
            }
            System.out.println();
        }
    }
}
