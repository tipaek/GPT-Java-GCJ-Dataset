import java.io.*;
import java.util.StringTokenizer;

public class Solution{
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = stoi(st.nextToken());
        int A = stoi(st.nextToken());
        int B = stoi(st.nextToken());

        for(int i = 1; i <= T; i++){
            int x = -1000000000 + A;
            int y = -1000000000 + A;

            bw.write(String.format("%d %d",x,y));
            bw.flush();

            String output = br.readLine();
            while(output.equals("MISS")){
                x += A;
                if(x > 1000000000){
                    x = -1000000000+A;
                    y += A;
                }
                if(y > 1000000000){
                    break;
                }
                bw.write(String.format("%d %d",x,y));
                bw.flush();
                output = br.readLine();
            } // find first hit

            if(output.equals("CENTER")){
                continue;
            }
            if(output.equals("WRONG") || output.equals("MISS")){
                break;
            } //catch error

            int low = -1000000000;
            int high = x;
            int mid = (low +high) >> 1;
            while(low <= high){
                bw.write(String.format("%d %d",mid,y));
                bw.flush();
                output= br.readLine();
                if(output.equals("MISS")){
                    low = mid + 1;
                } else if(output.equals("HIT")) {
                    high = mid -1;
                } else {
                    break;
                }

            }
            //binary search for left bound
            if(output.equals("CENTER")){
                continue;
            }
            if(output.equals("WRONG")){
                break;
            } // catch error
            int xL =low;

            low = x;
            high = 1000000000;
            mid = (low +high) >> 1;
            while(low <= high){
                bw.write(String.format("%d %d",mid,y));
                bw.flush();
                output= br.readLine();
                if(output.equals("MISS")){
                    high = mid - 1;
                } else if(output.equals("HIT")) {
                    low = mid + 1;
                } else {
                    break;
                }

            }
            //binary search for right bound
            if(output.equals("CENTER")){
                continue;
            }
            if(output.equals("WRONG")){
                break;
            } // catch error
            int xR = low;



            low = -1000000000;
            high = y;
            mid = (low +high) >> 1;
            while(low <= high){
                bw.write(String.format("%d %d",x,mid));
                bw.flush();
                output= br.readLine();
                if(output.equals("MISS")){
                    low = mid + 1;
                } else if(output.equals("HIT")) {
                    high = mid -1;
                } else {
                    break;
                }

            }
            //binary search for lower bound
            if(output.equals("CENTER")){
                continue;
            }
            if(output.equals("WRONG")){
                break;
            } // catch error
            int yL = low;


            low = y;
            high = 1000000000;
            mid = (low +high) >> 1;
            while(low <= high){
                bw.write(String.format("%d %d",x,mid));
                bw.flush();
                output= br.readLine();
                if(output.equals("MISS")){
                    high = mid - 1;
                } else if(output.equals("HIT")) {
                    low = mid + 1;
                } else {
                    break;
                }

            }
            //binary search for upper bound
            if(output.equals("CENTER")){
                continue;
            }
            if(output.equals("WRONG")){
                break;
            } // catch error
            int yU = low;

            bw.write(String.format("%d %d",(xL+xR)/2,(yL+yU)/2));
            output = br.readLine();
            if(output.equals("CENTER")){
                continue;
            } else {
                break;
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
