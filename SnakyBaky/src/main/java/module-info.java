module com.example.snakybaky {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakybaky to javafx.fxml;
    exports com.example.snakybaky;
}