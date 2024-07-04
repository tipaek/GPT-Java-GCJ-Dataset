import java.util.*;
public class Solution {
    private static Scanner sc;
   public static int tn=1;
    public static void main(String args[]){
        sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
            solve();
        }
    }
    private static void solve(){
        int n=sc.nextInt();
        int mat[][]=new int[n][2];
        int[][] matsorted=mat.clone();
        char person='J';
        boolean impo=false;
        char[] chars=new char[n];
        Stack <int[]> JStack=new Stack<>();
        Stack<int[]> CStack=new Stack<>();
        Map<int [],Integer> map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                mat[i][j]=sc.nextInt();
            }
            map.put(mat[i],i);
        }
        Arrays.sort(matsorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        for(int i=0;i<matsorted.length;i++)
        {
            chars[map.get(matsorted[i])]=person;
            if(i < matsorted.length-1&&doesOverlap(matsorted[i],matsorted[i+1])){
                if(person=='J'){
                    JStack.push(matsorted[i]);
                    person=getPerson(person);
                    if(!CStack.isEmpty()&&doesOverlap(CStack.peek(),matsorted[i+1]))
                            {
                        impo=true;
                        break;
                    }

                }else{
                    CStack.push(matsorted[i]);
                    person=getPerson(person);
                    if(!JStack.isEmpty()&&doesOverlap(JStack.peek(),matsorted[i+1]))
                    {
                        impo=true;
                        break;
                    }

                }
            }else{

                if(person=='J'){
                    JStack.push(matsorted[i]);
                }else{
                    CStack.push(matsorted[i]);
                }
            }
        }
        System.out.println("Case #"+(tn++)+": "+(impo ? "IMPOSSIBLE" : new String(chars)));
    }
    private static char getPerson(char p){
        return p=='J'?'C':'J';
    }
    private static boolean doesOverlap(int []a,int[] b){

        return a[1]>b[0];
    }
}
