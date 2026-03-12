public class SearchingSorting {

    public static void quickSortByPriority(Task[] arr,int low,int high){

        if(low<high){

            int pi = partition(arr,low,high);

            quickSortByPriority(arr,low,pi-1);

            quickSortByPriority(arr,pi+1,high);

        }

    }

    private static int partition(Task[] arr,int low,int high){

        Task pivot = arr[high];

        int i = low-1;

        for(int j=low;j<high;j++){

            if(arr[j].priority > pivot.priority){

                i++;

                Task temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

            }

        }

        Task temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;

    }

}