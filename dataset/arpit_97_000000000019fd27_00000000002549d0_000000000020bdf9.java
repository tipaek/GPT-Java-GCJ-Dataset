import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int t=1;t<=test_case;t++){
            int n = Integer.parseInt(br.readLine());
            Triplet arr[] = new Triplet[n];
            for(int i=0;i<n;i++){
                String str[] = br.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                arr[i] = new Triplet(start, end, i);
            }
            char ans[] = new char[n];
            Arrays.sort(arr, new Comparator<Triplet>(){
                public int compare(Triplet t1, Triplet t2){
                    return t1.start-t2.start;
                }
            });
            int end_j = 0, end_c = 0;
            boolean flag = true;
            for(int i=0;i<n;i++){
                Triplet triplet = arr[i];
                if(i == 0){
                    end_j = triplet.end;
                    ans[triplet.index] = 'J';
                    continue;
                }
                if(end_j<=triplet.start){
                    end_j = triplet.end;
                    ans[triplet.index] = 'J';
                }
                else if(end_c<=triplet.start){
                    end_c = triplet.end;
                    ans[triplet.index] = 'C';
                }
                else{
                    flag = false;
                    break;
                } 
            }
            if(!flag){
                System.out.println("Case #"+t+": IMPOSSIBLE");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(ans[i]);
            }
            System.out.println("Case #"+t+": "+sb);
        }
    }
    
    static class Triplet{
        int start, end, index;
        Triplet(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
    }
    
}