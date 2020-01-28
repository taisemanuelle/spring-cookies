package br.edu.ifal.usandocookies;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * CookiesController
 */
@RestController
public class CookiesController {

    @GetMapping(value = "/")
    public ModelAndView lerCookie(@CookieValue(value = "primeiroAcesso", defaultValue = "sim") String primeiroAcesso,
            HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("index");
        if (primeiroAcesso.equals("sim")) {
            // Cookie c = new Cookie("primeiroAcesso", "nao");
            // response.addCookie(c);
            mv.addObject("msg", "Este é seu primeiro acesso!");
        } else {
            mv.addObject("msg", "Este NÃO é seu primeiro acesso!");
        }
        return mv;

    }

    @PostMapping(value = "/adicionacookie")
    public ModelAndView mudaNomeCookie(String nome, HttpServletResponse response) {
        Cookie c = new Cookie("primeiroAcesso", "nao");
        response.addCookie(c);
        return new ModelAndView("redirect:/");
    }

}