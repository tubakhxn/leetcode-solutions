class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<int> row(m), col(n);

        for (int i = 0; i < m; i++)
            if (grid[i][0] == 0)
                row[i]++;

        for (int j = 1; j < n; j++)
        {
            int zero = 0;
            for (int i = 0; i < m; i++)
            {
                int actual = row[i] + col[j];
                if (actual % 2)
                    zero += (grid[i][j] == 1);
                else
                    zero += (grid[i][j] == 0);
            }
            if (zero > (m / 2))
                col[j]++;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((row[i] + col[j]) % 2)
                    grid[i][j] = !grid[i][j];

        int ans = 0;
        for (int i = 0; i < m; i++)
        {
            int cur = 0;
            for (int j = n - 1; j >= 0; j--)
                if (grid[i][j])
                    cur += (1 << (n - j - 1));
            ans += cur;
        }

        return ans;    
    }
};
