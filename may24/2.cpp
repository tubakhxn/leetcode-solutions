class Solution {
public:
    int findMaxK(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        if(nums[0]>0 || nums[nums.size()-1] <0) return -1;
        int i=0,j=nums.size()-1;
        while(i<j){
           if(nums[i]+nums[j] == 0) return nums[j];
           else if((nums[i]+nums[j]) < 0) i++;
           else j--;

           if(nums[i] >0 || nums[j]<0) break;
        }
        return -1;
    }
};
