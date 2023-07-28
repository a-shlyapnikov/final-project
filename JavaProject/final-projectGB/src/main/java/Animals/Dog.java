package Animals;

import java.util.List;

public class Dog extends Pet{
    public Dog(String name) {
        super(name, "Dog");
    }

    public Dog(String name, List<String> commands) {
        super(name, commands, "Dog");
    }
}
