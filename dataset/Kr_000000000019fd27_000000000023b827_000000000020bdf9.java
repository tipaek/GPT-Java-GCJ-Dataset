import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;



public class Solution {
    static class Interval {
        int start;
        int end;
        int pos;

        public Interval(int pos,int start, int end) {
            super();
            this.pos=pos;
            this.start = start;
            this.end = end;
        }
    }
    static class SortByStart implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
        public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        for(int x=1;x<=t;x++){
            int n=sc.nextInt();
            Interval[] arr=new Interval[n];
            for(int i=0;i<n;i++){
                arr[i]=new Interval(i,sc.nextInt(),sc.nextInt());
            }

            Arrays.sort(arr,new SortByStart());

             StringBuilder ans=solver(n,arr);
            System.out.println("Case #"+x+": "+ans);
        }
    }

    private static StringBuilder solver(int n, Interval[] arr) {
        StringBuilder result=new StringBuilder("");
        for(int i=0;i<n;i++)
            result.append("X");
        ArrayList<Integer> c=new ArrayList<>();
        ArrayList<Integer> j=new ArrayList<>();
        ArrayList<Integer> included=new ArrayList<>();
        int prevEnd=arr[0].end;
        c.add(arr[0].pos);
        for(int i=1;i<n;i++){
            //System.out.println(i+" "+ prevEnd+" c "+c);
            if(prevEnd<=arr[i].start){
                c.add(arr[i].pos);
                included.add(i);
                prevEnd=arr[i].end;
            }
        }
        prevEnd=-1;
        for(int i=1;i<n;i++){
            if(included.contains(i))
                continue;
            if( prevEnd<=arr[i].start){
                j.add(arr[i].pos);
                included.add(i);
                prevEnd=arr[i].end;
            }
            else{
                return new StringBuilder("IMPOSSIBLE");
            }
        }

       // System.out.println(c+"\n"+j);
        for(int i=0;i<c.size();i++)
            result.setCharAt(c.get(i),'C');
        for(int i=0;i<j.size();i++)
            result.setCharAt(j.get(i),'J');

        return result;
    }


}
