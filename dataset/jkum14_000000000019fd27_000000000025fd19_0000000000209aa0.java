class Solution {


    private static boolean checkForNaturalLatin(int size, int k) {
        int sum=0;
        for(int i=0; i<size; i++){
            return sum+i ==k;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        int caseNo = 0;

        while (tests-- > 0) {
            int size = br.read();
            int k = br.read();
            if(checkForNaturalLatin(size, k)){
                System.out.println("Case #"+ ++caseNo+ ": POSSIBLE");
            }
            else System.out.println("Case #"+ ++caseNo+ ": IMPOSSIBLE");
        }
    }
}
