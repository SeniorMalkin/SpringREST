package com.netcracker.WebService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.POJO.Status;
import com.netcracker.model.Buyer;
import com.netcracker.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class BuyerRestService {
    @Autowired
    BuyerService buyerService;

    @GetMapping(value = "/buyer")
    public ResponseEntity<List<Buyer>> getAll(){
        return new ResponseEntity<List<Buyer>>(buyerService.getAllBuyers(), HttpStatus.OK);
    }

    @GetMapping(value = "/buyer/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") int id){
        Buyer buyer = buyerService.getBuyerByID(id);
        if(buyer != null)
        return new ResponseEntity<Buyer>(buyer,HttpStatus.OK);
        else
            return new ResponseEntity<Buyer>(new Buyer(),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/buyer/{id}")
    public ResponseEntity<Status> deleteBuyerById(@PathVariable("id")int id){
        Buyer buyer = buyerService.getBuyerByID(id);
        if(buyer != null){
            buyerService.deleteByID(id);
            return new ResponseEntity<Status>(new Status("OK","Delete successfully"),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Status>(new Status("NO_CONTENT","Item not found"),HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping(value = "/buyer")
    public ResponseEntity<Status> deleteAll(){
        buyerService.deleteAllBuyers();
        return new ResponseEntity<Status>(new Status("OK","All deleted"),HttpStatus.OK);
    }

    @PostMapping(value = "/buyer")
    public ResponseEntity<Status> saveBuyer(@RequestBody String body){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Buyer buyer = mapper.readValue(body, Buyer.class);
            buyerService.saveBuyer(buyer);
            return new ResponseEntity<Status>(new Status("OK","Object successfully saved"),HttpStatus.OK);
        }
        catch (IOException exp){
            System.out.println(exp.getMessage());
            return new ResponseEntity<Status>(new Status("BAD_REQUEST","IOException"),HttpStatus.BAD_REQUEST);
        }
    }
}
