package com.example.Vending_Machine.controller;

import com.example.Vending_Machine.dto.*;
import com.example.Vending_Machine.model.*;
import com.example.Vending_Machine.service.*;
import com.example.Vending_Machine.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class VendingMachineController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @PostMapping("/vending-Machine/buyProduct")
    public ResponseEntity<VendingMachineResponseDTO> buyProduct(@RequestBody VendingMachineRequestDTO vendingMachineRequestDTO){
      //get current loggined user
        VendingMachineResponseDTO vendingMachineResponseDTO = null;
        User user = userService.getUserById(1);
        if(vendingMachineRequestDTO != null) {
            if(user.getRole().equals(UserRoles.BUYER.toString())){
                Integer change = Integer.valueOf(user.getDeposit()) - Integer.valueOf(vendingMachineRequestDTO.getAmountOfProduct());
                vendingMachineResponseDTO.setDepositMoney(Integer.valueOf(vendingMachineRequestDTO.getAmountOfProduct()));
                vendingMachineResponseDTO.setChange(change.toString());
                vendingMachineResponseDTO.setTotal("500");
                }
        }
        return new ResponseEntity(vendingMachineRequestDTO, HttpStatus.OK);
    }
}
