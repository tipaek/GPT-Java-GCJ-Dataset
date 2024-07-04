import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Boolean FROM_FILE = Boolean.FALSE;

    public static void main(String[] args) throws IOException{
        BufferedReader br;
        BufferedWriter bw;

        if(FROM_FILE){
            br = new BufferedReader(new FileReader("C2020R1CPB.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            if(FROM_FILE) {
                File file = new File("C2020R1CPB.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            String line = br.readLine();
            String[] p;
            int tests = Integer.parseInt(line);

            for(int i = 0; i < tests; i++){
                line = br.readLine();
                int u = Integer.parseInt(line);
                Map<Character, Integer> map = new HashMap<>();
                Map<Character, Integer> alph = new HashMap<>();
                for(int j = 0; j<10000;j++){

                    line = br.readLine();
                    p = line.split("\\s+");
                    long q = Long.parseLong(p[0]);
                    String r = p[1];
                    Character c = r.charAt(0);
                    long qq = q;
                    int digits = 1;
                    while (qq>=10) {qq = (qq-qq%10)/10; digits++;}
                    int qd = (int) (qq%10);

                    if(digits == r.length()){
                        if(map.containsKey(c)){
                            int max = map.get(c);
                            max = Math.min(max,qd);
                            map.put(c, max);
                        } else {
                            map.put(c, qd);
                        }
                    }//else useless?

                    //all letters
                    for(int k=0;k<r.length();k++){
                        if(!alph.containsKey(r.charAt(k))){
                            alph.put(r.charAt(k),0);
                        }
                    }
                }
                String answer = "";
                //greedy choice to force unique
                for(int k=9;k>=0;k--){
                    for(Character key : map.keySet()){
                        if(map.get(key).equals(k)) {
                            answer = key + answer;
                            map.put(key,-1);
                        }
                    }
                }

                if(answer.length() < 10){
                    for(Character key : alph.keySet()){
                        if(!map.containsKey(key)) {
                            answer = key + answer;
                            break;
                        }
                    }
                }

                //output
                bw.write("Case #"+(i+1)+": "+answer+"\n");
                bw.flush();
            }

            if(FROM_FILE) {
                bw.close();
            }
        } finally {
            if(FROM_FILE) {
                br.close();
            }
        }
    }
}
