package com.netcracker.WebService;

import com.netcracker.POJO.Result;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
public class CalculationRestService {

    @RequestMapping(method = RequestMethod.GET)
    public String getSum1(ModelMap model){
        model.addAttribute("summ",new Integer(0));
        return "Hello,it's calculator!";
    }
    @GetMapping(value = "/add/{a}/{b}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Result> getSumJandX(@PathVariable("a") int a, @PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a+b);
        return new ResponseEntity<Result>(result,HttpStatus.OK);
    }
    @GetMapping(value = "/add/{a}/{b}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getSumText(@PathVariable("a") int a, @PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a+b);
        return new ResponseEntity<String>(result.toString(),HttpStatus.OK);
    }

    @GetMapping(value = "/subst/{a}/{b}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Result> getSubstrJandX(@PathVariable("a") int a,@PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a-b);
        return new ResponseEntity<Result>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/subst/{a}/{b}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getSubstrText(@PathVariable("a") int a, @PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a-b);
        return new ResponseEntity<String>(result.toString(),HttpStatus.OK);
    }

    @GetMapping(value = "/mult/{a}/{b}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Result> getMultJandX(@PathVariable("a") int a,@PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a*b);
        return new ResponseEntity<Result>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/mult/{a}/{b}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getMultText(@PathVariable("a") int a, @PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a*b);
        return new ResponseEntity<String>(result.toString(),HttpStatus.OK);
    }

    @GetMapping(value = "/divis/{a}/{b}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Result> getDivisJandX(@PathVariable("a") int a,@PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a/b);
        return new ResponseEntity<Result>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/divis/{a}/{b}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getDivisText(@PathVariable("a") int a, @PathVariable("b") int b){
        Result result = new Result();
        result.setRes(a/b);
        return new ResponseEntity<String>(result.toString(),HttpStatus.OK);
    }

}
