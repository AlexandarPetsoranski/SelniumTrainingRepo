package pages.seleniumTraining;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private final String name;
    private final String position;
    private final String office;

    public Customer(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}
