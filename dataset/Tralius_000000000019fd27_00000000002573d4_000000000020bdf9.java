import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i <= t; i++) {
            int nr = in.nextInt();
            String answer = "";
            boolean impossible = false;
            boolean cNotEmpty = false;
            boolean jNotEmpty = false;
            boolean covered = false;
            ArrayList<Integer> cameronStart = new ArrayList<>();
            ArrayList<Integer> cameronEnd = new ArrayList<>();
            ArrayList<Integer> jamieStart = new ArrayList<>();
            ArrayList<Integer> jamieEnd = new ArrayList<>();
            for(int j = 0; j < nr; j++){
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                if(impossible == false){
                    covered = false;
                    cNotEmpty = false;
                    jNotEmpty = false;
                    for(int pos = 0; pos < cameronStart.size()  && covered == false; pos++){
                        cNotEmpty = true;
                        if(startTime >= cameronEnd.get(pos)){
                            cameronStart.add(startTime);
                            cameronEnd.add(endTime);
                            covered = true;
                            answer += "C";
                        } else if(endTime <= cameronStart.get(pos)){
                            cameronStart.add(startTime);
                            cameronEnd.add(endTime);
                            covered = true;
                            answer += "C";
                        }
                    }
                    for(int pos = 0; pos < jamieStart.size() && covered == false; pos++){
                        jNotEmpty = true;
                        if(startTime >= jamieEnd.get(pos)){
                            jamieStart.add(startTime);
                            jamieEnd.add(endTime);
                            covered = true;
                            answer += "J";
                        } else if(endTime <= jamieStart.get(pos)){
                            jamieStart.add(startTime);
                            jamieEnd.add(endTime);
                            covered = true;
                            answer += "C";
                        }
                    }

                    if(cNotEmpty == false && covered == false){
                        cameronStart.add(startTime);
                        cameronEnd.add(endTime);
                        answer += "C";
                        jNotEmpty = true;
                        covered = true;
                    } else if(jNotEmpty == false && covered == false){
                        jamieStart.add(startTime);
                        jamieEnd.add(endTime);
                        answer += "J";
                        jNotEmpty = true;
                        covered = true;
                    }

                    if(jNotEmpty == true && cNotEmpty == true&& covered == false) {
                        impossible = true;
                        answer = "IMPOSSIBLE";
                    }
                }
            }
            System.out.println("Case #" + i + ": " + answer);
        }
    }
}
