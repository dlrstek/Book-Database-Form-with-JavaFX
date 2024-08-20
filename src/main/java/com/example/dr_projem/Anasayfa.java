package com.example.dr_projem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Date;



public class Anasayfa extends Application {

    // GIRIS SAYFASI 1.SCENE
    private Label lb1_email = new Label("Kullanıcı Adı:");
    private TextField tfkullanici_adi1 = new TextField();
    private Label lb2_sifre = new Label("Şifre:");
    private TextField tfmusteri_sifre1 = new TextField();
    private Button btGirisYap = new Button("Giriş Yap");
    private Button btUyeOl = new Button("Üye ol");
    private Button btCikisYap = new Button("Çıkış Yap");
    private Label tekrar_dene = new Label();
    private Label giriniz = new Label();


    // ÜYELİK SAYFASI 2.SCENE
    private TextField tfmusteri_id = new TextField();
    private TextField tfmusteri_adi = new TextField();
    private TextField tfmusteri_soyadi = new TextField();
    private TextField tfmusteri_sifre = new TextField();
    private TextField tfmusteri_email = new TextField();
    private TextField tfkullanici_adi = new TextField();
    private TextField tftelefon = new TextField();
    private TextField tfcinsiyet = new TextField();
    private Text basarili = new Text();
    private Button btUyeOl2 = new Button("Üye Ol");
    private Button btGirisEkranınaGıt = new Button("Giriş Sayfasına Git");

    private int musteri_id;
    private String musteri_adi;
    private String musteri_soyadi;
    private String musteri_sifre;
    private String musteri_email;
    private String kullanici_adi;
    private String telefon;
    private String cinsiyet;

    // 3. SCENE ANASAYFA VBOX

    BorderPane borderPane=new BorderPane();
    BorderPane borderPane1=new BorderPane();
    Scene scene3= new Scene(borderPane,900,550);
    GridPane gridPane3=new GridPane();

    private Button btKitaplar = new Button("KİTAPLAR");

    private Button btHesabim = new Button("HESABIM");
    private Button btCikisYap2 = new Button("ÇIKIŞ YAP");

    // KİTAPLAR BUTONU İÇERİK SAYFASI

    private TextField tfkitap_id = new TextField();
    private TextField tfkitap_adi = new TextField();
    private TextField tfyazar_adi = new TextField();
    private TextField tfsayfa_sayisi = new TextField();
    private TextField tfkitap_fiyati = new TextField();
    private TextField tfbasim_tarihi= new TextField();
    private TextField tfyayinevi_adi =new TextField();

    private TextField tftur_adi =new TextField();
    private String kitap_adi;
    private String yazar_adi;
    private int sayfa_sayisi;
    private float kitap_fiyati;
    private java.sql.Date basim_tarihi;
    private String yayinevi_adi;

    private String tur_adi;
    private Button btara = new Button("Ara");
    private Button btara1 = new Button("Ara");
    private Button btListele = new Button("Sırala");
    private Button btGet=new Button("Getir");

    private Button btTemizle=new Button("Temizle");

    MenuItem menuItem1 = new MenuItem("Edebiyat");
    MenuItem menuItem2 = new MenuItem("Psikoloji");
    MenuItem menuItem3 = new MenuItem("Felsefe");

    MenuButton menuButton = new MenuButton("Tür seçiniz", null, menuItem1, menuItem2, menuItem3);



    private TableView<kitaplar> tableView = new TableView<>();


    // HESABIM
    GridPane gridPane4=new GridPane();
    Scene scene4= new Scene(gridPane4,900,550);

    private int adres_id;
    private String il;
    private String ilce;
    private String mahalle;
    private String cadde;
    private int bina_no;

    private TextField tfadres_id = new TextField();
    private TextField tfil = new TextField();
    private TextField tfilce = new TextField();
    private TextField tfmahalle = new TextField();
    private TextField tfcadde= new TextField();
    private TextField tfbina_no = new TextField();

    private Button btGuncelle=new Button("Güncelle");
    private Button btGet2=new Button("Getir");
    private Button btSil=new Button("Adres Kaydını Sil");
    private TableView<adresler> tableView1 = new TableView<>();

