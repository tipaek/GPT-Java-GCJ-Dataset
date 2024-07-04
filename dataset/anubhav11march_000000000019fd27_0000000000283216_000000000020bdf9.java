import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{
    static class Activity{
        int sTime=-1, eTime=-1;
        char doer='N';
    }
    static class Moment{
        int c, j;
        Moment(int c, int j){
            this.c = c;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for(int k=0; k<n; k++){
            int x = inp.nextInt();
            ArrayList<Activity> a = new ArrayList<>();
            Moment[] day = new Moment[1441];
            for(int i=0; i<1441; i++){
                day[i] = new Moment(0, 0);
            }
            for(int i=0; i<x; i++){
                a.add(new Activity());
                a.get(i).sTime = inp.nextInt();
                a.get(i).eTime = inp.nextInt();
            }
            boolean possible = true;
            for (int i=0; i<x; i++){
                int st=a.get(i).sTime, et = a.get(i).eTime;
                if(day[st].c == 0 && day[et].c == 0){
                    int timer=st;
                    while(timer<et){
                        day[timer++].c = 1;
                    }
                    a.get(i).doer='C';
                }
                else if(day[st].j == 0 && day[et].j == 0){
                    int timer=st;
                    while(timer<et){
                        day[timer++].j = 1;
                    }
                    a.get(i).doer='J';
                }
                else {
                    possible = false;
                    break;
                }
            }
            System.out.print("Case #" + (k+1) +  ": ");
            if(possible) {
                for (int i = 0; i < x; i++) {
                    System.out.print(a.get(i).doer);
                }
                System.out.println();
            }
            else
                System.out.println("IMPOSSIBLE");
        }
    }
}