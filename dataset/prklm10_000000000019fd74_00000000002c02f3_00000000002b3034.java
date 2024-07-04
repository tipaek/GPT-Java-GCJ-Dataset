
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
            if(arr[index].length()<arr[i].length())
                index=i;
        }
        System.out.println(index);
        String[] a;
        a = arr[index].split("\\*");
        longest=a[1];
         System.out.println(longest);
        int flag=0;
        for(int i=0;i<arr.length;i++) {
            if (index != i) {
                String[] b = arr[i].split("\\*");
                String g;
                String h;
                if(b[1]!=null){
                    g=b[1];
                    h=b[0];
                }
                else{
                    g=b[1];
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < g.length(); j++) {
                    sb.append(longest.charAt((longest.length() - g.length()) + j));
                }
                // sb.reverse();
                //System.out.println(sb);
                if (!sb.toString().equals(g)) {
                    flag = 1;
                    break;
                }

            }
        }
        if(flag==0)
            return longest;
        else
            return "*";
    }
}