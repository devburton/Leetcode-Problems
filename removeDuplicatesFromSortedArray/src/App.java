class App {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int uniqueValues = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                uniqueValues += 1;
                nums[uniqueValues - 1] = nums[i];
            }
        }
        return uniqueValues;
    }
}