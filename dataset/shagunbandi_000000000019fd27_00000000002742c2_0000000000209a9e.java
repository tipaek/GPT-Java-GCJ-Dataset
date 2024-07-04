import java.util.*; 

class Solution { 
    public static void forTen(Scanner sc1, int t) {
        while(t>0){
            t--;
            String str = "";
            for(int i=1;i<=10;i++){
                System.out.println(i);
                int response = sc1.nextInt();
                sc1.nextLine();
                str += "" + response;
            }
            
            System.out.println(str); 
            String res = sc1.nextLine();
            if(!res.equals("Y")){
                return;
            }
        }

    }
    
    public static void main(String[] args) 
    { 
        Scanner sc1 = new Scanner(System.in); 
        int t = sc1.nextInt();
        int b = sc1.nextInt();
        sc1.nextLine();
        
        if(b==10){
            forTen(sc1, t);
        }
        return;
    } 
} 
