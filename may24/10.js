
var kthSmallestPrimeFraction = function (arr, k) {
    let fractions = [], ans = []
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            fractions.push([arr[i] / arr[j], arr[i], arr[j]])
        }
    }
    fractions.sort((a, b) => a[0] - b[0]);

    return [fractions[k - 1][1], fractions[k - 1][2]]
};
