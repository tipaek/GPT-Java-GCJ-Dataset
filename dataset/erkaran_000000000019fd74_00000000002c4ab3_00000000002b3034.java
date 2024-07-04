import java.util.*;

public class Solution{
 
    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for(int o=1 ;o<=t;o++){
            int n = Integer.parseInt(sc.nextLine());
            String arr[] = new String[n];
            boolean fall = true;
            for(int i = 0; i<n;i++){
                arr[i] = sc.nextLine();
                if(arr[0].charAt(0) != '*'){
                    fall = false;
                }
            }
            Arrays.sort(arr,(String s1, String s2)->s2.length()-s1.length());
           if(fall){
            boolean flag = true;
            char last = arr[0].charAt(arr[0].length() -1);
            String sub = arr[0].substring(1,arr[0].length() );
            for(int i = 1; i<n;i++){
                if(last == arr[i].charAt(arr[i].length() -1)){
                    if(sub.indexOf(arr[i].substring(1,arr[i].length())) == -1){
                    flag = false;
                    break;
                }
                }
                else{
                    flag = false;
                    break;
                }
                
            }
            if(flag)
             System.out.println("Case #"+o+": "+sub);
            else 
             System.out.println("Case #"+o+": *");
           }else{
               boolean flag = true;
               char first = arr[0].charAt(0);
               if(first == '*'){
                   for(int i = 0; i<n;i++){
                       if(arr[i].charAt(0)!='*'){
                           first = arr[i].charAt(0);
                           break;
                       }
                   }
               }
               
               for(int i = 0; i<n;i++){
                   if(first != arr[i].charAt(0) || arr[i].charAt(0)!='*'){
                       
                   }
                   else{
                       flag = false;
                       break;
                   }
               }
               if(flag){
                   String r[] = new String[n];
                   String l[] = new String[n];
                   for(int i = 0; i<n;i++){
                       String[] temp = arr[i].split("\\*");
                        if(temp.length==1){
                                if(arr[i].charAt(0) == '*'){
                                    l[i]=temp[0];
                                    r[i]="*";
                                }else{
                                     r[i]=temp[0];
                                    l[i]="*";
                                }
                        }else{
                            l[i]=temp[1];
                            r[i]=temp[0];
                        }
                    }
                    String right = helperss(r);
                    String left = "";
                    if(right.length()==0)
                       System.out.println("Case #"+o+": *");
                    else left = helperss(l);
                    if(left.length()==0)
                       System.out.println("Case #"+o+": *");
                    else System.out.println("Case #"+o+": "+right+left);
                    
               }else 
             System.out.println("Case #"+o+": *");
           }
        }
    }
    
    public static String helperss(String[] arr){
         Arrays.sort(arr,(String s1, String s2)->s2.length()-s1.length());
          
        boolean flag = true;
            char last = arr[0].charAt(arr[0].length() -1);
            String sub = arr[0];
            for(int i = 1; i<arr.length;i++){
                if(arr[i].length()>1){
                    if(sub.indexOf(arr[i]) == -1){
                    return "";
                    }
                }
            }
            return arr[0];
    }

}