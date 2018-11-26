import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        Map<Integer, Boolean> vistedMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            vistedMap.put(i, false);
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
            if (vistedMap.get(i)) {
                continue;
            }
            current.add(cur);
            vistedMap.put(i, true);
            dfs(sortedNums, result, vistedMap, current);
            current.removeLast();
            vistedMap.put(i, false);
            while (i + 1 < sortedNums.length && sortedNums[i] == sortedNums[i+1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for (List<Integer> ret : new PermuteUnique().permuteUnique(new int[]{1,1,2})) {
            System.out.println(ret);
        }
    }
}
