package fr.simplon.resistron;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

import java.math.BigDecimal;

/**
 * Controller of the Resistron view.
 * <p>
 * Each resistor ring is independant and had its own variables (color buttons and sum up text field).
 */
public class ResistronController {

    @FXML
    private Button mButtonBlack1;

    @FXML
    private Button mButtonBlack2;

    @FXML
    private Button mButtonBlack3;

    @FXML
    private Button mButtonBlue1;

    @FXML
    private Button mButtonBlue2;

    @FXML
    private Button mButtonBlue3;

    @FXML
    private Button mButtonBlue4;

    @FXML
    private Button mButtonBrown1;

    @FXML
    private Button mButtonBrown2;

    @FXML
    private Button mButtonBrown3;

    @FXML
    private Button mButtonBrown4;

    @FXML
    private Button mButtonGold3;

    @FXML
    private Button mButtonGold4;

    @FXML
    private Button mButtonGray1;

    @FXML
    private Button mButtonGray2;

    @FXML
    private Button mButtonGray3;

    @FXML
    private Button mButtonGray4;

    @FXML
    private Button mButtonGreen1;

    @FXML
    private Button mButtonGreen2;

    @FXML
    private Button mButtonGreen3;

    @FXML
    private Button mButtonGreen4;

    @FXML
    private Button mButtonOrange1;

    @FXML
    private Button mButtonOrange2;

    @FXML
    private Button mButtonOrange3;

    @FXML
    private Button mButtonRed1;

    @FXML
    private Button mButtonRed2;

    @FXML
    private Button mButtonRed3;

    @FXML
    private Button mButtonRed4;

    @FXML
    private Button mButtonSilver3;

    @FXML
    private Button mButtonSilver4;

    @FXML
    private Button mButtonViolet1;

    @FXML
    private Button mButtonViolet2;

    @FXML
    private Button mButtonViolet3;

    @FXML
    private Button mButtonViolet4;

    @FXML
    private Button mButtonWhite1;

    @FXML
    private Button mButtonWhite2;

    @FXML
    private Button mButtonWhite3;

    @FXML
    private Button mButtonYellow1;

    @FXML
    private Button mButtonYellow2;

    @FXML
    private Button mButtonYellow3;

    @FXML
    private Line mLine1;

    @FXML
    private Line mLine2;

    @FXML
    private Line mLine3;

    @FXML
    private Line mLine4;

    @FXML
    private TextField mTextFieldResistorTolerance;

    @FXML
    private TextField mTextFieldResistorValue;

    @FXML
    private TextField mTextFieldRing1;

    @FXML
    private TextField mTextFieldRing2;

    @FXML
    private TextField mTextFieldRing3;

    @FXML
    private TextField mTextFieldRing4;

    private int mValue1;
    private int mValue2;
    private double mValue3;
    private double mValue4;

    private Paint mColorRing1;
    private Paint mColorRing2;
    private Paint mColorRing3;
    private Paint mColorRing4;

    /**
     * Initializes the view with default valules. Text field of resistor value and tolerance are not editable.
     */
    @FXML
    private void initialize()
    {
        updateView();
        mTextFieldResistorValue.setEditable(false);
        mTextFieldResistorTolerance.setEditable(false);
    }

