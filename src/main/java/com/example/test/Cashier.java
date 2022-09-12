package com.example.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Cashier {
    private List<Change> change;
    private int b1000,b500,b100,b20,b10,b5,b1;
    private int num0;

    public Cashier(){
        change = new ArrayList<>();
    }

    @RequestMapping(value = "/getChange/{num}")
    public Change getChange(@PathVariable("num") int num){
        int total = num;
        if(total/1000>0){
            this.b1000=total/1000;
            total = total-(total/1000)*1000;
        }
        else {
            this.b1000=0;
        }
        if(total/500>0){
            this.b500 = total/500;
            total = total-(total/500)*500;
        }
        else {
            this.b500 = 0;
        }
        if(total/100>0){
            this.b100 = total/100;
            total = total-(total/100)*100;
        }
        else {
            this.b100=0;
        }
        if(total/20>0){
            this.b20 = total/20;
            total = total-(total/20)*20;
        }
        else {
            this.b20=0;
        }
        if(total/10>0){
            this.b10 = total/10;
            total = total-(total/10)*10;
        }
        else {
            this.b10=0;
        }
        if(total/5>0){
            this.b5 = total/5;
            total = total-(total/5)*5;
        }
        else {
            this.b5=0;
        }

        this.b1 =total;

        this.change.add(new Change(this.b1000,this.b500,this.b100,this.b20,this.b10,this.b5,this.b1));
        return this.change.get(this.change.size()-1);
    }

}
