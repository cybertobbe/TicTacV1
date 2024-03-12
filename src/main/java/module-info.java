module com.example.tictacv1 {
      requires javafx.controls;
      requires javafx.fxml;


      opens com.example.tictacv1 to javafx.fxml;
      exports com.example.tictacv1;
}