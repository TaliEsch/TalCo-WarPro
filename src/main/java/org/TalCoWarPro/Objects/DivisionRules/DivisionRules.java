package org.TalCoWarPro.Objects.DivisionRules;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter

public class DivisionRules {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int referenceId;
    private String descriptorDeck;
    private String uniteDescriptor;
    private boolean availableWithoutTransport;
    private String availableTransportList;
    private int numberOfUnitInPack;
    private String numberOfUnitInPackXPMultiplier;
    private Boolean isEdited;

    public DivisionRules(String descriptorDeck, String uniteDescriptor, boolean availableWithoutTransport,
                  String availableTransportList, int numberOfUnitInPack, String numberOfUnitInPackXPMultiplier){
        this.descriptorDeck = descriptorDeck;
        this.uniteDescriptor = uniteDescriptor;
        this.availableWithoutTransport = availableWithoutTransport;
        this.availableTransportList = availableTransportList;
        this.numberOfUnitInPack = numberOfUnitInPack;
        this.numberOfUnitInPackXPMultiplier = numberOfUnitInPackXPMultiplier;
        referenceId = count.incrementAndGet();
    }

    public DivisionRules(int referenceId, String descriptorDeck, String uniteDescriptor, boolean availableWithoutTransport,
                         String availableTransportList, int numberOfUnitInPack, String numberOfUnitInPackXPMultiplier){
        this.descriptorDeck = descriptorDeck;
        this.uniteDescriptor = uniteDescriptor;
        this.availableWithoutTransport = availableWithoutTransport;
        this.availableTransportList = availableTransportList;
        this.numberOfUnitInPack = numberOfUnitInPack;
        this.numberOfUnitInPackXPMultiplier = numberOfUnitInPackXPMultiplier;
    }

    public boolean getAvailableWithoutTransport(){
        return availableWithoutTransport;
    }

}
