import setofarraylists.Myarraylist;

public class Main {
    public static void main(String[] args) {
        Myarraylist<Integer> myarraylist = new Myarraylist<>();
        myarraylist.add(3);
        myarraylist.add(5);
        myarraylist.add(7);
        myarraylist.add(9);
        myarraylist.add(1);
        myarraylist.add(2);

        myarraylist.addFirst(99);
        myarraylist.addLast(99);
        System.out.println(myarraylist.getFirst());
        System.out.println(myarraylist.getLast());
        myarraylist.removeFirst();
        myarraylist.removeLast();
        myarraylist.remove(0);
        System.out.println(myarraylist.size());
        for(int i=0; i<myarraylist.size(); i++){
            System.out.println(myarraylist.get(i));
        }

    }
}
