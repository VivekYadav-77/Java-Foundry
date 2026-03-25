class MaxAreaOfHistogram{
    static int CalArea(int arr[]){
        int res = 0;
        int count;
        for(int i =0;i<arr.length;i++){
            count = 1;
            for(int j =i+1;j<arr.length-1;j++){
                if(arr[i]<=arr[j]){
                    count++;
                }else{
                    break;
                }
            }
            for (int j= i-1; j>=0;j--) {
                if(arr[i]<=arr[j]){
                    count++;
                }else{
                    break;
                }
                
            }
            System.out.println("count"+count);
            int area = count*arr[i];
            if(res<area){
                res=area;
            }
            System.out.println(res);
            
        }
        return res;
    }
    public static void main(String[] args) {
        int arr []={11,3,4,4,1,5,7};
        int maxarea = CalArea(arr);
        System.out.println("Max area is :"+maxarea);
    }
}