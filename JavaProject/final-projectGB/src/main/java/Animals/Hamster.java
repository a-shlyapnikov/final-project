package Animals;

import java.util.List;

public class Hamster extends Pet{
    public Hamster(String name) {
        super(name, "Hamster");
    }

    public Hamster(String name, List<String> commands) {
        super(name, commands, "Hamster");
    }
}
