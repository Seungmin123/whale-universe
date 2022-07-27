public class QuickSort {

    public QuickSort() {
    }
    private void quick_sort(int[] array, int start, int end){

        if(start >= end) return; // 원소 1개일 시 종료

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            // 피벗보다 큰 데이터 찾을 때까지 루프
            while(left <= end && array[left] <= array[pivot]){
                left += 1;
            }

            // 피벗보다 작은 데이터 찾을 때까지 루프
            while(right > start && array[right] >= array[pivot]){
                right += 1;
            }

            if(left > right){
                int tempNum = array[right];
                array[right] = array[pivot];
                array[pivot] = tempNum;
            }else{
                int tempNum = array[left];
                array[left] = array[pivot];
                array[pivot] = tempNum;
            }

            // 분할 이후 각각 수행
            quick_sort(array, start, right - 1);
            quick_sort(array, right + 1, end);
        }
    }
}
