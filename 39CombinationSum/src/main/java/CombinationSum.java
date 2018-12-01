import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 *  1. All numbers (including target) will be positive integers.
 *  2. The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target < 0) {
            return result;
        }

        if (candidates.length < 1) {
            return result;
        }

        Arrays.sort(candidates);

        LinkedList<Integer> current = new LinkedList<>();
        backTracing(candidates, target, result, current, 0);
        return result;
    }

    private void backTracing(int[] sortedCandidates, int target, List<List<Integer>> result, LinkedList<Integer> current, int level) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = level; i < sortedCandidates.length ; i++) {
            target-=sortedCandidates[i];
            current.add(sortedCandidates[i]);
            backTracing(sortedCandidates, target, result, current, i);
            current.removeLast();
            target += sortedCandidates[i];

        }
    }

    public static void main(String[] args) {
        for (List<Integer> ret : new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7)) {
            System.out.println(ret);
        }

        for (List<Integer> ret : new CombinationSum().combinationSum(new int[]{10,1,2,7,6,1,5}, 8)) {
            System.out.println(ret);
        }
    }
}
