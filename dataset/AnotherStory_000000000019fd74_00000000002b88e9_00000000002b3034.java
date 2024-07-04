import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int ts = 0; ts < t; ts++) {
            int n = in.nextInt();
            boolean answer = true;

            String arr[] = new String[n];

            for(int i = 0; i < n; i++) {
                arr[i] = in.next();
            }

            List<String> afterAsterisk = new ArrayList<>();
            List<String> beforeAsterisk = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                int index = 0;

                for(int j = 0; j < arr[i].length(); j++)
                    if(arr[i].charAt(j) == '*'){
                        index = j;
                        break;
                    }

                if(index != arr[i].length() - 1)
                    afterAsterisk.add(arr[i].substring(index+1, arr[i].length()));

                if(index != 0)
                    beforeAsterisk.add(arr[i].substring(0, index));
            }

            int maxAfterAsterisk = 0;
            int maxBeforeAsterisk = 0;

            for(int i = 0; i < afterAsterisk.size(); i++)
                if(afterAsterisk.get(i).length() > afterAsterisk.get(maxAfterAsterisk).length())
                    maxAfterAsterisk = i;


            for(int i = 0; i < beforeAsterisk.size(); i++)
                if(beforeAsterisk.get(i).length() > beforeAsterisk.get(maxBeforeAsterisk).length())
                    maxBeforeAsterisk = i;
            
            for(int i = 0; i < afterAsterisk.size(); i++){
                if(i != maxAfterAsterisk){
                    if(!afterAsterisk.get(maxAfterAsterisk).contains(afterAsterisk.get(i))){
                        answer = false;
                        break;
                    }
                }
            }

            for(int i = 0; i < beforeAsterisk.size(); i++){
                if(i != maxBeforeAsterisk){
                    if(!beforeAsterisk.get(maxBeforeAsterisk).contains(beforeAsterisk.get(i))){
                        answer = false;
                        break;
                    }
                }
            }
    
            // System.out.println("length -> " + afterAsterisk.size() + " " + beforeAsterisk.size());

            String out = "";

            if(answer == false){
                out = "*";
            }
            else{
                if(beforeAsterisk.size() > 0 && afterAsterisk.size() > 0){
                    System.out.println("Inside Both");
                    out = beforeAsterisk.get(maxBeforeAsterisk) + "" + afterAsterisk.get(maxAfterAsterisk);
                }
                else{
                    if(beforeAsterisk.size() > 0){
                        System.out.println("Inside beforeAsterisk");
                        out = beforeAsterisk.get(maxBeforeAsterisk);
                    }
                    else{
                        System.out.println("Inside afterAsterisk");
                        out = afterAsterisk.get(maxAfterAsterisk);
                    }
                }
            }

            System.out.println("Case #" + (ts + 1) + ": " + out);
        }
    }
}