package com.springmvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {

        return "index";

    }

    @RequestMapping("/submit")
    public String home(@RequestParam("action") String action) {

        if ("login".equals(action)) {
            return "login";
        } else {
            return "sign_up";
        }

    }


    @RequestMapping("/signup")
    public String signup(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") int phone,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("action") String action,
            Model m) {

        if ("Signup".equals(action)) {
            ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
            UserDao userDao = context.getBean("userDao", UserDao.class);

            userDao.insertUserData(name, email, phone, username, password);

        }
        return "demo";

    }

    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("action") String action,
            Model m, HttpServletRequest request,
            HttpServletResponse response) {

        if ("Login".equals(action)) {

            ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
            UserDao userDao = context.getBean("userDao", UserDao.class);

            List<User> user = userDao.getUserData();

            HttpSession session = request.getSession(true);

            session.setAttribute("username", username);
            m.addAttribute("session", session);
            m.addAttribute("model",m);
            for(int i =0; i<=user.size()-1;i++) {
                if (user.get(i).getUsername().equals(username) && user.get(i).getPassword().equals(password)) {
                    m.addAttribute("message", "welcome");
                }
            }


        }


        return "message";
    }



}
