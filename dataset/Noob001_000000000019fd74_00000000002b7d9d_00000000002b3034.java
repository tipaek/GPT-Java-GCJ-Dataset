import java.util.*;
import java.util.Comparator;
class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++){
            int n=sc.nextInt();
            String[] strs=new String[n];
            for (int i=0;i<n;i++){
                strs[i]=sc.next();
            }
            String[] pre=new String[n];
            String[] post=new String[n];
            int[][] start_end=new int[n][2];
            for (int i=0;i<n;i++){
                String s=strs[i];
                int ptr=0;
                String ans="";
                while(s.charAt(ptr)!='*'){
                    ans+=s.charAt(ptr);
                    ptr++;
                }
                start_end[i][0]=ptr;
                pre[i]=ans;

                ptr=s.length()-1;
                ans="";
                while(s.charAt(ptr)!='*'){
                    ans=s.charAt(ptr)+ans;
                    ptr--;
                }
                post[i]=ans;
                start_end[i][1]=ptr;
            }
            String front=func(pre);
            String back=func(post);
            if(front=="!" || back=="!"){
                System.out.println("*");
            }else{
                //System.out.println(back);
                String mid="";
                for (int i=0;i<n;i++){
                    String s=strs[i];
                    int ptr=start_end[i][0]+1;
                    while(ptr<start_end[i][1]){
                        if(s.charAt(ptr)!='*'){
                            mid+=s.charAt(ptr);
                        }
                        ptr++;
                    }



                }
                System.out.println(front+mid+back);
            }

        }

    }



    public static String func(String[] arr){
        String ans=arr[0];
        for(int i=1;i<arr.length;i++){
            String s=arr[i];
//            System.out.println(ans);
//            System.out.println(s);
            if(s!=""){
                if( is_sub(ans,s) ){
                    ans=ans;
                }
                else if(is_sub(s,ans)){
                    ans=s;
                }else{
                    ans="!";
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean is_sub(String s1,String s2){
        boolean isFound = s1.indexOf(s2) !=-1? true: false;
        return isFound;
    }
}

