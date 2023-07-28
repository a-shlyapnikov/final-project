package Animals;

import java.util.List;

public abstract class Pet extends Animal {
    public Pet(String name, String subtype) {
        super(name, "Pet", subtype);
    }

    public Pet(String name, List<String> commands, String subtype) {
        super(name, commands, "Pet", subtype);
    }
}
