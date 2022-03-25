import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args){
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1) List the first n recorde where type: TV Show");
            System.out.println("2) List the first n recorde where Listed_in: Horror Movies");
            System.out.println("3) List the first n type: Movie where country: India");
            System.out.println("0) Exit\n");

            System.out.print("\n Make your choice: ");
            option = sc.nextInt();

            ReadCsv readCsv = new ReadCsv();
            readCsv.readCsv("/Users/akagaikwad/Documents/Assignment2/NetflixDataAnalysis/netflix_titles.csv");
            switch (option) {
                case 1:
                    readCsv.getData( "Type", "TV Show","all");
                    break;
                case 2:
                    readCsv.getData( "Genre", "Horror Movies","all");
                    break;
                case 3:
                    readCsv.getData( "Type", "Movie","India");
                    break;
                case 0:
                    System.out.println(" ***Thank you For using the service *** \n");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \n\n");
            }
        } while (option !=0);
    }
}
