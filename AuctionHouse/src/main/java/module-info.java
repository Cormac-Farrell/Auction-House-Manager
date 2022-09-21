module com.example.auctionhouse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.auctionhouse to javafx.fxml;
    exports com.example.auctionhouse;
}