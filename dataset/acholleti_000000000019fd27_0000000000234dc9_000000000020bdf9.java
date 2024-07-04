import java.util.Scanner;
import java.util.*;

class Solution{

    static class Activity{
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void helper(int caseNo, int noActivities, List<Activity> activities){
    PriorityQueue<Activity> queue = new PriorityQueue<>((a,b) -> {
        return a.start - b.start;
    });
    char[] chars = new char[noActivities];
    for(Activity activity : activities){
        queue.add(activity);
    }

    int cLast = 0;
    int jLast = 0;
    Activity previous = queue.poll();
    cLast = previous.end;
    chars[previous.index] = 'C';
    while(!queue.isEmpty()){
        Activity temp = queue.poll();
        
            if(cLast <= temp.start){
                cLast = temp.end;
                chars[temp.index] = 'C';
            }else if(jLast <= temp.start){
                jLast = temp.end;
                chars[temp.index] = 'J';
            }else{
                System.out.println("Case "+"#"+caseNo+": IMPOSSIBLE");
                return;
            }
        
        previous = temp;
    }
    String result = "";
    for(char ch : chars){
        result = result + ch;
    }
    System.out.println("Case "+"#"+caseNo+": "+result);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int n=1;n<=cases;n++){
            int noActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for(int i=0;i<noActivities;i++){
                Activity activity = new Activity(0, 0, 0);
                activity.start = scanner.nextInt();
                activity.end = scanner.nextInt();
                activity.index = i;

                activities.add(activity);
            }
            helper(n, noActivities, activities);
        }
        scanner.close();
    }
}