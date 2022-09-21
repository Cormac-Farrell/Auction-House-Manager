package com.example.auctionhouse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SelectType();
        SelectBidder();
        CancelItem();
        ResetCurrentBid();
    }
    int CurrentBid=0;

    /////////////////LOT CONTROLLERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @FXML
    public ListView<String> Lotlist;

    @FXML
    private TextField ItemName;

    @FXML
    private TextField ItemDescription;

    @FXML
    private TextField StartingPrice;

    @FXML
    private ChoiceBox<String> SelectType;

    @FXML
    private DatePicker DateofOrigin;

    @FXML
    private DatePicker DateofSale;

    @FXML
    private TextField TimeofSale;

    private void SelectType(){
        SelectType.getItems().add("Furniture");
        SelectType.getItems().add("Antiques");
        SelectType.getItems().add("Paintings");
        SelectType.getItems().add("Cars");
        SelectType.getItems().add("Clothes");
        SelectType.getItems().add("Misc");
        SelectType.setValue("Please select the item type");
    }


    //Commands for Buttons in Item Screen

    @FXML
    void addItem(MouseEvent event) {
        AuctionItem ai;
        HelloApplication.AIlist.addElement(ai = new AuctionItem(ItemName.getText(), SelectType.getValue(), ItemDescription.getText(), DateofOrigin.getValue(), DateofSale.getValue(), TimeofSale.getText(), Integer.parseInt(StartingPrice.getText())));
        Lotlist.getItems().addAll(ItemName.getText() + " - " + SelectType.getValue() + " - " + ItemDescription.getText() + " - " + DateofOrigin.getValue() + " - " + DateofSale.getValue() + " - " + TimeofSale.getText() + " - " + Integer.parseInt(StartingPrice.getText()));
        SelectItemBox();

    }

    public void EditItem(MouseEvent event){
        AuctionItem a;
        int selectedID = Lotlist.getSelectionModel().getSelectedIndex();
        Lotlist.getItems().remove(selectedID);
        HelloApplication.AIlist.addElement(a = new AuctionItem(ItemName.getText(), SelectType.getValue(), ItemDescription.getText(), DateofOrigin.getValue(), DateofSale.getValue(), TimeofSale.getText(), Integer.parseInt(StartingPrice.getText())));
        Lotlist.getItems().addAll(ItemName.getText() + " - " + SelectType.getValue() + " - " + ItemDescription.getText() + " - " + DateofOrigin.getValue() + " - " + DateofSale.getValue() + " - " + TimeofSale.getText() + " - " + Integer.parseInt(StartingPrice.getText()));
        SelectItemBox();

    }


    @FXML
    private void RemoveItem(){
        AuctionItem ai;
        int selectedID = Lotlist.getSelectionModel().getSelectedIndex();
        Lotlist.getItems().remove(selectedID);
        SelectItemBox();

    }

    @FXML
    private void ClearItems(){
        Lotlist.getItems().clear();
        SelectItemBox();

    }

    /////////////////Bidder CONTROLLERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FXML
    public ListView<String> bidderlist;

    @FXML
    private TextField bidderName;

    @FXML
    private TextField bidderAddress;

    @FXML
    private TextField bidderphone;

    @FXML
    private TextField bidderemail;

