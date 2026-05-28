module view {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens controller to javafx.fxml;
    exports view;
    exports controller;
}