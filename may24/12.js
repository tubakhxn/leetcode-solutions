/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var largestLocal = function (grid) {
    const nRows = grid.length;
    const nCols = grid[0].length;

    let result = new Array(nRows - 2).fill().map(() => new Array(nCols - 2).fill(0));

    for (let row = 0; row < nRows - 2; row++) {
        for (let col = 0; col < nCols - 2; col++) {
            result[row][col] = findLargest(grid, row, col);
        }
    }

    return result;
};

function findLargest(grid, row, col) {
    let best = grid[row][col];
    for (let i = row; i < row + 3; i++) {
        for (let j = col; j < col + 3; j++) {
            best = Math.max(best, grid[i][j]);
        }
    }
    return best;
}
