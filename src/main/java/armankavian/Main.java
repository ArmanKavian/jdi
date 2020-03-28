package armankavian;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IOCContainer i = IOCContainer.INSTANCE;

        System.out.println(i.getPool());

        FirstControlClass fcc = (FirstControlClass)i.get("firstcontrolclass");
        fcc.showMessage();
        System.out.println(((SecondControlClass)i.get("secondcontrolclass")).add(2, 3));
    }
}
