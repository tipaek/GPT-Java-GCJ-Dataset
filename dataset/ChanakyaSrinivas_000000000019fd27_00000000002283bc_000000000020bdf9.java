import java.util.Arrays;
import java.util.Scanner;
class time implements Comparable{
    int s;
    int e;
    int c=0;
    char ch;
    time(int s,int e){
        this.s=s;
        this.e=e;
        this.c++;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof time){
            time temp=(time)o;
            if(this.s>temp.s)
                return 1;
            if(this.s==temp.s)
                return 0;
            return -1;
        }
        return -1;
    }
}
public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int N=sc.nextInt();
            time timings[]=new time[N];
            time duplicate[]=new time[N];
            for(int n=0;n<N;n++){
                timings[n]=new time(sc.nextInt(),sc.nextInt());
                duplicate[n]=timings[n];
            }
            System.out.print("Case #"+t+": ");
            int j=0;
            Arrays.sort(timings);
            int c=timings[0].e;
            timings[0].ch='C';
            boolean flag=false;
            for(int n=1;n<N;n++){
                if(timings[n].s>=c){
                    timings[n].ch='C';
                    c=timings[n].e;
                }
                else if(timings[n].s>=j){
                    timings[n].ch='J';
                    j=timings[n].e;
                }
                else{
                    flag=true;
                    break;
                }
            }
            if(flag) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            for(int n=0;n<N;n++)
                System.out.print(duplicate[n].ch);
            System.out.println();
        }
    }
}
