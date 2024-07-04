  import java.io.*;
import java.util.*;
public class Solution{

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=  Integer.parseInt(br.readLine());
        int cs=1;
        while(t--){
                //take input
                
                
            int a[] = new int[26];
            int ull = Integer.parseInt(br.readLine());
            Arrays.fill(a,-1);

            for(int i =0;i<10000;i++){
                String input[] = br.readLine().split(" ");
                int val = Integer.parseInt(input[0]);
                String encode = input[1];
                for(int l=0;l<encode.length();l++){
                    char c = encode.charAt(l);
                    int index = indexx(c);
                    if(a[index]>val||a[index]==-1){
                        a[index]=val;
                    }
                }
            }
            for(int i=0;i<26;i++){
                if(a[i]>-1){

                    a[i]%=10;
                }
            }
            char[] rest = new char[10];
            for(int i =0;i<26;i++){
                if(a[i]>-1){
                    rest[a[i]]=(char)(i+'A');
                }
            }
            //output
            System.out.println("Case #"+(cs)+": "+String.valueOf(rest));
            cs++;
        }

    }

    static int indexx(char ch){
        return ch-'A';
    }
}