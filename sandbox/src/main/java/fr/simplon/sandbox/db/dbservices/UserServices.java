package fr.simplon.sandbox.db.dbservices;

import fr.simplon.sandbox.db.Database;
import fr.simplon.sandbox.db.dbobjects.Role;
import fr.simplon.sandbox.db.dbobjects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserServices
{
    public static final String TABLE_NAME = "aprennants";

    private Database mDatabase;

    public UserServices(Database pDatabase)
    {
        mDatabase = pDatabase;
    }

    /**
     * Recupère la liste de tous les utilisateurs en base de données.
     *
     * @return la liste de tous les apprenants.
     */
    public List<User> findAll()
    {
        List<User> result = new ArrayList<>();
        try (Connection connection = mDatabase.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("SELECT id, mail, prenom, nom FROM " + TABLE_NAME);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                int i = 1;
                int id = resultSet.getInt(i++);
                String login = resultSet.getString(i++);
                String prenom = resultSet.getString(i++);
                String nom = resultSet.getString(i++);

                User user = new User(id, login, prenom, nom, Role.Apprenant);
                result.add(user);
            }
        }
        catch (SQLException pE)
        {
            pE.printStackTrace();
        }
        return result;
    }

    public User getUser(String login, String password)
    {
        User result = null;
        try (Connection connection = mDatabase.getConnection(login, password))
        {
            PreparedStatement statement = connection.prepareStatement("SELECT id, prenom, nom, id_role FROM " + TABLE_NAME + " WHERE login=?");

            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                int i = 1;
                int id = resultSet.getInt(i++);
                String prenom = resultSet.getString(i++);
                String nom = resultSet.getString(i++);
                int idRole = resultSet.getInt(i++);
                Optional<Role> optionalRole = Arrays.stream(Role.values()).filter(r -> r.ordinal() == idRole).findAny();
                result = new User(id, login, prenom, nom, optionalRole.orElse(Role.Apprenant));
            }
        }
        catch (SQLException pE)
        {
            pE.printStackTrace();
            System.out.println("Nom d'utilisateur ou mot de passe incorrect: '" + login + "'");
        }
        return result;
    }
}
