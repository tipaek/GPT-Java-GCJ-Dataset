import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.nextLine());

        for(int cnt = 1; cnt <= t ; cnt++){
            int s = Integer.parseInt(sc.nextLine());

            ArrayList<HashSet<Integer>> vert = new ArrayList<>(), hori = new ArrayList<>();

            for(int i = 0 ; i < s ; i++){
                vert.add(new HashSet<Integer>());
            }

            int sum = 0;
            for(int i = 0 ; i < s ; i++){
                hori.add(new HashSet<Integer>());

                StringTokenizer st = new StringTokenizer(sc.nextLine());
                for(int ii = 0 ; ii < s ; ii++){
                    int target = Integer.parseInt(st.nextToken());
                    hori.get(i).add(target);
                    vert.get(ii).add(target);

                    if(i == ii){
                        sum += target;
                    }
                }
            }
            
            int vc = 0, hc = 0;
            for(int i = 0 ; i < s ; i++){
                if(vert.get(i).size() < s){
                    vc++;
                }
                if(hori.get(i).size() < s){
                    hc++;
                }
            }



            System.out.println("Case #"+cnt+": "+sum+" " + hc+ " " + vc);
        }
    }
}