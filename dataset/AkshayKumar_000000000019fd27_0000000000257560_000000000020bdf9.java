import java.util.*;



class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n=sc.nextInt();
            Pair[] times=new Pair[n];
            for (int i = 0; i < n; i++) {
                times[i]=new Pair(sc.nextInt(),sc.nextInt(),i);
            }
            Compare.compare(times, n);
            char result[]=new char[n];
            result[times[0].index]='C';
            int current_max_C=times[0].y;
            int current_max_J=0;
            boolean mark=false;
            
            for (int i = 1; i < times.length; i++) {
                // System.out.println(times[i].x+" "+times[i].y+" "+times[i].index);
                if(current_max_C<=times[i].x){
                result[times[i].index]='C';
                current_max_C=times[i].y;
            }
                else if(current_max_J<=times[i].x){
                result[times[i].index]='J';
                current_max_J=times[i].y;
            }
                else
                mark=true;
            }

            if(mark)
            System.out.println("Case #"+k+": IMPOSSIBLE");
            else
            System.out.println("Case #"+k+": "+String.copyValueOf(result));
        }

    }
}

// User defined Pair class 
class Pair { 
    int x; 
    int y; 
    int index;
    // Constructor 
public Pair(int x, int y,int index) 
    { 
        this.x = x; 
        this.y = y; 
        this.index=index;
    } 
} 
  
// class to define user defined conparator 
class Compare { 
  
    static void compare(Pair arr[], int n) 
    { 
        // Comparator to sort the pair according to second element 
        Arrays.sort(arr, new Comparator<Pair>() { 
            @Override public int compare(Pair p1, Pair p2) 
            { 
                return p1.x - p2.x; 
            } 
        }); 
  
        // for (int i = 0; i < n; i++) { 
        //     System.out.print(arr[i].x + " " + arr[i].y + " "); 
        //     System.out.println();
        // } 
        
    } 
} 