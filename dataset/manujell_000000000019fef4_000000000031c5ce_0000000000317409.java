import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int j = 1; j<=T; j++){
            String str = fan(br);
            System.out.format("Case #%d: %s\n", j, str);
        }
    }
/*
    public static String pancake(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int D = Integer.parseInt(line[1]);
    }
*/
    public static String fan(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");

        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        String M = line[2];
        List<Integer> xCat = new ArrayList<>();
        List<Integer> yCat = new ArrayList<>();

        xCat.add(x);
        yCat.add(y);
        for(char c : M.toCharArray()){
            switch (c){
                case 'N':
                    yCat.add(yCat.get(yCat.size()-1)+1);
                    xCat.add(xCat.get(xCat.size()-1));
                    break;
                case 'S':
                    yCat.add(yCat.get(yCat.size()-1)-1);
                    xCat.add(xCat.get(xCat.size()-1));
                    break;
                case 'E':
                    xCat.add(xCat.get(xCat.size()-1)+1);
                    yCat.add(yCat.get(yCat.size()-1));
                    break;
                case 'W':
                    xCat.add(xCat.get(xCat.size()-1)-1);
                    yCat.add(yCat.get(yCat.size()-1));
                    break;
            }
        }
        for(int i=0; i<xCat.size(); i++){
            if(Math.abs(xCat.get(i)) + Math.abs(yCat.get(i)) <= i){
                return i + "";
            }
        }

        return "IMPOSSIBLE";
    }
}
