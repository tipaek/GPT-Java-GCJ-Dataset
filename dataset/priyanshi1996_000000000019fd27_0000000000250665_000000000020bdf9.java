import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int N = sc.nextInt();
            ArrayList<Time> list = new ArrayList<>();
            for(int i=0;i<N;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                list.add(new Time(start, end, i));
            }
            sort(list);
            String[] result = new String[N];
            // result[0] = "C";
            // char ch = 'C';
            // int end = list.get(0).end;
            boolean flag = true;
            int CTime=0, JTime=0;
            for(int i=0;i<N;i++){
                Time time = list.get(i);
                if(time.start>=CTime){
                    CTime=time.end;
                    result[time.index]="C";
                }
                else if(time.start>=JTime){
                    JTime=time.end;
                    result[time.index]="J";
                }
                else{
                    flag=false;
                    break;
                }
            }
            String finalResult="IMPOSSIBLE";
            if(flag){
                finalResult="";
                for(int i=0;i<N;i++)
                    finalResult+=result[i];
            }
            System.out.println("Case #"+t+": "+finalResult);
        }
    }
    public static char changeChar(char ch){
        if(ch == 'C')
            return 'J';
        else
            return 'C';
    }
    public static void sort(ArrayList<Time> list){
        Comparator<Time> comp=new Comparator<Time>(){
            public int compare(Time t1, Time t2){
                if(t1.start<t2.start)
                    return -1;
                else if(t1.start>t2.start)
                    return 1;
                else if(t1.end<t2.end)
                    return -1;
                else
                    return 1;
            }
        };
        Collections.sort(list,comp);
    }
}
class Time{
    int start;
    int end;
    int index;
    Time(int start,int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }
    
    public String toString(){
        return start+" "+end;
    }
}