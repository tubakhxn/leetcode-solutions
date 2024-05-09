
var maximumHappinessSum = function(happiness, k) {
    happiness.sort((a, b) => b - a);

  let ans = 0;
  let minHappiness = 0;

  for (let i = 0; i < happiness.length && k > 0; i++) {
    if (minHappiness < happiness[i]) {
      ans += happiness[i] - minHappiness;
    }
    minHappiness++;
    k--;
  }

  return ans;
};
