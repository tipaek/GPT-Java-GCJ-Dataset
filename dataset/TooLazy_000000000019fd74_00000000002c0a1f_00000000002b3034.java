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
//           for(int i = 0;i < num_pattern;i++){
//             System.out.println(patterns.get(i));
//           }
           String ans = patterns.get(0).substring(1);
            for(int i = 1;i < num_pattern;i++){
                String cur = patterns.get(i).substring(1);
                if(cur.equals(ans.substring(ans.length()-cur.length())));
                else{
                  ans = "*";
                  break;
                }
            }
            if(ans.length() > 10000) ans = "*";
          System.out.println("Case #"+ no + ": "+ans);
        }
    }
//    public static StringBuilder match(String pattern, String name){
//        StringBuilder builder = new StringBuilder();
//        String pattern_non = pattern.replace('*','');
//        String name_non = name.replace('*','');
//        if(pattern_non.toLowerCase().contains(name_non)) return builder.append(pattern);
//        else{
//            for(int i = 0,j = 0;i < name.length() && j < pattern.length();i++){
//              if(name.charAt(i) != '*' && pattern.charAt(j)!= '*'){
//                if(name.charAt(i) != pattern.charAt(j)) return new StringBuilder();
//                else
//                  j++;
//              }
//              else if(pattern.charAt(j) != '*'){
//                if(i == name.length()-1){
//                  builder = new StringBuilder();
//                  return builder.append(pattern);
//                }
//                else{
//                  
//                }
//              }
//                
//            }
//        }
//    }
}