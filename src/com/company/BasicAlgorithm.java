package com.company;

import java.util.Arrays;

public class BasicAlgorithm {

    // 穷举法解决鸡兔同笼问题
    private void QiongJu(int head, int foot){
        System.out.println("foot = " + foot);
        System.out.println("head = " + head);
        // 鸡数量为i 兔数量为j
        int i,j;
        for (i = 0; i <= head; i++) {
            j = head -i;
            if (2*i+4*j==foot){
                System.out.println("答案为: 鸡为"+i+"只, 兔子为"+j+"只！");
            }
        }
    }

    // 递推算法斐波拉契
    private int Fibonacci(int n){
        int t1,t2;
        if (n==1 || n==2){
            return 1;
        }else {
            t1 = Fibonacci(n-1);
            t2 = Fibonacci(n-2);
            return t1+t2;
        }
    }


    // 递归算法阶乘
    private long fact(int i){
        if (i<=1){
            return 1;
        }else
            return i*fact(i-1);
    }

    /**
     * 分治算法
     * 分三种情况，俩个硬币，硬币数量为偶数，硬币数量为奇数
     * @return
     */
    private int FalseCoin(int coin[], int low, int high){
        int sum1=0, sum2=0;
        int result = 0;
        // 两个硬币情况
        if (low+1==high){
            if (coin[low]+1==coin[high]){
                return low+1;
            }else {
                return high+1;
            }
        }
        // 硬币数为偶数的情况
        if ((high-low+1)%2==0){
            // 分成两半
            // 前半段
            for (int i = low; i <= low + (high - low) / 2; i++) {
                sum1 = sum1 + coin[i];
            }
            // 后半段
            for (int i = low + (high - low) / 2 + 1; i <= high; i++) {
                sum2 = sum2 + coin[i];
            }
            if (sum1 > sum2){
                result = FalseCoin(coin, low+(high-low)/2+1, high);
                return result;
            }else {
                result = FalseCoin(coin, low, low+(high-low)/2);
                return result;
            }
        }else {
            // 硬币数量为奇数的情况，分成两半和中间的一个，遇到三种情况
            for (int i = low; i <= low+(high-low)/2-1; i++) {
                sum1 = sum1 + coin[i];
            }
            for (int i = low+(high-low)/2+1; i <= high; i++) {
                sum2 = sum2 + coin[i];
            }
            if (sum1>sum2){
                result = FalseCoin(coin, low+(high-low)/2+1,high);
                return result;
            }else if (sum1<sum2){
                result = FalseCoin(coin, low, low+(high-low)/2-1);
                return result;
            }else {
                result = low +(high-low)/2 + 1;
                return result;
            }
        }
    }

    /**
     * 概率算法思想
     * 计算PI
     * @return
     */
    private double MountPI(int n ){
        double PI;
        double x,y;
        int sum=0;
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if ((x*x+y*y)<=1)sum++;
        }
        PI = 4.0 * sum/n;
        return PI;
    }

    public static void main(String[] args) {
        BasicAlgorithm ba = new BasicAlgorithm();

        // ba.QiongJu(35,94);

        // System.out.println("n==5, 结果为"+ba.Fibonacci(5));

        //System.out.println("n==12, 阶乘结果为："+ba.fact(12));

        /*int []coin = new int[]{1,1,1,1,1,1,0,1,1,1};
        int result = ba.FalseCoin(coin,0,coin.length-1);
        System.out.println(Arrays.toString(coin));
        System.out.println("结果是第"+result+"个是假币");*/

        double PI = ba.MountPI(1000000);
        System.out.println("PI = " + PI);

    }
}
