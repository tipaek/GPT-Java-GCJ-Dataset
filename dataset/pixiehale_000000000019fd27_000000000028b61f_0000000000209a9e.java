import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int t = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        for (int i = 0; i < t; i++) {
            int t1Ind = -1;
            int t2Ind = -1;
            int a[] = new int[b];
            boolean t1Inv = false;
            boolean t2Inv = false;
            int ind= 0;
            for (int j = 0; j < 150&&ind<b/2; ) {
                if(j%10==0){
                    if (t1Ind>=0){
                        System.out.println(t1Ind+1);
                        int t1 = Integer.parseInt(br.readLine());
                        if(t1==a[t1Ind]){
                            t1Inv = false;
                        } else {
                            t1Inv = true;
                        }
                        j++;
                    }
                    if (t2Ind>=0){
                        System.out.println(t2Ind+1);
                        int t2 = Integer.parseInt(br.readLine());
                        if(t2==a[t2Ind]){
                            t2Inv = false;
                        } else {
                            t2Inv = true;
                        }
                        j++;
                    }
                    if (j%2==1){
                        System.out.println(1);
                        br.readLine();
                        j++;
                    }

                }
                System.out.println(ind+1);
                int bit = Integer.parseInt(br.readLine());
                System.out.println(b-ind);
                int bitFromEnd = Integer.parseInt(br.readLine());
                if (bit==bitFromEnd){
                    if (t1Inv) {
                        a[ind] = 1 - bit;
                        a[b-ind-1] = 1-bitFromEnd;
                    } else {
                        a[ind] = bit;
                        a[b-ind-1] = bitFromEnd;
                    }
                    if (t1Ind==-1)
                        t1Ind=ind;
                } else {
                    if (t2Inv) {
                        a[ind] = 1 - bit;
                        a[b-ind-1] = 1-bitFromEnd;
                    } else {
                        a[ind] = bit;
                        a[b-ind-1] = bitFromEnd;
                    }
                    if (t2Ind==-1)
                        t2Ind=ind;
                }
                j+=2;
                ind++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < b; j++) {
                if (a[j]==a[b-j-1]){
                    if (t1Inv)
                        sb.append(1-a[j]);
                    else
                        sb.append(a[j]);
                }else{
                    if (t2Inv)
                        sb.append(1-a[j]);
                    else
                        sb.append(a[j]);
                }
            }
            System.out.println(sb);
            if (br.readLine().equals("N"))
                break;
        }
    }
}
