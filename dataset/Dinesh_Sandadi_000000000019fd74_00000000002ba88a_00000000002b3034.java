
import java.util.*;

public class Solution {

    private String commonString(List<String> li){
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
    private String fa(String[] arr){
        List<List<String>> groups =new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            String[] temp = arr[i].split("\\*");
            for(int j = 0; j < temp.length; j++){
                while(groups.size() < (j + 1)){
                    groups.add(new ArrayList<>());
                }
                groups.get(j).add(temp[j]);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(List<String> group : groups){
            ans.append(commonString(group));
        }

        if(groups.size() == 0)
            return "A";
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
