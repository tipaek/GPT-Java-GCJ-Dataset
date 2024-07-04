import java.util.*;

class Interval 
{ 
    int start,end, ind; 
      
    Interval(int start, int end, int ind) 
    { 
        this.start=start; 
        this.end=end;
        this.ind = ind;
    } 
} 

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int tc =1; tc <= t; tc++) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            
            Interval[] arr = new Interval[n];
            
            for(int i = 0; i < n; i++) {
            	int s = sc.nextInt();
            	int e = sc.nextInt();
            	arr[i] = new Interval(s,e,i);
            }
            char[] ans = new char[n];
            
            Arrays.sort(arr,new Comparator<Interval>(){ 
                public int compare(Interval i1,Interval i2) 
                { 
                    return i1.start - i2.start; 
                } 
            });
            
            int cet = -1, jet = -1;
            boolean f = false;
            for(int i = 0; i < n; i++) {
            	int s = arr[i].start;
            	int e = arr[i].end;
            	int index = arr[i].ind;
            	//System.out.println("start end :" + s + " " + e);
            	if(!f && s >= cet) {
            		ans[index] = 'C';
            		cet = e;
            	} else if(!f && s >= jet) {
            		ans[index] = 'J';
            		jet = e;
            	} else {
            		f = true;
            	}
            		
            }
            
            String res = "";
            if(f) res = "IMPOSSIBLE";
            else res = new String(ans);
            
            System.out.println("Case #" + tc + ": " + res);
        }
    }
}


