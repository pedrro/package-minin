package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Inventory;
import model.Order;

public class ProcessOrder {


    public void processOrder(ArrayList<Order> orders, ArrayList<Inventory> inventory) {
        orders.forEach(order -> {
            System.out.println(shipProduct(order,filterInventory(order.getName(), inventory)));
        });
    }

    public List<Inventory> filterInventory(String productName, ArrayList<Inventory> inventory) {
        return inventory
                .stream()
                .filter(inv ->
                        inv.getProductName().equals(productName))
                .collect(Collectors.toList());
    }

    public List<Inventory> shipProduct(Order order, List<Inventory> availableInventory) {
        ArrayList<Inventory> shippedInv = new ArrayList<>();

        availableInventory.forEach(inventory -> {
            if(inventory.getProductQuantity() == order.getQuantity()) {
                shippedInv.add(inventory);
                order.setQuantity(order.getQuantity() - inventory.getProductQuantity());
            } else if (inventory.getProductQuantity() < order.getQuantity()) {
                shippedInv.add(inventory);
                order.setQuantity(order.getQuantity() - inventory.getProductQuantity());
            } else if(inventory.getProductQuantity() > order.getQuantity() && order.getQuantity() > 0) {
                shippedInv.add(Inventory.builder().name(inventory.getName()).productName(inventory.getProductName()).productQuantity(inventory.getProductQuantity() - order.getQuantity()).build());
                order.setQuantity(order.getQuantity() - inventory.getProductQuantity());
            }
        });

        return shippedInv;
    }

}
