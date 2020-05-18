package leecode.sort;


import java.util.Arrays;

/**
 * @author KyLin
 * @Description:排序相关
 * @date 2018/12/20 10:40
 */
public class Sort {


    public static void main(String[] args) {
        selectSort();
    }

    /**
     * @Description:冒泡排序实现
     * @author KyLin
     * @date 2018/12/20 10:50
     */
    public static void bubbleSort() {

        int[] array = {4, 2, 5, 3, 6, 0};
        for (int i = 0; i < array.length; i++) {
            //没有元素互换位置的时候就可以跳出循环
            boolean flag = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * @Description:插入排序
     * @author KyLin
     * @date 2018/12/20 16:28
     */
    public static void insertSort() {

        int[] array = {4, 2, 5, 3, 6, 0};
        int n = array.length;
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            //带插入元素
            int value = array[i];
            //已经排序位置
            int j = i - 1;
            // 从数组尾部查找插入的位置
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    // 数据移动
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * @Description:选择排序
     * @author KyLin
     * @date 2018/12/20 17:27
     */
    public static void selectSort() {
        int[] arr = {4, 2, 5, 3, 6, 0};
        //选择排序的优化
        // 做第i趟排序
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            // 选最小的记录
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    //记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            //交换a[i]和a[k]
            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arrays
     * @param L      指向数组第一个元素
     * @param R      指向数组最后一个元素
     * @Description:归并排序
     * @author KyLin
     * @date 2018/12/21 14:14
     */
    public static void mergeSort(int[] arrays, int L, int R) {
        //如果只有一个元素，那就不用排序了
        if (L == R) {
            return;
        } else {
            //取中间的数，进行拆分
            int M = (L + R) / 2;
            //左边的数不断进行拆分
            mergeSort(arrays, L, M);
            //右边的数不断进行拆分
            mergeSort(arrays, M + 1, R);
            //合并
            merge(arrays, L, M + 1, R);
        }
    }

    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {

        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }
        int i = 0, j = 0;
        // arrays数组的第一个元素
        int k = L;

        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            k++;
            j++;
        }
    }


    /**
     * 快速排序
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, left + 1, rightIndex);
    }

}
