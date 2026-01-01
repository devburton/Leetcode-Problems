public class App {
    public static void main(String[] args) throws Exception {
        int[] list = {-1,0,3,5,9,12};
        System.out.println(binarySearch(list, 13, 0, list.length));
    }
    public static int binarySearch(int[] nums, int target, int l, int r) {
        int mid = l + (r - l) / 2;
        if(l > r) return -1;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target) {
            return binarySearch(nums, target, l, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, r);
        }
    }
}
