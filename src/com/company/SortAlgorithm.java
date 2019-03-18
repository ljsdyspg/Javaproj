package com.company;


import java.util.Arrays;

public class SortAlgorithm {
    /**
     * 冒泡排序算法
     * 依次比较两个相邻的数的大小、转换位置
     * <p>
     * 需要执行n-1次，效率不高，可以考虑增加是否已完成判断，加速执行过程
     *
     * @param list
     */
    private void bubbleSort(int[] list) {
        int temp;
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
            System.out.println("第" + i + "次排序的结果为" + Arrays.toString(list));
        }
    }

    /**
     * 选择排序算法
     * 每次找出后续最小的数与当前数交换位置
     * <p>
     * 需要执行n-1次，且效率不高
     *
     * @param list
     */
    private void selectionSort(int[] list) {
        int index, temp;
        for (int i = 0; i < list.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[index]) {
                    index = j;
                }
            }
            // 交换两个数
            if (index != i) {
                temp = list[i];
                list[i] = list[index];
                list[index] = temp;
            }
            System.out.print("第" + i + "步排序结果：");
            for (int num : list) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }


    /**
     * 插入排序算法
     * 先把前面的数排好，后一个数排好的最后一个数比较，大就加入，小就插入到正确的位置
     * <p>
     * 数据已有一定顺序的情况下，效率比较好，数据无规则需要移动大量的数据，效率不高
     *
     * @param list
     */
    private void insertionSort(int[] list) {
        int i, j, t, h;
        for (i = 1; i < list.length; i++) {
            t = list[i];
            j = i - 1;
            while (j >= 0 && t < list[j]) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = t;
            System.out.print("第" + i + "次排序结果： ");
            for (int num :
                    list) {
                System.out.printf(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * shell排序算法
     * 每次都分组 n/2 n/4 n/8这样，对每个小组进行小大排序，然后再用插入算法
     * <p>
     * 如果已经有序，效率大幅提升；对于数量较小的序列使用直接插入排序，移动的数量也较少，效率较高
     *
     * @param list
     */
    private void shell(int[] list) {
        int i;
        int j;
        int r;
        int temp;
        int x = 0;
        for (r = list.length / 2; r >= 1; r /= 2) {
            for (i = r; i < list.length; i++) {
                temp = list[i];
                j = i - r;
                while (j >= 0 && temp < list[j]) {
                    list[j + r] = list[j];
                    j -= r;
                }
                list[j + r] = temp;
            }
            x++;
            System.out.print("第" + x + "步排序结果: ");
            for (int num :
                    list) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }

    private void quickSort(int[] list, int left, int right) {
        int f,t;
        int ltemp,rtemp;

        ltemp = left;
        rtemp = right;

        f = list[(left+right)/2]; // 分解值
        while (ltemp<rtemp){
            while(list[ltemp]<f) ltemp++;
            while (list[rtemp]>f) rtemp--;
            if (ltemp<=rtemp){
                t = list[ltemp];
                list[ltemp] = list[rtemp];
                list[rtemp] = t;
                rtemp--;
                ltemp++;
            }
        }
        if (ltemp == rtemp)ltemp++;
        if (left<rtemp) quickSort(list, left, ltemp-1);
        if (ltemp<right) quickSort(list, rtemp+1, right);
    }


    public static void main(String[] args) {
        int SIZE = 10;
        int[] list = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            list[i] = (int) (Math.random() * 100);
        }
        System.out.println("初始数组为：    " + Arrays.toString(list));
        SortAlgorithm sa = new SortAlgorithm();

        // 冒泡排序
        // sa.bubbleSort(list);
        // 选择排序
        // sa.selectionSort(list);
        // 插入排序
        // sa.insertionSort(list);
        // Shell排序
        // sa.shell(list);
        // 快速排序
        sa.quickSort(list,0,list.length-1);

        System.out.println("最终数组为：    " + Arrays.toString(list));
    }
}