    public static void main(String[] args) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //GİRİŞ YAP 1.PAGE

        GridPane gridPane = new GridPane(); gridPane.setId("gridPane");
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(gridPane, 400, 400);


        // UYELİK SAYFASI 2. PAGE
        GridPane gridPane2 = new GridPane(); gridPane2.setId("gridPane2");
        gridPane2.setHgap(5);
        gridPane2.setVgap(5);
        gridPane2.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(gridPane2, 400, 400);

        btGirisYap.setId("btGirisYap"); btUyeOl.setId("btUyeOl");btCikisYap.setId("btCikisYap");
        lb1_email.setId("lb1_email"); lb2_sifre.setId("lb2_sifre");

        //BUTONLAR
        btGirisYap.setOnAction(e -> GirisYap(e));
        btUyeOl.setOnAction(e -> primaryStage.setScene(scene2));
        btCikisYap.setOnAction(e -> CikisYap(e));

        gridPane.add(this.lb1_email, 1, 0);
        gridPane.add(this.tfkullanici_adi1, 2, 0);

        gridPane.add(this.lb2_sifre, 1, 1);
        gridPane.add(this.tfmusteri_sifre1, 2, 1);

        gridPane.add(this.btGirisYap, 2, 2);
        gridPane.add(this.btUyeOl, 2, 3);
        gridPane.add(this.btCikisYap, 2, 4);

        gridPane.add(this.tekrar_dene, 2, 5);
        gridPane.add(this.giriniz, 2, 5);

        // UYELİK KISMI 2. PAGE

        Label UYEOL = new Label("ÜYE OL"); UYEOL.setId("UYEOL");

        //BUTONLAR
        btUyeOl2.setOnAction(e -> Uyelik(e));
        btGirisEkranınaGıt.setOnAction(e -> primaryStage.setScene(scene1));

        gridPane2.add(UYEOL, 0, 0);
        gridPane2.add(new Label("Müşteri ID: "), 0, 1);
        gridPane2.add(tfmusteri_id, 1, 1);

        gridPane2.add(new Label("Adı: "), 0, 2);
        gridPane2.add(tfmusteri_adi, 1, 2);

        gridPane2.add(new Label("Soyadı: "), 0, 3);
        gridPane2.add(tfmusteri_soyadi, 1, 3);

        gridPane2.add(new Label("Şifre:"), 0, 4);
        gridPane2.add(tfmusteri_sifre, 1, 4);

        gridPane2.add(new Label("E-mail:"), 0, 5);
        gridPane2.add(tfmusteri_email, 1, 5);

        gridPane2.add(new Label("Kullanıcı adı: "), 0, 6);
        gridPane2.add(tfkullanici_adi, 1, 6);

        gridPane2.add(new Label("Telefon: "), 0, 7);
        gridPane2.add(tftelefon, 1, 7);

        gridPane2.add(new Label("Cinsiyet: "), 0, 8);
        gridPane2.add(tfcinsiyet, 1, 8);

        gridPane2.add(this.btUyeOl2, 1, 9);
        gridPane2.add(this.btGirisEkranınaGıt, 1, 10);
        gridPane2.add(basarili, 1, 11);


        // ANASAYFA SOL MENÜ  3.scene
        VBox vBox = new VBox(40); vBox.setId("vBox");
        gridPane3.setHgap(5);
        gridPane3.setVgap(5);
        borderPane.setLeft((vBox)); borderPane.setId("borderpane");
        borderPane.setCenter(gridPane3);
        vBox.setPrefWidth(120);




        Image image= new Image("C:\\Users\\Lenovo\\IdeaProjects\\DR_PROJEM\\src\\main\\java\\com\\example\\dr_projem\\DR_logo.jpg");
        ImageView imageView= new ImageView(image);
        Button btDRimage=new Button("",imageView);
        imageView.setFitHeight(80);
        imageView.setFitWidth(100);
        // SEKME BUTONLAR
        btKitaplar.setId("btKitaplar");
        btHesabim.setId("btHesabim");
        btCikisYap2.setId("btCikisYap2");
        vBox.getChildren().addAll(btDRimage,btKitaplar,btHesabim,btCikisYap2);
        vBox.setSpacing(15);

