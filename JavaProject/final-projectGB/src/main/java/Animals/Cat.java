package Animals;

import java.util.List;

public class Cat extends Pet{
    public Cat(String name) {
        super(name, "Cat");
    }

    public Cat(String name, List<String> commands) {
        super(name, commands, "Cat");
    }
}
