/**
 * @param {number[]} nums
 * @return {number[][]}
 */

var subsets = function(nums) {
    const Ans = [];
    const n = nums.length;

    // Helper function
    const Helper = (op, startIdx) => {
        // base case
        if (startIdx === n) {
            Ans.push(op.slice()); // add a copy of op to Ans
            return;
        }

        // recursive case
        // choice 1: include the current element
        op.push(nums[startIdx]);
        Helper(op, startIdx + 1);
        
        // backtracking step
        op.pop();
        
        // choice 2: exclude the current element
        Helper(op, startIdx + 1);
    }

    Helper([], 0);
    return Ans;
};
