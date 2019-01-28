package com.ds.baza.dsbaza.utils;

import com.ds.baza.dsbaza.model.user.User;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

@Component
public class MyUtils {

    private static MessageSource messageSource;

    public MyUtils(MessageSource messageSource) {
        MyUtils.messageSource = messageSource;
    }

    public static String getMessage(String messageKey, Object... args) {
        return messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
    }

    public static void flash(RedirectAttributes redirectAttributes, String flashKind, String flashMessage) {
        redirectAttributes.addFlashAttribute("flashMessage", getMessage(flashMessage));
        redirectAttributes.addFlashAttribute("flashKind", flashKind);
    }

    public static Optional<User> currentUser(){

        //rekli smo sada prvo uzimamo Autentication objekat iz spring security context-a
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //ovo kaze if somebody is logged in
        if(auth != null){
            Object principal = auth.getPrincipal();
            //svakako ce principal biti instanca nase user klase, ali da bismo bili sigurni duplo cemo se obezbediti
            if (principal instanceof User) {
                return Optional.of((User) principal);
            }
        }
        return Optional.empty();
    }
}
