
public class Main {
    public static void main(String[] args) {
        MyContainer a = new MyContainer();

        for(int i = 1; i < 20; ++i)
            a.add(i);

        a.setValue(100, 6);
        System.out.println("value at 6 index after changes: " + a.getValue(6));
        a.removeAt(10);
        a.add(1);
        a.add(2);
        a.add(3);
        a.removeAt(a.size() - 1);
        System.out.println("size: " + a.size());
        System.out.println("value at 6 index: " + a.getValue(6));
        System.out.println("value at 10 index: " + a.getValue(10));
        System.out.println("---------------");

        for(int elem : a)
        {
            System.out.println(elem);
        }
    }
}