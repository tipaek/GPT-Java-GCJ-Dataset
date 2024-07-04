import java.util.*;

class Activity{
        int start, finish;
        Activity(int start, int finish){
            this.start = start;
            this.finish = finish;
        }
    }
    
class Solution{

    public static String changePerson(String person){
        if(person.equals("C"))
            return "J";
        else
            return "C";
            
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int startTime = 0, endTime = 0;
        
        for(int k=1;k<=testCase;k++){
            int n = sc.nextInt();
            // int [] start = new int[n];
            // int [] end = new int[n];
            
            ArrayList<Activity> listActy = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                startTime = sc.nextInt();
                endTime = sc.nextInt();
               //Activity a = new Activity(startTime, endTime);
                listActy.add(new Activity(startTime, endTime));
                
              
            }
            
           //  for(Activity a: listActy){
           //	System.out.println(a.finish+"  "+a.start);
           //}
            
            Collections.sort(listActy, new Comparator<Activity>(){
            	public int compare(Activity a1, Activity a2){
            		if(a1.finish < a2.finish)
            			return 1;
            		else
            			return 0;
            	}
            		
            });
            
           //  for(Activity a: listActy){
           //	System.out.println(a.finish+"  "+a.start);
           //}
           
            
            int [] taskAssign = new int[n];
            taskAssign[0] = 1;
             //for(int i=0;i<n;i++)
            	// System.out.print(taskAssign[i]+ " ");
            	// System.out.println("\n");
            // task done by C
            for(int i=1;i<n;i++){
                Activity prev = listActy.get(i-1);
                Activity curr = listActy.get(i);
                
                if(curr.start>=prev.finish)
                    taskAssign[i]=1;
            }
            
            // task done by J
            Activity prevTaskJ = null;
            for(int i=1;i<n;i++){
                if(taskAssign[i]==0){
                   if(prevTaskJ==null){
                       taskAssign[i]=2;
                       prevTaskJ = listActy.get(i);
                   } else{
                       Activity curr = listActy.get(i);
                       if(curr.start>=prevTaskJ.finish)
                            taskAssign[i] = 2;
                            prevTaskJ = curr;
                        
                   }
                }
            }
            
          
            boolean ansExists = true;
            StringBuilder seq = new StringBuilder();
            for(int i=0;i<n;i++){
                if(taskAssign[i]==0){
                    ansExists = false;
                    break;
                }
                
                else if(taskAssign[i]==1)
                    seq.append("C");
                else if(taskAssign[i]==2)
                    seq.append("J");
            }
            
            // for(int i=0;i<n;i++)
            // 	System.out.print(taskAssign[i]+" ");
            	
            	// System.out.println("\n");
            
            
            if(ansExists==false)
                System.out.println("Case #"+k+": IMPOSSIBLE");
            else
                System.out.println("Case #"+k+": "+seq.toString());
            
            
        }
        
    }
}