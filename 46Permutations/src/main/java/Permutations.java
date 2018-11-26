import java.util.*;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Map<Integer, Boolean> vistedMap = new HashMap<>();
        for (Integer n : nums) {
            vistedMap.put(n, false);
        }

        Arrays.sort(nums);
        dfs(nums, result, vistedMap, new LinkedList<Integer>());

        return result;
    }

    private void dfs(final int[] sortedNums, final List<List<Integer>> result, final Map<Integer, Boolean> vistedMap, LinkedList<Integer> current) {
        if (current.size() == sortedNums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i<sortedNums.length; i++) {
            int cur = sortedNums[i];
            if (vistedMap.get(cur)) {
                continue;
            }
            current.add(cur);
            vistedMap.put(cur, true);
            dfs(sortedNums, result, vistedMap, current);
            current.removeLast();
            vistedMap.put(cur, false);
        }
    }


    public static void main(String[] args) {
        for (List<Integer> ret : new Permutations().permute(new int[]{1,2,3})) {
            System.out.println(ret);
        }
    }
}
