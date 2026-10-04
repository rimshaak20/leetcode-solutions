class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        int[] arr=new int[256];
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){        //hashing characters
            arr[s.charAt(i)]++;
        }

        while(n>0){
            int m=0;
            int pos=-1;
            for(int i=0; i<256; i++){
                if(m<arr[i]){
                    m=arr[i];
                    pos=i;
                }
            }
            if(m==0)    break;
            n=n-m;
            while(m>0){
                sb.append((char)(pos));
                m--;
            }
            arr[pos]=0;
        }
        return sb.toString();
    }
}