module AnnuaireV1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires de.jensd.fx.glyphs.fontawesome;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens model to javafx.base;
}
