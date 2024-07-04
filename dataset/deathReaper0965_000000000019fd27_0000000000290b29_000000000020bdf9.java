import java.util.*;

class Tracker{
    int start;
    int end;
    int index;
    
    Tracker(int start,int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }
   
    public String toString(){
        return start+" "+end;
    }
}

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int k=0;k<t; k++){
            int n = scan.nextInt();
            ArrayList<Tracker> tList = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                int start = scan.nextInt();
                int end = scan.nextInt();
                tList.add(new Tracker(start, end, i));
            }
            
            sort(tList);
            
            String[] res = new String[n];
            boolean flag = true;
            int C=0, J=0;
            
            for(int i=0;i<n;i++){
                Tracker tracker = tList.get(i);
                if(tracker.start>=C){
                    C=tracker.end;
                    res[tracker.index]="C";
                }
                else if(tracker.start>=J){
                    J=tracker.end;
                    res[tracker.index]="J";
                }
                else{
                    flag=false;
                    break;
                }
            }
            
            String reqRes="IMPOSSIBLE";
            
            if(flag){
                reqRes="";
                for(int i=0;i<n;i++)
                    reqRes+=res[i];
            }
            
            System.out.println("Case #"+(k+1)+": "+reqRes);
        }
    }
    
    public static void sort(ArrayList<Tracker> tList){
        Collections.sort(tList, new Comparator<Tracker>(){
                                    public int compare(Tracker t1, Tracker t2){
                                        if(t1.start<t2.start)
                                            return -1;
                                        else if(t1.start>t2.start)
                                            return 1;
                                        else if(t1.end<t2.end)
                                            return -1;
                                        else
                                            return 1;
                                    }
                                }
                        );
    }
}