        btCikisYap2.setOnAction(e->CikisYapButon());
        btKitaplar.setOnAction(e->Kitaplar()); // GRİD 3
        btHesabim.setOnAction(e->Hesabim()); // GRİD 4


        // kitaplar GRİD PANE
        Label lbkitap_adi=new Label("Kitap Adı:"); lbkitap_adi.setId("lbkitap_adi");
        Label lbyazar_adi=new Label("Yazar Adı: "); lbyazar_adi.setId("lbyazar_adi");
        Label lbsirala=new Label("Ucuzdan pahalıya sırala:"); lbsirala.setId("lbsirala");


        gridPane3.add(lbkitap_adi,3,0);
        gridPane3.add(tfkitap_adi, 4, 0); tfkitap_adi.setId("tfkitap_adi");
        gridPane3.add(this.btara, 5, 0);  btara.setId("btara");
        gridPane3.add(lbyazar_adi, 3, 1);
        gridPane3.add(tfyazar_adi, 4, 1); tfyazar_adi.setId("tfyazar_adi");
        gridPane3.add(this.btara1, 5, 1); btara1.setId("btara");
        gridPane3.add(lbsirala, 3, 2);
        gridPane3.add(this.btListele, 4, 2);
        gridPane3.add(this.btGet, 4, 3);

        FlowPane flowPane=new FlowPane();
        flowPane.setHgap(8);
        flowPane.setVgap(8);
        flowPane.getChildren().addAll(btGet,btTemizle,menuButton);
        gridPane3.add(flowPane, 4, 4);

        gridPane3.add(getTableView(), 4, 5);

        btara.setOnAction(e->ara1(tfkitap_adi.getText()));
        btara1.setOnAction(e->ara2(tfyazar_adi.getText()));
        tableView.setOnMouseClicked(e -> onEdit());
        btGet.setOnAction(e -> Listele());
        btTemizle.setOnAction(e->Temizle());
        btListele.setOnAction(e->UcuzPahalı());
        menuItem1.setOnAction(e->Edebiyat(tftur_adi.getText()));
        menuItem2.setOnAction(e->Psikoloji(tftur_adi.getText()));
        menuItem3.setOnAction(e->FelsefeDüsünce(tftur_adi.getText()));

        scene1.getStylesheets().add("dr.css");
        scene2.getStylesheets().add("dr.css");
        scene3.getStylesheets().add("dr.css");
        scene4.getStylesheets().add("dr.css");




        primaryStage.setTitle("GİRİŞ YAP");

