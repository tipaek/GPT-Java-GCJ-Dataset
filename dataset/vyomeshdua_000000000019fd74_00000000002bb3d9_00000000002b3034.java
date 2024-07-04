import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int patterns = sc.nextInt();
            boolean possible = true;
            ArrayList<String> start = new ArrayList<>();
            ArrayList<String> end = new ArrayList<>();
            ArrayList<String> middle = new ArrayList<>();
            ArrayList<String> exact = new ArrayList<>();

            String finalStart = new String();
            String finalEnd = new String();
            String finalExact = new String();
            String solution = new String();


            for(int j = 0; j<= patterns; j++){
                String str = sc.nextLine();

                boolean prev = false;
                StringBuilder subStr = new StringBuilder();
                for(int n = 0; n< str.length(); n++){

                    if(str.charAt(n) == '*'){
                        if(subStr.length() > 0) {
                            if(prev)
                                middle.add(subStr.toString());
                            else
                                start.add(subStr.toString());
                            subStr = new StringBuilder();
                        }
                        prev = true;
                    }

                    if(str.charAt(n) != '*'){
                        subStr.append(str.charAt(n));
                        if(n == str.length() - 1){
                            if(prev)
                                end.add(subStr.toString());
                            else
                                exact.add(subStr.toString());
                        }
                    }
                }
            }

            if(exact.size() > 0){
                finalExact = exact.get(0);
                for(int n = 1; n< exact.size(); n++){
                    if(!finalExact.equals(exact.get(n)))
                        possible = false;
                }

                for(int n =0; n<middle.size(); n++){
                    if(!finalExact.contains(middle.get(n)))
                        possible = false;
                }
            }

            if(start.size() > 0){
                finalStart = start.get(0);
                for(int n = 1; n< start.size(); n++){
                    if (start.get(n).contains(finalStart))
                        finalStart = start.get(n);
                    else if(!finalStart.contains(start.get(n)))
                        possible = false;
                }
            }

            if(end.size() > 0){
                finalEnd = end.get(0);
                for(int n = 1; n< end.size(); n++){
                    if (end.get(n).contains(finalEnd))
                        finalEnd = end.get(n);
                    else if(!finalEnd.contains(end.get(n)))
                        possible = false;
                }
            }

            if(possible){
                if(finalExact.length()>0)
                    solution = finalExact;
                else{
                    StringBuilder middles = new StringBuilder();
                    for(int n = 0; n<middle.size(); n++){
                        if(!middles.toString().contains(middle.get(n)))
                            middles.append(middle.get(n));
                    }
                    solution = finalStart + middles + finalEnd;
                }
                System.out.println("Case #" + (i + 1) + ": " + solution);
            }
            else
                System.out.println("Case #" + (i + 1) + ": *");
        }
    }
}
