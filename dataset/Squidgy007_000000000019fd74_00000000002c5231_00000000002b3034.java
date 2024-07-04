import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int T=scn.nextInt();
        for(int t=1;t<=T;t++){
            int N=scn.nextInt();
            String[] A=new String[N];
            for(int i=0;i<N;i++){
                A[i]=scn.next();
            }
            for(int i=0;i<N;i++){
                formTrie(A[i]);
            }
            for(int i=0;i<N;i++){
                formTriemid(A[i]);
            }
            for(int i=0;i<N;i++){
                formTrieLast(A[i]);
            }
            String initialString=searchTrie(0);
            String finalString=searchTrie(2);

            if(initialString.equals("*")||finalString.equals("*")){
                System.out.println("Case #" + t + ": " + "*");
                continue;
            }

            finalString = new StringBuilder(finalString).reverse().toString();
            String midString=searchTrie1(middleTrie, "");
//            System.out.println("Initial string is" +initialString);
//            System.out.println("Middle string" +midString);
//            System.out.println("Final String" + finalString);
            System.out.println("Case #" + t + ": " + initialString+midString+finalString);

        }
    }




    private static void formTrieLast(String s) {
        String lastTrieStr="";
        boolean lastTrieFlag=false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='*'){
                lastTrieFlag=false;
                break;
            }
            else{
                lastTrieStr=lastTrieStr+s.substring(i,i+1);
            }
        }
//        System.out.println(lastTrieStr);
        createTrie(lastTrieStr, 2);
    }

    private static void formTriemid(String s) {
        int initialIndex=-1;
        int finalIndex=-1;


        boolean lastTrieFlag=false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='*'){
                finalIndex=i;
                break;
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                initialIndex=i;
                break;
            }
        }
        String midString="";
        for(int i=initialIndex+1;i<=finalIndex-1;i++){
            if(s.charAt(i)=='*'){

            }
            else{
                midString=midString+s.substring(i, i+1);
            }
        }
//        System.out.println(midString);
        createTrie(midString, 1);
    }

    private static void formTrie(String s) {
        String initialTrieStr="";
        boolean initialTrieFlag=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                initialTrieFlag=false;
                break;
            }
            else{
                initialTrieStr=initialTrieStr+s.substring(i,i+1);
            }
        }
//        System.out.println(initialTrieStr);
        createTrie(initialTrieStr, 0);
    }

    private static void createTrie(String string, int trieSeq) {
        Trie crawl;
        if(trieSeq==0){
            crawl=initialTrie;
        }
        else if(trieSeq==1){
            crawl=middleTrie;
        }
        else{
            crawl=finalTrie;
        }
        for(int i=0;i<string.length();i++){
            int index=string.charAt(i)-'A';
            if(crawl.children[index]==null){
                crawl.children[index]=new Trie();
            }
            crawl=crawl.children[index];
        }

    }

    private static String searchTrie(int trieSeq) {
        Trie crawl;
        if(trieSeq==0){
            crawl=initialTrie;
        }
        else if(trieSeq==1){
            crawl=middleTrie;
        }
        else{
            crawl=finalTrie;
        }
        return findStr(crawl, "");

    }

    private static String findStr(Trie crawl, String string) {
        boolean hasOneChildren=false;
        char ch;
        if(crawl!=null){
            for(int i=0;i<26;i++){
                if(crawl.children[i]!=null){
                    if(hasOneChildren){
                        return "*";
                    }
                    else{
                        ch= (char) ('A'+i);
                        String str=findStr(crawl.children[i], string);
                        if(str.equals("*")){
                            return "*";
                        }
                        string=string+ ch + str;
                    }
                    hasOneChildren=true;
                }
            }
        }

        return string;
    }

    private static String searchTrie1(Trie crawl, String string) {
        char ch;
        if(crawl!=null){
            for(int i=0;i<26;i++){
                if(crawl.children[i]!=null){
                        ch= (char) ('A'+i);
                        String str=findStr(crawl.children[i], string);
                        string=string+ ch + str;
                }
            }
        }

        return string;
    }
    private static class Trie{
        Trie[] children=new Trie[26];
        boolean endOfWord;
        Trie(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            endOfWord=false;
        }
    }

    static Trie initialTrie=new Trie();

    static Trie middleTrie= new Trie();

    static Trie finalTrie = new Trie();
}