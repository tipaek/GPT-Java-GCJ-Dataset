 class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        for(int x=1;x <= T;x++){
            int N = sc.nextInt();
            ArrayList<String> arr = new ArrayList<>();
            for(int i=0;i<N;i++){
             String temp = sc.next();
             arr.add(temp);
             }
             System.out.println("Case #"+x+": "+ans);
        }
    }
    public static String ans(ArrayList<String> arr){
        max = 0;
        String s="";
        for(int i=0;i<n;i++){
            if(arr.get(i).length()>max){
               max = arr.get(i).length();
                s = arr.get(i);
            }
        }
        if(checkVowel(s))
         return s.replace('*','');
        else
         return "*";
    }
    public static boolean checkVowel(String s){
        s = s.toUpperCase();
        boolean x = false;
        for(int i=1;i<s.length-1;i++){
            if(A || E || I || O || U == s.charAt(i)){
                x  = true;
                break;
            }
        }
        return x;
    }
            
    }