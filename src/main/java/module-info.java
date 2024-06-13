module com.example.tictacv1 {
      requires javafx.controls;
      requires javafx.fxml;
    requires org.apache.logging.log4j;


    opens com.example.tictacv1 to javafx.fxml;
      exports com.example.tictacv1;
}