
    import java.util.*;
    import java.io.*;

    import static java.lang.Math.*;

    public class Solution {
        public static class Key {

        private final int x;
        private final int y;

        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }
            public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            PrintWriter w = new PrintWriter(System.out);
            int t=sc.nextInt();
            for(int x=1;x<=t;x++){
                int n=sc.nextInt();
                Integer arr[][]=new Integer[n][2];
                Integer ans[][]=new Integer[n][2];
                for(int i=0;i<n;i++){
                    arr[i][0]=sc.nextInt();
                    arr[i][1]=sc.nextInt();
                    ans[i][0]=arr[i][0];ans[i][1]=arr[i][1];
                }
                Arrays.sort(arr,Comparator.comparing((Integer a[])->a[0]));
                Map<Key,Character> map=new HashMap<>();
                int c=0,j=0;
                boolean f=false;
                for(int i=0;i<n;i++){
                    if(c<=arr[i][0]){
                        c=arr[i][1];
                        map.put(new Key(arr[i][0],arr[i][1]),'C');
                    }
                    else if(j<=arr[i][0]){
                        j=arr[i][1];
                        map.put(new Key(arr[i][0],arr[i][1]),'J');
                    }
                    else {
                        f=true;
                        break;
                    }
                }
                w.print("Case #"+x+": ");
                if(f)w.println("IMPOSSIBLE");
                else{
                    for(int i=0;i<n;i++){
                        w.print(map.get(new Key(ans[i][0],ans[i][1])));
                    }
                    w.println();
                }
            }
//            int t=sc.nextInt();
//            sc.nextLine();
//            for(int i=1;i<=t;i++){
//                char arr[]=sc.nextLine().toCharArray();
//                ArrayList<Character> ans=new ArrayList<>();
//                boolean o=false;
//                for(int j=0;j<arr.length;j++){
//                    if(arr[j]=='1'){
//                        if(!o){
//                            ans.add('(');
//                            o=true;
//                        }
//                        ans.add(arr[j]);
//                    }
//                    else{
//                        if(o){
//                            o=false;
//                            ans.add(')');
//
//                        }
//                        ans.add(arr[j]);
//                    }
//
//
//                }
//                if(o){
//                    ans.add(')');
//                }
//                w.print("Case #"+i+": ");
//                for(char c:ans)w.print(c);
//                w.println();
//
//            }



                    w.close();
            }
    }