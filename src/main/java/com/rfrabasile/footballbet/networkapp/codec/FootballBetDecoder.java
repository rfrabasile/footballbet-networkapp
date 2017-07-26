/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rfrabasile.footballbet.networkapp.codec;

import com.rfrabasile.footballbet.networkapp.model.FootballBet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.nio.charset.Charset;
import java.util.List;

/**
 *
 * @author rfrabasile@gmail.com
 */
public class FootballBetDecoder extends ReplayingDecoder<FootballBet>{
    
    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
            throws Exception {        
        
        //Decode fields from bytes to POJO
        int idClient = in.readInt();        
        //String length should be explicited
        int stringLength = in.readInt();
        String timestamp = in.readCharSequence(stringLength, charset).toString();        
        int homeTeamId = in.readInt();
        int awayTeamId = in.readInt();
        short homeTeamScore = in.readShort();
        short awayTeamScore = in.readShort();
        byte currency = in.readByte();
        
        FootballBet footballBet = new FootballBet(idClient, 
                                        timestamp,
                                        homeTeamId, 
                                        awayTeamId, 
                                        homeTeamScore,
                                        awayTeamScore,
                                        currency);
        
        System.out.println("Data content: " + footballBet.toString() + "\n");
        
        out.add(footballBet);
        
    }
    
}
