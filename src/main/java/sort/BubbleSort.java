package sort;

public class BubbleSort implements ISort{
    @Override
    public void sort(int[] arr) {
        //stable sort
        //inplace sort
        for(int i = 0; i<arr.length-1 ; i++){ // 전체 리스트 for
            for(int j = 0; j<arr.length-1-i; j++){ // 정렬된 리스트 for
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
