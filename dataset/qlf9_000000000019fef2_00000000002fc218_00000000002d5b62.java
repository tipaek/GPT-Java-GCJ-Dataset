import java.util.*;
import java.io.*;

public class Solution {
    public static int LOGMAX = 40;
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int tt = Integer.parseInt(f.readLine());
        int t = tt;
        while(t --> 0){
            StringTokenizer st = new StringTokenizer(f.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(((a%2)+2)%2 == ((b%2)+2)%2){
                out.println("Case #" + (tt-t) + ": IMPOSSIBLE");
            }else{
                int[] arr1 = new int[LOGMAX];
                int[] arr2 = new int[LOGMAX];
                Arrays.fill(arr1, Integer.MAX_VALUE);
                Arrays.fill(arr2, Integer.MAX_VALUE);
                boolean switched = false;
                boolean aneg = false;
                boolean bneg = false;
                if(a < 0){
                    a = -a;
                    aneg = true;
                }
                if(b < 0){
                    b = -b;
                    bneg = true;
                }
                if(b < a){
                    long q = b;
                    b = a;
                    a = q;
                    switched = true;
                    boolean temp = aneg;
                    aneg = bneg;
                    bneg = temp;
                }
                long temp = a;
                int count = 0;
                while(temp != 0){
                    if(temp % 2 == 0){
                        arr1[count] = 0;
                    }else{
                        arr1[count] = 1;
                    }
                    count++;
                    temp/=2;
                }
                temp = b;
                count = 0;
                while(temp != 0){
                    if(temp % 2 == 0){
                        arr2[count] = 0;
                    }else{
                        arr2[count] = 1;
                    }
                    count++;
                    temp/=2;
                }
                boolean done = false;
                for(int i = 0; i < LOGMAX; i++){
                    if(arr1[i] == arr2[i] && arr1[i] != Integer.MAX_VALUE){
                        if(i == 0 || arr1[i] == 0){
                            out.println("Case #" + (tt-t) + ": IMPOSSIBLE");
                            done = true;
                            break;
                        }else{
                            if(i != LOGMAX-1 && arr2[i+1] == 0 || arr2[i+1] == Integer.MAX_VALUE){
                                arr2[i-1] = -1;
                                arr2[i] = 0;
                                arr2[i+1] = 1;
                            }
                        }
                    }
                }
                if(done) continue;
                StringBuilder ans = new StringBuilder();
                for(int i = 0; i < LOGMAX; i++){
                    if(arr1[i] == 0 || (arr1[i] == Integer.MAX_VALUE && arr2[i] != Integer.MAX_VALUE)){
                        if(arr2[i] == -1 && !switched && !bneg) {
                            ans.append('S');
                        }else if(arr2[i] == -1 && !switched && bneg){
                            ans.append('N');
                        }else if(arr2[i] == 1 && !switched && !bneg) {
                            ans.append('N');
                        }else if(arr2[i] == 1 && !switched && bneg){
                            ans.append('S');
                        }else if(arr2[i] == -1 && switched && !bneg){
                            ans.append('W');
                        }else if(arr2[i] == -1 && switched && bneg){
                            ans.append('E');
                        }else if(arr2[i] == 1 && switched && !bneg){
                            ans.append('E');
                        }else{
                            ans.append('W');
                        }
                    }
                    if(arr2[i] == 0 || (arr2[i] == Integer.MAX_VALUE && arr1[i] != Integer.MAX_VALUE)){
                        if(!switched && !aneg){
                            ans.append('E');
                        }else if(!switched && aneg){
                            ans.append('W');
                        }else if(switched && !aneg){
                            ans.append('N');
                        }else{
                            ans.append('S');
                        }
                    }
                }
                out.println("Case #" + (tt-t) + ": " + ans.toString());
            }
        }



        out.close();
    }
}
