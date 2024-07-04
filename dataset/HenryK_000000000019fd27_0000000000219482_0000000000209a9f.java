import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int i = 1 ; i <= t ; i++){
            String s = sc.nextLine();
            int[] arr = new int[s.length()];

            for(int cnt = 0 ; cnt < s.length() ; cnt++){
                arr[cnt] = Integer.parseInt(s.substring(cnt,cnt+1));
            }

            String strBuild = "";
            int sum = 0;
            for(int x = (arr.length - 1) ; x >= 0 ; x--){
                int target = arr[x], gather = 0;
                for(int p = 0 ; p < (target - sum) ; p++){
                    strBuild = ")" + strBuild;
                    gather++;
                }
                strBuild = target + strBuild;
                if(x > 0){
                    for(int p = 0 ; p < (target - arr[x-1]) ; p++){
                        strBuild = "(" + strBuild;
                        gather--;
                    }
                }
                else{
                    for(int p = 0 ; p < target ; p++){
                        strBuild = "(" + strBuild;
                        gather--;
                    }
                }
                sum += gather;
            }

            System.out.println("Case #"+i+": "+strBuild);
        }
    }
}