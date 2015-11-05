/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webs.mumscrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Walid
 */
@Controller
public class MainController {

    @RequestMapping(value = {"/", "", "/welcome"}, method = RequestMethod.GET)
    public String getWelcomePage() {
        return "welcome";
    }
}
