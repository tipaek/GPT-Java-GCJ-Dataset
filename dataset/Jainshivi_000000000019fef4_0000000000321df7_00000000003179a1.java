import java.io.*;
import java.util.*;
public class Solution{

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=  Integer.parseInt(br.readLine());
        for(int k =0;k<t;k++){
            int arr[] = new int[26];
            int u = Integer.parseInt(br.readLine());
            Arrays.fill(arr,-1);

            for(int i =0;i<10000;i++){
                String input[] = br.readLine().split(" ");
                int val = Integer.parseInt(input[0]);
                String encode = input[1];
                for(int l=0;l<encode.length();l++){
                    char c = encode.charAt(l);
                    int index = indexx(c);
                    if(arr[index]>val||arr[index]==-1){
                        arr[index]=val;
                    }
                }
            }
            for(int i=0;i<26;i++){
                if(arr[i]>-1){

                    arr[i]%=10;
                 //   System.out.print((char)(i+'A')+ " "+arr[i]+" ,");

                }
            }
            char[] res = new char[10];
            for(int i =0;i<26;i++){
                if(arr[i]>-1){
                    res[arr[i]]=(char)(i+'A');
                }
            }
            System.out.println("Case #"+(k+1)+": "+String.valueOf(res));


        }

    }

    static int indexx(char ch){
        return ch-'A';
    }
}