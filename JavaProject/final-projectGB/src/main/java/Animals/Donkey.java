package Animals;

import java.util.List;

public class Donkey extends Pack{
    public Donkey(String name) {
        super(name, "Donkey");
    }

    public Donkey(String name, List<String> commands) {
        super(name, commands,"Donkey");
    }
}
