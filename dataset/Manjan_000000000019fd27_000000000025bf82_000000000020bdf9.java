import java.util.*;

class Activity {
    public int time;
    public String tag;
    public int index;
}

public class Solution {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0;k<t;k++) {
            int n = sc.nextInt();
            List<Activity> list = new ArrayList<>();
            for(int i=0;i<n;i++) {
                Activity temp = new Activity();
                temp.time = sc.nextInt();
                temp.tag = "A";
                temp.index = i;
                
                list.add(temp);
                temp = new Activity();
                temp.time = sc.nextInt();
                temp.tag = "D";
                temp.index = i;
                list.add(temp);
            }
            
            Comparator<Activity> comp = new Comparator<Activity>() {
              
              public int compare(Activity a1,Activity a2) {
                  return a1.time-a2.time;
              }
                
            };
            
            Collections.sort(list,comp);
            int isC=-1,isJ=-1;
            String result="";
            char[] ar = new char[n];
            for(Activity a : list) {
                //System.out.println(a+" "+isC+" "+isJ);
                if(isC!=-1 && isJ!=-1 && a.tag.equals("A")) {
                    result = "IMPOSSIBLE";
                    break;
                }
                if(a.tag.equals("A")) {
                    if(isC==-1) {
                        ar[a.index] = 'C';
                        isC=a.index;
                    } else {
                        ar[a.index] = 'J';
                        isJ=a.index;
                    }
                } else {
                    if(isC!=-1 && a.index==isC)
                        isC=-1;
                    if(isJ!=-1 && a.index==isJ)
                        isJ=-1;
                }
            }
            if(result.equals("IMPOSSIBLE")) {
                System.out.print("Case #"+(k+1)+": "+result + "\n");
            } else {
                result = new String(ar);
                System.out.print("Case #"+(k+1)+": "+result + "\n");
            }
            
        }
        
    }
    
}