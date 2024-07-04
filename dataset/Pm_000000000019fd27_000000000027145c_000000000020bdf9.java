import java.util.*;




public class Solution {
    

   static class Pair{
    int first;
    int second;
    
}

 static class MyComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return (a.first - b.first);
    }
}

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     int testCase = 1;
     while(t-->0){
         int n = sc.nextInt();
         int[] a = new int[n];
         int[] d = new int[n];
         Pair[] pairs = new Pair[n];
         for(int i=0;i<n;i++){
             a[i] = sc.nextInt();
             d[i] = sc.nextInt();
             pairs[i] = new Pair();
             pairs[i].first = a[i];
             pairs[i].second = d[i];
         }
        Arrays.sort(pairs, new MyComparator());
        
        StringBuilder sb = new StringBuilder();
        int cd = pairs[0].second;
        int jd = pairs[1].second;
        sb.append("C");
        sb.append("J");
        for(int i=2;i<n;i++){
            // if(pairs[i].second<pairs[i].first){
            //     break;
            // }
            if(pairs[i].first>=cd){
                sb.append("C");
                cd = pairs[i].second;
            }else if(pairs[i].first>=jd){
                sb.append("J");
                jd = pairs[i].second;
            }else{
                break;
            }
        }

        if(sb.toString().trim().length() !=n){
            System.out.println("Case #"+testCase+": "+"IMPOSSIBLE");
        }else{
           
            System.out.println("Case #"+testCase+": "+sb.toString().trim());
        }

         testCase++;
         
     }

    }
}