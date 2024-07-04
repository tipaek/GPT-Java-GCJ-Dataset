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
    public String toString(){
        return start+" "+end+" "+position;
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
        StringBuilder str=new StringBuilder();
        for(int i=0;i<testCase;i++){
            int noOfActivities=sc.nextInt();
            for(int j=0;j<noOfActivities;j++){
                activity.start=sc.nextInt();
                activity.end=sc.nextInt();
                activity.position=j;
                treeSet.add(activity);
                activity= new Activity();
            }
            Iterator<Activity> itr= treeSet.iterator();
            // Activity temp= itr.next();
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
                    str.append("J");
                }
                else if(cameron.isFree){
                    cameron.isFree=false;
                    cameron.busyTill=activity.end;
                    str.append("C");
                }
                else{
                    str=new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            cameron.busyTill=0;
            jamie.busyTill=0;
            // if(!str.toString().equals("IMPOSSIBLE")){
            //     String result= str.toString();
            //     itr= treeSet.iterator();
            //     int j=0;
            //     while(itr.hasNext()){
            //         activity=itr.next();
            //         str.setCharAt(activity.position,result.charAt(j++));
            //     }
            // }
            System.out.println("Case #"+(i+1)+": "+str);
            str=new StringBuilder("");
            treeSet.clear();
        }
    }
}