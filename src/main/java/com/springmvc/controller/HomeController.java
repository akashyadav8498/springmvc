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
import java.util.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {

        return "index";

    }

    @RequestMapping("/index")
    public String index2() {

        return "index";

    }

    @RequestMapping("/signup")
    public String home() {


        return "sign_up";


    }


    @RequestMapping("/save_user")
    public String signup(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") int phone,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model m) {


        ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);

        userDao.insertUserData(name, email, phone, username, password);


        return "data_saved";

    }

    @RequestMapping("/user_validation")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model m, HttpServletRequest request,
            HttpServletResponse response) {
        int count = 0;


        HttpSession session2 = request.getSession(false);
        String usr = (String)session2.getAttribute("username");

        if(usr==null) {

            //VALIDATING USER FROM DATABASE-->
            ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
            UserDao userDao = context.getBean("userDao", UserDao.class);
            List<User> user = userDao.getUserData();

            for (int i = 0; i <= user.size() - 1; i++) {
                if (user.get(i).getUsername().equals(username) && user.get(i).getPassword().equals(password)) {
                    m.addAttribute("message", "WELCOME");
                    m.addAttribute("username", username);
                    count++;
                }
            }


            if (count == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                return "valid_user";
            } else {

                return "invalid_user";
            }
        }

        else {
            m.addAttribute("username",usr);
            return "old_user";
        }

    }



    @RequestMapping("/logout")
    public String logout(
            Model m, HttpServletRequest request,
            HttpServletResponse response) {


            HttpSession session3 = request.getSession(false);
            session3.invalidate();

            return "index";


    }

    @RequestMapping("/search")
    public String search(
            @RequestParam String name,
            Model m, HttpServletRequest request,
            HttpServletResponse response) {



        //SEARCHING USER IN DATABASE-->
        ApplicationContext context = new ClassPathXmlApplicationContext("dbconfig.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        List<User> user = userDao.getUserData();
        int count = 0;
        for (int i = 0; i <= user.size() - 1; i++) {
            if (user.get(i).getName().equals(name)) {

                User user1 = user.get(i);

                ArrayList<String> arr = new ArrayList<String>();
                arr.add(user1.getName());
                arr.add(user1.getEmail());
                arr.add(user1.getPhone());
                arr.add(user1.getUsername());

                m.addAttribute("user", arr);
                count++;
            }
        }

        if (count == 1) {
            return "search";
        } else {
            return "data_not_found";
        }
    }


    }


