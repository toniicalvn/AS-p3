package junit.com;

public class ReceiptImpl implements Receipt{

    private int value;

    public ReceiptImpl(int value){
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
