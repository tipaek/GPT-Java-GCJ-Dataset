import java.util.*;

class Solution{
    
    static class Time{
        int s1;
        int e1;
     Time(int s, int e){
            this.s1=s;
            this.e1=e;
        }
    }
    
    public static boolean checkOverlap(int s1,int e1,int s2, int e2){
        if(s1<=s2 && e1>s2) return true;
        if(s1<e2 && e1>=e2) return true;
        if(s1>=s2 && e1<=e2) return true;
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            //int mat[][]=new int[n][2];
            String ans="";
            //boolean b=false;
            ArrayList<Time> cam = new ArrayList<Time>();
            ArrayList<Time> jam = new ArrayList<Time>();
            for(int i=0;i<n;i++){
                int x1=sc.nextInt();
                int y1=sc.nextInt();
                boolean res=true;
                for(int j=0;j<cam.size();j++){
                    if(checkOverlap(cam.get(j).s1,cam.get(j).e1,x1,y1)){
                        res=false;
                        break;
                    }
                }
                if(res){
                    ans+="C";
                    cam.add(new Time(x1,y1));
                    continue;
                }
                res=true;
                for(int j=0;j<jam.size();j++){
                    if(checkOverlap(jam.get(j).s1,jam.get(j).e1, x1,y1)){
                        res=false;break;
                    }
                }
                if(res){
                    ans+="J";
                    jam.add(new Time(x1,y1));
                    continue;
                }else{
                    ans="IMPOSSIBLE";
                    break;
                }
            }
            //if(b) continue;
            System.out.println("Case #"+k+": "+ans);
        }
    }
}