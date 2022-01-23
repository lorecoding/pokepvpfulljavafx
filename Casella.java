package com.example.pokepvp;


import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;

import static com.example.pokepvp.Main.matrix;

public class Casella extends StackPane{
    static int dim = 100;
    int riga;
    int colonna;
    ImageView box = new ImageView();

    public Casella(int riga, int colonna) {
        this.riga = riga;
        this.colonna = colonna;
        this.setMaxSize(dim, dim);
        this.setMinSize(dim, dim);
        this.getChildren().add(box);
        /*if ((riga+colonna)%2!=0){
            this.setStyle("-fx-background-color:#CCEEFF");
        }*/}
        /*public Movimento() {

        }*/
    }