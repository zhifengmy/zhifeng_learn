package sort;

/**
 * @author KyLin
 * @Description:各类查找算法实现
 * @date 2019/2/28 11:04
 */
public class Search {


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 8, 10};
        int i = binarySearchBig(arr, 7);
        System.out.println(i);

    }

    /**
     * @Description:二分查找
     * @author KyLin
     * @date 2019/2/28 11:05
     */
    public static int binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;
        //注意退出条件
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < item) {
                low = mid;
            } else if (arr[mid] == item) {
                return mid;
            } else if (arr[mid] > item) {
                high = mid;
            }
        }
        return -1;
    }

    /**
    * @Description:查找第一个值等于给定值的元素
    * @author KyLin
    * @date 2019/2/28 17:55
    */
    public static int binarySearchOne(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;
        //注意退出条件 {2, 3, 7, 7, 8, 10}
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < item) {
                low = mid;
            } else if (arr[mid] == item) {
               //{2, 3, 7, 7, 8, 10}
                if(mid==0||arr[mid-1]<item){
                    return mid;
                }else{
                    high=mid;
                }
            } else if (arr[mid] > item) {
                high = mid;
            }
        }
        return -1;
    }

    /**
     * @Description:查找第一个值等于给定值的元素
     * @author KyLin
     * @date 2019/2/28 17:55
     */
    public static int binarySearchLast(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;
        //注意退出条件 {2, 3, 7, 7, 8, 10}
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < item) {
                low = mid;
            } else if (arr[mid] == item) {
                //{2, 3, 7, 7, 8, 10}
                if(mid==high||arr[mid+1]>item){
                    return mid;
                }else{
                    low=mid;
                }
            } else if (arr[mid] > item) {
                high = mid;
            }
        }
        return -1;
    }

    /**
     * @Description:查找第一个大于等于等于给定值的元素
     * @author KyLin
     * @date 2019/2/28 17:55
     */
    public static int binarySearchBig(int[] arr, int item) {
//        int low = 0;
//        int high = arr.length - 1;
//        //注意退出条件 {2, 3, 7, 7, 8, 10}
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (arr[mid] >= item) {
//                //{2, 3, 7, 7, 8, 10}
//                if(arr[mid-1]<item){
//                    return mid;
//                }else{
//                    low=mid;
//                }
//            } else{
//                low = mid;
//            }
//        }
        return -1;
    }


}
