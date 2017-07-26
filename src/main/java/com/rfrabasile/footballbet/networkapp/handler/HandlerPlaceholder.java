/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rfrabasile.footballbet.networkapp.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfrabasile.footballbet.networkapp.model.FootballBet;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *
 * @author rfrabasile@gmail.com
 */
public class HandlerPlaceholder extends ChannelInboundHandlerAdapter {
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FootballBet footballBet = (FootballBet)msg; 
        System.out.println("Processed bet is: " + footballBet.toString());
        ObjectMapper mapper = new ObjectMapper();                
        String jsonInString = mapper.
                                    writerWithDefaultPrettyPrinter().
                                    writeValueAsString(footballBet);        
        System.out.println("Processed bet in json format: " + jsonInString);
        ChannelFuture future = ctx.writeAndFlush(footballBet);
        future.addListener(ChannelFutureListener.CLOSE);
    }
    
}
