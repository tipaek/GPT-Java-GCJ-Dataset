import java.util.*;
import java.io.*;
class Slot{
    int start;
    int end;
    int index;
    char assignee;
    public Slot(int start,int end,int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
public class Solution{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tt = t;
        while(t-->0){
            int n = sc.nextInt();
            Slot[] slots = new Slot[n];
            Slot[] temp = new Slot[n];
            HashMap<String,Character> hm = new HashMap<>();
            for(int i=0;i<n;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                slots[i] = new Slot(start,end,i);
                temp[i] = new Slot(start,end,i);
            }
            Arrays.sort(slots, new Comparator<Slot>(){
                public int compare(Slot a,Slot b){
                    return a.start-b.start;
                }
            });

            boolean flag = false;
            String ans = "";
            int end1 = slots[0].end,end2=slots[1].end;
            slots[0].assignee='C';
            slots[1].assignee='J';
//            boolean[] busy = new boolean[2];


            for(int i=2;i<n;i++){
                int starttime = slots[i].start;
                if(starttime<end1 && starttime<end2){
                    flag = true;
                    break;
                }
                else if(starttime>=end1){
                    end1 = slots[i].end;
                    slots[i].assignee = 'C';
                }
                else{
                    end2 = slots[i].end;
                    slots[i].assignee = 'J';
                }
            }

            Arrays.sort(slots, new Comparator<Slot>(){
                public int compare(Slot a,Slot b){
                    return a.index-b.index;
                }
            });

            for(int i=0;i<n;i++){
                ans+=slots[i].assignee;
            }

            System.out.println("Case #"+(tt-t)+": "+(flag?"IMPOSSIBLE":ans));


        }
    }
}