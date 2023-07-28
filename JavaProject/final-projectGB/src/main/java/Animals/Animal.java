package Animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    protected String name;
    protected List<String> commands = new ArrayList<>();
    protected String type;
    protected String subtype;


    public Animal(String name, String type, String subtype) {
        this.name = name;
        this.type = type;
        this.subtype = subtype;
    }

    public Animal(String name, List<String> commands, String type, String subtype) {
        this.name = name;
        this.commands.addAll(commands);
        this.type = type;
        this.subtype = subtype;
    }

   public void addCommand(String command){
        this.commands.add(command);
   }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }
}
