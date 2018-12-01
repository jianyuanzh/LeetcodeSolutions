import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target<0 || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTracing(candidates, result, new LinkedList<>(), target, 0);
        return result;
    }

    private void backTracing(int[] sortedCandidates, List<List<Integer>> result, LinkedList<Integer> current,  int target, int level) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = level; i < sortedCandidates.length; i++) {
            current.add(sortedCandidates[i]);
            target-=sortedCandidates[i];
            backTracing(sortedCandidates, result, current, target, i+1);
            current.removeLast();
            target+=sortedCandidates[i];
            while (i + 1 < sortedCandidates.length && sortedCandidates[i] == sortedCandidates[i+1]) {
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        for (List<Integer> ret : new CombinationSumII().combinationSum2(new int[]{2,3,6,7}, 7)) {
            System.out.println(ret);
        }

//        [10,1,2,7,6,1,5]
//        8
        for (List<Integer> ret : new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)) {
            System.out.println(ret);
        }


        System.out.println("third case");
        for (List<Integer> ret : new CombinationSumII().combinationSum2(new int[]{2,2,2}, 2)) {
            System.out.println(ret);
        }
    }
}
