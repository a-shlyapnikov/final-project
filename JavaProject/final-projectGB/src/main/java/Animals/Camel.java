package Animals;

import java.util.List;

public class Camel extends Pack{
    public Camel(String name) {
        super(name, "Camel");
    }

    public Camel(String name, List<String> commands) {
        super(name, commands,"Camel" );
    }
}
