package ie.atu.sw;


public class MenuTemplate {

    /**
     * Menu created to which will be produced once Main in runner is called
     */
    public static void showMainMenu() {

        System.out.println(ConsoleColour.WHITE);
        System.out.println("************************************************************");
        System.out.println("*       ATU - Dept. Computer Science & Applied Physics     *");
        System.out.println("*                                                          *");
        System.out.println("*              Virtual Threaded Text Indexer               *");
        System.out.println("*                                                          *");
        System.out.println("************************************************************");
        System.out.println("(1) Specify Text File");
        System.out.println("(2) Specify Dictionary file");
        System.out.println("(3) Specify Google words file");
        System.out.println("(4) Specify Output File");
        System.out.println("(5) Execute");
        System.out.println("(6) Quit");
        System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
        System.out.print("Select Option [1-4]>");
        System.out.println();
    }

}