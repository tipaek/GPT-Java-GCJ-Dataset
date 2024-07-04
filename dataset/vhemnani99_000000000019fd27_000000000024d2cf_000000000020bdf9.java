import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Solution{

    public static void main(String[] args) throws IOException {
        System.out.println("");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t =Integer.parseInt(br.readLine());
        test:for(int t1=1 ; t1<=t ; t1++) {
            int n = Integer.parseInt(br.readLine());
            String st[]=new String[n];

            int[][] arr = new int[n][4];
            for(int i=0 ; i<n ; i++) {
                String[] input =br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(input[0]);
                arr[i][1] = Integer.parseInt(input[1]);
                arr[i][2] = i;
            }

            Arrays.sort(arr, new Comparator<int[]>(){

                    public int compare(int a1[], int a2[]) {
                        if(a1[0]>a2[0])
                            return 1;
                        else
                            return -1;
                    }});

            int cameron = 0;
            int jamie = 0;
            StringBuilder sb = new StringBuilder();

            for(int i=0 ; i<n ; i++) {
                int from = arr[i][0];
                int to = arr[i][1];

                if(cameron<=from) {
                    arr[i][3] = 0;
                    cameron = to;
                }
                else {
                    if(jamie<=from) {
                        arr[i][3] = 1;
                        jamie = to;
                    }
                    else {
                        bw.write("Case #"+t1+": "+"IMPOSSIBLE"+"\n");
                        continue test;
                    }
                }
            }  
            Arrays.sort(arr, new Comparator<int[]>(){
                    public int compare(int a1[], int a2[]) {
                        if(a1[0]>a2[0])
                            return 1;
                        else
                            return -1;
                    }});

            for(int i=0 ; i<arr.length ; i++) {
                if(arr[i][3]==0) sb.append('C');
                else sb.append('J');
            }

            bw.write("Case #"+t1+": "+sb.toString()+"\n");
        }

        bw.flush();
    }
}