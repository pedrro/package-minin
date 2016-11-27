package Business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import model.Inventory;
import model.Order;

import static org.junit.Assert.assertEquals;

public class ProcessOrderTest {

    private ProcessOrder processOrder;

    @Before
    public void setUp() throws Exception {
        processOrder = new ProcessOrder();
    }

    @Test
    public void shouldFilterListByProductName() throws Exception {
        ArrayList<Inventory> inventory = new ArrayList<>();
        inventory.add(Inventory.builder().name("Brazil").productName("Keyboard").productQuantity(1).build());
        inventory.add(Inventory.builder().name("Germany").productName("Keyboard").productQuantity(1).build());
        inventory.add(Inventory.builder().name("USA").productName("Keyboard").productQuantity(1).build());
        inventory.add(Inventory.builder().name("England").productName("Mouse").productQuantity(1).build());
        List<Inventory> filteredList = processOrder.filterInventory("Keyboard", inventory);

        assertEquals(3, filteredList.size());
    }

    @Test
    public void shouldShipProductFrom3DifferentCountries() throws Exception {
        ArrayList<Inventory> inventory = new ArrayList<>();
        inventory.add(Inventory.builder().name("Brazil").productName("Keyboard").productQuantity(1).build());
        inventory.add(Inventory.builder().name("Germany").productName("Keyboard").productQuantity(1).build());
        inventory.add(Inventory.builder().name("USA").productName("Keyboard").productQuantity(1).build());
        Order order = Order.builder().name("Keyboard").quantity(4).build();
        List<Inventory> shippedProducts = processOrder.shipProduct(order,inventory);

        assertEquals(3, shippedProducts.size());
    }

    @Test
    public void shouldShipProductFrom2DifferentCountries() throws Exception {
        ArrayList<Inventory> inventory = new ArrayList<>();
        inventory.add(Inventory.builder().name("Brazil").productName("Keyboard").productQuantity(1).build());
        inventory.add(Inventory.builder().name("Germany").productName("Keyboard").productQuantity(2).build());
        inventory.add(Inventory.builder().name("USA").productName("Keyboard").productQuantity(1).build());
        Order order = Order.builder().name("Keyboard").quantity(3).build();
        List<Inventory> shippedProducts = processOrder.shipProduct(order,inventory);

        assertEquals(2, shippedProducts.size());
    }
}