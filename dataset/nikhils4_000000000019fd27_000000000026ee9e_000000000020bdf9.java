
import java.util.*;

class Solution {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int caseno = 1;
        while(test-->0){
            int tasks = sc.nextInt();
            int eq = tasks;
            String ans = "";
            Parents jamie = new Parents();
            Parents cameron = new Parents();
            while(tasks-->0){
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(jamie.ifFree(start, end)){
                    ans = ans + "J";
                } else if (cameron.ifFree(start, end)){
                    ans = ans + "C";
                } else {
                    break;
                }
            }

            if(ans.length() == eq){
                System.out.println("Case #" + caseno++ + ": " + ans);
            } else {
                System.out.println("Case #" + caseno++ + ": IMPOSSIBLE");
            }
            ans = "";
        }
    }
}

class Parents {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public boolean ifFree(int start, int end){
        for(Integer k : this.map.keySet()){
            if(this.map.size() == 0){
                return true;
            }
            if(k <= start && start < map.get(k)){
                return false;
            }
            if(k <= end && end < map.get(k)){
                return false;
            }
            if((k <= start && start < map.get(k)) && (k <= end && end < map.get(k))){
                return false;
            }
        }
        this.map.put(start, end);
        return true;
    }
}