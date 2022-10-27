package main;

public class Test {
    public void testEnter100() {
        Cashier c = new Cashier();
        Balance b = c.showTotal("100.0");
        assert b.result() == 95.0;       
    }
        public void testEnter101() {
        Cashier c = new Cashier();
        Balance b = c.showTotal("101.0");
        assert b.result() == 95.95;       
    }
}