import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    enum TYPE{
        TYPE_A,
        TYPE_B,
        TYPE_NULL
    }
    static Scanner sc;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for(int i=0;i<T;i++) {
            if(!solve(B)){
                return;
            }
        }
    }
    private static boolean solve(int B){
        TYPE[] type = new TYPE[B];
        int[] num = new int[B];
        Arrays.fill(type, TYPE.TYPE_NULL);
        for(int i=0;i<5;i++){
            getInfo(i, num, type);
        }
        int ofs=5;
        while(ofs < B/2){
            boolean chgA = chkChanged(TYPE.TYPE_A, num, type);
            boolean chgB = chkChanged(TYPE.TYPE_B, num, type);
            seiri(chgA, chgB, num ,type);
            for(int i=0;i<4;i++){
                getInfo(ofs+i, num, type);
            }
            ofs += 4;
        }
        boolean chgA = chkChanged(TYPE.TYPE_A, num, type);
        boolean chgB = chkChanged(TYPE.TYPE_B, num, type);
        seiri(chgA, chgB, num ,type);
        for(int i=0;i<B;i++){
            System.out.print(num[i]);
        }
        System.out.println();
        String s = sc.next();
        if(s.equals("N")){
            //System.err.println("failed");
            return false;
        }
        return true;
    }

    private static void getInfo(int ind, int[] num, TYPE[] type){
        int len = num.length;
        int first=q(ind);
        int li=len-1-ind;
        int last=q(li);
        if(first == last){
            type[ind] = TYPE.TYPE_B;
            type[li] = TYPE.TYPE_B;
        }else{
            type[ind] = TYPE.TYPE_A;
            type[li] = TYPE.TYPE_A;
        }
        num[ind]=first;
        num[li]=last;
    }
    private static void seiri(boolean chgA, boolean chgB, int[] num, TYPE[] type){
        for(int i=0;i<num.length;i++){
            if((chgA && type[i] == TYPE.TYPE_A) || (chgB && type[i] == TYPE.TYPE_B)){
                num[i] = 1-num[i];
            }
        }
    }
    private static boolean chkChanged(TYPE tgtType, int[] num, TYPE[] type){
        int ind=0;
        while(ind < type.length && type[ind] != tgtType){
            ind++;
        }
        if(ind == type.length){
            q(0);
            return false;
        }else{
            int now=q(ind);
            if(num[ind] == now){
                return false;
            }else{
                return true;//changed!
            }
        }
    }

    private static int q(int i){
        System.out.println(i+1);
        return sc.nextInt();
    }
}
