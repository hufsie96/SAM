package com.kep.cnp.sam.manageraccount.controller;

import com.kep.cnp.sam.manageraccount.service.AccountServiceImple;
import com.kep.cnp.sam.manageraccount.vo.Manager;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import javax.servlet.http.HttpSession;

@Controller
public class AccountViewController {
    AccountServiceImple accountService;

    public AccountViewController() { super(); }

    @Autowired
    public void setAccountService(AccountServiceImple accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/login")
    public String showLoginForm(RequestEntity requestEntity, Model model) {
        System.out.println(requestEntity.getHeaders().get("referer"));
        model.addAttribute("reqUrl", requestEntity.getHeaders().get("referer"));
        model.addAttribute("manager", new Manager(null, ""));
        return "login";
    }

    @RequestMapping(value="/join")
    public String showJoinForm(Model model) {
        model.addAttribute("manager", new Manager(null, ""));
        return "join";
    }

    @RequestMapping(value="/search")
    public String showSearchForm(Model model) {
        model.addAttribute("manager", new Manager(null, ""));
        return "search";
    }


    @PostMapping(value="/authenticate")
    public String login(Manager manager, Model model) {
        System.out.println("authenticate mapping !!!");
        if ("".equals(manager.getLibrarianId()) || "".equals(manager.getPassword())) {
            model.addAttribute("loginErr", "fail to login.");
            return "login";
        }

        String token = accountService.authentication(manager);
        if("".equals(token)) {
            model.addAttribute("loginErr", "fail to login.");
            return "login";
        }
        return "redirect:authenticated";
    }

    @GetMapping(value = "/authenticated")
    public String authenticated(Model model, HttpSession session) {
//        String token = (String)model.getAttribute("result");
//        session.setAttribute("token", token);
        model.addAttribute("authenticated", "true");
        session.setAttribute("authenticated", "true");
        return "index";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        System.out.println("Logout mapping...");
        // result what...
        sessionStatus.setComplete();
        session.setAttribute("authenticated", "false");
        return "redirect:/";
    }

    @PostMapping(value="/join")
    public String join(@Validated Manager manager, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "join";
        }

        boolean response = accountService.createManager(manager);
        if(!response){
            return "join";
        }

        model.addAttribute("joined", "success");
        return "login";
    }
}
