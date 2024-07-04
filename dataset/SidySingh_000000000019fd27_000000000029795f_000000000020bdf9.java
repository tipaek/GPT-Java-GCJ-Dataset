import java.util.Set;
public class Test{
    private static Scanner sc;
    static int ct = 1;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            answer();
        }
    }
    private static void answer(){
        int n = sc.nextInt();
        int [][] arr = new int [n][2];
        int [][] arrSort = arr.clone();
        char person = 'J';
        char[] ch = new char[n];
        Stack<int[]> JSt = new Stack<>();
        Stack<int[]> CSt = new Stack<>();
        boolean imp = false;
        Map<int[], Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
            map.put(arr[i],i);
        }
        
        Arrays.sort(arrSort , new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        for(int i = 0; i < arrSort.length; i++){
            ch[map.get(arrSort[i])] = person;
            if(i < arrSort.length - 1 && Overlap(arrSort[i],arrSort[i+1])){
                if(person == 'J'){
                    JSt.push(arrSort[i]);
                    person = getPer(person);
                    if(!CSt.isEmpty() && Overlap(CSt.peek(),arrSort[i+1])){
                        imp = true;
                        break;
                    }
                }
                
                else{
                    CSt.push(arrSort[i]);
                    person = getPer(person);
                    if(!JSt.isEmpty() && Overlap(JSt.peek(),arrSort[i+1])){
                        imp = true;
                        break;
                    }
                }
            }
            else{
                
                if(person == 'J')
                    JSt.push(arrSort[i]);
                else
                    CSt.push(arrSort[i]);
                
            }
         }
         System.out.println("Case #" + (ct++) + ": " + (imp ? "IMPOSSIBLE" : new String(ch)));
         
    }
    
    private static char getPer(char p){
        return p == 'J' ? 'C' : 'J';
    }
    
    private static boolean Overlap(int[] a, int[] b){
        return a[1] > b[0];
    }
}
