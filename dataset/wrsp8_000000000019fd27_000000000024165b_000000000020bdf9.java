import java.util.*;

public class Solution{
    static Scanner in;
    static Appointment[] list;
    static int size;
    static boolean noSolFlag;
    public static void main(String[] args){
        in = new Scanner(System.in);
        int cases = in.nextInt();
        
        for(int i = 0; i < cases; i++){
            parse();
            solve();
            System.out.print("Case #"+(i+1)+": ");
            print();
        }
    }
    
    public static void parse(){
        size = in.nextInt();
        list = new Appointment[size*2];
        for(int i = 0; i < size*2; i++){
            list[i] =new Appointment(in.nextInt(),i/2,i%2==0);
        }
        for(int i =1; i<size*2; i=i+2){
            list[i].origin = list[i-1];
        }
    }
    
    public static void solve(){
        Appointment[] listC = list.clone();
        Arrays.sort(listC);
        noSolFlag = false;
        // C = 1, J=2
        boolean CWorking = false;
        boolean JWorking = false;
        for(Appointment i:listC){
            if(!i.in) {
                if(i.origin.assigned==1){
                    CWorking = false;
                } else {
                    JWorking = false;
                }
            } else{
                if(CWorking==false){
                    CWorking=true;
                    i.assigned = 1;    
                } else if (JWorking==false){
                    JWorking = true;
                    i.assigned = 2;
                } else {
                    noSolFlag = true;
                    break;
                }
            }
        }
    }
    
    public static void print(){
        if(noSolFlag){
            System.out.println("IMPOSSIBLE");
        } else {
            for(int i = 0; i < size*2; i=i+2){
                if(list[i].assigned == 1) {
                    System.out.print("C");
                } else {
                    System.out.print("J");
                }
            }
            System.out.println();
        }
    }
    
    
    private static class Appointment implements Comparable<Appointment>{
        int time;
        int corr;
        boolean in;
        int assigned;
        Appointment origin;
        
        public Appointment(int time, int corr, boolean in){
            this.time =time;
            this.corr =corr;
            this.in = in;
            assigned =0;
        }
        
        public void setAssigmnet(int i){
            assigned = i;
        }
        
        public int compareTo(Appointment other){
            return time - other.time;
        }
    }
    
}