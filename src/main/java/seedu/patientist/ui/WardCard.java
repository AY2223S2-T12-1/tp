package seedu.patientist.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.patientist.model.ward.Ward;

/**
 * An UI component that displays information of a {@code Ward}.
 */
public class WardCard extends UiPart<Region> {
    private static final String FXML = "WardListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on Patientist level 4</a>
     */

    public final Ward ward;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label patientCount;
    @FXML
    private Label staffCount;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public WardCard(Ward ward, int displayedIndex) {
        super(FXML);
        this.ward = ward;
        id.setText(displayedIndex + ". ");
        name.setText(ward.getWardName());
        patientCount.setText("No. of patients: " + ward.getPatientsAsUnmodifiableObservableList().size());
        staffCount.setText("No. of staffs: " + ward.getStaffsAsUnmodifiableObservableList().size());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof WardCard)) {
            return false;
        }

        // state check
        WardCard card = (WardCard) other;
        return id.getText().equals(card.id.getText())
               && ward.equals(card.ward);
    }
}
