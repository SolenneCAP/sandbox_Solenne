package fr.simplon.tpihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController
{
    @FXML
    private Button    mButtonConnect;
    @FXML
    private Label     mLabelWelcome;
    @FXML
    private TextField mTextLogin;

    @FXML
    public void onButtonConnectAction()
    {
        mLabelWelcome.setText("Welcome " + mTextLogin.getText() + " !");
    }
}
