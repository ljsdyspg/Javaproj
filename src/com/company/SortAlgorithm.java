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


    /**
     * 快速排序算法
     * <p>
     * 设定一个分界值，在两个指针不重合的基础上，然后从左开始找到比基准值大的，从右开始找到比基准值小的，然后交换这两个值
     * 每次都将比基准值小的移动到基准值左边，把比基准值大的移动到基准值右边
     *
     * @param list  待排序的数组
     * @param left  当前排序数组最左序号
     * @param right 当前排序数组最右序号
     */
    private void quickSort(int[] list, int left, int right) {
        int base, temp;
        int i, j;

        i = left;
        j = right;

        base = list[(left + right) / 2]; // 分界值
        while (i < j) {
            while (list[i] < base) i++;
            while (list[j] > base) j--;
            if (i <= j) {
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                j--;
                i++;
            }
        }
        if (i == j) i++;
        if (left < j) quickSort(list, left, i - 1);
        if (i < right) quickSort(list, j + 1, right);
    }


    /**
     * 堆排序
     * <p>
     * 每次都取堆顶的元素，将其放在数组的最后面，然后将剩余的元素重新调整为最大堆，以此类推，最后得到排序的序列
     *
     * @param list
     */
    private void heapSort(int list[]) {
        int i, j, h, k;
        int t;
        int n = list.length;

        for (i = n / 2 - 1; i >= 0; i--) {
            while (2 * i + 1 < n) {
                j = 2 * i + 1;
                if ((j + 1) < n) {
                    if (list[j] < list[j + 1])
                        j++;
                }
                if (list[i] < list[j]) {
                    t = list[i];
                    list[i] = list[j];
                    list[j] = t;
                    i = j;
                } else break;
            }
        }

        // 输出构成的堆
        System.out.println("原始数据构成的堆");
        for (int num : list) {
            System.out.print(" " + num);
        }
        System.out.println();

        for (i = n - 1; i > 0; i--) {
            t = list[0];
            list[0] = list[i];
            list[i] = t;
            k = 0;
            while (2 * k + 1 < i) {
                j = 2 * k + 1;
                if ((j + 1) < i) {
                    if (list[j] < list[j + 1]) j++;
                }
                if (list[k] < list[j]) {
                    t = list[k];
                    list[k] = list[j];
                    list[j] = t;
                    k = j;
                } else break;
            }

            System.out.print("第" + (n - i) + "步排序结果: ");
            for (int num : list) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }


    /**
     * 合并排序
     * @param list
     * @param n
     */
    private void mergeSort(int list[], int n) {
        int h , count, len, f;

        count = 0;
        len = 1;
        f = 0;
        int[] p = new int[n];
        while(len<n){
            if (f==1){
                mergeOne(p,list,n,len);
            }else {
                mergeOne(list,p,n,len);
            }
            len *= 2;
            f = 1-f;

            count++;
            System.out.println("第"+count+"步排序结果： ");
            for (int sum : list) {
                System.out.print(" "+sum);
            }
            System.out.println();

            if (f==1){
                for (h=0;h<n;h++){
                    list[h] = p[h];
                }
            }
        }
    }

    // 完成一遍合并
    private void mergeOne(int a[], int b[], int n, int len) {
        int i, j, k, s, e;
        s = 0;
        while (s + len < n) {
            e = s + 2 * len - 1;
            if (e >= n) { // 最后一段有可能少于len个
                e = n - 1;
            }
            // 相邻有序段合并
            k = s;
            i = s;
            j = s + len;
            while (i < s + len && j <= e) {
                if (a[i] < a[j]) {
                    b[k++] = a[i++];
                } else {
                    b[k++] = a[j++];
                }
            }
            while (i < s + len) {
                b[k++] = a[i++];
            }
            while (j <= e) {
                b[k++] = a[j++];
            }
            s = e + 1;
        }
        if (s < n) {
            for (; s < n; s++) {
                b[s] = a[s];
            }
        }
    }


    public static void main(String[] args) {
        int SIZE = 10;
        /*int[] list = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            list[i] = (int) (Math.random() * 100);
        }*/
        int[] list = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
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
        // sa.quickSort(list, 0, list.length - 1);
        // 堆排序
        // sa.heapSort(list);
        // 合并排序
        sa.mergeSort(list,list.length);


        System.out.println("最终数组为：    " + Arrays.toString(list));
    }
}
