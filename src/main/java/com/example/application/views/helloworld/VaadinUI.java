package com.example.application.views.helloworld;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
public class VaadinUI extends UI {

//    @Autowired
    private PacketService service;

    private Packet packet;

    private Binder<Packet> binder = new Binder<>(Packet.class);

    private Grid<Packet> grid = new Grid(Packet.class);
    private TextField packetType = new TextField("Packet Type");
    private TextField payloadLength = new TextField("Payload Length");
    private Button save = new Button("Save", e -> savePacket());

    @Override
    protected void init(VaadinRequest request) {
        updateGrid();
        grid.setColumns("packetType", "payloadLength");
        grid.addSelectionListener(e -> updateForm());

        binder.bindInstanceFields(this);

        VerticalLayout layout = new VerticalLayout(grid, packetType, payloadLength, save);
        setContent(layout);
    }

    private void updateGrid() {
        List<Packet> customers = service.findAll();
        grid.setItems(customers);
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            packet = grid.asSingleSelect().getValue();
            binder.setBean(packet);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        packetType.setVisible(visible);
        payloadLength.setVisible(visible);
        save.setVisible(visible);
    }

    private void savePacket() {
        service.update(packet);
        updateGrid();
    }

}
