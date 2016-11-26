package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Inventory;

public class ProcessOrder {

    public List<Inventory> filterInventory(String productName, ArrayList<Inventory> inventory) {
        return inventory
                .stream()
                .filter(inv ->
                        inv.getProductName().equals(productName))
                .collect(Collectors.toList());
    }

    public List<Inventory> shipProduct(int productQuantity, List<Inventory> availableInventory) {
        ArrayList<Inventory> shippedInv = new ArrayList<>();
        availableInventory.forEach(inventory -> {

        });

        return shippedInv;
    }



}
