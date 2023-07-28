package Animals;

import java.util.List;

public abstract class Pack extends Animal {
    public Pack(String name, String subtype) {
        super(name, "Pack", subtype);
    }

    public Pack(String name, List<String> commands, String subtype) {
        super(name, commands, "Pack", subtype);
    }
}
