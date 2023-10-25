module EffortLogger {
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	opens com.EffortLogger to javafx.fxml;
	exports com.EffortLogger;
}