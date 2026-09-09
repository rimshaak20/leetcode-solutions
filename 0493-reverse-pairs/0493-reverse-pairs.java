class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
   
    }
    private int mergesort(int [] arr, int low, int high){
        int cnt=0;
        if(low >= high)     return cnt;
        int mid= (low + high)/2;
        cnt+= mergesort(arr,low,mid);
        cnt+= mergesort(arr,mid+1,high);
        cnt+= comparefn(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;   
    }
    private int comparefn(int []arr, int low, int mid, int high){
        int cnt=0;  int right=mid+1;
        for(int left=low; left<=mid; left++){
            while(right <= high && (long)arr[left] > (2*(long)arr[right]))
                right++;
            cnt+= right-(mid+1);           
        }
        return cnt;
    }
    private void merge(int []arr, int low, int mid, int high){

        ArrayList<Integer> temp =new ArrayList<>();
        int left=low;   int right=mid+1;

        while(left<=mid && right<=high){
            if(arr[left]<= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }

        while(left<=mid)    temp.add(arr[left++]);
        while(right<=high)    temp.add(arr[right++]);

        for(int i=low; i<=high; i++){
            arr[i]= temp.get(i-low);
        }
        
    }
}
