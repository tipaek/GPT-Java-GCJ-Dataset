import java.util.*;
import java.lang.*;
public class Sol{
    private static Scanner sc;
    static int inc=1;   
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
     
        while(t--> 0){
           solve();

        }
    } 

    private static void solve(){
        int n=sc.nextInt();
        int [][] arr=new int[n][2];
        int[][]arr1= arr.clone();
        char person='J';
        char[] chars= new char[n];
        Stack<int[]> Stack1= new Stack<>();
        Stack<int[]> Stack2= new Stack<>();
        boolean impossible=false;
        Map<int[], Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=sc.nextInt();

            }
            map.put(arr[i],i);
        }
    Arrays.sort(arr1, new Comparator<int[]>(){
       @Override
       public int compare(int[] a, int[] b){
           return a[0]-b[0];
       }
    });  
       
    for(int i=0;i<arr1.length;i++){
        chars[map.get(arr1[i])]=person;

        if(i<arr1.length-1 && doesOverlap(arr1[i], arr1[i+1])){
            if(person== 'J'){
                Stack1.push(arr1[i]);
                person=getPerson(person);
                if(!Stack2.isEmpty()&&doesOverlap(Stack2.peek(),arr1[i+1])){

                    impossible= true;
                    break;
                }
            }else{
                Stack2.push(arr1[i]);
                person=getPerson(person);
         
         
              if(!Stack1.isEmpty()&& doesOverlap(Stack1.peek(), arr1[i+1])){
                impossible=true;
                break;
              
                }
            }
        }else{
            if(person=="J"){
            Stack1.push(arr1[i]);
      
           }else{
             Stack2.push(arr1[i]);
          }
        }
    }
    System.out.println("Case #"+ (inc++)+ ": " +(impossible?"IMPOSSIBLE":new String(chars)));
    }


    private static char getPerson(char p){
    return p== 'J'?'C' : 'J';

    }


    private static boolean doesOverlap(int[] a,int[] b){
    return a[1]>b[0];
    }
}