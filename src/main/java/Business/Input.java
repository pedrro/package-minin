package Business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Inventory;
import model.Order;

import static java.lang.Integer.parseInt;

public class Input {

    public ArrayList<Inventory> inventories = new ArrayList<Inventory>();
    public ArrayList<Order> orders = new ArrayList<Order>();

    public void readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            checkLine(scanner.nextLine());
        }
        scanner.close();

        processFile(inventories, orders);
    }

    private void processFile(ArrayList<Inventory> inventories, ArrayList<Order> orders) {
        ProcessOrder processOrder = new ProcessOrder();
        processOrder.processOrder(orders,inventories);
    }

    public String lineStatus(String[] line) {
        if(isInventory(line)) {
            return "isInventory";
        } else if(isOrder(line)) {
            return "isOrder";
        } else {
            return "isBlank";
        }
    }

    private void checkLine(String line) {
        String[] splittedLine = line.split(" ");

        String verifiedLine = lineStatus(splittedLine);
        switch (verifiedLine) {
            case "isInventory" :
                buildInventory(splittedLine);
                break;
            case "isOrder" :
                buildOrder(splittedLine);
        }
    }

    private boolean isInventory(String[] line) {
        return line.length == 3;
    }

    private boolean isOrder(String[] line) {
        return line.length == 2;
    }

    public ArrayList<Inventory> buildInventory(String[] inventoryInformation) {
        Inventory inventory = Inventory.builder().name(inventoryInformation[0]).productName(inventoryInformation[1]).productQuantity(parseInt(inventoryInformation[2])).build();
        inventories.add(inventory);

        return inventories;
    }

    public ArrayList<Order> buildOrder(String[] orderInformation) {
        Order order = Order.builder().name(orderInformation[0]).quantity(parseInt(orderInformation[1])).build();
        orders.add(order);

        return orders;
    }
}
