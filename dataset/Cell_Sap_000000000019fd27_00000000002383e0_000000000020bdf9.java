import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int m = 1;m <= t;m++){
            int n = sc.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            Map<String,String> tempMap = new LinkedHashMap<String,String>();
            for(int j = 0;j < n;j++){
                    start[j] = sc.nextInt();
                    end[j] = sc.nextInt();
                    tempMap.put(start[j]+" "+end[j],"");
            }
            for(int i = 0;i<n-1;i++){
                for(int j=0;j<n-1-i;j++){
                    if(start[j] >start[j+1]){
                        int temp = start[j];
                        start[j] = start[j+1];
                        start[j+1] = temp;
                        temp = end[j];
                        end[j] = end[j+1];
                        end[j+1]= temp;
                    }
                }
            }
            
            int c,j;
            c = end[0];
            tempMap.put(start[0]+" "+end[0],"C");
            j = end[1];
            tempMap.put(start[1]+" "+end[1],"J");
            String res = "";
            for(int k = 2;k < n;k++){
                if(c <= start[k]){
                    c = end[k];
                    tempMap.put(start[k]+" "+end[k],"C");
                }
                 else if(j<=start[k]){
                    j = end[k];
                    tempMap.put(start[k]+" "+end[k],"J");
                }
                else{
                    res = "IMPOSSIBLE";
                    break;
                }
            }
            if(!res.equalsIgnoreCase("IMPOSSIBLE")){
                for(Map.Entry<String,String> map : tempMap.entrySet()){
                    res = res + map.getValue();
                }
            }
                System.out.println("Case #" + m +": " + res);
        }
    }

}