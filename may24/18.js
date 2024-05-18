var distributeCoins = function(root) {
        const dfs = (curNode, parent) => {
            if (curNode === null) {
                return 0;
            }
            let moves = dfs(curNode.left, curNode) + dfs(curNode.right, curNode);
            let fromThis = curNode.val - 1;
            parent.val += fromThis;
            moves += Math.abs(fromThis);
            return moves;
        };

        return dfs(root, new TreeNode()); 
};
