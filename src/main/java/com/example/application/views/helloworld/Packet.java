package com.example.application.views.helloworld;

public class Packet {

    private Long id;
    private short packetType;
    private short payloadLength;
    private short packetCntr;
    private short versionId;
    private short buildId;

    public Packet(Long id, short packetType, short payloadLength, short packetCntr, short versionId, short buildId) {
        this.id = id;
        this.packetType = packetType;
        this.payloadLength = payloadLength;
        this.packetCntr = packetCntr;
        this.versionId = versionId;
        this.buildId = buildId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getPacketType() {
        return packetType;
    }

    public void setPacketType(short packetType) {
        this.packetType = packetType;
    }

    public short getPayloadLength() {
        return payloadLength;
    }

    public void setPayloadLength(short payloadLength) {
        this.payloadLength = payloadLength;
    }

    public short getPacketCntr() {
        return packetCntr;
    }

    public void setPacketCntr(short packetCntr) {
        this.packetCntr = packetCntr;
    }

    public short getVersionId() {
        return versionId;
    }

    public void setVersionId(short versionId) {
        this.versionId = versionId;
    }

    public short getBuildId() {
        return buildId;
    }

    public void setBuildId(short buildId) {
        this.buildId = buildId;
    }
}
