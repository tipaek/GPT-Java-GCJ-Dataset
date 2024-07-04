import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for(int i = 1 ; i <= t ; i++){
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<Integer[]> arr = new ArrayList<>();
            for(int cnt = 0 ; cnt < n ; cnt++){
                Integer[] tmp = new Integer[2];
                StringTokenizer st = new StringTokenizer(sc.nextLine());

                tmp[0] = Integer.parseInt(st.nextToken());
                tmp[1] = Integer.parseInt(st.nextToken());

                arr.add(tmp);
            }

            // arr.sort((a,b) -> a[0] - b[0]);
            System.out.println("Case #"+i+": "+find(arr, n));
        }
    }

    static String find(ArrayList<Integer[]> arr, int n){
        String[] ans = new String[n];

        HashSet<Integer[]> c = new HashSet<>(), j = new HashSet<>();

        for(int l = 0 ; l < n ; l++){
            boolean tfc = false, tfj = false;
            int tx = arr.get(l)[0], ty = arr.get(l)[1];
            for(Integer[] x : c){
                int px = x[0], py = x[1];
                if((tx <= px && px < ty) || (px <= tx && tx < py)){
                    tfc = true;
                    break;
                }
            }

            if(tfc){
                for(Integer[] x : j){
                    int px = x[0], py = x[1];
                    if((tx <= px && px < ty) || (px <= tx && tx < py)){
                        tfj = true;
                        break;
                    }
                }

                if(tfj){
                    return "IMPOSSIBLE";
                }
                else{
                    ans[l] = "J";
                    j.add(arr.get(l));
                }
            }
            else{
                ans[l] = "C";
                c.add(arr.get(l));
            }
        }
        
        String strBuild = "";
        for(String x : ans){
            strBuild += x;
        }
        return strBuild;
    }
}