package adapter;

import adaptee.BinarySearch;
import adaptee.QuickSort;
import operation.ScoreOperation;

import java.util.Arrays;

public class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj;
    private BinarySearch searchObj;

    public OperationAdapter(){
        this.sortObj = new QuickSort();
        this.searchObj = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array,key);
    }

    /**
     * 优点:
     * 1.将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有
     * 结构。
     * 2.增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而
     * 言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。
     * 3.灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修
     * 改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
     *
     * 缺点:
     * 1.系统需要使用一些现有的类，而这些类的接口（如方法名）不符合系统的需要，甚至没有
     * 这些类的源代码。
     * 2.想创建一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可
     * 能在将来引进的类一起工作。
     *
     * @param args
     */
    public static void main(String[] args) {
        ScoreOperation operation = new OperationAdapter();
        int scores[] = {84,76,50,69,90,91,88,96}; //定义成绩数组
        int[] sort = operation.sort(scores);
        System.out.println(Arrays.toString(sort));

        int search = operation.search(sort, 90);
        if (search!= -1){
            System.out.println("找到成绩90");
        }else {
            System.out.println("没有找到成绩90");
        }
    }
}
