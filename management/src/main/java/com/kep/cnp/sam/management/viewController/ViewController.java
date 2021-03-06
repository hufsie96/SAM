package com.kep.cnp.sam.management.viewController;

import com.kep.cnp.sam.management.service.ManagementServiceImple;
import com.kep.cnp.sam.management.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ViewController {
    ManagementServiceImple managementService;

    public ViewController() { super(); }

    @Autowired
    public void setAccountService(ManagementServiceImple managementService) {
        this.managementService = managementService;
    }

    @RequestMapping(value="/")
    public String index(Model model, HttpSession session, @RequestHeader Map<String, Object> requestHeader) {
        /*
        if(null == session.getAttribute("authenticated")) {
            System.out.print("authenticated");
            session.setAttribute("authenticated", "false");
        }else {
            System.out.println("authenticated:" + session.getAttribute("authenticated") );
        }
        */

        return "index";
    }

    @RequestMapping("/login")
    public String redirectLoginServer(Model model) {
//        URI redirectUri = new URI("http://localhost:8082/login");
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(redirectUri);
//        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);


        return "redirect:http://localhost:8082/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session, HttpServletResponse response) {

        if(null != session.getAttribute("authenticated")) {
            session.setAttribute("authenticated", "false");
            Cookie logoutCookie = new Cookie("jwt_token", null);
            logoutCookie.setMaxAge(0);         // 쿠키의 expiration 타임을 0으로 하여 없앤다.
            logoutCookie.setPath("/");         // 모든 경로에서 삭제 됬음을 알린다.
            response.addCookie(logoutCookie);
        }

        return "index";
    }

    @GetMapping(value = "/search")
    public String search(Model model) {
        String[] searchTypes = {"도서명", "카테고리", "저자"};
        model.addAttribute("searchTypes", searchTypes);
        model.addAttribute("category", managementService.getCategoryList());
        return "search";
    }

    @GetMapping(value = "/searchResult/{searchType}/{searchData}")
    public String searchResult(Model model, @PathVariable("searchType") String searchType, @PathVariable("searchData") String searchData) {

        model.addAttribute("books", managementService.findBookList(searchType, searchData));

        return "searchResult";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("category", managementService.getCategoryList());
        return "register";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {

        return "home";
    }

    @GetMapping(value = "/header")
    public String header() {
        return "fragment/header";
    }


}
