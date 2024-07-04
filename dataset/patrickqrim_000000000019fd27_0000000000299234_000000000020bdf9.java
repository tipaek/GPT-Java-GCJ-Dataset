import java.io.*;
import java.util.*;
/**
 * Write a description of class Snail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Solution
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int nn = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int n = 1; n <= nn; n++){
            int N = Integer.parseInt(br.readLine());
            String result = "";
            int cEndTime = 0;
            int jEndTime = 0;
            boolean bool = true;

            int[][] arr = new int[N][2];
            int[][] temp = new int[N][2];
            String[] strarray = new String[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < 2; j++){
                    temp[i][j] = arr[i][j];
                }
            }
            sortbyColumn(arr);

            for(int i = 0; i < N; i++){
                
                int x = 0;
                for(int a = 0; a < N; a++){
                    if(temp[a][0] == arr[i][0] && temp[a][1] == arr[i][1]){
                        x = a;
                        break;
                    }
                }
                
                System.out.println(x);
                
                if(arr[i][0] >= cEndTime && !result.equals("IMPOSSIBLE")){
                    strarray[x] = "C";
                    cEndTime = arr[i][1];
                }
                else if(arr[i][0] >= jEndTime && !result.equals("IMPOSSIBLE")){
                    strarray[x] = "J";
                    jEndTime = arr[i][1];
                }
                else{
                    result = "IMPOSSIBLE";
                }
            }
            
            if(!result.equals("IMPOSSIBLE")){
                for(String s : strarray){
                    result += s;
                }
            }
            out.println("Case #" + n + ": " + result);
        }
        out.close();
    }

    public static void sortbyColumn(int arr[][]) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
                @Override
                public int compare(final int[] entry1, final int[] entry2) {
                    if(entry1[0] == entry2[0]){
                        return entry2[1] - entry1[1];
                    }
                    return entry1[0] - entry2[0];
                }
            });  
    } 
}
