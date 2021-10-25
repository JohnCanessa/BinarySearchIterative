import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class BinarySearch {


    /**
     * Given an array of integers nums which is sorted in ascending order, 
     * and an integer target, write a function to search target in nums. 
     * If target exists, then return its index. Otherwise, return -1.
     * 
     * 47 / 47 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Memory Usage: 51.8 MB
     * 
     * Execution: O(n log(n)) - Space: O(1)
     */
    static public int search(int[] nums, int target) {
        
        // **** sanity check(s) ****
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        // **** initialization ****
        int l = 0;
        int r = nums.length - 1;
        int m = 0;

        // **** search for the target value ****
        while (l <= r) {

            // **** compute mid ****
            m = l + (r - l) / 2;

            // ???? ????
            System.out.println("<<< m: " + m);

            // **** check if target found ****
            if (target == nums[m]) return m;

            // **** update range to continue search ****
            if (target < nums[m])
                r = m - 1;          // go left
            else
                l = m + 1;          // go right

            // ???? ????
            System.out.println("<<< l: " + l + " m: " + m + " r: " + r);
        }

        // **** target NOT found ****
        return -1;
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read nums int[] ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** read target ****
        int target = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));
        System.out.println("main <<< target: " + target);

        // **** call function of interest and display output ****
        System.out.println("main <<< output: " + search(nums, target));
    }
}