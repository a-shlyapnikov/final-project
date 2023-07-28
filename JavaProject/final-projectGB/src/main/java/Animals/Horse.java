package Animals;

import java.util.List;

public class Horse extends Pack{
    public Horse(String name) {
        super(name, "Horse");
    }

    public Horse(String name, List<String> commands) {
        super(name, commands, "Horse");
    }
}
