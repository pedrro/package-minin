package Business;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import model.Inventory;
import model.Order;

import static org.junit.Assert.assertEquals;

public class InputTest {
    private Input input;
    private String INVENTORY_LINE = "Brazil Keyboard 2";
    private String ORDER_LINE = "Keyboard 2";
    private String BLANK_LINE = "";

    @Before
    public void setUp() throws Exception {
        input = new Input();
    }

    @Test
    public void shouldReturnIsInventory() throws Exception {
        assertEquals("isInventory", input.lineStatus(INVENTORY_LINE.split(" ")));
    }

    @Test
    public void shouldReturnIsOrder() throws Exception {
        assertEquals("isOrder", input.lineStatus(ORDER_LINE.split(" ")));
    }

    @Test
    public void shouldReturnIsBlank() throws Exception {
        assertEquals("isBlank", input.lineStatus(BLANK_LINE.split("")));
    }

    @Test
    public void shouldBuildAnInventory() throws Exception {
        ArrayList<Inventory> inventories = input.buildInventory(INVENTORY_LINE.split(" "));

        assertEquals("Brazil", inventories.get(0).getName());
        assertEquals("Keyboard", inventories.get(0).getProductName());
        assertEquals(2, inventories.get(0).getProductQuantity());
    }

    @Test
    public void shouldBuildAnOrder() throws Exception {
        ArrayList<Order> Orders = input.buildOrder(ORDER_LINE.split(" "));

        assertEquals("Keyboard", Orders.get(0).getName());
        assertEquals(2, Orders.get(0).getQuantity());
    }
}