//Commands for Buttons in Bidder

    @FXML
    public void addBidder() {
        Bidder b;
        HelloApplication.Blist.addElement(b = new Bidder(bidderName.getText(), bidderAddress.getText(), bidderphone.getText(), bidderemail.getText()));
        bidderlist.getItems().addAll(bidderName.getText() + " - " + bidderAddress.getText() + " - " + bidderphone.getText() + " - " + bidderemail.getText() + " - " );
        SelectBidder();
    }

    @FXML
    public void RemoveBidder(){
        Bidder b;
        int selectedID = bidderlist.getSelectionModel().getSelectedIndex();
        bidderlist.getItems().remove(selectedID);
        SelectBidder();
    }

    public void EditBidder(MouseEvent event){
        Bidder b;
        int selectedID = bidderlist.getSelectionModel().getSelectedIndex();
        bidderlist.getItems().remove(selectedID);
        HelloApplication.Blist.addElement(b = new Bidder(bidderName.getText(), bidderAddress.getText(), bidderphone.getText(), bidderemail.getText()));
        bidderlist.getItems().addAll(bidderName.getText() + " - " + bidderAddress.getText() + " - " + bidderphone.getText() + " - " + bidderemail.getText() + " - " );
        SelectBidder();
    }

    @FXML
    public void ClearBidder(){
        bidderlist.getItems().clear();
        SelectBidder();
    }





    /////////////////Bid CONTROLLERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FXML
    public ListView<String> bidlist;

    @FXML
    private ChoiceBox<String> SelectBidder;

    @FXML
    private DatePicker DateofBid;

    @FXML
    private TextField TimeofBid;

    @FXML
    private TextField BidAmount;

    //Commands for Buttons in Bidding Screen

    @FXML
    public void addBid(MouseEvent event) {
        Bids f;
        if (Integer.parseInt(BidAmount.getText()) >= CurrentBid) {
            HelloApplication.Bidlist.addElement(f = new Bids(DisplayItem.getText(), SelectBidder.getValue(), TimeofBid.getText(), DateofBid.getValue(), Integer.parseInt(BidAmount.getText())));
            bidlist.getItems().addAll(DisplayItem.getText() + " - " + SelectBidder.getValue() + " - " + DateofBid.getValue() + " - " + TimeofBid.getText() + " - " + BidAmount.getText() + " - ");
            CurrentBid = 1 + Integer.parseInt(BidAmount.getText());
        } else{
            ErrorMessage();
        }

    }

    public void ResetCurrentBid(){
        int CurrentBid = 0;
    }

    @FXML
    public void EditBid(){
        Bids b;
        int selectedID = bidlist.getSelectionModel().getSelectedIndex();
        bidlist.getItems().remove(selectedID);
        HelloApplication.Bidlist.addElement(b = new Bids(DisplayItem.getText(), SelectBidder.getValue(), TimeofBid.getText(), DateofBid.getValue(), Integer.parseInt(BidAmount.getText())));
        bidlist.getItems().addAll(DisplayItem.getText() + " - " + SelectBidder.getValue() + " - " + DateofBid.getValue() + " - " + TimeofBid.getText() + " - " + BidAmount.getText() + " - ");


    }

    @FXML
    private void ErrorMessage(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Input not valid");
        errorAlert.setContentText("Please enter a bid higher than the previous");
        errorAlert.showAndWait();

    }


    @FXML
    private void RemoveBid(){
        Bidder b;
        int selectedID = bidlist.getSelectionModel().getSelectedIndex();
        bidlist.getItems().remove(selectedID);

    }

    @FXML
    private void ClearBid(){
        bidlist.getItems().clear();
        CurrentBid=0;
    }

    /////////////////MISC CONTROLLERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FXML
    private Label DisplayItem;

    @FXML
    private ChoiceBox SelectItemBox;

    @FXML
    public void SelectItemBox(){
        SelectItemBox.getItems().clear();
        SelectItemBox.getItems().addAll(Lotlist.getItems());
        SelectItemBox.setValue("Please Select an Item");
    }

    @FXML
    public void DisplatItemUpdate(){
        DisplayItem.setText((String) SelectItemBox.getValue());
    }



    @FXML
    public void SelectBidder(){
        SelectBidder.getItems().clear();
        SelectBidder.getItems().addAll(bidderlist.getItems());
        SelectBidder.setValue("Please enter your Name");

    }

    @FXML
    private void CancelItem(){
        DisplayItem.setText("Please select an Item to Bid on");
        bidlist.getItems().clear();
        CurrentBid=0;

    }

    ////////////////////////SOLD ITEM CONTROLS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @FXML
    public ListView<String> SoldItemView;

    @FXML
    public void SellItem(MouseEvent event){
        SoldItems s;
        CurrentBid=0;
        int selectedID = bidlist.getSelectionModel().getSelectedIndex();
        HelloApplication.SIlist.addElement(s = new SoldItems(DisplayItem.getText(), bidlist.getSelectionModel().getSelectedItem()));
        SoldItemView.getItems().addAll( bidlist.getSelectionModel().getSelectedItem() + " - ");
        bidlist.getItems().clear();
    }

    @FXML
    private void RemoveSoldItem(){
        SoldItems sl;
        int selectedID = SoldItemView.getSelectionModel().getSelectedIndex();
        SoldItemView.getItems().remove(selectedID);

    }
}
