module com.example.compunettaller_udp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.compunettaller_udp to javafx.fxml;
    exports com.example.compunettaller_udp;
    exports com.example.compunettaller_udp.controllers;
    opens com.example.compunettaller_udp.controllers to javafx.fxml;

}