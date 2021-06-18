// File: HomePageController.java
// Controller class that handlers requests for / and renders the application's
// home page
// Author: 1760169 - Le Anh Tai
// Email: leanhtai01@gmail.com
// GitHub: https://github.com/leanhtai01
package com.team18.salesmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndexPage() {
        return "homepage";
    }
} // end class HomePageController
