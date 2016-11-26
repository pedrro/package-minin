package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Inventory {
    String name;
    String productName;
    int productQuantity;
}
