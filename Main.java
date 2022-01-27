package com.example.pokepvp;


import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {
    //---------INIZIO DICHIARAZIONI-------------------------------------//
    Personaggio tizio= new Personaggio(8,9);
    Timer timer;
    Timer timer1;
    Timer timer2;
    int contat =0;
 Timer timer3;
    int turno=1;
    final static int LATO=11;
    final static int LATO2=25;
    int controllo=0;
    static Casella[][] matrix = new Casella[LATO][LATO2];

    @Override
    public void start(Stage stage)  {

        GridPane root = new GridPane();


        Image img = new Image("img/sfondo.png");
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        root.setBackground(bGround);

        for (int i = 0; i < LATO; i++) {
            for (int j = 0; j < LATO2; j++) {
                matrix[i][j] = new Casella(i, j);
                root.add(matrix[i][j], j, i);

            }
        }
       // root.setGridLinesVisible(true);


//--------------BOTTONE--------------------------------------------------//

        Button bottone = new Button("GIOCA");
        bottone.setMaxSize(400, 400);
        bottone.setMinSize(400, 400);
        bottone.setFont(new Font("Verdana", 32));
        bottone.setBackground(null);
        matrix[7][5].getChildren().add(bottone);


        Button bottone1 = new Button("REGOLE");
        bottone1.setMaxSize(400, 400);
        bottone1.setMinSize(400, 400);
        bottone1.setFont(new Font("Verdana", 32));

        bottone1.setBackground(null);
        matrix[7][14].getChildren().add(bottone1);

        //--------------BOTTONE--------------------------------------------------//

        ImageView image2View = new ImageView();
        Image image2 = new Image("img/p2.PNG");
        image2View.setImage(image2);

        ImageView image3View = new ImageView();
        Image image3 = new Image("img/p1.PNG");
        image3View.setImage(image3);

        ImageView image4View = new ImageView();
        Image image4 = new Image("img/p3.PNG");
        image4View.setImage(image4);

        ImageView image5View = new ImageView();
        Image image5 = new Image("img/p4.PNG");
        image5View.setImage(image5);

        ImageView image6View = new ImageView();
        Image image6 = new Image("img/testo.PNG");
        image6View.setImage(image6);

        ImageView image7View = new ImageView();
        Image image7 = new Image("img/vuoto.PNG");
        image7View.setImage(image7);

        ImageView av = new ImageView();
        Image a = new Image("img/a.PNG");
        av.setImage(a);

// pokemon immagini //
        ImageView image11View = new ImageView();
        Image image11 = new Image("img/swampert.gif");
        image11View.setImage(image11);

        ImageView infernapeview = new ImageView();
        Image infernape = new Image("img/eelektross.gif");
        infernapeview.setImage(infernape);






// pokemon immagini //


        // mosse immagini //

        ImageView cascatav = new ImageView();
        Image cascata= new Image("img/cascata.gif");
        cascatav.setImage(cascata);

        ImageView fulminev = new ImageView();
        Image fulmine= new Image("img/fulmine.gif");
        fulminev.setImage(fulmine);
        fulminev.setFitHeight(220);
        fulminev.setFitWidth(280);

        //mosse //

//---------EVENT BOTTONE 1-------------------------------------//


        bottone.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            bottone.setVisible(false);
            bottone1.setVisible(false);

            Image img1 = new Image("img/3.png");
            BackgroundImage bImg1 = new BackgroundImage(img1,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            Background bGround1 = new Background(bImg1);

            root.setBackground(bGround1);

            matrix[8][9].getChildren().add(image2View);


        });


        bottone1.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            ImageView image1View = new ImageView();
            Image image1 = new Image("img/3.PNG");
            image1View.setImage(image1);
            root.getChildren().add(image1View);


        });


        Scene scene = new Scene(root, 1900, 1000);

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent key) -> {
            if(controllo==0)

            {
                matrix[8][9].getChildren().remove(image2View);

                if (key.getCode().equals(KeyCode.W)) {


                    if ((tizio.riga == 5 && tizio.colonna < 9) || (tizio.riga == 5 && tizio.colonna < 13 && tizio.colonna > 9) || tizio.riga == 2 && tizio.colonna == 14 || (tizio.riga < 3 && tizio.colonna == 18)) {
                        image7View.setImage(image2);
                    } else {
                        image7View.setImage(image2);
                        matrix[tizio.riga - 1][tizio.colonna].getChildren().add(image7View);
                        tizio.riga = tizio.riga - 1;
                    }


                }


                if (key.getCode().equals(KeyCode.S)) {

                    if (tizio.riga == 8 || tizio.riga == 7 && tizio.colonna < 7 || (tizio.riga == 0 && tizio.colonna == 14)) {
                        image7View.setImage(image3);
                    } else {
                        image7View.setImage(image3);
                        matrix[tizio.riga + 1][tizio.colonna].getChildren().add(image7View);
                        tizio.riga = tizio.riga + 1;
                    }

                }

                if (key.getCode().equals(KeyCode.A)) {


                    if ((tizio.riga == 8 && tizio.colonna == 7) || (tizio.riga < 5 && tizio.colonna == 13) || (tizio.riga == 1 && tizio.colonna == 15)) {
                        image7View.setImage(image5);
                    } else {
                        image7View.setImage(image5);
                        matrix[tizio.riga][tizio.colonna - 1].getChildren().add(image7View);
                        tizio.colonna = tizio.colonna - 1;
                    }
                }


                if (key.getCode().equals(KeyCode.D)) {

                    if (tizio.riga == 1 && tizio.colonna == 14 || (tizio.riga == 1 && tizio.colonna == 13) || (tizio.riga < 2 && tizio.colonna == 17)) {
                        image7View.setImage(image4);
                    } else {
                        image7View.setImage(image4);
                        matrix[tizio.riga][tizio.colonna + 1].getChildren().add(image7View);
                        tizio.colonna = tizio.colonna + 1;

                    }
                }


                if (matrix[tizio.riga][tizio.colonna] == matrix[4][9]) {

                    matrix[4][9].getChildren().remove(image7View);
                    matrix[9][12].getChildren().add(image7View);


                    Image img2 = new Image("img/PAL1.PNG");
                    BackgroundImage bImg2 = new BackgroundImage(img2,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.DEFAULT,
                            BackgroundSize.DEFAULT);
                    Background bGround2 = new Background(bImg2);
                    root.setBackground(bGround2);
                    controllo=1;

                    tizio.riga=9;
                    tizio.colonna=12;

                }
            }



//----scenario entrata palestra 1---------//

            else if(controllo==1)
            {

                Image img2 = new Image("img/PAL1.PNG");
                BackgroundImage bImg2 = new BackgroundImage(img2,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bGround2 = new Background(bImg2);
                root.setBackground(bGround2);

                System.out.println(tizio.riga);
                System.out.println(tizio.colonna);

                if (key.getCode().equals(KeyCode.W)) {
                    if ((tizio.riga<4&& tizio.colonna<12)||(tizio.riga==3 && tizio.colonna==13)||(tizio.riga==3 && tizio.colonna==14))
                    {
                        image7View.setImage(image2);
                    }
                    else {
                        image7View.setImage(image2);
                        matrix[tizio.riga - 1][tizio.colonna].getChildren().add(image7View);
                        tizio.riga = tizio.riga - 1;
                    }
                }


                if (key.getCode().equals(KeyCode.S)) {

                    if(tizio.riga==9||(tizio.riga==7 && tizio.colonna==14)) {
                        image7View.setImage(image3);
                    }
                    else{image7View.setImage(image3);
                        matrix[tizio.riga + 1][tizio.colonna].getChildren().add(image7View);
                        tizio.riga = tizio.riga + 1;
                    }

                }

                if (key.getCode().equals(KeyCode.A)) {

                    if ((tizio.colonna==8)||(tizio.riga==8 && tizio.colonna==11  ))  {

                        image7View.setImage(image5);

                    } else {
                        image7View.setImage(image5);
                        matrix[tizio.riga][tizio.colonna - 1].getChildren().add(image7View);
                        tizio.colonna = tizio.colonna - 1;
                    }
                }


                if (key.getCode().equals(KeyCode.D)) {

                    if(tizio.colonna==14 || (tizio.riga==8 && tizio.colonna==13)) {

                        image7View.setImage(image4);

                    } else {
                        image7View.setImage(image4);
                        matrix[tizio.riga][tizio.colonna + 1].getChildren().add(image7View);
                        tizio.colonna = tizio.colonna + 1;
                    }

                }


                if (matrix[tizio.riga][tizio.colonna] == matrix[5][12]) {

                    image7View.setImage(image5);
                    controllo=2;
                    matrix[5][12].getChildren().remove(image7View);
                }
                if (matrix[tizio.riga][tizio.colonna] == matrix[0][12]) {


                    controllo=3;

                }


            }


            else if(controllo==2) {

             Image img8 = new Image("img/sfondo1.PNG");
                BackgroundImage bImg8 = new BackgroundImage(img8,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bGround3 = new Background(bImg8);
                root.setBackground(bGround3);

                image11View.setFitHeight(370);
                image11View.setFitWidth(340);
                matrix[5][5].getChildren().add(image11View);

               infernapeview.setFitHeight(220);
                infernapeview.setFitWidth(280);
                matrix[2][13].getChildren().add(infernapeview);


                Text t1 = new Text();
                t1.setText(" Swampert 💧");
                t1.setFill(Color.BLACK);
                matrix[2][2].getChildren().add(t1);
                t1.setFont(new Font("Verdana", 35));

                Text t = new Text();
                t.setText("❤❤❤❤❤❤❤❤❤❤");
                t.setFill(Color.RED);
                matrix[3][3].getChildren().add(t);
               t.setFont(new Font("Verdana", 35));


                Text t2 = new Text();
                t2.setText("Elektross ⚡ ");
                t2.setFill(Color.BLACK);
                matrix[0][9].getChildren().add(t2);
                t2.setFont(new Font("Verdana", 35));

                Text t3 = new Text();
                t3.setText("❤❤❤❤❤❤❤❤❤❤");
                t3.setFill(Color.RED);
                matrix[1][9].getChildren().add(t3);
                t3.setFont(new Font("Verdana", 35));

                Button mossa1 = new Button("CASCATA 💧");
                mossa1.setMaxSize(400, 400);
                mossa1.setMinSize(400, 400);
                mossa1.setFont(new Font("Verdana", 35));
                matrix[9][4].getChildren().add(mossa1);
                mossa1.setBackground(null);


                Button mossa2 = new Button("IDROPULSAR 💧");
                mossa2.setMaxSize(400, 400);
                mossa2.setMinSize(400, 400);
                mossa2.setFont(new Font("Verdana", 35));
                matrix[9][7].getChildren().add(mossa2);
                mossa2.setBackground(null);

                Button mossa3 = new Button("ATTACCO RAPIDO ");
                mossa3.setMaxSize(400, 400);
                mossa3.setMinSize(400, 400);
                mossa3.setFont(new Font("Verdana", 35));
                matrix[9][11].getChildren().add(mossa3);
                mossa3.setBackground(null);

                Button mossa4 = new Button("AZIONE");
                mossa4.setMaxSize(400, 400);
                mossa4.setMinSize(400, 400);
                mossa4.setFont(new Font("Verdana", 35));
                matrix[9][14].getChildren().add(mossa4);
                mossa4.setBackground(null);



                 mossa1.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent v) -> {
                    Text t4 = new Text();
                     t4.setFill(Color.BLACK);
                     t4.setFont(new Font("Verdana", 35));
                     matrix[9][9].getChildren().add(t4);

if(contat==0) {
    matrix[3][13].getChildren().add(cascatav);
    timer1 = new Timer();
    timer1.schedule(new TimerTask() { //attivo il timer
        @Override
        public void run() {
            cascatav.setImage(null);

        }
    }, 2500);


    t3.setText("❤❤❤❤❤");
    mossa1.setVisible(false);
    mossa2.setVisible(false);
    mossa3.setVisible(false);
    mossa4.setVisible(false);

    t4.setText("Cascata è superefficacie contro Elektross");

    timer1.schedule(new TimerTask() { //attivo il timer
        @Override
        public void run() {

            t4.setText(null);
        }
    }, 2500);
    contat = 1;
}
                    matrix[6][15].getChildren().add(av);

             if (contat==1) {

                 av.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent rv) -> {
                     matrix[5][5].getChildren().add(fulminev);

                     timer3 = new Timer();
                     timer3.schedule(new TimerTask() { //attivo il timer
                         @Override
                         public void run() {
                             fulminev.setImage(null);

                         }
                     }, 2500);
                     t4.setText("Elektross usa fulmine");
                     contat = 2;
                     timer3 = new Timer();
                     timer3.schedule(new TimerTask() { //attivo il timer
                         @Override
                         public void run() {

                             t4.setText(null);
                         }
                     }, 2000);

                     t.setText("❤❤❤❤❤❤");
                     t4.setText("Fulmine è efficacie su Swampert");



                 });
                 contat=2;

             }





            } );


                mossa2.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent v) -> {


                });

                mossa3.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent v) -> {


                });

                mossa4.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent v) -> {


                });

            }
        });

        //----------importante------




        stage.setTitle("PokePvP");
        stage.setScene(scene);
        stage.getIcons().add(new Image("img/icona.png"));
        stage.show();
        image2View.requestFocus();

    }

    public static void main(String[] args) {
        launch();
    }
}
