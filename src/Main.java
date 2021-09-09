import java.sql.*;
import java.util.Scanner;
public class Main {

    private static Object Conifers;
    private static Object LeafTrees;
    private static Object Perenials;

    public static void main(String[] args) {

        DBConnection FloraDb = new DBConnection();
        Scanner input = new Scanner(System.in);

        System.out.println("======== WELCOME TO GARDEN APPLICATION! +++++++++\n");
        System.out.println("Please choose one of two options:\n");
        int menuEntry;
        do{
            System.out.println("1.) Please suggest a plant based on conditions.");
            System.out.println("2.) Would like to choose a plant from a list.");
            System.out.println("Enter Your Menu Choice: ");

            menuEntry = input.nextInt();
        }

        while(menuEntry >3);

       switch(menuEntry) {

           case 1:
               int type;
               System.out.println("Please select one of following plant type:");
               System.out.println("1.) Conifers");
               System.out.println("2.) Leaf Trees");
               System.out.println("3.) Perennials");

               type = input.nextInt();
               switch (type) {
                   case 1 :
                       FloraDb.getConifers();
                       break;
                   case 2:
                       FloraDb.getLeafTree();
                       break;
                   case 3:
                       FloraDb.getPerenials();
                       break;
                   default:
                       throw new IllegalStateException("Unexpected value: " + type);
               }

               int soil;
               System.out.println("What type of soil do you have in your garden, please select:");
               System.out.println("1.) clay soil");
               System.out.println("2.) sandy soil");
               System.out.println("3.) clay sand soil");
               System.out.println("4.) loam soil");
               System.out.println("5.) peat soil");

               soil = input.nextInt();
              /* switch (soil) {
                   case 1:
                       System.out.println("Plants that prefer clay soil");
                       FloraDb.findPlantBySoil();
                       break;
                   case 2:
                       System.out.println("Plants that prefer sandy soil");
                       FloraDb.findPlantBySoil();
                       break;
                   default:
                       throw new IllegalStateException("Unexpected value: " + soil);
               }*/


               int light;
               System.out.println("Please select light conditions:");
               System.out.println("1.) sunny");
               System.out.println("2.) shady");

               light = input.nextInt();

               int height;
               System.out.println("Please select the willing height:");
               System.out.println("1.) 0-50 cm");
               System.out.println("2.) 51-100 cm");
               System.out.println("3.) 101-200 cm");
               System.out.println("4.) above 200 cm");

               System.out.println("Please pick a random plant");
               System.out.println("Exit");

               break;

           default:
               System.out.println("menu item does not exist");

           case 2:
               int type2;
               System.out.println("Please select one of following plant type:");
               System.out.println("1.) Conifers");
               System.out.println("2.) Leaf Trees");
               System.out.println("3.) Perennials");
               System.out.println("4.) Exit");

               type2 = input.nextInt();

               switch (type2) {
                   case 1 :
                       System.out.println("Here is the list of Conifers:");
                       FloraDb.getConifers();
                       break;

                   case 2:
                       System.out.println("Here is the list of LeafTrees:");
                       FloraDb.getLeafTree();
                       break;

                   case 3:
                       System.out.println("Here is the list of Perenials:");
                       FloraDb.getPerenials();
                       break;

                   default:
                       throw new IllegalStateException("Unexpected value: " + type2);
               }
               break;
       }


        // Bad Menu Option Direct
        if (menuEntry > 2 || menuEntry < 1){
            System.out.println("This is not a valid Menu Option! Please Select Another.");
            do{
                menuEntry = input.nextInt();
            }
            while(menuEntry < 3 );
        }



    }
}
