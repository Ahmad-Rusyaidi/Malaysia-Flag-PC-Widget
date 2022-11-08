module Malaysia {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires com.jfoenix;
	requires javafx.graphics;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
}