    /**
     * This method is called when user clicks on a color button.
     * The resistor drawing is updated with the color of the button (only the matching ring is updated).
     * We also compute the new resistor value according to previous values entered byt user.
     *
     * @param event The click event.
     */
    @FXML
    void onColorButtonAction(ActionEvent event)
    {
        Button button = (Button) event.getSource(); // Cast explicite pour convertir de Object vers Button
        Paint buttonColor = button.getBackground().getFills().get(0).getFill();

        // Black buttons
        if (button == mButtonBlack1) {
            mValue1 = 0;
            mColorRing1 = buttonColor;
        } else if (button == mButtonBlack2) {
            mValue2 = 0;
            mColorRing2 = buttonColor;
        } else if (button == mButtonBlack3) {
            mValue3 = 1;
            mColorRing3 = buttonColor;
        }

        // Brown buttons
        if (button == mButtonBrown1) {
            mValue1 = 1;
            mColorRing1 = buttonColor;
        } else if (button == mButtonBrown2) {
            mValue2 = 1;
            mColorRing2 = buttonColor;
        } else if (button == mButtonBrown3) {
            mValue3 = 10;
            mColorRing3 = buttonColor;
        } else if (button == mButtonBrown4) {
            mValue4 = 1;
            mColorRing4 = buttonColor;
        }

        // Red buttons
        if (button == mButtonRed1) {
            mValue1 = 2;
            mColorRing1 = buttonColor;
        } else if (button == mButtonRed2) {
            mValue2 = 2;
            mColorRing2 = buttonColor;
        } else if (button == mButtonRed3) {
            mValue3 = 100;
            mColorRing3 = buttonColor;
        } else if (button == mButtonRed4) {
            mValue4 = 2;
            mColorRing4 = buttonColor;
        }

        // Orange buttons
        if (button == mButtonOrange1) {
            mValue1 = 3;
            mColorRing1 = buttonColor;
        } else if (button == mButtonOrange2) {
            mValue2 = 3;
            mColorRing2 = buttonColor;
        } else if (button == mButtonOrange3) {
            mValue3 = 1000;
            mColorRing3 = buttonColor;
        }

        // Yellow buttons
        if (button == mButtonYellow1) {
            mValue1 = 4;
            mColorRing1 = buttonColor;
        } else if (button == mButtonYellow2) {
            mValue2 = 4;
            mColorRing2 = buttonColor;
        } else if (button == mButtonYellow3) {
            mValue3 = 10000;
            mColorRing3 = buttonColor;
        }

        // Green buttons
        if (button == mButtonGreen1) {
            mValue1 = 5;
            mColorRing1 = buttonColor;
        } else if (button == mButtonGreen2) {
            mValue2 = 5;
            mColorRing2 = buttonColor;
        } else if (button == mButtonGreen3) {
            mValue3 = 100000;
            mColorRing3 = buttonColor;
        } else if (button == mButtonGreen4) {
            mValue4 = 0.5;
            mColorRing4 = buttonColor;
        }

        // Blue buttons
        if (button == mButtonBlue1) {
            mValue1 = 6;
            mColorRing1 = buttonColor;
        } else if (button == mButtonBlue2) {
            mValue2 = 6;
            mColorRing2 = buttonColor;
        } else if (button == mButtonBlue3) {
            mValue3 = 1000000;
            mColorRing3 = buttonColor;
        } else if (button == mButtonBlue4) {
            mValue4 = 0.25;
            mColorRing4 = buttonColor;
        }

        // Violet buttons
        if (button == mButtonViolet1) {
            mValue1 = 7;
            mColorRing1 = buttonColor;
        } else if (button == mButtonViolet2) {
            mValue2 = 7;
            mColorRing2 = buttonColor;
        } else if (button == mButtonViolet3) {
            mValue3 = 10000000;
            mColorRing3 = buttonColor;
        } else if (button == mButtonViolet4) {
            mValue4 = 0.1;
            mColorRing4 = buttonColor;
        }

        // Gray buttons
        if (button == mButtonGray1) {
            mValue1 = 8;
            mColorRing1 = buttonColor;
        } else if (button == mButtonGray2) {
            mValue2 = 8;
            mColorRing2 = buttonColor;
        } else if (button == mButtonGray3) {
            mValue3 = 100000000;
            mColorRing3 = buttonColor;
        } else if (button == mButtonGray4) {
            mValue4 = 0.05;
            mColorRing4 = buttonColor;
        }

        // White buttons
        if (button == mButtonWhite1) {
            mValue1 = 9;
            mColorRing1 = buttonColor;
        } else if (button == mButtonWhite2) {
            mValue2 = 9;
            mColorRing2 = buttonColor;
        } else if (button == mButtonWhite3) {
            mValue3 = 1000000000;
            mColorRing3 = buttonColor;
        }

        // Gold buttons
        if (button == mButtonGold3) {
            mValue3 = 0.1;
            mColorRing3 = buttonColor;
        } else if (button == mButtonGold4) {
            mValue4 = 5;
            mColorRing4 = buttonColor;
        }

        // Silver buttons
        if (button == mButtonSilver3) {
            mValue3 = 0.01;
            mColorRing3 = buttonColor;
        } else if (button == mButtonSilver4) {
            mValue4 = 10;
            mColorRing4 = buttonColor;
        }

        updateView();
    }

