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

            String lpad = newfind(0, n, new String[n], arr, new ArrayList<Integer[]>(), new ArrayList<Integer[]>());
            System.out.println("Case #"+i+": "+lpad);
        }
    }

    public static String newfind(int index, int n, String[] ans, ArrayList<Integer[]> arr, ArrayList<Integer[]> c, ArrayList<Integer[]> j){
        if(index == n){
            String strBuild = "";
            for(String x : ans){
                strBuild += x;
            }
            return strBuild; 
        }

        boolean tfc = false, tfj = false;
        int tx = arr.get(index)[0], ty = arr.get(index)[1];
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
                ans[index] = "J";
                j.add(arr.get(index));

                return newfind(index + 1, n, ans, arr, c, j);
            }
        }
        else{
            ArrayList<Integer[]> cc = new ArrayList<>(), cj = new ArrayList<>();
            for(Integer[] cm : c){
                cc.add(cm);
            }
            for(Integer[] jm : j){
                cj.add(jm);
            }

            ans[index] = "C";
            c.add(arr.get(index));
            String f = newfind(index + 1, n, ans, arr, c, j);

            if(f == "IMPOSSIBLE"){
                for(Integer[] x : cj){
                    int px = x[0], py = x[1];
                    if((tx <= px && px < ty) || (px <= tx && tx < py)){
                        return "IMPOSSIBLE";
                    }
                }

                ans[index] = "J";
                cj.add(arr.get(index));
                return newfind(index + 1, n, ans, arr, cc, cj);
            }
            else{
                return f;
            }
        }
    }
}