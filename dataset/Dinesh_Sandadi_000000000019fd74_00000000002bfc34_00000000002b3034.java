
import java.util.*;

public class Solution {

    private String commonStringEnd(List<String> li){
        if(li.size() == 0)
            return "";
        Collections.sort(li, (s1, s2)-> s2.length() - s1.length());
        String common = li.get(0);

        for(String curr: li) {
            if(!common.substring(common.length() - curr.length()).equals(curr))
                return "";
        }

        return common;
    }
    private String commonStringStart(List<String> li){
        if(li.size() == 0)
            return "";
        Collections.sort(li, (s1, s2)-> s2.length() - s1.length());
        String common = li.get(0);

        for(String curr: li) {
            if(!common.substring(0, curr.length()).equals(curr))
                return "";
        }

        return common;
    }

    private String fa(String[] arr){
//        List<List<String>> groups =new ArrayList<>();
        List<String> start = new ArrayList<>();
        List<String> end = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            String curr = arr[i];
            StringBuilder t1 = new StringBuilder();
            int p1 = -1;
            int p2 = -1;

            for(int j = 0; j < curr.length(); j++){
                if(curr.charAt(j) == '*'){
                    p1 = j;
                    break;
                }
                else
                    t1.append(curr.charAt(j));
            }
            start.add(t1.toString());

            t1 = new StringBuilder();
            for(int j = curr.length() - 1;j >= 0; j--){
                if(curr.charAt(j) == '*'){
                    p2 = j;
                    break;
                }
                else
                    t1.insert(0, curr.charAt(j));
            }
            end.add(t1.toString());

            for(int j = p1; j < p2; j++){
                if(curr.charAt(j) != '*')
                    ans.append(curr.charAt(j));
            }
        }

        if(start.size() == 0 && end.size() == 0)
            return "A";

        ans.insert(0, commonStringStart(start));

        ans.append(commonStringEnd(end));

        return ans.toString();

    }


    private void printAnswer(String ans, int test){
        if(ans.length() == 0)
            ans = "*";
        System.out.println("Case #"+ test +": " + ans);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution s1 = new Solution();
        int T = Integer.parseInt(sc.nextLine());

        int count = 1;
        while(count <= T){
            int N  = Integer.parseInt(sc.nextLine());
            String[] arr = new String[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextLine();
            }
            String ans = s1.fa(arr);
            s1.printAnswer(ans, count);
            count++;
        }
    }
}
