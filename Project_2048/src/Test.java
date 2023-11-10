public class Test {
    public Test(){

    }
    public static void main(String[] args) {
        Test t=new Test();
        int[] arr={1,2,3};
        t.change(arr);
        t.print(arr);
    }
    void change(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]++;
        }
    }
    void print(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}