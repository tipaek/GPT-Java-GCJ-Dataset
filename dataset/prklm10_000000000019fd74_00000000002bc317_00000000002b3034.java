
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int o=1;o<=t;o++){
            int N=Integer.parseInt(br.readLine());
            String[] arr =new String[N];
            for(int i=0;i<N;i++){
                arr[i]=br.readLine();
            }
            String ans =pattern(arr);
            String sol="Case #"+o+": "+ans;
            System.out.println(sol);
        }
    }
    static String pattern(String[] arr){
        String longest="";
        int index=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i].length()>arr[i-1].length())
                index=i;
        }
        String[] a;
        a = arr[index].split("\\*");
        longest=a[1];
       // System.out.println(longest);
        int flag=0;
        for(int i=0;i<arr.length;i++) {
            String[] b = arr[i].split("\\*");
            String g = b[1];
            String sb="";
            if(!longest.contains(g)){
                flag=1;
                break;
            }
            for(int j=0;j<g.length();j++){
                sb+=longest.charAt((longest.length()-g.length())+j);
            }
           // sb.reverse();
            //System.out.println(sb);
            if(!sb.equals(g)){
                flag=1;
                break;
            }

        }
        if(flag==0)
            return longest;
        else
            return "*";
    }
}