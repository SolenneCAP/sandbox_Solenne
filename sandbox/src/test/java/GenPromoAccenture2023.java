import fr.simplon.sandbox.JavaFileGenerator;
import fr.simplon.sandbox.db.Database;
import fr.simplon.sandbox.db.MysqlDatabase;
import fr.simplon.sandbox.db.dbobjects.User;
import fr.simplon.sandbox.db.dbservices.UserServices;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Scanner;

public class GenPromoAccenture2023
{
    public static void main(String[] args)
    {
        // Récupération d'une BDD MySQL
        Database database = MysqlDatabase.getInstance("root","root","localhost", 3306,"binomotronms");
        UserServices userServices = new UserServices(database);

        // Récupérer nom des utilisateurs
        List<User> userList = userServices.findAll();
        JavaFileGenerator gen = new JavaFileGenerator("fr.simplon.sandbox.PromoAccenture_2023");
        for (User user : userList) {
            gen.addMethod("fr.simplon.sandbox.Apprenant", user.firstName() + user.lastName(), "return null;");


        }

        // Configuration de la classe à générer

      //  gen.addImport("java.util.HashMap");

        // Génération du fichier
        File srcDir = new File("src/main/java");
        try {
            gen.writeTo(srcDir);
        }
        catch (FileAlreadyExistsException pE) {
            System.out.println("Le fichier existe déjà, voulez-vous l'écraser ? (N/y) ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            while(s == null || s.isEmpty() || ("y".equalsIgnoreCase(s.trim()) && "n".equalsIgnoreCase(s.trim()))){
                s = scanner.nextLine();
            }
            if ("y".equalsIgnoreCase(s))
            {
                try
                {
                    System.out.print("Ecrasement du fichier...");
                    gen.writeTo(srcDir, true);
                    System.out.println("OK");
                }
                catch (IOException pEx)
                {
                    pE.printStackTrace();
                }
            }
        }
        catch (IOException pE) {
            pE.printStackTrace();
        }
    }
}
