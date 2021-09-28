package com.example.application.views.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacketService {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Packet> findAll() {
        return jdbcTemplate.query(
                "SELECT id, packet_type, payload_length, packet_cntr, version_id, build_id FROM packet",
                (rs, rowNum) -> new Packet(rs.getLong("id"),
                        rs.getShort("packet_type"), rs.getShort("payload_length"),
                        rs.getShort("packet_cntr"), rs.getShort("version_id"),
                        rs.getShort("build_id")));
    }

    public void update(Packet packet) {
        jdbcTemplate.update(
                "UPDATE packet SET packet_type=?, payload_length=? WHERE id=?",
                packet.getPacketType(), packet.getPayloadLength(), packet.getId());
    }

}
