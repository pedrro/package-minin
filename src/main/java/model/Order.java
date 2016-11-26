package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Order {
    String name;
    int quantity;
}
