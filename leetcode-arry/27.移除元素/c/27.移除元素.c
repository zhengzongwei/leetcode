#include <stdio.h>


int removeElement(int* nums, int numsSize, int val){
    int left = 0;
    for(int i =0;i<numsSize;i++){
        if(nums[i]!=val){
            nums[left] = nums[i];
            left++;
        }
    }
    return left;
}


// int main(int argc, char const *argv[])
// {
    

//     return 0;
// }
