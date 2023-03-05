import fr.simplon.sandbox.JavaFileGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class JavaFileGeneratorTest
{
    public static void main(String[] args)
    {
        // Configuration de la classe à générer
        JavaFileGenerator gen = new JavaFileGenerator("fr.simplon.sandbox.SomeClass");
        gen.addImport("java.util.HashMap");
        gen.addMethod("java.util.HashMap", "doSomething", "return new HashMap<>();");

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
