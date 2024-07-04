import java.io.*;
public class Solution {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int N, j;
        char c;
        char[] list;
        boolean check;
        String P, tmp;
        for(int t = 1; t <= tc; t++){
            list = new char[100];
            N = Integer.parseInt(br.readLine());
            check = true;
            for(int i = 0; i < N; i++){
                P = br.readLine();
                for(j = 0; j < P.length() && (c = P.charAt(j))!='*'; j++){
                    if(list[j] == 0){list[j] = c; continue;}
                    if(c != list[j]){
                        i = N;
                        System.out.println("Case #"+t+": *");
                        check = false;
                        break;
                    }
                }
                for(j = 1; j <= P.length() && (c = P.charAt(P.length() - j))!='*'; j++){
                    if(list[100 - j] == 0){list[100 - j] = c; continue;}

                    if(c != list[100 - j]){
                        i = N;
                        System.out.println("Case #"+t+": *");
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                P = "";
                for(j = 0; j < 100 && list[j]!=0; j++)P = P + list[j];
                tmp = "";
                for(j = 0; j < 100 && list[99-j]!=0; j++)tmp = list[99-j]+tmp;
                System.out.println("Case #"+t+": "+P+tmp);
            }
            
        }
        br.close();
    }

}