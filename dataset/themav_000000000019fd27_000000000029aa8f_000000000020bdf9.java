import java.util.*;
class nodeAns{
    int startTime;//Start time of the task
    int endTime;// End time of the task
    char ch;
    nodeAns(int k,int l)
    {
        startTime=k;
        endTime=l;
    }
}
public class Solution{

     public static void main(String []args){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        int caseNumber=1;
        while(caseNumber<=T){
            int n=s.nextInt();
            ArrayList<nodeAns> arr1=new ArrayList<nodeAns>();
            ArrayList<nodeAns> store=new ArrayList<nodeAns>();
            
            for(int i=0;i<n;i++){
                int startTime=s.nextInt();
                int endTime=s.nextInt();
                nodeAns node1=new nodeAns(startTime,endTime);
                arr1.add(node1);
                store.add(node1);
            }
            Collections.sort(arr1,new Comparator<nodeAns>(){
                public int compare(nodeAns a,nodeAns b){
                    if(a.startTime==b.startTime){
                        return a.endTime-b.endTime;
                    }
                    else{
                        return a.startTime-b.startTime;
                    }
                }
            });
            int t=Integer.MIN_VALUE;
            int o=Integer.MIN_VALUE;
            int i=0;
            boolean visual=true;
            String ans="Case #"+caseNumber+": ";
            while(i<n){
                if(t<=arr1.get(i).startTime){
                    t=Integer.MIN_VALUE;
                }
                if(o<=arr1.get(i).startTime){
                    o=Integer.MIN_VALUE;
                }
                boolean success = false;
                if(t<=arr1.get(i).startTime){
                    t=arr1.get(i).endTime;
                    success=true;
                    arr1.get(i).ch='C';
                }
                else if(o<=arr1.get(i).startTime){
                    o=arr1.get(i).endTime;
                    success=true;
                    arr1.get(i).ch='J';
                }
                if(!success){
                    ans="Case #"+caseNumber+": "+"IMPOSSIBLE";
                    visual=false;
                    break;
                }
                i++;
            }
            if(visual){
                for(int p=0;p<n;p++)
                {
                    ans=ans+store.get(p).ch;
                }
                System.out.println(ans);
            }
            else
            {
                System.out.println(ans);
            }
            caseNumber++;
        }
     }
}