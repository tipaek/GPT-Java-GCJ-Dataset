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
                //System.out.println(isJAvailable+" "+isCAvailable);
                if(!isJAvailable && !isCAvailable) {
                	//System.out.println("Both failed");
                	isPossible=false;
                	break;
                }
                else if(isCAvailable) {
                	//add to c
                	CStart.add(s[i]);
                    CEnd.add(e[i]);
                    answer+="C";
                }
                else if(isJAvailable) {
                	//add to J
                	CStart.add(s[i]);
                    CEnd.add(e[i]);
                    answer+="J";
                }
            }
            if(!isPossible)
            	System.out.println("Case #"+h+": IMPOSSIBLE");
            else
            	System.out.println("Case #"+h+": "+answer);
        }
    }
    public static boolean CheckAvailability(int start,int end,ArrayList<Integer> startArray,ArrayList<Integer> endArray){
    	if(startArray.size()==0)
    		return true;
        for(int i=0;i<startArray.size();i++){
        	//System.out.println(end+" "+startArray.get(i)+" "+endArray.get(i)+" "+start+" "+(end<startArray.get(i) || endArray.get(i)<start));
        	int a,b,c,d;
        	if(start<startArray.get(i)) {
        		a=start;
        		b=end;
        		c=startArray.get(i);
        		d=endArray.get(i);
        	}
        	else {
        		c=start;
        		d=end;
        		a=startArray.get(i);
        		b=endArray.get(i);
        	}
            if(b>c)
            	return false;
        }
        return true;
    }
}