    /**
     * This method takes the model current values and sends them to the graphical user interface fields.
     * Value of the resistor is updated first and is formatted to be human-readable.
     * @see #getHumanReadableResistorValueFromNumber(double)
     * @see #getHumanReadableMultiplierValueFromNumber(double)
     */
    private void updateView()
    {
        mTextFieldRing1.setText(String.valueOf(mValue1));
        mTextFieldRing2.setText(String.valueOf(mValue2));
        mTextFieldRing3.setText(String.valueOf(getHumanReadableMultiplierValueFromNumber(mValue3)));
        mTextFieldRing4.setText(String.valueOf(mValue4));

        BigDecimal tolerance = BigDecimal.valueOf(mValue4).divide(BigDecimal.valueOf(100));
        BigDecimal resistance =
                BigDecimal.valueOf(mValue1).multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(mValue2)).multiply(BigDecimal.valueOf(mValue3));

        try {
            mTextFieldResistorTolerance.setText(BigDecimal.valueOf(mValue4).toBigIntegerExact().toString() + "%");
        } catch (Exception e) {
            mTextFieldResistorTolerance.setText(String.valueOf(mValue4) + "%");
        }

        String humanReadableValue = getHumanReadableResistorValueFromNumber(resistance.doubleValue());
        mTextFieldResistorValue.setText(humanReadableValue);

        mLine1.setStroke(mColorRing1);
        mLine2.setStroke(mColorRing2);
        mLine3.setStroke(mColorRing3);
        mLine4.setStroke(mColorRing4);
    }

    /**
     * Transforms a resistor value into a human-friendly string with units for kilos (k), millions (M) and billions (G).
     * @param number The number to format.
     * @return A user-friendly string representing the number.
     */
    public static String getHumanReadableResistorValueFromNumber(double number)
    {
        if (number >= 1000_000_000) {
            return String.format("%.1f GΩ", BigDecimal.valueOf(number).divide(BigDecimal.valueOf(1000_000_000.0)));
        }
        if (number >= 1000_000.0) {
            return String.format("%.1f MΩ", BigDecimal.valueOf(number).divide(BigDecimal.valueOf(1000_000.0)));
        }
        if (number >= 1000) {
            return String.format("%.1f kΩ", BigDecimal.valueOf(number).divide(BigDecimal.valueOf(1000.0)));
        }
        return BigDecimal.valueOf(number).toBigInteger().toString();
    }

    /**
     * Transforms a resistor tolerance into a human-friendly string with no unit.
     * @param number The number to format.
     * @return A user-friendly string representing the number.
     */
    public static String getHumanReadableMultiplierValueFromNumber(double number)
    {
        if (number >= 1000_000_000) {
            return String.format("%.0f.G", BigDecimal.valueOf(number).divide(BigDecimal.valueOf(1000_000_000.0)));
        }
        if (number >= 1000_000.0) {
            return String.format("%.0fM", BigDecimal.valueOf(number).divide(BigDecimal.valueOf(1000_000.0)));
        }
        if (number >= 1000) {
            return String.format("%.0fk", BigDecimal.valueOf(number).divide(BigDecimal.valueOf(1000.0)));
        }
        return BigDecimal.valueOf(number).toBigInteger().toString();
    }
}
