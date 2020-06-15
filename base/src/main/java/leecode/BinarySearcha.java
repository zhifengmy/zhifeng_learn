package leecode;

public class BinarySearcha {



    /**
     * @Author: Alpha Li
     * @Paramter:
     * @ReturnType:
     * @Description: 找出第一个符合的下标
     * @Datetime: 2019/4/4
     */
    public static int searchFirst(int[] arr, int tar){
        int l = 0, r = arr.length - 1;// r=7
        while(l <= r){
            int mid = (r + l)/2;
            if(arr[mid] > tar)
                r = mid - 1;
            else if(arr[mid] < tar)
                l = mid + 1;//4
            else if(arr[mid] == tar){
                while (l<=mid){
                   if(arr[mid-1]<arr[mid]){
                       return mid;
                   }
                   mid--;
                }
            }
        }

        return -1;
    }




    /**
    * @Author: Alpha Li
    * @Paramter:
    * @ReturnType:
    * @Description: 找出第一个符合的下标
    * @Datetime: 2019/4/4
    */
    public static int searchFloor(int[] arr, int tar){
        int l = 0, r = arr.length - 1;// r=7
        while(l <= r){
            int mid = l + (r - l)/2;//3,5
            if(arr[mid] >= tar)
                r = mid - 1;
            else
                l = mid + 1;//4
        }
        if(l < arr.length && arr[l] == tar)
            return l;
        return -1;
    }
 
    /**
    * @Author: Alpha Li
    * @Paramter:
    * @ReturnType:
    * @Description: 找出最后一个符合的下标
    * @Datetime: 2019/4/4
    */
    public static int searchCeil(int[] arr, int tar){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] <= tar)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if(r >= 0 && arr[r] == tar)
            return r;
        return -1;
    }
 
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,5};
        System.out.println(searchFirst(arr, 4));
    }
}