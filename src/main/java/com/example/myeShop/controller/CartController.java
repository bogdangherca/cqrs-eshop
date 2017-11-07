package com.example.myeShop.controller;

import com.example.myeShop.cart.command.AddItemCommand;
import com.example.myeShop.cart.command.CreateCartCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Bogdan.Gherca on 10/24/2017.
 */

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void addItem() {
//        Long id = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        Long id = 41799341522744293L;
        CreateCartCommand command = CreateCartCommand.aCreateCartCommand(id);
        commandGateway.send(command);

        AddItemCommand addItemCommand = AddItemCommand.anAddItemCommand(id, 1L);
        commandGateway.send(addItemCommand);
    }

}
