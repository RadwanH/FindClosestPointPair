import java.awt.geom.Point2D;

public class QuickSort {


    /**
     * Default Contructor
     */
    public QuickSort() {
        //Empty constructor --- do nothing

    }

    /**
     * The main function that implements QuickSort
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @param orderBy    --> compareX or compareY
     *                   compareX: sort minimum to maximum arr[] by X point
     *                   compareY: sort minimum to maximum arr[] by Y point
     */
    public void sort(Point2D.Double[] arr, int startIndex, int lastIndex, String orderBy) {
        if (orderBy.equals("compareX")) {
            int size = lastIndex - startIndex + 1;
            if (size <= 3){
                if (size <= 1){
                    return;
                }
                if (size == 2) {

                    if (arr[startIndex].getX() > arr[lastIndex].getX()){
                        swap(arr, startIndex, lastIndex);
                    }

                    return;
                } else {

                    if (arr[startIndex].getX() > arr[lastIndex].getX()){
                        swap(arr, startIndex, lastIndex);
                    }

                    if (arr[lastIndex - 1].getX() > arr[lastIndex].getX()){
                        swap(arr, lastIndex - 1, lastIndex);
                    }

                    swap(arr, startIndex, lastIndex - 1);

                }
            }
            int partitionX = partitionX(arr, startIndex, lastIndex);

            sort(arr, startIndex, partitionX - 1, orderBy);
            sort(arr, partitionX + 1, lastIndex, orderBy);

        }


        if (orderBy.equals("compareY")) {
            int size = lastIndex - startIndex + 1;
            if (size<=3){

                if (size <= 1)
                    return;
                if (size == 2) {
                    if (arr[startIndex].getY() > arr[lastIndex].getY())
                        swap(arr, startIndex, lastIndex);
                    return;
                } else {

                    if (arr[startIndex].getY() > arr[lastIndex - 1].getY()){
                        swap(arr, startIndex, lastIndex - 1);
                    }

                    if (arr[startIndex].getY() > arr[lastIndex].getY()){
                        swap(arr, startIndex, lastIndex);
                    }


                    if (arr[lastIndex - 1].getY() > arr[lastIndex].getY()){
                        swap(arr, lastIndex - 1, lastIndex);
                    }

                }
            }

            int partitionY = partitionY(arr, startIndex, lastIndex);

            sort(arr, startIndex, partitionY - 1, orderBy);
            sort(arr, partitionY + 1, lastIndex, orderBy);
        }
    }

    /**
     * A utility function to swap two elements
     *
     * @param arr --> Array to be sorted
     * @param i   --> first index
     * @param j   --> second index
     */
    private void swap(Point2D.Double[] arr, int i, int j) {
        Point2D.Double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Get Median of 3 order by Point.X
     *
     * @param arr   --> Array to be sorted
     * @param left  --> First index of arr[]
     * @param right --> Last index of arr[]
     * @return
     */
    private Point2D.Double getMedianX(Point2D.Double[] arr, int left, int right) {
        int centerX = (left + right) / 2;

        if (arr[left].getX() > arr[centerX].getX()){
            swap(arr, left, centerX);
        }


        if (arr[left].getX() > arr[right].getX()){
            swap(arr, left, right);
        }

        if (arr[centerX].getX() > arr[right].getX()){
            swap(arr, centerX, right);
        }


        swap(arr, centerX, right - 1);
        return arr[right - 1];
    }

    /**
     * Get Median of 3 order by Point.Y
     *
     * @param arr   --> Array to be sorted
     * @param left  --> First index of arr[]
     * @param right --> Last index of arr[]
     * @return
     */
    private Point2D.Double getMedianY(Point2D.Double[] arr, int left, int right) {
        int centerY = (left + right) / 2;

        if (arr[left].getY() > arr[centerY].getY()){
            swap(arr, left, centerY);
        }


        if (arr[left].getY() > arr[right].getY()){
            swap(arr, left, right);
        }

        if (arr[centerY].getY() > arr[right].getY()){
            swap(arr, centerY, right);
        }


        swap(arr, centerY, right - 1);
        return arr[right - 1];
    }

    /**
     * This function takes median of three as pivot, places
     * the pivot element at the end of the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * Sort order by Point.X
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @return pivot index
     */
    private int partitionX(Point2D.Double[] arr, int startIndex, int lastIndex) {
        double pivotX = getMedianX(arr, startIndex, lastIndex).getX();
        int i = startIndex;
        int j = lastIndex-1;
        while (true) {
            while (arr[++i].getX() < pivotX) continue;
            while (arr[--j].getX() > pivotX) continue;

            if (i < j) {
                swap(arr, i, j);
            }

            else
                break;
        } //end-while

        swap(arr,i,lastIndex-1);// Restore the pivot

        return i;
    }

    /**
     * This function takes median of three as pivot, places
     * the pivot element at the end of the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * Sort order by Point.Y
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @return pivot index
     */
    private int partitionY(Point2D.Double[] arr, int startIndex, int lastIndex) {
        double pivotY = getMedianY(arr, startIndex, lastIndex).getY();
        int i = startIndex;
        int j = lastIndex-1;
        while (true) {
            while (arr[++i].getY() < pivotY) continue;
            while (arr[--j].getY() > pivotY) continue;

            if (i < j) {
                swap(arr,i,j);
            }
            else
                break;
        } //end-while

        swap(arr,i,lastIndex-1);// Restore the pivot

        return i;
    }

}
