import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for (int j = 1; j <=t ; j++) {
            int n=s.nextInt();
            Times times[]=new Times[n];
            for (int i = 0; i <n ; i++) {
                times[i] =new Times(i+1);
                int startTime=s.nextInt();
                int endTime=s.nextInt();
                times[i].startTime=startTime;
                times[i].endTime=endTime;
            }
            Arrays.sort(times);
           // System.out.println(Arrays.deepToString(times));
            String res="C";
            int f=0;
            int startTimeC=times[0].startTime;
            int startTimeJ=0;
            int endTimeC=times[0].endTime;
            int endTimeJ=0;
            int index=times[0].index;
            char ans[]=new char[n];
            ans[index-1]='C';
            for (int i = 1; i <times.length ; i++) {
                Times times1=times[i];
                int st=times1.startTime;
                int en=times1.endTime;
                int idx=times1.index;
                if(st>=endTimeC) {
                    ans[idx-1]='C';
                    startTimeC=st;
                    endTimeC=en;
                }
                else if(st>=endTimeJ){
                    ans[idx-1]='J';
                    startTimeJ=st;
                    endTimeJ =en;
                }
                else{
                    f=1;
                    break;
                }
            }

            if(f==1)
                res="IMPOSSIBLE";
            else{
                res="";
                for (int i = 0; i <n ; i++) {
                 res+=ans[i];
                }
            }
            System.out.println("Case #" + j + ": " + res);

        }
    }
}
class Times implements Comparable<Times> {
    Integer startTime;
    Integer endTime;
    Integer index;


    public  Times(int index){
         this.index=index;
     }


    @Override
    public int compareTo(Times o) {
        if(this.startTime!=o.startTime)
        return this.startTime.compareTo(o.startTime);
        else
            return this.endTime.compareTo(o.endTime);
    }

    @Override
    public String toString() {
        return "Times{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", index=" + index +
                '}';
    }
}