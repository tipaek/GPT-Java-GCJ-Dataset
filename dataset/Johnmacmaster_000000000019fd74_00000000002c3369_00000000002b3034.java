
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            String[] arr=new  String[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j]=br.readLine();
            }
            Set<String> set=new HashSet<>();
            String temp=arr[0];
            for (int j = 0; j < arr.length; j++) {
                if(Pattern.matches(temp,arr[j])){
                    temp=arr[j];
                }
                else if(Pattern.matches(arr[j],temp)){
                    temp=arr[j];
                }
            }
            System.out.println("Case #"+(i+1)+": "+temp);
        }
    }
}