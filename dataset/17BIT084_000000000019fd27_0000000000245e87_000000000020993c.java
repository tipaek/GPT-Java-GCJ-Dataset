import java.util.*;
public class Solution{
     
public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for(int p=1;p<=t;p++){
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        int r=0,c=0,d=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.clear();
            boolean b = false;
            for(int j=0;j<n;j++){
                int temp = sc.nextInt();
                a[i][j] = temp;
                if(set.contains(temp)){
                    b = true;
                }else{
                    set.add(temp);
                }
                if(i==j){
                    d+=temp;
                }
            }
            if(b){
                r++;
            }
        }
        for(int i=0;i<n;i++){
            set.clear();
            boolean b = false;
            for(int j=0;j<n;j++){
                if(set.contains(a[j][i])){
                    b = true;
                }else{
                    set.add(a[j][i]);
                }
            }
            if(b){
                c++;
            }
        }
        System.out.println("Case #"+p+": "+d+" "+r+" "+c);
    }
	}
}