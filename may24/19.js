var maximumValueSum = function(nums, k, edges) {
    let sum = 0;
    let minExtra = 1000000; 
    let count = 0;

    for (const val of nums) {
        if ((val ^ k) > val) {
            sum += val ^ k;
            minExtra = Math.min(minExtra, (val ^ k) - val);
            count++;
        } else {
            sum += val;
            minExtra = Math.min(minExtra, val - (val ^ k));
        }
    }

    return count % 2 === 0 ? sum : sum - minExtra;
};
