package com.example.pokepvp;


import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.EventHandler;



public class Main extends Application {
    //---------INIZIO DICHIARAZIONI-------------------------------------//
    Personaggio tizio= new Personaggio(8,9);
   final static int LATO=11;
    final static int LATO2=25;
  int controllo=0;
static Casella[][] matrix = new Casella[LATO][LATO2];

    @Override
    public void start(Stage stage) {

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
        root.setGridLinesVisible(true);


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
        Image image6 = new Image("img/IND.PNG");
        image6View.setImage(image6);

        ImageView image7View = new ImageView();
        Image image7 = new Image("img/vuoto.PNG");
        image7View.setImage(image7);


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



//----scenario entrata palestra---------//

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
            if (tizio.riga<4&& tizio.colonna<12)
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


                            image7View.setImage(image3);
                            matrix[tizio.riga + 1][tizio.colonna].getChildren().add(image7View);
                            tizio.riga = tizio.riga + 1;


                        }

                        if (key.getCode().equals(KeyCode.A)) {



                            image7View.setImage(image5);
                            matrix[tizio.riga][tizio.colonna - 1].getChildren().add(image7View);
                            tizio.colonna = tizio.colonna - 1;

                        }


                        if (key.getCode().equals(KeyCode.D)) {


                            image7View.setImage(image4);
                            matrix[tizio.riga][tizio.colonna + 1].getChildren().add(image7View);
                            tizio.colonna = tizio.colonna + 1;


                        }

                        if (matrix[tizio.riga][tizio.colonna] == matrix[0][11]) {


                            controllo=2;

                    }


                    }


                    else if(controllo==2) {
                        Image img8 = new Image("img/PAL2.PNG");
                        BackgroundImage bImg8 = new BackgroundImage(img8,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT);
                        Background bGround3 = new Background(bImg8);
                        root.setBackground(bGround3);


                        matrix[0][10].getChildren().remove(image2View);
                        tizio.riga=8;
                        tizio.colonna=9;
                        matrix[tizio.riga - 1][tizio.colonna].getChildren().add(image2View);
                        if (key.getCode().equals(KeyCode.W)) {



                            image7View.setImage(image2);
                            matrix[tizio.riga][tizio.colonna].getChildren().add(image7View);
                            tizio.riga = tizio.riga - 1;



                        }
                        if (key.getCode().equals(KeyCode.S)) {


                            image7View.setImage(image3);
                            matrix[tizio.riga + 1][tizio.colonna].getChildren().add(image7View);
                            tizio.riga = tizio.riga + 1;


                        }

                        if (key.getCode().equals(KeyCode.A)) {



                            image7View.setImage(image5);
                            matrix[tizio.riga][tizio.colonna - 1].getChildren().add(image7View);
                            tizio.colonna = tizio.colonna - 1;

                        }


                        if (key.getCode().equals(KeyCode.D)) {


                            image7View.setImage(image4);
                            matrix[tizio.riga][tizio.colonna + 1].getChildren().add(image7View);
                            tizio.colonna = tizio.colonna + 1;


                        }

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
