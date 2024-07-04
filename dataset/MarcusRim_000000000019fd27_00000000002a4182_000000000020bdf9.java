import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int n = 1; n <= times; n++){
            int jobs = Integer.parseInt(br.readLine());
            String ans = "";
            int cend = 0;
            int jend = 0;

            int[][] arr = new int[jobs][2];
            int[][] tempArr = new int[jobs][2];
            String[] arrayarray = new String[jobs];

            for(int i = 0; i < jobs; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
           
            for(int i = 0; i < jobs; i++){
                for(int j = 0; j < 2; j++){
                    tempArr[i][j] = arr[i][j];
                }
            }
            sortie(arr);

            for(int i = 0; i < jobs; i++){
               
                int x = 0;
                for(int a = 0; a < jobs; a++){
                    if(tempArr[a][0] == arr[i][0] && tempArr[a][1] == arr[i][1]){
                        x = a;
                        tempArr[a][0] = Integer.MAX_VALUE;
                        break;
                    }
                }
               
                if(arr[i][0] >= cend && !ans.equals("IMPOSSIBLE")){
                    arrayarray[x] = "C";
                    cend = arr[i][1];
                }
                else if(arr[i][0] >= jend && !ans.equals("IMPOSSIBLE")){
                    arrayarray[x] = "J";
                    jend = arr[i][1];
                }
                else{
                    ans = "IMPOSSIBLE";
                }
            }
           
            if(!ans.equals("IMPOSSIBLE")){
                for(String s : arrayarray){
                    ans += s;
                }
            }
            pw.println("Case #" + n + ": " + ans);
        }
        pw.close();
    }

    public static void sortie(int arr[][])
    {
        Arrays.sort(arr, new Comparator<int[]>() {
           
          @Override              
          public int compare(final int[] one,  
                             final int[] two) {
 
            if (one[0] > two[0])
                return 1;
            else
                return -1;
          }
        }); 
    }
}
