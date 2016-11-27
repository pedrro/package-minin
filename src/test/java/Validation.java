import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import Business.ProcessOrder;
import model.Inventory;
import model.Order;

import static org.junit.Assert.assertEquals;

public class Validation {

    @Test
    public void shouldValidadeInput1() throws Exception {
        ProcessOrder processOrder = new ProcessOrder();
        ArrayList<Inventory> inventories = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        inventories.add(Inventory.builder().name("Brazil").productName("Keyboard").productQuantity(2).build());
        inventories.add(Inventory.builder().name("Brazil").productName("Mouse").productQuantity(1).build());
        inventories.add(Inventory.builder().name("Argentina").productName("Mouse").productQuantity(2).build());
        orders.add(Order.builder().name("Keyboard").quantity(2).build());

        List<Inventory> shippedInventory1 = processOrder.shipProduct(orders.get(0), processOrder.filterInventory(orders.get(0).getName(), inventories));
        assertEquals("Brazil", shippedInventory1.get(0).getName());
        assertEquals("Keyboard", shippedInventory1.get(0).getProductName());
        assertEquals(2, shippedInventory1.get(0).getProductQuantity());
    }

    @Test
    public void shouldValidateInput2() throws Exception {
        ProcessOrder processOrder = new ProcessOrder();
        ArrayList<Inventory> inventories = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        inventories.add(Inventory.builder().name("Brazil").productName("Keyboard").productQuantity(2).build());
        inventories.add(Inventory.builder().name("Brazil").productName("Mouse").productQuantity(1).build());
        inventories.add(Inventory.builder().name("Argentina").productName("Mouse").productQuantity(2).build());
        orders.add(Order.builder().name("Keyboard").quantity(2).build());
        orders.add(Order.builder().name("Mouse").quantity(1).build());

        List<Inventory> shippedInventory1 = processOrder.shipProduct(orders.get(0), processOrder.filterInventory(orders.get(0).getName(), inventories));
        List<Inventory> shippedInventory2 = processOrder.shipProduct(orders.get(1), processOrder.filterInventory(orders.get(1).getName(), inventories));

        assertEquals("Brazil", shippedInventory1.get(0).getName());
        assertEquals("Keyboard", shippedInventory1.get(0).getProductName());
        assertEquals(2, shippedInventory1.get(0).getProductQuantity());
        assertEquals("Brazil", shippedInventory2.get(0).getName());
        assertEquals("Mouse", shippedInventory2.get(0).getProductName());
        assertEquals(1, shippedInventory2.get(0).getProductQuantity());
    }

    @Test
    public void shouldValidadeInput3() throws Exception {
        ProcessOrder processOrder = new ProcessOrder();
        ArrayList<Inventory> inventories = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        inventories.add(Inventory.builder().name("Brazil").productName("Keyboard").productQuantity(2).build());
        inventories.add(Inventory.builder().name("Brazil").productName("Mouse").productQuantity(1).build());
        inventories.add(Inventory.builder().name("Brazil").productName("Monitor").productQuantity(1).build());
        inventories.add(Inventory.builder().name("Chile").productName("Keyboard").productQuantity(2).build());
        inventories.add(Inventory.builder().name("Chile").productName("Monitor").productQuantity(2).build());
        inventories.add(Inventory.builder().name("Panama").productName("Mouse").productQuantity(2).build());
        inventories.add(Inventory.builder().name("Argentina").productName("Monitor").productQuantity(2).build());

        orders.add(Order.builder().name("Keyboard").quantity(3).build());
        orders.add(Order.builder().name("Mouse").quantity(1).build());
        orders.add(Order.builder().name("Monitor").quantity(2).build());

        List<Inventory> shippedInventory1 = processOrder.shipProduct(orders.get(0), processOrder.filterInventory(orders.get(0).getName(), inventories));
        List<Inventory> shippedInventory2 = processOrder.shipProduct(orders.get(1), processOrder.filterInventory(orders.get(1).getName(), inventories));
        List<Inventory> shippedInventory3 = processOrder.shipProduct(orders.get(2), processOrder.filterInventory(orders.get(2).getName(), inventories));

        assertEquals("Brazil", shippedInventory1.get(0).getName());
        assertEquals("Keyboard", shippedInventory1.get(0).getProductName());
        assertEquals(2, shippedInventory1.get(0).getProductQuantity());
        assertEquals("Chile", shippedInventory1.get(1).getName());
        assertEquals("Keyboard", shippedInventory1.get(1).getProductName());
        assertEquals(1, shippedInventory1.get(1).getProductQuantity());

        assertEquals("Brazil", shippedInventory2.get(0).getName());
        assertEquals("Mouse", shippedInventory2.get(0).getProductName());
        assertEquals(1, shippedInventory2.get(0).getProductQuantity());

        assertEquals("Brazil", shippedInventory3.get(0).getName());
        assertEquals("Monitor", shippedInventory3.get(0).getProductName());
        assertEquals(1, shippedInventory3.get(0).getProductQuantity());
        assertEquals("Chile", shippedInventory3.get(1).getName());
        assertEquals("Monitor", shippedInventory3.get(1).getProductName());
        assertEquals(1, shippedInventory3.get(1).getProductQuantity());


    }
}
