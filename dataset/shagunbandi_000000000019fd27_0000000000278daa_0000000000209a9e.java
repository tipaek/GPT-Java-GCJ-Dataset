import java.util.*; 

class Solution { 
    public static void forTen(Scanner sc1) {
        
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
    
    public static void forTwenty(Scanner sc1) {
        int[] arr = new int[20];
        for(int i=6;i<=15;i++){
            System.out.println(i);
            int response = sc1.nextInt();
            sc1.nextLine();
            arr[i-1] = response;
        }
        
        for(int i=1;i<=5;i++){
            System.out.println(i);
            int response = sc1.nextInt();
            sc1.nextLine();
            arr[i-1] = response;
        }
        
        for(int i=16;i<=20;i++){
            System.out.println(i);
            int response = sc1.nextInt();
            sc1.nextLine();
            arr[i-1] = response;
        }
        
        int[] ar = new int[10];
        for(int i=1;i<=10;i++){
            System.out.println(i);
            int response = sc1.nextInt();
            sc1.nextLine();
            ar[i-1] = response;
        }
        
        compareThis(ar, arr, 0, 4, 20);
        compareThis(ar, arr, 5, 9, 20);
        
        String str = "";
        for(int i=0;i<20;i++){
            str += "" + arr[i];
        }
        
        System.out.println(str); 
        String res = sc1.nextLine();
        if(!res.equals("Y")){
            return;
        }

    }
    
    public static void compareThis(int[] ar, int[] arr, int st, int end, int tot){
        boolean flag = true;
        for(int i=st;i<=end;i++){
            if(ar[i] != arr[i]){
                flag = false;
            }
        }
        if(flag){
            return;
        }
        
        flag=true;
        for(int i=st;i<end;i++){
            if(ar[i] != 1-arr[i]){
                flag=false;
            }
        }
        if(flag){
            for(int i=st;i<end;i++){
                arr[i] = 1-arr[i];
                arr[tot-i-1] = 1-arr[tot-i-1];
            }
            return;
        }

        flag=true;
        for(int i=st;i<end;i++){
            if(ar[i] != arr[tot-i-1]){
                flag=false;
            }
        }
        if(flag){
            for(int i=st;i<end;i++){
                int tmp = arr[tot-i-1];
                arr[tot-i-1] = arr[i];
                arr[i] = tmp;
            }
            return;
        }
        
        flag=true;
        for(int i=st;i<end;i++){
            if(ar[i] != 1-arr[tot-i-1]){
                flag=false;
            }
        }
        if(flag){
            for(int i=st;i<end;i++){
                int tmp = 1-arr[tot-i-1];
                arr[tot-i-1] = 1-arr[i];
                arr[i] = tmp;
            }
            return;
        }
        return;
    }
    
    public static void main(String[] args) 
    { 
        Scanner sc1 = new Scanner(System.in); 
        int t = sc1.nextInt();
        int b = sc1.nextInt();
        sc1.nextLine();
        
        while(t>0){
            if(b==10){
                forTen(sc1);
            }
            else if(b==20){
                forTwenty(sc1);
            }
            else {
                forEverythingElse(sc1, b);
            }
            t--;
        }

        
        return;
    } 
} 
