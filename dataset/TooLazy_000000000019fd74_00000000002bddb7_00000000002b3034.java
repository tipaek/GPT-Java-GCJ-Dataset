import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int no = 0;
        while(no < testCase){
            no++;
            int num_pattern = scanner.nextInt();
            ArrayList<String> patterns = new ArrayList<>();
            for(int i = 0;i < num_pattern;i++){
                int j = 0;
                String cur = scanner.next();
                while(j < patterns.size() && cur.length() < patterns.get(j).length()){
                    j++;
                }
                patterns.add(j,cur);
            }

            String ans = patterns.get(0).substring(1);
            for(int i = 1;i < num_pattern;i++){
                String cur = patterns.get(i).substring(1);
                if(ans.contains(cur));
                else{
                  ans = "*";
                  break;
                }
            }
          System.out.println("Case #"+ no + ": "+ans);
        }
    }

}