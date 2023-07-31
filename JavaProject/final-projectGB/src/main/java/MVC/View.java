package MVC;

public class View {
    private String mainMenu;


    public View() {
        this.mainMenu = createMainMenu();
    }

    public void showMenu(){
        System.out.println(mainMenu);
    }

    private String createMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Main menu:\n");
        sb.append("1. Add new animal\n");
        sb.append("2. Teach command\n");
        sb.append("3. Get commands\n");
        sb.append("0.Exit\n");
        return sb.toString();
    }
    public void enterAnimalType(){
        System.out.println("Enter animal type: ");
    }
    public void enterName(){
        System.out.println("Enter animal name: ");
    }
}
