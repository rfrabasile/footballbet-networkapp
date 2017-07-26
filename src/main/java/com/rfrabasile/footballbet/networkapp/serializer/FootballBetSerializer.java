/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rfrabasile.footballbet.networkapp.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.rfrabasile.footballbet.networkapp.model.FootballBet;
import java.io.IOException;

/**
 *
 * @author rfrabasile@gmail.com
 */
public class FootballBetSerializer extends StdSerializer<FootballBet>{
    
    public FootballBetSerializer() {
        this(null);
    }
   
    public FootballBetSerializer(Class<FootballBet> t) {
        super(t);
    }
 
    @Override
    public void serialize(
      FootballBet value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException { 
        
        jgen.writeStartObject(); 
        jgen.writeNumberField("client", value.getIdClient());
        jgen.writeObjectField("timestamp", value.getTimestamp());
        jgen.writeNumberField("homeTeamId", value.getHomeTeamId());
        jgen.writeNumberField("awayTeamId", value.getAwayTeamId());
        jgen.writeNumberField("homeTeamScore", value.getHomeTeamScore());
        jgen.writeNumberField("awayTeamScore", value.getAwayTeamScore());
        jgen.writeObjectField("currency", getCurrency(value.getCurrency()));
        jgen.writeEndObject();        
              
    }

    private String getCurrency(byte value){
        switch(value){
            case 0: return "US$";
            case 1: return "EU$";
            case 2: return "AU$";
            case 3: return "L$";
            default: throw new IllegalArgumentException();
        }
    }
    
}