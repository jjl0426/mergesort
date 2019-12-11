package MergeSort;

/**
 * 归并排序理解：
 * 1.将一个待排序的数组中的元素分为两个子序列，通过递归调用分别对两个子序列进行排序
 * 2.将两个排好序的子序列合并为一个序列：每次比较两个子序列中的最小值，选出更小值
 * 3.选取更小值，放入辅助数组
 * 4.依次将辅助数组的元素复制给原数组
 *
 * @author Administrator
 * @date 2019-12-11
 * @version
 * @description
 */
public class MergeSortTest {

    /**
     * 将子序列两路归并，放入辅助数组，依次将辅助数组的元素赋值给原数组
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int []a,int left,int mid,int right) {
        //辅助数组
        int []temp=new int[a.length];
        //p1表示左侧子序列start-index，p2表示右侧子序列start-index，k表示辅助数组start-index
        int p1=left,p2=mid+1,k=left;
        //比较并选出两个子序列中的最小值的更小值，然后赋给辅助数组
        while (p1<=mid && p2<=right) {
            if (a[p1]<=a[p2]) {
                temp[k++]=a[p1++];
            }else {
                temp[k++]=a[p2++];
            }
        }
        //序列中的元素未比较完毕，直接将元素加到辅助数组中
        while (p1<=mid) {
            temp[k++]=a[p1++];
        }
        //序列中的元素未比较完毕，直接将元素加到辅助数组中
        while (p2<=right) {
            temp[k++]=a[p2++];
        }
        //依次将辅助数组的元素复制给原数组
        for (int i = left; i <=right; i++) {
            a[i]=temp[i];
        }
    }

    /**
     * 通过递归调用分别对两个子序列进行排序,并对两个子序列进行合并
     * @param a
     * @param start
     * @param end
     */
    public void mergeSort(int []a,int start,int end) {
        //递归结束条件：子序列中只有一个元素时
        if (start<end) {
            //拆分子序列
            int mid=(start+end)/2;
            //对左侧子序列进行递归排序
            mergeSort(a, start, mid);
            //对右侧子序列进行递归排序
            mergeSort(a, mid+1, end);
            //两路归并
            merge(a, start, mid, end);
        }
    }

    public static void main(String[] args) {
        MergeSortTest sort = new MergeSortTest();
        int []a={100,78,99,56,34,67,45};
        sort.mergeSort(a, 0, a.length-1);
        System.out.println("排序后的顺序：");
        for (int i : a) {
            System.out.print(i+" ");
        }
    }




}
