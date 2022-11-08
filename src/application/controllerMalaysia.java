package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class controllerMalaysia implements Initializable{
	

	File directory;
	File[] files;
	ArrayList<File> songs;
	Timer timer;
	TimerTask task;
	boolean running;
	Media media;
	MediaPlayer mediaPlayer;
	int songNumber;
	
	 @FXML
	 private ImageView bintang;

	 @FXML
	 void playSong(MouseEvent event) {
		 songs = new ArrayList<File>();
		 directory = new File("music");
		 files = directory.listFiles();
		 if(files != null) {

			 for(File file : files) {

				 songs.add(file);
			 }
		 }

		 media = new Media(songs.get(songNumber).toURI().toString());
		 mediaPlayer = new MediaPlayer(media);
		 mediaPlayer.play();
	 }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
