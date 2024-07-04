import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static  ArrayList<Point> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            list = new ArrayList<>();
            int n = sc.nextInt();
            ArrayList<Point> p = new ArrayList<>();

            for(int i=0;i<n;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                list.add(new Point(start, end));
                p.add(new Point(start,end));
            }
            Collections.sort(list);
            StringBuilder answer = new StringBuilder();
            answer.append("Case #"+tc+": ");
            int time = list.get(0).x;
            Point J=list.get(0);
            Point C=list.get(1);
            J.name = 'J';
            C.name = 'C';
            int idx = 2;
            int flag = 0;
            StringBuilder jc = new StringBuilder();

            ArrayList<Point> answerList = new ArrayList<>();
            answerList.add(J);
            answerList.add(C);
            while(time<=1440 && idx<n){
               if(isAva(J,idx)){
                   J = list.get(idx);
                   J.name = 'J';
                   answerList.add(J);
                   idx++;
               }
               else if(isAva(C,idx)){
                   C = list.get(idx);
                   C.name = 'C';
                   answerList.add(C);
                   idx++;
               }
               else {
                   flag = 1;
                   break;
               }
            }
            if(flag==1){
                answer.append("IMPOSSIBLE");
            }
            else {
                for(int i=0;i<n;i++){
                    Point tmp = p.get(i);
                    for(Point a : answerList){
                        if(a.x == tmp.x && a.y==tmp.y){
                            jc.append(a.name);
                            break;
                        }
                    }
                }
                answer.append(jc.toString());
            }
            System.out.println(answer.toString());
        }
    }
    public static boolean isAva(Point p, int n){
        if(p.y<=list.get(n).x){
            return true;
        }
        else {
            return false;
        }
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        char name;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x-o.x==0){
                return this.y-o.y;
            }
            return this.x-o.x;
        }
    }
}
