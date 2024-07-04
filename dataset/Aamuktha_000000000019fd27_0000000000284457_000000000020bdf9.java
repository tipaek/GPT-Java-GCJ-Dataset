import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int h=1;h<=t;h++){
            int n=sc.nextInt();
            int s[]=new int[n+1];
            int e[]=new int[n+1];
            for(int i=1;i<=n;i++){
                s[i]=sc.nextInt();
                e[i]=sc.nextInt();
            }
            boolean isJFree=true,isCFree=true;
            ArrayList<Integer> JStart =new ArrayList<>();
            ArrayList<Integer> CStart =new ArrayList<>();
            ArrayList<Integer> JEnd =new ArrayList<>();
            ArrayList<Integer> CEnd =new ArrayList<>();
            String answer="";
            boolean isPossible=true;
            for(int i=1;i<=n;i++){
                if(i==1){
                    JStart.add(s[i]);
                    JEnd.add(e[i]);
                    answer+="J";
                    continue;
                }
                boolean isJAvailable=CheckAvailability(s[i],e[i],JStart,JEnd);
                boolean isCAvailable=CheckAvailability(s[i],e[i],CStart,CEnd);
                if(!isJAvailable && !isCAvailable) {
                	isPossible=false;
                	break;
                }
            }
            if(!isPossible)
            	System.out.println("Case #"+h+": IMPOSSIBLE");
            else
            	System.out.println("Case #"+h+": "+answer);
        }
    }
    public static boolean CheckAvailability(int start,int end,ArrayList<Integer> startArray,ArrayList<Integer> endArray){
        for(int i=0;i<startArray.size();i++){
            if(end<startArray.get(i) || endArray.get(i)<start)
            	return false;
        }
        return true;
    }
}