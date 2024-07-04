import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i<cases; i++){
            ArrayList<Character> record = new ArrayList<>();
            int tasks = sc.nextInt();
            HashSet<Integer> jamie = new HashSet<>();
            HashSet<Integer> cameron = new HashSet<>();
            for(int j = 0; j<=1440; j++){
                jamie.add(j);
                cameron.add(j);
            }
            boolean possible = true;
            for(int j = 0; j<tasks; j++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(possible) {
                    if(jamie.contains(start)&&jamie.contains(end)){
                        for(int k = start+1; k<=end-1; k++){
                            jamie.remove(k);
                        }
                        record.add('J');
                    } else if(cameron.contains(start)&&cameron.contains(end)){
                        for(int k = start+1; k<=end-1; k++){
                            cameron.remove(k);
                        }
                        record.add('C');
                    } else {
                        System.out.printf("Case #%d: IMPOSSIBLE", i+1);
                        System.out.println();
                        possible = false;
                    }
                }
            }
            if(possible) {
                System.out.printf("Case #%d: ", i+1);
                for(int j = 0; j<record.size(); j++){
                    System.out.print(record.get(j));
                }
                System.out.println();
            }
        }
    }
}