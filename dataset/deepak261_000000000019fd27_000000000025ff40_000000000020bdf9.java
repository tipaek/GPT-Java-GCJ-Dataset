


import java.util.*;
class Solution{
    private static Scanner sc;
    static int tn=1;

    public static void main(String args[]){
        sc=new Scanner(System.in);
        int t =sc.nextInt();
        sc.nextLine();
        while(t-- > 0)
        {
            solve();
        }

    }

    public static void solve(){
        int n=sc.nextInt();
        int matrix[][] =new int[n][2];
        int msort[][] =matrix.clone();
        char pers='J';
        char chars[] =new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible=false;
        Map<int[],Integer> map =new HashMap<>();

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=sc.nextInt();
            }
            map.put(matrix[i],i);
        }
        Arrays.sort(msort,new Comparator<int[]>()
        {
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        }
        );

        for(int i=0;i<msort.length;i++){
            chars[map.get(msort[i])]=pers;
            if(i < msort.length-1 &&overlap(msort[i],msort[i+1])){
                if(pers=='J'){
                    JStack.push(msort[i]);
                    pers=getParent(pers);
                if(!CStack.isEmpty() && overlap(CStack.peek(),msort[i+1])){
                    impossible=true;
                    break;
                }
            }else {
                CStack.push(msort[i]);
                pers=getParent(pers);
                if(!JStack.isEmpty() && overlap(JStack.peek(),msort[i+1])){
                    impossible=true;
                    break;
            }
            }
        }else{
                if(pers=='J'){
                JStack.push(msort[i]);
                }else{
                CStack.push(msort[i]);
                }
        }
    }
    System.out.println("Case #"+(tn++)+": "+(impossible ? "IMPOSSIBLE" : new String(chars)));
}

private static char getParent(char p){
    return p=='J'?'C':'J';
}
private static boolean overlap(int[] a,int b[]){
    return a[1]>b[0];
}

}
