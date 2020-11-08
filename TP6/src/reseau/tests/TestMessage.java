package reseau.tests;

import reseau.Message;

public class TestMessage {

    public static void main(String[] args)
    {

        testSize();
        testGetOctet();
        testToString();
    }

    private static void testSize()
    {
        Message m = new Message(117, 108, 101);
        assert m.size() == 6 : "Problème size dans message";
    }

    private static void testGetOctet()
    {
        Message m = new Message(620, 108, 101);
        assert m.getOctet(3).getValue()==108 : "Problème getOctet dans message";
    }

    private static void testToString()
    {
        Message m = new Message((short)69, (short)108, (short)101);
        assert m.toString().equals("Ele") : "Problème toString dans message";
    }

}
