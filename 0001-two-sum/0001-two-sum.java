import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    static int[][] enumerateNums;

    // {3,0},{2,1},{4,2}
    public int[] twoSum(int[] nums, int target) {

        enumerateNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            enumerateNums[i][0] = nums[i];
            enumerateNums[i][1] = i;
        }

        int[] rt = new int[2];
        Arrays.sort(enumerateNums, Comparator.comparingInt(x -> x[0])); //nlogn

        for (int i = 0; i < enumerateNums.length; i++) { //n/2 * logn
            rt[0] = enumerateNums[i][1];
            int left = i + 1;
            int right = enumerateNums.length - 1;
            int idx = bs(enumerateNums, left, right, target - enumerateNums[i][0]);
            if (idx != -1) {
                rt[1] = idx;
                return rt;
            }
        }

        return rt;
    }

    public int bs(int[][] nums, int left, int right, int n) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid][0] < n) {
                left = mid + 1;
            } else if (nums[mid][0] > n) {
                right = mid - 1;
            } else {
                return nums[mid][1];
            }
        }

        return -1;
    }
}
