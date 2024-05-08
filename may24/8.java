class Solution {
    public String[] findRelativeRanks(int[] score) {
        int lenScore = score.length;
        List<String> answerList = new ArrayList<>(Collections.nCopies(lenScore, ""));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0], a[0]); // Max heap based on score
            }
        });

        String[] rank = { "Gold Medal", "Silver Medal", "Bronze Medal" };

        for (int index = 0; index < score.length; index++) {
            maxHeap.add(new int[] { score[index], index });
        }

        int number = 1;
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int index = top[1];
            if (number < 4) {
                answerList.set(index, rank[number - 1]);
            } else {
                answerList.set(index, String.valueOf(number));
            }
            number++;
        }

        // Convert List<String> to String[] for return
        String[] answer = new String[answerList.size()];
        answer = answerList.toArray(answer);
        return answer;
    }
}
