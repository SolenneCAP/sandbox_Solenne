package fr.simplon.sandbox;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe permet de générer un fichier Java dans un package du <i>source directory</i> du même
 * projet.
 * <p>
 * La définition des méthodes de la classe à générer se fait via
 * {@link #addMethod(String, String, String)}.
 * <p>
 * Exemple de configuration :
 * <pre>
 *     JavaFileGenerator gen = new JavaFileGenerator("fr.simplon.sandbox.PromoAccenture2023");
 *     gen.addImport("java.util.HashMap");
 *     gen.addMethod("java.util.HashMap<String>", "doSomething", "return new HashMap<>();");
 *     try {
 *         File srcDir = new File("src/main/java");
 *         gen.writeTo(srcDir);
 *     }
 *     catch (IOException pE) {
 *         pE.printStackTrace();
 *     }
 * </pre>
 */
public class JavaFileGenerator
{
    private String       mPackageName;
    private List<String> mImports;
    private String       mClassName;
    private List<String> mMethods;

    /**
     * Constructeur.
     *
     * @param pFullClassName Le nom complet de la classe à générer, nom de package inclus.
     */
    public JavaFileGenerator(String pFullClassName)
    {
        mImports = new ArrayList<>();
        mMethods = new ArrayList<>();
        mPackageName = pFullClassName.substring(0, pFullClassName.lastIndexOf('.'));
        mClassName = pFullClassName.substring(pFullClassName.lastIndexOf('.') + 1);
    }

    /**
     * Ajoute un clause d'import dans la classe générée.
     *
     * @param pFullClassName Nom complet de la classe importée.
     */
    public void addImport(String pFullClassName)
    {
        mImports.add(pFullClassName);
    }

    /**
     * Ajoute une méthode dans la classe générée.
     *
     * @param typeDeRetour Type de retour (nom complet avec le package, non nécessaire pour le
     *                     package java.lang)
     * @param nom          Le nom de la méthode.
     * @param code         Le corps de la méthode.
     */
    public void addMethod(String typeDeRetour, String nom, String code)
    {
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        String tabulation = "\t";

        int i = typeDeRetour.indexOf('<');
        String ret = i > 0 ? typeDeRetour.substring(0, i - 1) : typeDeRetour;

        if (mImports.contains(ret) || typeDeRetour.startsWith(mPackageName))
        {
            typeDeRetour = typeDeRetour.substring(typeDeRetour.lastIndexOf('.') + 1);
        }
        sb.append(String.format("    public %s %s() { %n        %s%n    }%n", typeDeRetour, nom, code));
        mMethods.add(sb.toString());
    }

    /**
     * @return Le code de la classe générée.
     */
    public String getGeneratedCode()
    {
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        String tabulation = "\t";

        // Déclaration du package
        sb.append("package ").append(mPackageName).append(";").append(newLine).append(newLine);

        // Déclaration des imports
        for (String anImport : mImports)
        {
            sb.append("import ").append(anImport).append(";").append(newLine).append(newLine);
        }

        // Déclaration de la classe
        sb.append("public class ").append(mClassName).append(" {").append(newLine).append(newLine);

        // Déclaration des méthodes
        for (String method : mMethods)
        {
            sb.append(method).append(newLine);
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Génère le fichier java de la classe dans le bon répertoire de sources.
     *
     * @param srcDir      Répertoire de destination (ne pas inclure le package, c'est géré
     *                    automatiquement).
     * @param isOverwrite Pour indiquer s'il faut écraser le fichier s'il existe déjà.
     */
    public void writeTo(File srcDir, boolean isOverwrite) throws IOException
    {
        String packagePath = mPackageName.replaceAll("\\.", "/");
        String destDir = srcDir.getAbsolutePath() + File.separator + packagePath;
        String code = getGeneratedCode();
        OpenOption[] options = null;
        if (!isOverwrite)
        {
            options = new OpenOption[]{StandardOpenOption.CREATE_NEW};
        }
        else
        {
            options = new OpenOption[]{
                    StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING
            };
        }
        Files.writeString(new File(destDir, mClassName + ".java").toPath(), code, options);
    }

    /**
     * Génère le fichier java de la classe dans le bon répertoire de sources.
     *
     * @param srcDir Répertoire de destination (ne pas inclure le package, c'est géré *
     *               automatiquement).
     * @throws IOException En cas de problème d'écriture du fichier.
     */
    public void writeTo(File srcDir) throws IOException
    {
        writeTo(srcDir, false);
    }

}
