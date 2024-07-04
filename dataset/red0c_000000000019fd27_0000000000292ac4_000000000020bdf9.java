import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int ti=1;ti<=t;ti++){

            int n = in.nextInt();


            Map<Integer,Integer> tasks = new TreeMap<>();
            Map<Integer,Integer> order = new HashMap<>();
            int [] arrStart = new int[n];

            for(int i=0;i<n;i++){
                int start = in.nextInt();
                int end = in.nextInt();

                tasks.put(start,end);
                order.put(start,i);
            }


            int cat = 0;
            for (Map.Entry<Integer, Integer> entry : tasks.entrySet()) {
                arrStart[cat] = entry.getKey();
                ++cat;
            }

            
            char ans[] = new char[n];
            int currC = arrStart[0];
            int currJ = -1;

            ans[order.get(currC)] = 'C';

            boolean isImp = false;

            for(int i=1;i<n;i++){
                if(tasks.get(currC) <= arrStart[i] || currC == -1){
                    ans[order.get(arrStart[i])] = 'C';
                    currC = arrStart[i];
                }
                else if(currJ == -1 || tasks.get(currJ) <= arrStart[i]){
                    ans[order.get(arrStart[i])] = 'J';
                    currJ = arrStart[i];
                }
                else{
                    isImp = true;
                    break;
                }
            }

            String finalAns = new String(ans);

            if(isImp)
                finalAns = "IMPOSSIBLE";

            System.out.println("Case #"+ti+": "+finalAns);

        }
    }
}