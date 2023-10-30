module EffortLogger {
	requires java.desktop;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive java.sql;
	opens com.EffortLogger to javafx.fxml;
	exports com.EffortLogger;
}