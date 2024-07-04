import java.util.*;


class Solution{

public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    int cases = 1;
    
    while(cases<=testcases){
        
        int r = sc.nextInt();
        int s = sc.nextInt();
        
        int completedNumbers = 0;
        int S = (r*s)-r-1;
        int R = r;
        List<String> result = new LinkedList<>();
        while(completedNumbers+1<r){
            int sortedCount = 1;
            
            while(sortedCount<s){
                result.add(R+" "+S);
                S--;
                sortedCount++;
            }
            R--;
            completedNumbers++;
        }
        
        System.out.println("Case #"+cases+": "+result.size());
        for(int i=0;i<result.size();i++){
           System.out.println(result.get(i));
            
        }
        
        cases++;
    }
    
    
}


}

