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
                        continue;
                  }
                  int n = Integer.parseInt(str.substring(i,i+1));
                  findAndSet(n,ans);

            }
            System.out.println("Case #"+(c+1) + ": " + ans.toString());
            c++;
        }
    }
    static void findAndSet(int n, StringBuffer str){
       
          int count = 0;
          int i = str.length()-1;
          for(i = str.length()-1;i>=0 && count < n;i--){
                char ch = str.charAt(i);
                if(ch == ')'){
                      count++;
                }else if(ch == n){
                      break;
                }else{
                        break;
                }
            }
            if(count == n){
                  str.insert(i+1, n);
            }else{
                  String formnew = "";
                  for(int k = 0;k<n-count;k++){
                        formnew += "(";
                  }
                  formnew += ""+n;
                  for(int k = 0;k<n-count;k++){
                        formnew += ")";
                  }

                  str.insert(i+1, formnew);
            }
    }

}