package base.probability;

import java.util.Scanner;

public class CaseOfNumber2 {
    static int N;
    static int r;
    static boolean[] v;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        r=sc.nextInt();
        v=new boolean[N];
 
        System.out.println("순열");
        int[] perm=new int[r];    
        for(int i=0;i<N;i++) {
            perm[0]=i;
            v[i]=true;
            permutation(perm,1);
            v[i]=false;
        }
        
        System.out.println("조합");
        int[] comb=new int[r];
        for(int i=0;i<N;i++) {
            comb[0]=i;
            v[i]=true;
            combination(comb,1);
        }
 
        System.out.println("중복순열");
        int[] rePerm=new int[r];
        for(int i=0;i<N;i++) {
            rePerm[0]=i;
            rePermutation(rePerm,1);
        }
        
        System.out.println("중복조합");
        int[] reComb=new int[r];
        for(int i=0;i<N;i++) {
            reComb[0]=i;
            reCombination(reComb,1);
        }
    }
    public static void permutation(int[] perm,int n) {
        if(n==r) {
            for(int i:perm) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<N;i++) {
            if(!v[i]) {
                v[i]=true;
                perm[n]=i;
                permutation(perm,n+1);
                v[i]=false;
            }
        }
    }
    
    public static void combination(int[] comb,int n) {
        if(n==r) {
            for(int i:comb) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=comb[n-1];i<N;i++) {
            if(!v[i]) {
                v[i]=true;
                comb[n]=i;
                combination(comb,n+1);
                v[i]=false;
            }
        }
    }
    
    public static void rePermutation(int[] rePerm,int n) {
        if(n==r) {
            for(int i:rePerm) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<N;i++) {
                rePerm[n]=i;
                rePermutation(rePerm,n+1);
            }
    }
    
    public static void reCombination(int[] reComb,int n) {
        if(n==r) {
            for(int i:reComb) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=reComb[n-1];i<N;i++) {
                reComb[n]=i;
                reCombination(reComb,n+1);
            }
    }
}
