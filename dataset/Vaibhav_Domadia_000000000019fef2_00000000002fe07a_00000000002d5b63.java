import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while(t-->0) {
                outer: for(int i=-5 ; i<=5 ; i++) {
                    for(int j=-5 ; j<=5 ; j++) {
                        System.out.println(i + " " + j);
                        String response = br.readLine();
                        if(response.equals("CENTER")) {
                            break outer;
                        }
                        else if(response.equals("WRONG")) {
                            return;
                        }
                    }
                }

                /*for(int i=0 ; i<300 ; i++) {
                    int x = 0;
                    int y = 0;
                    System.out.println(x + " " + y);
                    String response = br.readLine();
                    if(response.equals("CENTER")) {
                        break;
                    }
                    else if(response.equals("HIT")) {

                    }
                    else if(response.equals("MISS")) {

                    }
                    else if(response.equals("WRONG")) {
                        return;
                    }
                }*/
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
