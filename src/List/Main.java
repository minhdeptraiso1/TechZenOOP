package List;


public class Main {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(30);
        myArrayList.add(40);

        //System.out.println(myArrayList);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(80);
        myLinkedList.addFirst(9);

//        myLinkedList.addLast(40);
//        myLinkedList.addLast(50);

//        myLinkedList.add(2, 90);
//        myLinkedList.add(3, 91);

        myLinkedList.swap();
        myLinkedList.output();
        //System.out.println(myLinkedList);

//        System.out.println(myLinkedList.removeFirst());
//
//        System.out.println(myLinkedList.removeLast());
//
//        System.out.println(myLinkedList);
    }
}
