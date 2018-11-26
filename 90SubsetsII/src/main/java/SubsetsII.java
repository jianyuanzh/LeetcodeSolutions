import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * See {@link} {}
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        result.add(new ArrayList<>());
        backTracing(nums, result, new LinkedList<>(), 0);
        return result;
    }

    private void backTracing(final int[] sortedNums, List<List<Integer>> results, LinkedList<Integer> current, int level) {
        for (int i = level; i < sortedNums.length; i++) {
            current.add(sortedNums[i]);
            results.add(new ArrayList<>(current));
            backTracing(sortedNums, results, current, i+1);
            current.removeLast();
            while (i+1 < sortedNums.length && sortedNums[i] == sortedNums[i+1]) {
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        for (List<Integer> ret : new SubsetsII().subsetsWithDup(new int[]{1,2,2})) {
            System.out.println(ret);
        }
    }
}
