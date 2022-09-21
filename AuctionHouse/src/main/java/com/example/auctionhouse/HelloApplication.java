package com.example.auctionhouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static LinkedList<AuctionItem> AIlist = new LinkedList<>();
    public static LinkedList<Bidder> Blist = new LinkedList<>();
    public static LinkedList<Bids> Bidlist = new LinkedList<>();
    public static LinkedList<SoldItems> SIlist = new LinkedList<>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AuctionHouseGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 772, 447);
        stage.setTitle("ActionManager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void  deleteBlist() {
        Blist.head=Blist.head.next;
    }
}
