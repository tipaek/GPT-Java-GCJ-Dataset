
import java.util.*;

public class Solution {

    static Task C = null;
    static Task J = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            C = null;
            J = null;
            String out = "";
            OUTER:
            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                Task tmp = new Task(s, e);
                boolean canAddToC = false;
                boolean canAddToJ = false;
                int res=addToC(tmp);
                switch (res) {
                    case 1:
                        out+="C";
                        break;
                    case -1:
                        out+="J";
                        break;
                    default:
                        out="IMPOSSIBLE";
                        break OUTER;
                }
            }
//            System.out.println(printChain(C));
//            System.out.println(printChain(J));
            System.out.println("Case #"+(i+1)+": "+out);
        }
    }

    static int addToC(Task tmp) {
        int result;
        if (C == null) {
            C = tmp;
            result=1;
        } else {
            if (tmp.e <= C.s) {
                tmp.next = C;
                C = tmp;
                result=1;
            } else if (tmp.s >= C.e) {
                if(C.addNext(tmp)){
                    result=1;
                }else if(J.addNext(tmp)){
                    result=-1;
                }else{
                    result=0;
                }
            } else {
                if(addToJ(tmp)){
                    result=-1;
                }else{
                    result=0;
                }
            }
        }
        return result;
    }

    static boolean addToJ(Task tmp) {
        boolean canAddToJ = false;
        if (J == null) {
            J = tmp;
            canAddToJ = true;
        } else {
            if (tmp.e <= J.s) {
                tmp.next = J;
                J = tmp;
                canAddToJ = true;
            } else if (tmp.s >= J.e) {
                canAddToJ = J.addNext(tmp);
            } else {
                canAddToJ = false;
            }
        }
        return canAddToJ;
    }
    static String printChain(Task start){
        String out="";
        while(start!=null){
            out+=start.s+" "+start.e+" ";
            start=start.next;
        }
        return out;
    }

}

class Task {

    int s;
    int e;
    Task next;

    public Task(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public boolean addNext(Task next) {
        if(next.s>=this.e &&  (this.next==null || next.e<= this.next.s)){
            next.next=this.next;
            this.next=next;
            return true;
        }
        if(this.next!=null){
            return this.next.addNext(next);
        }else{
            return false;
        }
        
    }

}
