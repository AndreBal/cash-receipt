package com.balash;

import com.balash.service.CheckService;
import com.balash.service.implementation.CheckServiceDefault;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! "+args.length);
        Map<String, String> parsedArgs = new HashMap<>();
        for(int i = 0;i<args.length;i++){
            String[] keyAndValueFromArg = args[i].split("-");
            parsedArgs.put(keyAndValueFromArg[0],keyAndValueFromArg[1]);
            System.out.println(args[i]);
        }
        CheckService checkService;

        checkService = new CheckServiceDefault();
        checkService.printCheck(parsedArgs);
    }
}