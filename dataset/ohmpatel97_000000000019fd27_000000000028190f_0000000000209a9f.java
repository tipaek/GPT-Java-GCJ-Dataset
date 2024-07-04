import java.util.*;

class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int c = 0;
        while(c < t){
            String str = s.next();
            StringBuffer ans = new StringBuffer();
            int lastindex = 0;
            for(int i = 0;i<str.length();i++){
                  if(str.charAt(i) == '0'){
                        ans.append((""+str.charAt(i)));
                        lastindex = ans.length() - 0 - 1;
                        continue;
                  }
                  if(i == 0){
                        int n = Integer.parseInt(str.substring(i,i+1));
                        int j = 1;
                        while(j <= n){
                              ans.append("(");
                              j++;
                        }
                        ans.append(""+n);
                        j = 1;
                        while(j <= n){
                              ans.append(")");
                              j++;
                        }
                        lastindex = ans.length() - n - 1;
                  }else if(str.charAt(i) != str.charAt(i-1)){
                        int n = Integer.parseInt(str.substring(i,i+1));
                        int j = 1;
                        while(j <= n){
                              ans.append("(");
                              j++;
                        }
                        ans.append((""+n));
                        j = 1;
                        while(j <= n){
                              ans.append(")");
                              j++;
                        }
                        lastindex = ans.length() - n - 1;
                  }else{
                        ans.insert(lastindex,str.charAt(i));
                  }
            }
            System.out.println("Case #"+(c+1) + ": " + ans.toString());
            c++;
        }
    }

}