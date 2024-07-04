import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int j=0; j<n; j++){
                int s = in.nextInt();
                int e = in.nextInt();
                int[] activ = new int[3];
                activ[0]=s;
                activ[1]=e;
                activ[2]=j;
                activities.add(activ);
            }
            Collections.sort(activities, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            int horafinC=0;
            int horafinJ=0;
            char[] result=new char[n];
            boolean imposible=false;
            int k=0;
            while(k<activities.size() && !imposible){
                int[]activ= activities.get(k);
                if(horafinC<=activ[0]){
                    horafinC=activ[1];
                    result[activ[2]]='C';
                }else if(horafinJ<=activ[0]){
                    horafinJ=activ[1];
                    result[activ[2]]='J';
                }else{
                    imposible=true;
                }
                k=k+1;
            }
            System.out.println("Case #" + i + ": " + (imposible?"IMPOSSIBLE":new String(result)));
        }
    }

    private static String repeat(String s, int number){
        String result="";
        for(int j=0; j<number; j++){
            result=result+s;
        }
        return result;
    }

}