        primaryStage.setScene(scene1);
        primaryStage.show();



    }

    private void FelsefeDüsünce(String Felsefe) {
        try {
            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select*from kitaplar where tur_adi ='"+Felsefe+"'");
            while (resultSet.next())
            {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));
            }

            connection.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    private void Psikoloji(String Psikoloji) {
        try {
            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM kitaplar WHERE tur_adi ='"+Psikoloji+"'");
            while (resultSet.next())
            {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));
            }

            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void Edebiyat(String Edebiyat) {
        try {

            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from kitaplar where tur_adi ='"+Edebiyat+"'");
            while (resultSet.next())
            {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));
            }

            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    private TableView getTableView1()
    {

        TableColumn<adresler, Integer> colAdresId = new TableColumn<>("Adres ID");
        colAdresId.setCellValueFactory(new PropertyValueFactory<>("adres_id"));

        TableColumn<adresler, String> colIl = new TableColumn<>("İl");
        colIl.setCellValueFactory(new PropertyValueFactory<>("il"));

        TableColumn<adresler, String> colilce = new TableColumn<>("İlçe");
        colilce.setCellValueFactory(new PropertyValueFactory<>("ilce"));

        TableColumn<adresler, String> colMahalle = new TableColumn<>("Mahalle");
        colMahalle.setCellValueFactory(new PropertyValueFactory<>("mahalle"));

        TableColumn<adresler, String> colCadde = new TableColumn<>("Cadde");
        colCadde.setCellValueFactory(new PropertyValueFactory<>("cadde"));

        TableColumn<adresler, Integer > colBina_no = new TableColumn<>("Bina no");
        colBina_no.setCellValueFactory(new PropertyValueFactory<>("bina_no"));

        tableView1.getColumns().addAll(colAdresId,colIl,colilce,colMahalle,colCadde,colBina_no);
        TableView.TableViewSelectionModel<adresler> selectionModel = tableView1.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        return tableView1;
    }

    private void Hesabim()
    {
        Label lbladresbilgilerim=new Label("ADRES BİLGİLERİM"); lbladresbilgilerim.setId("lbladresbilgilerim");
        Label lbladres_id=new Label("Adres ID:"); lbladres_id.setId("lbladres_id");
        Label lblil=new Label("İl:"); lblil.setId("lblil");
        Label lblilce=new Label("İlçe:"); lblilce.setId("lblilce");
        Label lblmahalle=new Label("Mahalle:"); lblmahalle.setId("lblmahalle");
        Label lblcadde=new Label("Cadde:"); lblcadde.setId("lblcadde");
        Label lblbina_no=new Label("Bina no:"); lblbina_no.setId("lblbina_no");

        gridPane4.setAlignment(Pos.BASELINE_CENTER);
        gridPane4.setId("gridPane4");
        borderPane.setCenter(gridPane4);

        gridPane4.add(lbladresbilgilerim, 4,0,4,1);


        gridPane4.add(lbladres_id, 4, 1);
        gridPane4.add(tfadres_id, 5, 1);

        gridPane4.add(lblil, 4, 2);
        gridPane4.add(tfil, 5, 2);

        gridPane4.add(lblilce, 4, 3);
        gridPane4.add(tfilce, 5, 3);

        gridPane4.add(lblmahalle, 4, 4);
        gridPane4.add(tfmahalle, 5, 4);

        gridPane4.add(lblcadde, 4, 5);
        gridPane4.add(tfcadde, 5, 5);

        gridPane4.add(lblbina_no, 4, 6);
        gridPane4.add(tfbina_no, 5, 6);

        tableView1.setOnMouseClicked(e -> onEdit2());
        btGet2.setOnAction(e -> Listele2());
        btGuncelle.setOnAction(e->Guncelle());
        btSil.setOnAction(e->Sil());
        FlowPane flowPane1=new FlowPane();
        flowPane1.setHgap(8);
        flowPane1.setVgap(8);
        flowPane1.getChildren().addAll(btGuncelle,btGet2,btSil);
        gridPane4.add(flowPane1, 5, 7);
        gridPane4.add(getTableView1(), 5, 8);

    }

    private void Sil() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            String queryString = "DELETE FROM adresler WHERE (adres_id=?)";
            PreparedStatement baglanti = connection.prepareStatement(queryString);
            adres_id= Integer.parseInt(tfadres_id.getText());
            baglanti.setString(1, String.valueOf((adres_id)));
            baglanti.executeUpdate();
            connection.close();
            Listele2();
            Temizle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void Guncelle() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            String queryString = "Update adresler SET il=?,ilce=?,mahalle=?,cadde=?,bina_no=? WHERE(adres_id=?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);

            il=tfil.getText();
            ilce=tfilce.getText();
            mahalle=tfmahalle.getText();
            cadde=tfcadde.getText();
            bina_no=Integer.parseInt(tfbina_no.getText());
            adres_id=Integer.parseInt(tfadres_id.getText());


            preparedStatement.setString(1,il);
            preparedStatement.setString(2,ilce);
            preparedStatement.setString(3,mahalle);
            preparedStatement.setString(4,cadde);
            preparedStatement.setInt(5,bina_no);
            preparedStatement.setInt(6,adres_id);

            int row=preparedStatement.executeUpdate();
            connection.close();
            Listele2();
            Temizle();


        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void Listele2() {
        try {
            tableView1.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select*from adresler");
            while (resultSet.next()) {


                adres_id=Integer.parseInt(resultSet.getString(1));
                il=resultSet.getString(2);
                ilce=resultSet.getString(3);
                mahalle=resultSet.getString(4);
                cadde =resultSet.getString(5);
                bina_no = Integer.parseInt(resultSet.getString(6));


                tableView1.getItems().add(new adresler(adres_id,il,ilce,mahalle,cadde,bina_no));
            }
            connection.close();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    private void onEdit2() {
        if (tableView1.getSelectionModel().getSelectedItem() != null) {
            adresler adresler = tableView1.getSelectionModel().getSelectedItem();

            tfadres_id.setText(String.valueOf(adresler.getAdres_id()));
            tfil.setText(adresler.getIl());
            tfilce.setText(adresler.getIlce());
            tfmahalle.setText(adresler.getMahalle());
            tfcadde.setText(adresler.getCadde());
            tfbina_no.setText(String.valueOf(adresler.getBina_no()));
        }
    }

    private void Kitaplar() {

        borderPane.setCenter(gridPane3);

    }


    private void UcuzPahalı() {
        try {
            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM kitaplar ORDER BY kitap_fiyati");

            while (resultSet.next())
            {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));
            }

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void ara2(String id) {

        try {
            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from kitaplar where yazar_adi ='"+id+"'");
            while (resultSet.next())
            {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));
            }

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }





    }

    private void Temizle() {
        tfkitap_adi.clear();
        tfyazar_adi.clear();
    }

    private void Listele() {
        try {
            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select*from kitaplar");
            while (resultSet.next()) {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));


            }

            connection.close();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    private void onEdit() {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            kitaplar kitaplar = tableView.getSelectionModel().getSelectedItem();

            tfkitap_adi.setText(kitaplar.getKitap_adi());
            tfyazar_adi.setText(kitaplar.getYazar_adi());
            tfsayfa_sayisi.setText(String.valueOf(kitaplar.getSayfa_sayisi()));
            tfkitap_fiyati.setText(String.valueOf(kitaplar.getKitap_fiyati()));
            tfbasim_tarihi.setText(String.valueOf(kitaplar.getBasim_tarihi()));
            tfyayinevi_adi.setText(kitaplar.getYayinevi_adi());
            tftur_adi.setText(kitaplar.getTur_adi());

        }
    }

    private void ara1(String id)

    {
        try {
            tableView.getItems().clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from kitaplar where kitap_adi ='"+id+"'");
            while (resultSet.next())
            {

                kitap_adi = resultSet.getString(2);
                yazar_adi = resultSet.getString(3);
                sayfa_sayisi= Integer.parseInt(resultSet.getString(4));
                kitap_fiyati= Float.parseFloat(resultSet.getString(5));
                basim_tarihi =resultSet.getDate(6);
                yayinevi_adi = resultSet.getString(7);
                tur_adi = resultSet.getString(8);

                tableView.getItems().add(new kitaplar(kitap_adi,yazar_adi,sayfa_sayisi,kitap_fiyati,basim_tarihi,yayinevi_adi,tur_adi));
            }

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void CikisYapButon()
    {
        Stage stage =(Stage) btCikisYap2.getScene().getWindow();
        stage.close();
    }


    private TableView getTableView()
    {


        TableColumn<kitaplar, String> colKitapAdi = new TableColumn<>("Kitap Adı");
        colKitapAdi.setCellValueFactory(new PropertyValueFactory<>("kitap_adi"));

        TableColumn<kitaplar, String> colYazarAdi = new TableColumn<>("Yazar Adı");
        colYazarAdi.setCellValueFactory(new PropertyValueFactory<>("yazar_adi"));

        TableColumn<kitaplar, Integer> colSayfaSayisi = new TableColumn<>("Sayfa Sayısı");
        colSayfaSayisi.setCellValueFactory(new PropertyValueFactory<>("sayfa_sayisi"));

        TableColumn<kitaplar, Float> colKitapFiyati = new TableColumn<>("Kitap Fiyati");
        colKitapFiyati.setCellValueFactory(new PropertyValueFactory<>("kitap_fiyati"));

        TableColumn<kitaplar, Date> colBasimTarihi = new TableColumn<>("Basım Tarihi");
        colBasimTarihi.setCellValueFactory(new PropertyValueFactory<>("basim_tarihi"));

        TableColumn<kitaplar, String > colYayıneviAdi = new TableColumn<>("Yayınevi Adı");
        colYayıneviAdi.setCellValueFactory(new PropertyValueFactory<>("yayinevi_adi"));

        TableColumn<kitaplar, String > colTurAdi= new TableColumn<>("Türü");
        colTurAdi.setCellValueFactory(new PropertyValueFactory<>("tur_adi"));

        tableView.getColumns().addAll(colKitapAdi,colYazarAdi,colSayfaSayisi,colKitapFiyati,colBasimTarihi,colYayıneviAdi,colTurAdi);
        TableView.TableViewSelectionModel<kitaplar> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        return tableView;
    }

    private VBox getVBox()
    {

        return null;
    }

    private void Uyelik(ActionEvent e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
            Statement statement = connection.createStatement();
            String queryString = "INSERT INTO musteriler (musteri_id,musteri_adi, musteri_soyadi, musteri_sifre,musteri_email,kullanici_adi, telefon, cinsiyet) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);


            musteri_adi = tfmusteri_adi.getText();
            musteri_soyadi = tfmusteri_soyadi.getText();
            musteri_sifre = tfmusteri_sifre.getText();
            musteri_email = tfmusteri_email.getText();
            kullanici_adi = tfkullanici_adi.getText();
            telefon = tftelefon.getText();
            cinsiyet = tfcinsiyet.getText();
            musteri_id = Integer.parseInt(tfmusteri_id.getText());

            preparedStatement.setInt(1, musteri_id);
            preparedStatement.setString(2, musteri_adi);
            preparedStatement.setString(3, musteri_soyadi);
            preparedStatement.setString(4, musteri_sifre);
            preparedStatement.setString(5, musteri_email);
            preparedStatement.setString(6, kullanici_adi);
            preparedStatement.setString(7, telefon);
            preparedStatement.setString(8, cinsiyet);
            int row = preparedStatement.executeUpdate();
            basarili.setText("Tebrikler! Üyelik Başarıyla Tamamlandı");
            basarili.setStyle("-fx-text-fill: green;");


        } catch (Exception ex) {
            basarili.setText("Eksik veya hatalı giriş yaptınız!");
            basarili.setStyle("-fx-text-fill: red;");
        }
    }



    public void UyeOL(ActionEvent e) {

    }

    public void GirisYap(ActionEvent e) {

        if (lb1_email.getText().isBlank() == false && lb2_sifre.getText().isBlank() == false) {
            GirisDataBase();
        } else {
            giriniz.setText("Eksik ya da hatalı giriş yaptınız");
        }
    }


    private void CikisYap(ActionEvent e)
    {
        Stage stage =(Stage) btCikisYap.getScene().getWindow();
        stage.close();
    }

    private void GirisDataBase(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/dr_proje", "root", "isik1234*");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String query="SELECT COUNT(1) FROM musteriler WHERE kullanici_adi= '"+ tfkullanici_adi1.getText() +"' AND musteri_sifre='"+ tfmusteri_sifre1.getText()+"'";


        try {
            Statement statement = connection.createStatement();
            ResultSet queryresult=statement.executeQuery(query);


            while (queryresult.next())
            {
                if(queryresult.getInt(1)==1)
                {
                    tekrar_dene.setText("Hoşgeldiniz!");
               try
               {
                   Stage stage=new Stage();
                   stage.setTitle("D&R");
                   stage.setScene(scene3);
                   stage.show();

               }

               catch (Exception e) {
                   throw new RuntimeException(e);
               }
                }
                else
                {
                    tekrar_dene.setText("Eksik ya da hatalı giriş yaptınız");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private void AnasayfaGit(ActionEvent e)
    {

    }


}



