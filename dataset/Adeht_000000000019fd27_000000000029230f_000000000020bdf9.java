import java.util.*;

class Activity implements Comparable<Activity>{
    int start,end,position;
    public int compareTo(Activity a) {  
        if(start>a.start){  
            return 1;  
        }
        else if(start<a.start){  
            return -1;  
        }
        else{  
        return 0;  
        }  
    }
}

class Parent{
    boolean isFree=true;
    int busyTill=0;
}
class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        TreeSet<Activity> treeSet= new TreeSet<Activity>();
        Activity activity= new Activity();
        Parent jamie= new Parent();
        Parent cameron= new Parent();
        int testCase=sc.nextInt();
        String str=new String();
        for(int i=0;i<testCase;i++){
            int noOfActivities=sc.nextInt();
            for(int j=0;j<noOfActivities;j++){
                activity.start=sc.nextInt();
                activity.end=sc.nextInt();
                activity.position=j;
                str.append("X");
                treeSet.add(activity);
                activity= new Activity();
            }
            Iterator<Activity> itr= treeSet.iterator();
            while(itr.hasNext()){
                activity=itr.next();
                if(jamie.busyTill<=activity.start){
                    jamie.isFree=true;
                }
                if(cameron.busyTill<=activity.start){
                    cameron.isFree=true;
                }
                if(jamie.isFree){
                    jamie.isFree=false;
                    jamie.busyTill=activity.end;
                    str.setCharAt(activity.position,'J');
                }
                else if(cameron.isFree){
                    cameron.isFree=false;
                    cameron.busyTill=activity.end;
                    str.setCharAt(activity.position,'C');
                }
                else{
                    str="IMPOSSIBLE";
                    break;
                }
            }
            cameron.busyTill=0;
            jamie.busyTill=0;
            System.out.println("Case #"+(i+1)+": "+str);
            str="";
            treeSet.clear();
        }
    }
}